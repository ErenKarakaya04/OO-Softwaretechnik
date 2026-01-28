package de.fhdw.rps.state;

import de.fhdw.rps.Move;
import de.fhdw.rps.RPSGame;
import de.fhdw.rps.RPSSingleplayer;

public class WaitingForPlayerOneState implements GameState{

    @Override
    public void performAction(RPSGame game, Move playerMove) {
        game.setPlayerOneMove(playerMove);
        game.setState(new WaitingForPlayerTwoState());

        if (game instanceof RPSSingleplayer) {
            GameState state = game.getState();
            state.performAction(game, ((RPSSingleplayer)game).makePlayerTwoMove());
        }
    }

}
