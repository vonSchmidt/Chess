package Chess;


public class StraightDirection extends Direction {

	@Override
	public boolean check_validity(Move m, Color c) {
		return (m.getStart().getX()==m.getEnd().getX() || m.getStart().getY()==m.getEnd().getY());
	}

	@Override
	public void getAllMoves(Piece p, Board b) {
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
				break;
			}
			else{
				valid_UP.add(b.getSquares()[i][p.square.getY()]);
			}

		}


	}

	@Override
	public boolean isPossible(Move m) {
		if(valid_DOWN.contains(m.getEnd())||valid_UP.contains(m.getEnd())||valid_RIGHT.contains(m.getEnd())||valid_LEFT.contains(m.getEnd()))
			return true;
		return false;
	}


}
