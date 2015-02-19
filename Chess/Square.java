package Chess;
public class Square{

    private	Color color;
    private Piece piece_occupying;
    private int X, Y;
    public Square(int X, int Y){
        setPiece_occupying(null);

        this.setX(X);
        this.setY(Y);

        color=getColor();
        this.setIndex(getIndex());
    }

    private Color getColor(){
        if (getX()%2==0 ^ getY()%2==0)
            return Color.WHITE;
        else return Color.BLACK;
    }

    public String toString(){
        return color.toString();
    }

    public String getIndex(){
        String s = "";
        char c = (char)(getX()+65);
        s+=c;

        s+=(getY()+1);

        return s;
    }

	public Piece getPiece_occupying() {
		return piece_occupying;
	}

	public void setPiece_occupying(Piece piece_occupying) {
		this.piece_occupying = piece_occupying;
	}

	public void setIndex(String index) {
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

}
