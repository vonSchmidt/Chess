package Chess;
import java.io.*;
import java.util.Scanner;

public class Game implements Serializable{

	private static final long serialVersionUID = 6802882053340804788L;
	private Board board;
	private GAME_STATE gs;
	private SaveLoadBundle slb;
	
	private boolean isWhiteTurn = true;
	
	private static Scanner q = new Scanner(System.in); 

	
	public boolean checkForSavedGame(){
		return slb.existsSavedGame();
	}
	public void saveGame(){
		try {
			slb.save();
		} catch (FileNotFoundException e) {
			System.err.println("[ERROR] >> File Was Not Found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("[ERROR] >> IO Exception Has Occured.");
			e.printStackTrace();
		}
	}
	public Game loadGame(){
		try {
			return slb.load();
		} catch (FileNotFoundException e) {
			System.err.println("[ERROR] >> File Was Not Found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("[ERROR] >> IO Exception Has Occured.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("[ERROR] >> ClassNotFound Exception Has Occured.");
			e.printStackTrace();
		}
		return null;
	}
	
	public void update_gs(){
		//TODO Update game state based on checking
	}

	public Game(){
		slb = new SaveLoadBundle(this);
		board = new Board();
		board.reset();
		gs = GAME_STATE.NOTHING;
	}

	public void run(){
		
		while(gs==GAME_STATE.NOTHING){
			MakeTurn();
			chgameState(board.getWhite());
			System.out.print("\033[H\033[2J");
			switchTurns();
		}
	}

	private void switchTurns(){
		if(isWhiteTurn) isWhiteTurn = false;
		else isWhiteTurn = true;
	}
	
	private void chgameState(Team member) {
		//check for game state (examine king's position)
		//member.set[0] //that's the king
		gs = ((King) member.getSet()[0]).isInDanger(board, member);

	}

	private void MakeTurn(){
		//System.out.println("\033[H\033[2J");	

		Color color;
		if(isWhiteTurn) color = Color.WHITE;
		else color = Color.BLACK;
		System.out.println(board);
		System.out.println("\n\t\t.:: "+color.getColorName()+"'S TURN ::.\n");

		Square tmp2=takeInput(color);
		Square tmpd2=takeDest(color);
		executeMove(board.getSquares()[tmp2.getX()][tmp2.getY()].getPiece_occupying(), board.getSquares()[tmpd2.getX()][tmpd2.getY()]);


	}

	private Square takeInput(Color color) {
		System.out.print("Select Source Square: \n\t> ");
		String input = q.next();
		input=input.toUpperCase();
		while(input.length()!=2){
			System.out.print("Syntax example: A1   or   E5\n\t> ");
			input=q.next();
		}
		char l=input.charAt(0);
		char n=input.charAt(1);
		try{
			Exception e = new Exception();
			int t=Integer.parseInt(""+n);
			if(t<0||t>8)
				throw e;
			if(l>'H'||l<'A')
				throw e;

		}catch (Exception e){
			System.out.print("\n\tSyntax example: A1   or   E5\n\t> ");
			return takeInput(color);
		}
		Square input1=decode(input);
		if(board.getSquares()[input1.getX()][input1.getY()].getPiece_occupying()==null){
			System.out.println("\nThere are no pieces on this square!");
			return takeInput(color);
		}
		if(board.getSquares()[input1.getX()][input1.getY()].getPiece_occupying().color==color)
			return input1;
		else{
			System.out.println("\nYou can't move this piece");
			return takeInput(color);
		}

	}

	private Square takeDest(Color color) {
		System.out.print("Select Destination Square: \n\t> ");
		String input = q.next();
		input=input.toUpperCase();
		while(input.length()!=2){
			System.out.print("Syntax example: A1   or   E5\n\t> ");
			input=q.next();
		}
		char l=input.charAt(0);
		char n=input.charAt(1);
		try{
			Exception e = new Exception();
			int t=Integer.parseInt(""+n);
			if(t<0||t>8)
				throw e;
			if(l>'H' || l<'A')
				throw e;

		}catch (Exception e){
			System.out.print("\n\tSyntax example: A1   or   E5\n\t> ");
			return takeInput(color);
		}
		Square input1=decode(input);
		return input1;	
	}

	private Square decode(String input) {
		int X=((int)(input.charAt(0))-65);
		int Y=Integer.parseInt(input.charAt(1)+"")-1;
		return new Square(X, Y);

	}

	public void executeMove(Piece p, Square dest){
		board.setInfos(board.getInfos() + ("Selection: "+p.color.getColorName()+" "+p.getClass().getSimpleName()+" on "+p.square.getIndex()+"\n"));
		p.move=new Move(p.square, dest);
		board.setInfos(board.getInfos() + (("Destination: "+dest.getIndex())+"\n"));
		if(!p.move.move(p, board)){
			MakeTurn();
		}
		p.gmove.getDirection().clear();

	}

}
