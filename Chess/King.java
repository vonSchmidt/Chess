package Chess;

public class King extends Piece{

	private static final long serialVersionUID = -6442590757910939157L;
	public King(Color color){
        name = "K";
        symbol = "♚";
        this.color = color;
        gmove = new GeneralMove(new SingleStepDisplacement(), new AllDirection());
    }
    public GAME_STATE isInDanger(Board board, Team member){

        return GAME_STATE.NOTHING; //TODO check all threats
    }
}
