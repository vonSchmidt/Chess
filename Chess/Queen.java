package Chess;

public class Queen extends Piece {

	private static final long serialVersionUID = -886916259921994612L;

	public Queen(Color color) {
		this.color=color;
		symbol = "♛";
		name = "Q";
		gmove = new GeneralMove(new MultipleStepDisplacement(), new AllDirection());
	}

}
