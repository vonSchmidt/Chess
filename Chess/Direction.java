package Chess;

import java.io.Serializable;
import java.util.Vector;


public abstract class Direction implements Serializable{

	private static final long serialVersionUID = -6056220710896687197L;
	protected Vector<Square> valid_UP = new Vector<Square>(),
           valid_DOWN = new Vector<Square>(),
           valid_RIGHT = new Vector<Square>(),
           valid_LEFT = new Vector<Square>(),
           valid_UP_RIGHT = new Vector<Square>(),
           valid_UP_LEFT = new Vector<Square>(),
           valid_DOWN_RIGHT = new Vector<Square>(),
           valid_DOWN_LEFT = new Vector<Square>();



    public abstract boolean check_validity(Move m, Color c);
    public abstract void getAllMoves(Piece p, Board b);
    public abstract boolean isPossible(Move m);
    public void clear() {
        valid_UP.clear();
        valid_DOWN.clear();
        valid_LEFT.clear();
        valid_RIGHT.clear();
        valid_UP_LEFT.clear();
        valid_UP_RIGHT.clear();
        valid_DOWN_LEFT.clear();
        valid_DOWN_RIGHT.clear();

    }
}
