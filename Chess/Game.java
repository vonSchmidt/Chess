package Chess;
import java.util.Scanner;

public class Game{

    private Board board;
    private GAME_STATE gs;
    
    private static Scanner q = new Scanner(System.in); 

    public void update_gs(){
        //TODO Update game state based on checking
    }

    public Game(){
        board = new Board();
        board.reset();
        gs = GAME_STATE.NOTHING;
    }

    public void run(){
    	System.out.println("\n\n\t\t  Welcome to Chess!\n\t\t  -----------------");
        while(gs==GAME_STATE.NOTHING){
            
            MakeTurn(Color.WHITE);
            chgameState(board.getWhite());
            System.out.print("\033[H\033[2J");
            MakeTurn(Color.BLACK);
            chgameState(board.getBlack());
            System.out.print("\033[H\033[2J");
        }
    }

    private void chgameState(Team member) {
        //check for game state (examine king's position)
        //member.set[0] //that's the king
        gs = ((King) member.getSet()[0]).isInDanger(board, member);

    }

    private void MakeTurn(Color color){
        //System.out.println("\033[H\033[2J");	

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
            MakeTurn(p.color);
        }
        p.gmove.getDirection().clear();

    }

    public static void main(String args[]){
        new Game().run();
    }


}
