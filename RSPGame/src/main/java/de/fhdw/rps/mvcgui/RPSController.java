package de.fhdw.rps.mvcgui;

import de.fhdw.rps.Move;
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

    public void registerEvent(){
        view.setPaperButtonEventListener(e -> model.playerChoose(Move.PAPER));
        view.setRockButtonEventListener(e -> model.playerChoose(Move.ROCK));
        view.setScissorsButtonEventListener(e -> model.playerChoose(Move.SCISSORS));
    }

}
