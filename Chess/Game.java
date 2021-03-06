package Chess;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.LinkedList;

public class Game implements Serializable{

	private static final long serialVersionUID = 6802882053340804788L;
	private Board board;
	private GAME_STATE gs;
	private SaveLoadBundle slb;
	private Checker checker;
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

	public Game(){
		slb = new SaveLoadBundle(this);
		board = new Board();
		board.reset();
		gs = GAME_STATE.NOTHING;
		checker = new Checker(board, this);
	}

	public void update_gs(GAME_STATE gs){
		System.out.println(gs);
		this.gs = gs;
		board.setStatus(this.gs.toString());
	}

	public void chGameState(){
		Team member;
		if(isWhiteTurn) member = board.getBlack();
		else member = board.getWhite();
		checker.chgameState(member);
	}

	public void run(){
		while
			(gs == GAME_STATE.NOTHING
			|| gs == GAME_STATE.BLACK_IN_CHECK
			|| gs == GAME_STATE.WHITE_IN_CHECK
					)
		{
			while(!MakeTurn()){}
			chGameState();
			clear();
			switchTurns();
		}
	}

	private void switchTurns(){
		if(isWhiteTurn) isWhiteTurn = false;
		else isWhiteTurn = true;
	}

	private boolean MakeTurn(){

		LinkedList<Square> v;
		Color color;
		// Compute all possible squares for King
		if(isWhiteTurn){
			v = checker.computeKingMoves(board.getWhite());
			if(v.isEmpty()){
				// Checkmate!
				update_gs(GAME_STATE.WHITE_IN_CHECKMATE);
			}
			color = Color.WHITE;
			if(gs == GAME_STATE.WHITE_IN_CHECK){
				for(Square s : v) s.setHint();
			}
		}
		else{
			v = checker.computeKingMoves(board.getBlack());
			color = Color.BLACK;
			if(gs == GAME_STATE.BLACK_IN_CHECK){
				for(Square s : v) s.setHint();
			}
		}
		

		System.out.println(board);
		if(gs == GAME_STATE.BLACK_IN_CHECKMATE
				|| gs == GAME_STATE.WHITE_IN_CHECKMATE){
			System.out.println("\n\t\t.:: CHECKMATE ::.\n");
			System.exit(0);
		}
		System.out.println("\n\t\t.:: "+color.getColorName()+"'S TURN ::.\n");


		Square tmp2=takeInput(color);
		Square tmpd2=takeDest(color);

		if(isWhiteTurn){
			if(gs == GAME_STATE.WHITE_IN_CHECK
					|| gs == GAME_STATE.BLACK_IN_CHECK
			){
				if(!(tmp2.getPiece_occupying() instanceof King)){
					System.out.println("\n You're in Check!\n You can only move your King.");
					return false;
				}
				

			}
		}
		
		if((tmp2.getPiece_occupying() instanceof King) 
				&& !v.contains(tmpd2)){
			System.out.println("\n Wrong Move.");
			return false;
		}
		
		for(Square s : v) s.setNormal();
		
		if(!this.executeMove(
				board.getSquares()[tmp2.getX()][tmp2.getY()]
						.getPiece_occupying(),
				board.getSquares()[tmpd2.getX()][tmpd2.getY()]))
			return false;
		return true;

	}

	private Square takeInput(Color color) {
		System.out.print(" Select Source Square: \n\t> ");
		String input = q.next();
		input=input.toUpperCase();
		while(input.length()!=2){
			System.out.print(" Syntax example: A1   or   E5\n\t> ");
			input=q.next();
		}
		char l=input.charAt(0);
		char n=input.charAt(1);
		try{
			InputMismatchException e = new InputMismatchException();
			int t=Integer.parseInt(""+n);
			if(t<0||t>8)
				throw e;
			if(l>'H'||l<'A')
				throw e;

		}catch (Exception e){
			System.out.print("\n\t Syntax example: A1   or   E5\n\t> ");
			return takeInput(color);
		}
		Square input1=decode(input);
		if(board.getSquares()[input1.getX()][input1.getY()].getPiece_occupying()==null){
			System.out.println("\n There are no pieces on this square!");
			return takeInput(color);
		}
		if(board.getSquares()[input1.getX()][input1.getY()].getPiece_occupying().color==color)
			return board.getSquares()[input1.getX()][input1.getY()];
		else{
			System.out.println("\n You can't move this piece");
			return takeInput(color);
		}

	}

	private Square takeDest(Color color) {
		System.out.print(" Select Destination Square: \n\t> ");
		String input = q.next();
		input=input.toUpperCase();
		while(input.length()!=2){
			System.out.print(" Syntax example: A1   or   E5\n\t> ");
			input=q.next();
		}
		char l=input.charAt(0);
		char n=input.charAt(1);
		try{
			InputMismatchException e = new InputMismatchException();
			int t=Integer.parseInt(""+n);
			if(t<0||t>8)
				throw e;
			if(l>'H' || l<'A')
				throw e;

		}catch (Exception e){
			System.out.print("\n\t Syntax example: A1   or   E5\n\t> ");
			return takeInput(color);
		}
		Square input1=decode(input);
		return board.getSquares()[input1.getX()][input1.getY()];	
	}

	private Square decode(String input) {
		int X=((int)(input.charAt(0))-65);
		int Y=Integer.parseInt(input.charAt(1)+"")-1;
		return new Square(X, Y);

	}

	public boolean executeMove(Piece p, Square dest){
		board.setInfos(board.getInfos() + (" Selection: "+p.color.getColorName()+" "+p.getClass().getSimpleName()+" on "+p.square.getIndex()+"\n"));
		p.move=new Move(p.square, dest);
		board.setInfos(board.getInfos() + ((" Destination: "+dest.getIndex())+"\n"));
		if(!p.move.move(p, board)){
			return false;
		}
		p.gmove.getDirection().clear();
		return true;
	}
	public void clear() {
		System.out.print("\033[H\033[2J");
	}

}
