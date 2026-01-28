package de.fhdw.rps.state;

import de.fhdw.rps.Move;
import de.fhdw.rps.RPSGame;

public interface GameState {

    abstract public void performAction(RPSGame game, Move playerMove);

}
