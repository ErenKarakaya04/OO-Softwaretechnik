package de.fhdw.rps;

import de.fhdw.rps.mvcgui.RPSController;
import de.fhdw.rps.mvcgui.RPSView;
import de.fhdw.rps.state.WaitingForPlayerOneState;

public class Main {

    public static void main(String[] args) {
        RPSGame gameModel = new RPSSingleplayer();

        RPSView view = new RPSView();

        gameModel.addObserver(view);

        RPSController controller = new RPSController(gameModel, view);
        controller.registerEvent();
    }
}
