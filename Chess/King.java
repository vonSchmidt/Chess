package Chess;

public class King extends Piece{


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
