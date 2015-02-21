package Chess;

import java.io.Serializable;

public enum GAME_STATE implements Serializable{
    WHITE_IN_CHECK, BLACK_IN_CHECK, WHITE_IN_CHECKMATE, BLACK_IN_CHECKMATE, DRAW, NOTHING;

    
    public String toString(){
    	switch(this){
		case BLACK_IN_CHECK:
			return "\t\t\t--------------\n\t\t\tCheck on Black\n\t\t\t--------------\n";
		case BLACK_IN_CHECKMATE:
			return "\t\t\t------------------\n\t\t\tCheckmate on Black\n\t\t\t------------------\n";
		case DRAW:
			return "\t\t\t-----------\n\t\t\tIt's a Draw\n\t\t\t-----------\n";
		case NOTHING:
			return "";
		case WHITE_IN_CHECK:
			return "\t\t\t--------------\n\t\t\tCheck on White\n\t\t\t--------------\n";
		case WHITE_IN_CHECKMATE:
			return "\t\t\t--------------\n\t\t\tCheck on White\n\t\t\t--------------\n";
		default:
			return "";
    	
    	}
    }
}
