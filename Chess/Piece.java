package Chess;

import java.io.Serializable;
import java.util.Vector;

public abstract class Piece implements Serializable{

	private static final long serialVersionUID = -574606787013779658L;
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
			return "\033[34;43m " + symbol +" \033[0m";
					
		default:
			return "";
		
		}
	}

	public String getSymbol() {
		return symbol;
	}
}
