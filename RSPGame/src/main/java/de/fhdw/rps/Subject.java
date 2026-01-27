package de.fhdw.rps;

import de.fhdw.rps.mvcgui.Observer;

import java.util.ArrayList;
import java.util.List;

abstract class Subject {
    public List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o){
        observers.add(o);
    };

    abstract public void notifyObserver();

}