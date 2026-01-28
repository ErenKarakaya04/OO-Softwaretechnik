package de.fhdw.rps;

import de.fhdw.rps.mvcgui.Observer;
import de.fhdw.rps.state.GameState;

import java.util.ArrayList;
import java.util.List;

abstract class Subject {
    public List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o){
        observers.add(o);
    };

    public void notifyObserver(int p1Health, int p2Health, Move p1Move, Move p2Move){
        for(Observer o : observers){
            o.update(p1Health, p2Health, p1Move, p2Move);
        }
    }

}