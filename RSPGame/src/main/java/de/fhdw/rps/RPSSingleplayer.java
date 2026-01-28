package de.fhdw.rps;

import de.fhdw.rps.mvcgui.Observer;
import de.fhdw.rps.state.GameState;

public class RPSSingleplayer extends RPSGame {

    private final CPUPlayer cpuPlayer = new CPUPlayer();

    public RPSSingleplayer() {
        this.setPlayerTwo(cpuPlayer);
    }

    public Move makePlayerTwoMove() {
        return cpuPlayer.makeMove();
    }

}
