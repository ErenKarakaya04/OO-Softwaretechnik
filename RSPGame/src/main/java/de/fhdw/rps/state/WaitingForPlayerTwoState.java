package de.fhdw.rps.state;

import de.fhdw.rps.Move;
import de.fhdw.rps.RPSGame;
import de.fhdw.rps.RPSSingleplayer;

public class WaitingForPlayerTwoState implements GameState{
    @Override
    public void performAction(RPSGame game, Move playerMove) {
        game.setPlayerTwoMove(playerMove);
        game.setState(new ResolveRoundState());
    }
}
