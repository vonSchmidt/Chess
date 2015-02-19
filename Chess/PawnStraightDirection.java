package Chess;

public class PawnStraightDirection extends Direction{
	
	@Override
	public boolean check_validity(Move m, Color c) {
				int dy=(m.getStart().getY()-m.getEnd().getY());
		if(c==Color.WHITE){
			
				if(dy==0||Math.abs(dy)==1)
					return true;
			return false;
			
		}else{
				if(dy==0||Math.abs(dy)==1)
					return true;
			return false;
		}
	}
	@Override
	public void getAllMoves(Piece p, Board b) {
		getUp(p, b);
		getDown(p, b);
		getUpLeft(p, b);
		getDownLeft(p, b);
		getUpRight(p, b);
		getDownRight(p, b);
	}
	@Override
	public boolean isPossible(Move m) {
		return (valid_DOWN.contains(m.getEnd())||valid_UP.contains(m.getEnd())||valid_UP_LEFT.contains(m.getEnd())||valid_UP_RIGHT.contains(m.getEnd())||
				valid_DOWN_RIGHT.contains(m.getEnd())||valid_DOWN_LEFT.contains(m.getEnd()));
	}

	public void getDown(Piece p, Board b) {
		for(int i=p.square.getX()+1;i<8;i++){
			if(b.getSquares()[i][p.square.getY()].getPiece_occupying()!=null)
					break;
			else{
				valid_DOWN.add(b.getSquares()[i][p.square.getY()]);
			}

		}

	}

	public void getUp(Piece p, Board b) {
		for(int i=p.square.getX()-1;i>=0;i--){
			if(b.getSquares()[i][p.square.getY()].getPiece_occupying()!=null)
				break;
			else{
				valid_UP.add(b.getSquares()[i][p.square.getY()]);
			}

		}


	}
	
	public void getUpRight(Piece p, Board b) {
		for(int i=p.square.getX()-1,j=p.square.getY()+1 ; i>=0 && j<8 ;){
			if(b.getSquares()[i][j].getPiece_occupying()!=null && b.getSquares()[i][j].getPiece_occupying().color!=p.color){
				valid_UP_RIGHT.add(b.getSquares()[i][j]);
				break;
			}
			else
				break;
		}
		
	}

	public void getDownRight(Piece p, Board b) {
		for(int i=p.square.getX()+1,j=p.square.getY()+1 ; i<8 && j<8 ;){
			if(b.getSquares()[i][j].getPiece_occupying()!=null && b.getSquares()[i][j].getPiece_occupying().color!=p.color){
				valid_DOWN_RIGHT.add(b.getSquares()[i][j]);
				break;
			}
			else
				break;
		}
		
	}

	public void getDownLeft(Piece p, Board b) {
		for(int i=p.square.getX()+1,j=p.square.getY()-1 ; i<8 && j>=0 ;){
			if(b.getSquares()[i][j].getPiece_occupying()!=null && b.getSquares()[i][j].getPiece_occupying().color!=p.color){
				valid_DOWN_LEFT.add(b.getSquares()[i][j]);
				break;
			}
			else
				break;
		}
		
	}

	public void getUpLeft(Piece p, Board b) {
		for(int i=p.square.getX()-1,j=p.square.getY()-1 ; i>=0 && j>=0 ;){
			if(b.getSquares()[i][j].getPiece_occupying()!=null && b.getSquares()[i][j].getPiece_occupying().color!=p.color){
				valid_UP_LEFT.add(b.getSquares()[i][j]);
				break;
			}
				
			else
				break;
		}
		
	}

}
