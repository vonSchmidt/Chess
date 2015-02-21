package Chess;

import java.io.Serializable;
import java.util.Vector;


public abstract class Direction implements Serializable{

	private static final long serialVersionUID = -6056220710896687197L;

	protected Vector<Square> 
	valid_UP = new Vector<Square>(),
	valid_DOWN = new Vector<Square>(),
	valid_RIGHT = new Vector<Square>(),
	valid_LEFT = new Vector<Square>(),
	valid_UP_RIGHT = new Vector<Square>(),
	valid_UP_LEFT = new Vector<Square>(),
	valid_DOWN_RIGHT = new Vector<Square>(),
	valid_DOWN_LEFT = new Vector<Square>();

	
	public boolean existsThreat(Piece p, Board b) {
		getAllMoves(p, b);
		
		if(containsThreat(valid_UP, p))
			return true;
		if(containsThreat(valid_DOWN, p))
			return true;
		if(containsThreat(valid_LEFT, p))
			return true;
		if(containsThreat(valid_RIGHT, p))
			return true;
		if(containsThreat(valid_UP_LEFT, p))
			return true;
		if(containsThreat(valid_UP_RIGHT, p))
			return true;
		if(containsThreat(valid_DOWN_LEFT, p))
			return true;
		if(containsThreat(valid_DOWN_RIGHT, p))
			return true;
		clear();
		return false;
	}

	protected boolean containsThreat(Vector<Square> v, Piece p){
		for(Square s:v){
			if(s.getPiece_occupying()==null)
				continue;
			if(s.getPiece_occupying().color==p.color)
				break;
			if(s.getPiece_occupying().gmove.getDirection().getClass()
					.getSimpleName().equals(this.getClass().getSimpleName())){
				Move m = new Move(s.getPiece_occupying().square, p.square);
				if(s.getPiece_occupying().gmove.isValidMove(m, p.color.getInverse())){
					return true;
				}
			}
		}
		return false;
	}
	
	
	public abstract boolean check_validity(Move m, Color c);
	protected abstract void getAllMoves(Piece p, Board b);
	public abstract boolean isPossible(Move m);
	protected void clear() {
		valid_UP.clear();
		valid_DOWN.clear();
		valid_LEFT.clear();
		valid_RIGHT.clear();
		valid_UP_LEFT.clear();
		valid_UP_RIGHT.clear();
		valid_DOWN_LEFT.clear();
		valid_DOWN_RIGHT.clear();

	}
	
	protected void printMoves(){
		System.out.println("DOWN");
		printMoveIn(valid_DOWN);
		
		System.out.println("UP");
		printMoveIn(valid_UP);
		
		System.out.println("LEFT");
		printMoveIn(valid_LEFT);
		
		System.out.println("RIGHT");
		printMoveIn(valid_RIGHT);
		
		System.out.println("DOWN_LEFT");
		printMoveIn(valid_DOWN_LEFT);
		
		System.out.println("DOWN_RIGHT");
		printMoveIn(valid_DOWN_RIGHT);
		
		System.out.println("UP_RIGHT");
		printMoveIn(valid_UP_RIGHT);
		
		System.out.println("UP_LEFT");
		printMoveIn(valid_UP_LEFT);
	}
	private void printMoveIn(Vector<Square> v){
		for(Square s:v){
			System.out.print(s.getPiece_occupying()+" ");
		}
		System.out.println();
	}
	
}
