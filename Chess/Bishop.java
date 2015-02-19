package Chess;

public class Bishop extends Piece {

    public Bishop(Color color){
        this.color=color;
        symbol = "♝";
        name = "B";
        gmove = new GeneralMove(new MultipleStepDisplacement(), new DiagonalDirection());
    }
}
