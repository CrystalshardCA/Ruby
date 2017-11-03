package ca.crystalshard.ruby.common.domain.eventbus;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ObservableTest {

    private TestObserver testObserver;
    private TestObservable testObservable;

    @Before
    public void setUp() {
        testObservable = new TestObservable();
        testObserver = spy(new TestObserver());
    }

    @Test
    public void notifyAllObservers_shouldNotify() {
        testObservable.subscribe(testObserver);

        testObservable.notifyAllObservers(new TestEvent());

        verify(testObserver).update(any(TestEvent.class));
    }

    @Test
    public void notifyAllObservers_shouldNotNotify_whenUnsubscribed() {
        testObservable.subscribe(testObserver);
        testObservable.unsubscribe(testObserver);

        testObservable.notifyAllObservers(new TestEvent());

        verify(testObserver, times(0)).update(any(TestEvent.class));
    }

    @Test
    public void notifyAllObservers_shouldNotifyAllObservers() {
        TestObserver testObserver2 = spy(new TestObserver());
        testObservable.subscribe(testObserver);
        testObservable.subscribe(testObserver2);

        testObservable.notifyAllObservers(new TestEvent());

        verify(testObserver).update(any(TestEvent.class));
        verify(testObserver2).update(any(TestEvent.class));
    }

}

