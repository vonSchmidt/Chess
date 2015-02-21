package Chess;

import java.io.Serializable;

public class Checker implements Serializable{

	private Board board;
	private Game game;
	
	private static final long serialVersionUID = -1685845427778545094L;

	public Checker(Board b, Game g){
		this.board = b;
		this.game = g;
	}
	
	public Board getBoard(){ return board; }
	
	public void chgameState(Team member) {
		// Check for game state (examine king's position)
		//member.set[0] // That's the king
		game.update_gs(((King) member.getSet()[0]).isInDanger(board, member));

	}
	
}
