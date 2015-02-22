package Chess;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Vector;

public class Checker implements Serializable{

	private static final long serialVersionUID = -1685845427778545094L;
	private Board board;
	private Game game;
	
	public LinkedList<Square> computeKingMoves(Team m){
		LinkedList<Square> possibleKingMoves = new LinkedList<Square>();
		LinkedList<Square> KingMoves = new LinkedList<Square>();
		King k = ((King) m.getSet()[0]);
		Square tmp = k.square;
		k.gmove.getDirection().getAllMoves(k, board);
		
		fix(k.gmove.getDirection().valid_UP, tmp, possibleKingMoves);
		fix(k.gmove.getDirection().valid_LEFT, tmp, possibleKingMoves);
		fix(k.gmove.getDirection().valid_DOWN, tmp, possibleKingMoves);
		fix(k.gmove.getDirection().valid_RIGHT, tmp, possibleKingMoves);
		fix(k.gmove.getDirection().valid_UP_LEFT, tmp, possibleKingMoves);
		fix(k.gmove.getDirection().valid_UP_RIGHT, tmp, possibleKingMoves);
		fix(k.gmove.getDirection().valid_DOWN_LEFT, tmp, possibleKingMoves);
		fix(k.gmove.getDirection().valid_DOWN_RIGHT, tmp, possibleKingMoves);
		
		k.gmove.getDirection().clear();
		
		k = new King(m.getColor());
		GAME_STATE g;
		Piece x = null;
		for(Square s : possibleKingMoves){
			if(board.getSquares()[s.getX()][s.getY()].getPiece_occupying() != null)
				x = board.getSquares()[s.getX()][s.getY()].getPiece_occupying();
			k.square = s;
			board.getSquares()[s.getX()][s.getY()].setPiece_occupying(k);

			g = k.isInDanger(board, m);
			if(m.getColor() == Color.WHITE 
					&& !(g == GAME_STATE.WHITE_IN_CHECK))
				KingMoves.add(s);
			else if (m.getColor() == Color.BLACK 
					&& !(g == GAME_STATE.BLACK_IN_CHECK))
				KingMoves.add(s);
			
			// Cleaning a bit
			k.square = null;
			board.getSquares()[s.getX()][s.getY()].setPiece_occupying(x);
			x = null;
		}
		
		return KingMoves;
	}
	
	private void fix(Vector<Square> v, Square init, LinkedList<Square> dest){
		for(Square s : v){
			if(new SingleStepDisplacement()
			.check_validity(new Move(init, s)))
				dest.add(s);
		}
	}
	

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
