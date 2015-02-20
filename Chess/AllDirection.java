package Chess;

public class AllDirection extends Direction {

	private static final long serialVersionUID = -5321646452886565611L;


	@Override
    public boolean check_validity(Move m, Color c) {
        return true;
    }

    @Override
    public void getAllMoves(Piece p, Board b) {
        getUpLeft(p, b);
        getDownLeft(p, b);
        getDownRight(p, b);
        getUpRight(p, b);
        getUp(p, b);
        getDown(p, b);
        getLeft(p, b);
        getRight(p, b);

    }

    public void getRight(Piece p, Board b) {
        for(int i=p.square.getY()+1;i<8;i++){
            if(b.getSquares()[p.square.getX()][i].getPiece_occupying()!=null){ // that piece/square we're currently checking

                if(b.getSquares()[p.square.getX()][i].getPiece_occupying().color!=p.color){
                    valid_RIGHT.add(b.getSquares()[p.square.getX()][i]);
                    break;
                }
                else
                    break;
            }
            else{
                valid_RIGHT.add(b.getSquares()[p.square.getX()][i]);
            }
        }
    }

    public void getLeft(Piece p, Board b) {
        for(int i=p.square.getY()-1;i>=0;i--){
            if(b.getSquares()[p.square.getX()][i].getPiece_occupying()!=null){
                if(b.getSquares()[p.square.getX()][i].getPiece_occupying().color!=p.color){
                    valid_LEFT.add(b.getSquares()[p.square.getX()][i]);
                    break;
                }
                else
                    break;
            }
            else{
                valid_LEFT.add(b.getSquares()[p.square.getX()][i]);
            }

        }

    }

    public void getDown(Piece p, Board b) {
        for(int i=p.square.getX()+1;i<8;i++){
            if(b.getSquares()[i][p.square.getY()].getPiece_occupying()!=null){
                if(b.getSquares()[i][p.square.getY()].getPiece_occupying().color!=p.color){
                    valid_DOWN.add(b.getSquares()[i][p.square.getY()]);
                    break;
                }
                else
                    break;
            }
            else{
                valid_DOWN.add(b.getSquares()[i][p.square.getY()]);
            }

        }

    }

    public void getUp(Piece p, Board b) {
        for(int i=p.square.getX()-1;i>=0;i--){
            if(b.getSquares()[i][p.square.getY()].getPiece_occupying()!=null){
                if(b.getSquares()[i][p.square.getY()].getPiece_occupying().color!=p.color){
                    valid_UP.add(b.getSquares()[i][p.square.getY()]);
                    break;
                }
                else
                    break;
            }
            else{
                valid_UP.add(b.getSquares()[i][p.square.getY()]);
            }

        }


    }

    public void getUpRight(Piece p, Board b) {
        for(int i=p.square.getX()-1,j=p.square.getY()+1 ; i>=0 && j<8 ; i--,j++){
            if(b.getSquares()[i][j].getPiece_occupying()==null){
                valid_UP_RIGHT.add(b.getSquares()[i][j]);
            }
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
            if(b.getSquares()[i][j].getPiece_occupying()==null){
                valid_DOWN_RIGHT.add(b.getSquares()[i][j]);
            }
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
            if(b.getSquares()[i][j].getPiece_occupying()==null){
                valid_DOWN_LEFT.add(b.getSquares()[i][j]);
            }
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
            if(b.getSquares()[i][j].getPiece_occupying()==null){
                valid_UP_LEFT.add(b.getSquares()[i][j]);
            }
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
        return valid_DOWN.contains(m.getEnd())||valid_UP.contains(m.getEnd())||valid_RIGHT.contains(m.getEnd())||
            valid_LEFT.contains(m.getEnd())||valid_UP_LEFT.contains(m.getEnd())||valid_UP_RIGHT.contains(m.getEnd())||
            valid_DOWN_RIGHT.contains(m.getEnd())||valid_DOWN_LEFT.contains(m.getEnd());
    }
}
