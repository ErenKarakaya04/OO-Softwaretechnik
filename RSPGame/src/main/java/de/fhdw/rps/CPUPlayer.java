package de.fhdw.rps;

import de.fhdw.rps.strategy.CPUStrategy;
import de.fhdw.rps.strategy.alwaysRock;
import de.fhdw.rps.strategy.copyLastMove;

import java.util.Random;

public class CPUPlayer extends Player {
    private CPUStrategy strategy;

    public CPUPlayer() {
        Random rand = new Random();
        int strategieNum = rand.nextInt(2);
        switch (strategieNum) {
            case 0 -> this.strategy = new alwaysRock();
            case 1 -> this.strategy = new copyLastMove();
        }
    }

    public Move makeMove(){
        return strategy.strategizeMove();
    }

}
