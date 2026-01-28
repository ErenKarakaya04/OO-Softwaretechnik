package de.fhdw.rps.mvcgui;

import de.fhdw.rps.Move;

public interface Observer {
    public void update(int p1Health, int p2Health, Move p1Move, Move p2Move);
}
