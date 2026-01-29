package de.fhdw.rps;

import de.fhdw.rps.strategy.CPUStrategy;
import de.fhdw.rps.strategy.alwaysRock;
import de.fhdw.rps.strategy.copyLastMove;
import de.fhdw.rps.strategy.randomMove;

import java.util.Random;

public class CPUPlayer extends Player {
    private CPUStrategy strategy;

    public CPUPlayer() {
        Random rand = new Random();
        int strategieNum = rand.nextInt(3);
        switch (strategieNum) {
            case 0 -> this.strategy = new alwaysRock();
            case 1 -> this.strategy = new copyLastMove();
            case 2 -> this.strategy = new randomMove();
        }
    }

    public Move makeMove(){
        return strategy.strategizeMove();
    }

}
