package Chess;

public class Knight extends Piece {

	public Knight(Color color){
		this.color=color;
		symbol = "♞";
		name = "k";
		gmove = new GeneralMove(new MultipleStepDisplacement(), new LshapedDirection());
	}

}
