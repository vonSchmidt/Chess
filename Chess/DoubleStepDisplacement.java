package Chess;

import java.io.Serializable;

public class DoubleStepDisplacement implements Displacement, Serializable{

	private static final long serialVersionUID = 6413956580108407326L;

	@Override
	public boolean check_validity(Move m) {
		int dx = m.getStart().getX() - m.getEnd().getX();
		return Math.abs(dx) <= 2;
	}

}
