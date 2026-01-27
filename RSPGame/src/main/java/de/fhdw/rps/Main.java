package de.fhdw.rps;

import de.fhdw.rps.mvcgui.RPSController;
import de.fhdw.rps.mvcgui.RPSView;
import de.fhdw.rps.state.WaitingForMoveState;

public class Main {

    public static void main(String[] args) {
        RPSGame gameModel = new RPSSingleplayer();
        gameModel.setState(new WaitingForMoveState());

        RPSView view = new RPSView();

        gameModel.addObserver(view);

        view.createAndShowGui();
        RPSController controller = new RPSController(gameModel, view);
    }
}
