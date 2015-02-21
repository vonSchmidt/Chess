package Chess;


public class DiagonalDirection extends Direction{
	
	private static final long serialVersionUID = -6605332339276010807L;

	@Override
    public boolean check_validity(Move m, Color c) {
        int dx=Math.abs(m.getStart().getX()-m.getEnd().getX());
        int dy=Math.abs(m.getStart().getY()-m.getEnd().getY());
        return dx==dy;
    }

    @Override
    protected void getAllMoves(Piece p, Board b) {
        getUpLeft(p, b);
        getDownLeft(p, b);
        getDownRight(p, b);
        getUpRight(p, b);
    }

    public void getUpRight(Piece p, Board b) {
        for(int i=p.square.getX()-1,j=p.square.getY()+1 ; i>=0 && j<8 ; i--,j++){
            if(b.getSquares()[i][j].getPiece_occupying()==null)
                valid_UP_RIGHT.add(b.getSquares()[i][j]);
            else{
                if(b.getSquares()[i][j].getPiece_occupying().color!=p.color){
                    valid_UP_RIGHT.add(b.getSquares()[i][j]);
                    break;
                }
                else break;
            }
        }

    }

    public void getDownRight(Piece p, Board b) {
        for(int i=p.square.getX()+1,j=p.square.getY()+1 ; i<8 && j<8 ; i++,j++){
            if(b.getSquares()[i][j].getPiece_occupying()==null)
                valid_DOWN_RIGHT.add(b.getSquares()[i][j]);
            else{
                if(b.getSquares()[i][j].getPiece_occupying().color!=p.color){
                    valid_DOWN_RIGHT.add(b.getSquares()[i][j]);
                    break;
                }
                else break;
            }
        }

    }

    public void getDownLeft(Piece p, Board b) {
        for(int i=p.square.getX()+1,j=p.square.getY()-1 ; i<8 && j>=0 ; i++,j--){
            if(b.getSquares()[i][j].getPiece_occupying()==null)
                valid_DOWN_LEFT.add(b.getSquares()[i][j]);
            else{
                if(b.getSquares()[i][j].getPiece_occupying().color!=p.color){
                    valid_DOWN_LEFT.add(b.getSquares()[i][j]);
                    break;
                }
                else break;
            }

        }

    }

    public void getUpLeft(Piece p, Board b) {
        for(int i=p.square.getX()-1,j=p.square.getY()-1 ; i>=0 && j>=0 ; i--,j--){
            if(b.getSquares()[i][j].getPiece_occupying()==null)
                valid_UP_LEFT.add(b.getSquares()[i][j]);
            else{
                if(b.getSquares()[i][j].getPiece_occupying().color!=p.color){
                    valid_UP_LEFT.add(b.getSquares()[i][j]);
                    break;
                }
                else break;
            }
        }

    }

    @Override
    public boolean isPossible(Move m) {
        if(valid_UP_LEFT.contains(m.getEnd())||valid_UP_RIGHT.contains(m.getEnd())||valid_DOWN_RIGHT.contains(m.getEnd())||valid_DOWN_LEFT.contains(m.getEnd()))
            return true;
        return false;
    }


}

