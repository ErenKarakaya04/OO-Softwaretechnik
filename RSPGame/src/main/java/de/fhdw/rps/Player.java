package de.fhdw.rps;

import java.util.List;

abstract public class Player {

    public int hitPoints = 3;
    public Move pendingMove;
    public List<Move> previousMoves;

}
