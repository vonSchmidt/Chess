package Chess;

public enum Color {

	BLACK, WHITE, HINT;

	public String getColorName(){
		switch(this){
		case WHITE:
			return "WHITE";
		case BLACK:
			return "BLACK";
		default:
			return "";
		}
	}

	public Color getInverse(){
		switch(this){
		case WHITE:
			return BLACK;
		case BLACK:
			return WHITE;
		default:
			return null;
		}
	}

	public String toString(){
		switch(this){
		case WHITE:
			return "\033[;45m \033[0m"; 
		case BLACK:
			return "\033[;40m \033[0m";
		case HINT:
			return "\033[;42m \033[0m";
		default:
			return "";
		}
	}
}
