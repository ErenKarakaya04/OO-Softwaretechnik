package de.fhdw.rps.strategy;

import de.fhdw.rps.Move;

import java.util.ArrayList;
import java.util.List;

public interface CPUStrategy {
    public List<Move> previousMoves = new ArrayList<Move>();
    public Move strategizeMove();
}
