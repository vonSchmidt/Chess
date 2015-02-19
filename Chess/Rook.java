package Chess;

public class Rook extends Piece {

	public Rook(Color color){
		this.color=color;
		symbol = "♜";
		name = "R";
		gmove = new GeneralMove(new MultipleStepDisplacement(), new StraightDirection());
	}
}
