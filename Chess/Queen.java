package Chess;

public class Queen extends Piece {

	public Queen(Color color) {
		this.color=color;
		symbol = "♛";
		name = "Q";
		gmove = new GeneralMove(new MultipleStepDisplacement(), new AllDirection());
	}

}
