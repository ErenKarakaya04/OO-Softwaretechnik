package de.fhdw.rps.strategy;

import de.fhdw.rps.Move;

import static de.fhdw.rps.Move.getRandomMove;

public class randomMove implements CPUStrategy {

    @Override
    public Move strategizeMove() {
        return getRandomMove();
    }
}
