package Chess;

public class Rook extends Piece {

	private static final long serialVersionUID = -5941801332680382603L;

	public Rook(Color color){
		this.color=color;
		symbol = "♜";
		name = "R";
		gmove = new GeneralMove(new MultipleStepDisplacement(), new StraightDirection());
	}
}
