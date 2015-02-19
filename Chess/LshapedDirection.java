package Chess;


public class LshapedDirection extends Direction {

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
}
