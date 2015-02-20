package Chess;

import java.io.IOException;

public class Launcher {


	public static void main(String args[]) throws IOException{
		// TODO Start checking for CSL file, then do game state checker
		System.out.println("\n\n\t\t  Welcome to Chess!\n\t\t  -----------------");
		System.out.println(" \tTip: Press Ctrl - D To Save The Game And " +
				"Quit.\n \t     Press Ctrl - C To Quit Without Saving.\n");
		Game g = new Game();
		
		System.out.println(" >> Checking For Previously Saved Game State ...");
		if(g.checkForSavedGame()){
			System.out.println(" >> Game State File Exists In Directory.");
			g = g.loadGame();
			System.out.println(" [INFO] >> Successfully Loaded Game State.");
		}
		else{
			System.out.println(" >> Did Not Find Game State File In Directory.");
		}
		try{
			g.run();
		} catch(Exception e){
			System.out.println(" >> Saving Game State ...");
			g.saveGame();
			System.out.println(" [INFO] >> Successfully Saved Game State.");
			System.out.println("\n Bye");
		}
	}
	
}
