package Chess;

import java.util.Vector;

public abstract class Piece{
	protected String name;
	protected String symbol = "";
	protected Square square;
	protected GeneralMove gmove;
	protected Move move;
	protected Vector<Square> possibleMoves;
	protected Color color;

	
	public String toString(){
		switch (this.color){
		
		case BLACK:
			return "\033[31;44m "+ symbol +" \033[0m";
						
		case WHITE:
			return "\033[34;47m " + symbol +" \033[0m";
					
		default:
			return "";
		
		}
	}


//	public GAME_STATE isInDanger(Board board, Team member) {
//		return GAME_STATE.NOTHING;
//	}


	public String getSymbol() {
		return symbol;
	}
}
