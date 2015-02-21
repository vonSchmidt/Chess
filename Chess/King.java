package Chess;

public class King extends Piece{

	private static final long serialVersionUID = -6442590757910939157L;
	public King(Color color){
		name = "K";
		symbol = "♚";
		this.color = color;
		gmove = new GeneralMove(new SingleStepDisplacement(), new AllDirection());
	}
	public GAME_STATE isInDanger(Board board, Team member){
		// Check all threats
		System.out.println(">>>>>>>>>>>>>> Checking for "+member.getColor()+" <<<<<<<<<<<<<<<");
		boolean diagonalThreat = threatIn(new DiagonalDirection(), board);
		
		boolean straightThreat = threatIn(new StraightDirection(), board);
		boolean AllDirThreat = threatIn(new AllDirection(), board);
		boolean LShapedThreat = threatIn(new LshapedDirection(), board);
		boolean pawnThreat = threatIn(new PawnStraightDirection(), board); 	

		if(diagonalThreat || straightThreat
				|| LShapedThreat || pawnThreat
				|| AllDirThreat)
			switch(member.getColor()){

			case BLACK:
				return GAME_STATE.BLACK_IN_CHECK;
			case WHITE:
				return GAME_STATE.WHITE_IN_CHECK;
			default:
				return GAME_STATE.NOTHING;
			}
		return GAME_STATE.NOTHING; 
	}

	private boolean threatIn(Direction d, Board b){
		return d.existsThreat(this, b);
	}
}
