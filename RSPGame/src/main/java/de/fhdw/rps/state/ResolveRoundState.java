package de.fhdw.rps.state;

import de.fhdw.rps.Move;
import de.fhdw.rps.RPSGame;

public class ResolveRoundState implements GameState{
    @Override
    public void performAction(RPSGame game) {

        Move p1 = game.getPendingMoveP1();
        Move p2 = game.getPendingMoveP2();
        game.evaluateRound(p1, p2);
        game.clearPendingMoves();

        if (game.isGameOver()){
            System.out.println("Spiel ist vorbei, Gewinner wird festgelegt");
            game.setState(new GameOverState());
        }
        else{
            System.out.println("Spiel ist noch nicht vorbei, auf neuen Zug warten");
            game.setState(new WaitingForMoveState());
        }
    }

    @Override
    public boolean isManualTransitionAllowed() {
        return false;
    }
}
