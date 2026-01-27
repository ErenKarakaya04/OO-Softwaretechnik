package de.fhdw.rps;

import de.fhdw.rps.mvcgui.Observer;
import de.fhdw.rps.state.GameState;

abstract public class RPSGame extends Subject{

   private Player playerOne;
   private Player playerTwo;
   private Move pendingMoveP1;
   private Move pendingMoveP2;
   private GameState state;

   public int[] getPlayerHP() {
      return new int[]{this.playerOne.hitPoints, this.playerOne.hitPoints};
   }

   public void setState(GameState state){
      this.state = state;
   }

   public void nextStep(){
      this.state.performAction(this);
   }



   //Aufgerufen vom Controller
   public void playerChooseRock(){processMove(Move.ROCK);}
   public void playerChoosePaper(){processMove(Move.PAPER);}
   public void playerChooseScissor(){processMove(Move.SCISSORS);}

   private void processMove(Move move){
      this.pendingMoveP1 = move;
      this.nextStep();
      this.notifyObserver();
   }

   public void evaluateRound(Move p1, Move p2) {
      if (p1 == null || p2 == null) {
         throw new IllegalStateException("Moves dürfen nicht null sein");
      }

      switch (p1) {
         case ROCK -> {
            if (p2 == Move.SCISSORS) playerTwo.takeDamage();
            else if (p2 == Move.PAPER) playerOne.takeDamage();
         }
         case PAPER -> {
            if (p2 == Move.ROCK) playerTwo.takeDamage();
            else if (p2 == Move.SCISSORS) playerOne.takeDamage();
         }
         case SCISSORS -> {
            if (p2 == Move.PAPER) playerTwo.takeDamage();
            else if (p2 == Move.ROCK) playerOne.takeDamage();
         }
      }
   }

   public boolean isGameOver(){
      return this.playerOne.hitPoints == 0 || this.playerTwo.hitPoints == 0;
   }
   public Move getPendingMoveP1(){ return pendingMoveP1; }
   public Move getPendingMoveP2(){ return pendingMoveP2; }
   public void setPendingMoveP2(Move move){ this.pendingMoveP2 = move; }
   public void clearPendingMoves(){
      playerOne.appendMove(pendingMoveP1);
      playerTwo.appendMove(pendingMoveP2);
      this.pendingMoveP1 = null;
      this.pendingMoveP2 = null;
   }

   @Override
   public void notifyObserver() {

   }
}
