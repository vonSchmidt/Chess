package Chess;

public class DoubleStepDisplacement implements Displacement {

	@Override
	public boolean check_validity(Move m) {
		int dx = m.getStart().getX() - m.getEnd().getX();
		return Math.abs(dx) <= 2;
	}

}
