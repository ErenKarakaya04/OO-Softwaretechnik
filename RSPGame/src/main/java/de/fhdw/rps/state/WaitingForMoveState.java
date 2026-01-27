package de.fhdw.rps.state;

import de.fhdw.rps.RPSGame;

public class WaitingForMoveState implements GameState{
    @Override
    public void performAction(RPSGame game) {
        game.setState(new ResolveRoundState());
    }

    @Override
    public boolean isManualTransitionAllowed() {
        return false;
    }
}
