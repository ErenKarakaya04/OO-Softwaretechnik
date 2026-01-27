package de.fhdw.rps.mvcgui;

import de.fhdw.rps.RPSGame;

public class RPSController {

    private RPSView view;
    private RPSGame model;


    public RPSController(RPSGame model, RPSView view) {
        // This is constructor dependency injection!
        this.view = view;
        this.model = model;
        registerEvent();
    }

    private void registerEvent(){
        view.setPaperButtonEventListener(e -> model.playerChoosePaper());
        view.setRockButtonEventListener(e -> model.playerChooseRock());
        view.setScissorsButtonEventListener(e -> model.playerChooseScissor());
    }

}
