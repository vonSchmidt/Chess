package Chess;

public class Knight extends Piece {

	private static final long serialVersionUID = -5472800360282227413L;

	public Knight(Color color){
		this.color=color;
		symbol = "♞";
		name = "k";
		gmove = new GeneralMove(new MultipleStepDisplacement(), new LshapedDirection());
	}

}
