package Chess;
public class Move{

	private Square start, end;

	public Move(Square start, Square end){
		this.setStart(start);
		this.setEnd(end);
	}

	public boolean move(Piece p, Board b){
		if(p.gmove.isValidMove(this, p.color)){
			p.gmove.getDirection().getAllMoves(p, b);    

			if(!p.gmove.getDirection().isPossible(this)){
				b.setInfos(b.getInfos() + ("*Invalid Move*\n"));
				return false;
			}
			getStart().setPiece_occupying(null);
			if(getEnd().getPiece_occupying()!=null){
				b.setInfos(b.getInfos() + (" .:: Attacking "+getEnd().getPiece_occupying()+" ! ::.\n"));
				b.getOutList().add(getEnd().getPiece_occupying());
			}
			
			getEnd().setPiece_occupying(p);
			p.square=getEnd();
			
			if(p.getClass()==Pawn.class){
				Pawn piece = (Pawn)p;
				if(!piece.getMoved())
					piece.setMoved();
			}
			
			b.setInfos(b.getInfos() + (p.getClass().getSimpleName()+" has been moved from "+getStart().getIndex() +" to "+getEnd().getIndex()+"\n"));
			if((p.getClass()==Pawn.class && p.color==Color.BLACK && getEnd().getX()==0)||(p.getClass()==Pawn.class && p.color==Color.WHITE && getEnd().getX()==7)){
				p=new Queen(p.color);
				getEnd().setPiece_occupying(p);
				p.square=getEnd();
				b.setInfos(b.getInfos() + " .:: Pawn has been converted to Queen ::.\n");
			}
			return true;
		}
		else {
			b.setInfos(b.getInfos() + ("*Invalid Move*\n"));
			return false;
		}

	}


	public Square getEnd() {
		return end;
	}


	public void setEnd(Square end) {
		this.end = end;
	}


	public Square getStart() {
		return start;
	}


	public void setStart(Square start) {
		this.start = start;
	}
}

