package Chess;

import java.io.Serializable;

public class SingleStepDisplacement implements Displacement, Serializable {

	private static final long serialVersionUID = -4725966941899362586L;

	@Override
	public boolean check_validity(Move m) {
		int dx = m.getStart().getX() - m.getEnd().getX();
		int dy = m.getStart().getY() - m.getEnd().getY();
		
		return Math.abs(dx)==1 || Math.abs(dy)==1;
	}

}
