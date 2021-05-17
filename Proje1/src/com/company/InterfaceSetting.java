package com.company;

public interface InterfaceSetting {
    public interface IObservable {
        void addObserve(IObserver observer);
        void removeObserver(IObserver observer);
        void notifyObserver();
    }
}
