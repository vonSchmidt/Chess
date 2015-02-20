package Chess;

import java.io.Serializable;

public class GeneralMove implements Serializable{

	private static final long serialVersionUID = 2531833000808985025L;
	private Displacement displacement;
    private Direction direction;



    public GeneralMove(Displacement displacement, Direction direction){
        this.displacement = displacement;
        this.setDirection(direction);
    }

    public boolean isValidMove(Move m, Color c){
        return (displacement.check_validity(m) && getDirection().check_validity(m, c));
    }

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

}
