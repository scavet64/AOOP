package com.scavetta.observerProject.observerAPI;

import java.util.ArrayList;

public class ObservableDataHelper implements IObservableData{

    private ArrayList<IObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(IObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(IObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(Object observableData) {
        for(IObserver observer: observers){
            observer.update(observableData);
        }
    }

    @Override
    public void removeAllObservers() {
        observers.clear();
    }
}
