package de.fhdw.rps;

import de.fhdw.rps.mvcgui.Observer;
import de.fhdw.rps.state.GameState;
import de.fhdw.rps.state.WaitingForPlayerOneState;
import de.fhdw.rps.state.WaitingForPlayerTwoState;

abstract public class RPSGame extends Subject{

   private final Player playerOne = new HumanPlayer();
   private Player playerTwo;
   private GameState state;

   public RPSGame() {
      this.state = new WaitingForPlayerOneState();
   }

   //Aufgerufen vom Controller
   public void playerChoose(Move move){
      this.state.performAction(this, move);
   }

   public void setState (GameState state) { this.state = state; }
   public GameState getState () { return state; };
   public void setPlayerOneMove(Move move){ this.playerOne.pendingMove = move; }
   public void setPlayerTwoMove(Move move){ this.playerTwo.pendingMove = move; }
   public Move getPendingMoveP1() { return this.playerOne.pendingMove; }
   public Move getPendingMoveP2() { return this.playerTwo.pendingMove; }
   public int getPlayerOneHP() { return this.playerOne.hitPoints; }
   public int getPlayerTwoHP() { return this.playerTwo.hitPoints; }
   public void takeDamageP1(){ playerOne.hitPoints--; }
   public void takeDamageP2(){ playerTwo.hitPoints--; }
   public boolean isGameOver(){return this.playerOne.hitPoints == 0 || this.playerTwo.hitPoints == 0;}
   protected void setPlayerTwo(Player playerTwo) { this.playerTwo = playerTwo; }

}
