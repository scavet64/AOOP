package com.scavetta.observerProject.observerAPI;

public interface IObservableData {
    void registerObserver(IObserver o);
    void removeObserver(IObserver o);
    void notifyObservers(Object observableData);
    void removeAllObservers();
}
