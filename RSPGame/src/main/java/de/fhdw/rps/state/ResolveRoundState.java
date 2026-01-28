package de.fhdw.rps.state;

import de.fhdw.rps.Move;
import de.fhdw.rps.RPSGame;

public class ResolveRoundState implements GameState{

    @Override
    public void performAction(RPSGame game, Move playerMove) {
        Move p1Move = game.getPendingMoveP1();
        Move p2Move = game.getPendingMoveP2();

        switch (p1Move){
            case ROCK -> {
                if(p2Move.equals(Move.PAPER)){
                    game.takeDamageP1();
                }
                else if(p2Move.equals(Move.SCISSORS)){
                    game.takeDamageP2();
                }
            }
            case PAPER -> {
                if (p2Move.equals(Move.SCISSORS)) {
                    game.takeDamageP1();
                }
                else if (p2Move.equals(Move.ROCK)) {
                    game.takeDamageP2();
                }
            }
            case SCISSORS -> {
                if (p2Move.equals(Move.ROCK)) {
                    game.takeDamageP1();
                }
                else if (p2Move.equals(Move.PAPER)) {
                    game.takeDamageP2();
                }
            }
        }
        if(game.isGameOver()){
            game.setState(new GameOverState());
            game.getState().performAction(game, playerMove);
        }
        else {
            game.setState(new WaitingForPlayerOneState());
        }
        game.notifyObserver(game.getPlayerOneHP(), game.getPlayerTwoHP(), p1Move, p2Move);
    }

}
