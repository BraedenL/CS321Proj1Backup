import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CacheTest {

	//Command for incorrect input format
	public static void showCacheTestUsage()
	{
		System.out.println("java CacheTest <cache-size> <serialized-data-filename>");
		System.exit(1);
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{
		long time = System.currentTimeMillis();
		FileInputStream fileIn;
		//LinkedList<Player> playerList = new LinkedList<>();
		//Make sure correct number of inputs are given
		if(args.length != 2)
		{
			showCacheTestUsage();
		}
		int cacheSize = Integer.parseInt(args[0]);
		Cache<Player> playerCache = new Cache<Player>(cacheSize);
		///////////////////
		//System.out.println("Made some stuff, at try command");
		//playerCache.printCacheStats();
		
		try
		{
			String inputFileName = args[1];
			fileIn = new FileInputStream(inputFileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			//playerList = (LinkedList<Player>) in.readObject();
			
			ArrayList<Player> playerList = (ArrayList<Player>) in.readObject();

			for(Player p: playerList)
			{
				playerCache.getObject(p);
			}
		playerCache.printCacheStats();
		long endTime = System.currentTimeMillis();
		System.out.println("Time to process: " + (endTime - time) + " milliseconds");
		System.out.println();
		in.close();	
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
