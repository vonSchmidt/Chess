package Chess;



public class Team{
    private	Color color;
	private Piece[] set=new Piece[16];

	public Team(Color color){
		this.color=color;
		getSet()[0] = new King(color);
		getSet()[1] = new Queen(color);
		getSet()[2] = new Bishop(color);
		getSet()[3] = new Bishop(color);
		getSet()[4] = new Knight(color);
		getSet()[5] = new Knight(color);
		getSet()[6] = new Rook(color);
		getSet()[7] = new Rook(color);
		getSet()[8] = new Pawn(color);
		getSet()[9] = new Pawn(color);
		getSet()[10] = new Pawn(color);
		getSet()[11] = new Pawn(color);
		getSet()[12] = new Pawn(color);
		getSet()[13] = new Pawn(color);
		getSet()[14] = new Pawn(color);
		getSet()[15] = new Pawn(color);

	}

	public void reset_position(Board board) {

        //TODO This is VERY BAD!!! Can find a relation, and minimize code lines

		if(color==Color.WHITE){
			board.getSquares()[0][0].setPiece_occupying(getSet()[6]); // rook 1
			getSet()[6].square=board.getSquares()[0][0];
			board.getSquares()[0][7].setPiece_occupying(getSet()[7]); // rook 2
			getSet()[7].square=board.getSquares()[0][7];
			
			board.getSquares()[0][1].setPiece_occupying(getSet()[4]); // knight 1
			getSet()[4].square=board.getSquares()[0][1];
			board.getSquares()[0][6].setPiece_occupying(getSet()[5]); // knight 2
			getSet()[5].square=board.getSquares()[0][6];
			
			board.getSquares()[0][2].setPiece_occupying(getSet()[3]); // bishop 1
			getSet()[3].square=board.getSquares()[0][2];
			board.getSquares()[0][5].setPiece_occupying(getSet()[2]); // bishop 2
			getSet()[2].square=board.getSquares()[0][5];
			
			board.getSquares()[0][4].setPiece_occupying(getSet()[1]); // queen
			getSet()[1].square=board.getSquares()[0][4];
			board.getSquares()[0][3].setPiece_occupying(getSet()[0]); // king
			getSet()[0].square=board.getSquares()[0][3];
			///////////////////////////////////////////////////////////////////////////
			board.getSquares()[1][0].setPiece_occupying(getSet()[8]); // the pawns
			getSet()[8].square=board.getSquares()[1][0];
			
			board.getSquares()[1][1].setPiece_occupying(getSet()[9]);
			getSet()[9].square=board.getSquares()[1][1];
			
			board.getSquares()[1][2].setPiece_occupying(getSet()[10]);
			getSet()[10].square=board.getSquares()[1][2];
			
			board.getSquares()[1][3].setPiece_occupying(getSet()[11]);
			getSet()[11].square=board.getSquares()[1][3];
			
			board.getSquares()[1][4].setPiece_occupying(getSet()[12]);
			getSet()[12].square=board.getSquares()[1][4];
			
			board.getSquares()[1][5].setPiece_occupying(getSet()[13]);
			getSet()[13].square=board.getSquares()[1][5];
			
			board.getSquares()[1][6].setPiece_occupying(getSet()[14]);
			getSet()[14].square=board.getSquares()[1][6];
			
			board.getSquares()[1][7].setPiece_occupying(getSet()[15]);
			getSet()[15].square=board.getSquares()[1][7];
		}
		else if(color==Color.BLACK){
			board.getSquares()[7][7].setPiece_occupying(getSet()[6]); // rook 1
			getSet()[6].square=board.getSquares()[7][7];
			board.getSquares()[7][0].setPiece_occupying(getSet()[7]); // rook 2
			getSet()[7].square=board.getSquares()[7][0];
			
			board.getSquares()[7][1].setPiece_occupying(getSet()[4]); // knight 1
			getSet()[4].square=board.getSquares()[7][1];
			board.getSquares()[7][6].setPiece_occupying(getSet()[5]); // knight 2
			getSet()[5].square=board.getSquares()[7][6];
			
			board.getSquares()[7][2].setPiece_occupying(getSet()[3]); // bishop 1
			getSet()[3].square=board.getSquares()[7][2];
			board.getSquares()[7][5].setPiece_occupying(getSet()[2]); // bishop 2
			getSet()[2].square=board.getSquares()[7][5];
			
			board.getSquares()[7][4].setPiece_occupying(getSet()[1]); // king
			getSet()[1].square=board.getSquares()[7][4];
			board.getSquares()[7][3].setPiece_occupying(getSet()[0]); // queen
			getSet()[0].square=board.getSquares()[7][3];
			///////////////////////////////////////////////////////////////////////
			board.getSquares()[6][0].setPiece_occupying(getSet()[8]); // the pawns
			getSet()[8].square=board.getSquares()[6][0];
			
			board.getSquares()[6][1].setPiece_occupying(getSet()[9]);
			getSet()[9].square=board.getSquares()[6][1];
			
			board.getSquares()[6][2].setPiece_occupying(getSet()[10]);
			getSet()[10].square=board.getSquares()[6][2];
			
			board.getSquares()[6][3].setPiece_occupying(getSet()[11]);
			getSet()[11].square=board.getSquares()[6][3];
			
			board.getSquares()[6][4].setPiece_occupying(getSet()[12]);
			getSet()[12].square=board.getSquares()[6][4];
			
			board.getSquares()[6][5].setPiece_occupying(getSet()[13]);
			getSet()[13].square=board.getSquares()[6][5];
			
			board.getSquares()[6][6].setPiece_occupying(getSet()[14]);
			getSet()[14].square=board.getSquares()[6][6];
			
			board.getSquares()[6][7].setPiece_occupying(getSet()[15]);
			getSet()[15].square=board.getSquares()[6][7];
		}
		
	}

	public Piece[] getSet() {
		return set;
	}

	public void setSet(Piece[] set) {
		this.set = set;
	}
}
