package Chess;

import java.io.Serializable;

public enum GAME_STATE implements Serializable{
    WHITE_IN_CHECK, BLACK_IN_CHECK, WHITE_IN_CHECKMATE, BLACK_IN_CHECKMATE, DRAW, NOTHING;

}
