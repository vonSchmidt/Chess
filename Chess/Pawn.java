package Chess;

public class Pawn extends Piece {

	private static final long serialVersionUID = 1055530432396175994L;
	private boolean moved;
	
	public Pawn(Color color){
		moved = false;
		this.color=color;
		symbol = "♟";
		name = "p";
		gmove = new GeneralMove(new DoubleStepDisplacement(), new PawnStraightDirection());
	}
	
	public void setMoved(){
		this.moved = true;
		this.gmove = new GeneralMove(new SingleStepDisplacement(), new PawnStraightDirection());
	}
	public boolean getMoved(){ return moved; }
}
