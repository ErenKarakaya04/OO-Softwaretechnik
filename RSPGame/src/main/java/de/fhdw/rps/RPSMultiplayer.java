package de.fhdw.rps;

import de.fhdw.rps.state.GameState;

public class RPSMultiplayer extends  RPSGame {

    public RPSMultiplayer() {
        this.setPlayerTwo(new HumanPlayer());
    }
}
