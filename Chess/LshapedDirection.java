package Chess;


public class LshapedDirection extends Direction {

	private static final long serialVersionUID = 3697027994311085508L;

	@Override
	public boolean check_validity(Move m, Color c) {
		int dx=Math.abs(m.getStart().getX()-m.getEnd().getX());
		int dy=Math.abs(m.getStart().getY()-m.getEnd().getY());
		boolean check=
				(dx==1 && dy==2)||(dx==2 && dy==1);
		return check;
	}

	@Override
	public void getAllMoves(Piece p, Board b) {
		//all moves according to LshapedDirection are to be accepted
		//no need for implementation here
	}

	@Override
	public boolean isPossible(Move m) {
		//All are possible
		return true;
	}

	@Override
	public boolean existsThreat(Piece p, Board b) {
		if(LShapedMove(p, b, -1, 2))
			return true;
		if(LShapedMove(p, b, -1, -2))
			return true;
		if(LShapedMove(p, b, 1, 2))
			return true;
		if(LShapedMove(p, b, 1, -2))
			return true;
		if(LShapedMove(p, b, 2, -1))
			return true;
		if(LShapedMove(p, b, 2, 1))
			return true;
		if(LShapedMove(p, b, -2, 1))
			return true;
		if(LShapedMove(p, b, -2, -1))
			return true;
		return false;
	}
	
	private boolean LShapedMove(Piece p, Board b, int x, int y){
		if(p.square.getX()+x > 7 || p.square.getY()+y > 7
			|| 	p.square.getX()+x < 0 || p.square.getY()+y < 0
		) 
			return false;
		
		return 
			b.getSquares()[p.square.getX()+x][p.square.getY()+y]
					.getPiece_occupying() instanceof Knight
					&& b.getSquares()[p.square.getX()+x][p.square.getY()+y]
							.getPiece_occupying().color != p.color;
		
	}
	
	
}
