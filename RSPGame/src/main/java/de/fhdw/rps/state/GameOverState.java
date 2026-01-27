package de.fhdw.rps.state;

import de.fhdw.rps.RPSGame;

public class GameOverState implements GameState{
    @Override
    public void performAction(RPSGame game) {
        System.out.println("Game Over");
    }

    @Override
    public boolean isManualTransitionAllowed() {
        return false;
    }
}
