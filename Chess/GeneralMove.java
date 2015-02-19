package Chess;
public class GeneralMove{

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
