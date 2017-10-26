package ca.crystalshard.ruby.common.domain.persistance.repositories;

import ca.crystalshard.TestInjectorProvider;
import com.google.inject.Injector;
import org.junit.AfterClass;

public class AbstractRepositoryTest {

    Injector injector;
    private static TestRepository testRepository;


    AbstractRepositoryTest() {
        this.injector = TestInjectorProvider.getInjector();
        testRepository = injector.getInstance(TestRepository.class);
    }

    @AfterClass
    public static void afterClass() {
        testRepository.cleanupDatabases();
    }

}
