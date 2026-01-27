package de.fhdw.rps.state;

import de.fhdw.rps.RPSGame;

public interface GameState {

    abstract public void performAction(RPSGame game);

    abstract public boolean isManualTransitionAllowed();
}
