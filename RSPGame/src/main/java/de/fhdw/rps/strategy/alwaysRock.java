package de.fhdw.rps.strategy;

import de.fhdw.rps.Move;

public class alwaysRock implements CPUStrategy {

    @Override
    public Move strategizeMove() {
        return Move.ROCK;
    }
}
