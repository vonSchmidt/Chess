package Chess;

import java.io.*;

public class SaveLoadBundle implements Serializable{
	
	private static final long serialVersionUID = 3025041693219125459L;
	static private ObjectOutputStream oos = null;
	static private ObjectInputStream ois = null;
	private static Game game;
	public static final File savedGame = new File(".savedGame");
	
	public SaveLoadBundle(Game g){
		game = g;
	}
	
	public void save() throws FileNotFoundException, IOException{
		oos = new ObjectOutputStream(
				new FileOutputStream(savedGame));
		
		oos.writeObject(game);
	}
	
	public boolean existsSavedGame(){
		return savedGame.exists();
	}
	
	public Game load() throws IOException, ClassNotFoundException{
		if(!existsSavedGame())
			return null;
		Game tmp = null;
		ois = new ObjectInputStream(new FileInputStream(savedGame));
		Object obj = ois.readObject();
		if(obj instanceof Game)
			tmp = (Game)obj;
		game = tmp;
		return game;
		
	}
	
}
