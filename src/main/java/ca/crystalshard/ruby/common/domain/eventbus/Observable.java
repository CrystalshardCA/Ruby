package ca.crystalshard.ruby.common.domain.eventbus;

import java.util.HashSet;
import java.util.Set;

public abstract class Observable {

    private Set<Observer> observers;

    protected Observable() {
        observers = new HashSet<>();
    }

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void notifyAllObservers(Event event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }

}

