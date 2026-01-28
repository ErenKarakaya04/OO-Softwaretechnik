package de.fhdw.rps.strategy;

import de.fhdw.rps.Move;

public class copyLastMove implements CPUStrategy {
    @Override
    public Move strategizeMove() {
        if (!previousMoves.isEmpty()) {
            return previousMoves.getLast();
        }
        return new alwaysRock().strategizeMove();
    }
}
