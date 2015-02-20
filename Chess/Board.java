package Chess;

import java.io.Serializable;
import java.util.Vector;

public class Board implements Serializable{

	private static final long serialVersionUID = -8536336866753177096L;
	private Square squares [][];
    private Team white;
    private Team black;
    private String infos="";
    private Vector<Piece> outList = new Vector<Piece>();
    
    public Board(){
        setSquares(new Square[8][8]);
        setWhite(new Team(Color.WHITE));
        setBlack(new Team(Color.BLACK));

        for (int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                getSquares()[i][j]=new Square(i,j);
            }
        }


    }

    public boolean BlackIsChecked(){
        //black.set[0]
        return false;
    }


    public String toString(){
        String S="";

        S+="\n"+getInfos()+"\n";
        if(!getOutList().isEmpty())
            S+=getOutList()+"\n\n";

        S+="       1     2     3     4     5     6     7     8\n";
        S+="     _____ _____ _____ _____ _____ _____ _____ _____\n";

        for (int i=0;i<8;i++){

            S+="    |";

            for(int j=0; j<8; j++){
                for(int p=1; p<=5; p++)
                    S+=getSquares()[i][j];
                S+="|";
            }
            S+="\n";
            S+=" "+getSquares()[i][0].getIndex().charAt(0)+"  ";
            for(int j=0;j<8;j++){

                if(getSquares()[i][j].getPiece_occupying()==null)
                    S+="|"+getSquares()[i][j]+getSquares()[i][j]+getSquares()[i][j]+getSquares()[i][j]+getSquares()[i][j];
                else
                    S+="|"+getSquares()[i][j]+getSquares()[i][j].getPiece_occupying()+getSquares()[i][j];
            }
            S+="| "+getSquares()[i][0].getIndex().charAt(0)+"\n";

            S+="    |";

            for(int j=0; j<8; j++){
                for(int p=1; p<=5; p++)
                    S+=getSquares()[i][j];
                S+="|";
            }
            S+="\n";
        }
        S+="     ⎺⎺⎺⎺⎺ ⎺⎺⎺⎺⎺ ⎺⎺⎺⎺⎺ ⎺⎺⎺⎺⎺ ⎺⎺⎺⎺⎺ ⎺⎺⎺⎺⎺ ⎺⎺⎺⎺⎺ ⎺⎺⎺⎺⎺";
        S+="\n       1     2     3     4     5     6     7     8\n";
        setInfos("");
        return S;
    }

    public void reset(){
        clear();
        getWhite().reset_position(this);
        getBlack().reset_position(this);
        getOutList().clear();
    }

    public void clear(){
        for(Square ss[]:getSquares())
            for(Square a:ss)
                a.setPiece_occupying(null);
    }

	public Square[][] getSquares() {
		return squares;
	}

	public void setSquares(Square squares[][]) {
		this.squares = squares;
	}

	public Team getWhite() {
		return white;
	}

	public void setWhite(Team white) {
		this.white = white;
	}

	public Team getBlack() {
		return black;
	}

	public void setBlack(Team black) {
		this.black = black;
	}

	public String getInfos() {
		return infos;
	}

	public void setInfos(String infos) {
		this.infos = infos;
	}

	public Vector<Piece> getOutList() {
		return outList;
	}

	public void setOutList(Vector<Piece> outList) {
		this.outList = outList;
	}
}
