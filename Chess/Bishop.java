package Chess;

public class Bishop extends Piece {

	private static final long serialVersionUID = -2040059264534118694L;

	public Bishop(Color color){
        this.color=color;
        symbol = "♝";
        name = "B";
        gmove = new GeneralMove(new MultipleStepDisplacement(), new DiagonalDirection());
    }
}
