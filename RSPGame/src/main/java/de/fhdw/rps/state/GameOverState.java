package de.fhdw.rps.state;

import de.fhdw.rps.Move;
import de.fhdw.rps.RPSGame;

public class GameOverState implements GameState{
    @Override
    public void performAction(RPSGame game, Move playerMove) {
        Move p1Move = game.getPendingMoveP1();
        Move p2Move = game.getPendingMoveP2();
        System.out.println("Game Over");
        game.notifyObserver(game.getPlayerOneHP(), game.getPlayerTwoHP(), p1Move, p2Move);
    }

}
