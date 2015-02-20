package Chess;

import java.io.Serializable;

public class MultipleStepDisplacement implements Displacement, Serializable{

	private static final long serialVersionUID = 119037188329853029L;

	@Override
	public boolean check_validity(Move m) {
		return true;
	}

}
