package de.fhdw.rps;

import java.util.List;

abstract public class Player {

    public int hitPoints = 3;
    public List<Move> previousMoves;

    public void appendMove(Move move){previousMoves.add(move);}
    public void takeDamage(){ hitPoints -= 1; }

}
