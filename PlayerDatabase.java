import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;


//TODO: add method headers and stuff
public class PlayerDatabase {
    File databaseFile;
    ArrayList<Player> database;

    public PlayerDatabase(String database)
    {
        this.databaseFile = new File(database);
    }

    /**
     * Searches the database for a player, and returns whether or not 
     * the player exists in the database.
     * 
     * @param player The player to check if contained in the database
     * @return True if the player is contained, false otherwise
     * @throws IOException
     */
    public boolean contains(String player) throws IOException
    {
        Scanner s = new Scanner(this.databaseFile);
        String line;
        while (s.hasNextLine())
        {
            line = s.nextLine();
            if (line.substring(0, line.indexOf(":")).equals(player))
            {
                s.close();
                return true;
            }
        }

        s.close();
        return false;
    }

    public void addPlayerToDatabase(String name) throws IOException
    {
        PrintWriter pw = new PrintWriter(new FileWriter(this.databaseFile, true));
        Player p = new Player(name, 1, 5.0);
        pw.println(p.toString());
        pw.close();
    }

    public void updateDatabase()
    {
        //idea: read through the entire file and compare player values to the strings in the file
        Scanner s = new Scanner(this.databaseFile);

        while (s.hasNextLine())
        {
            // make a new Player with the data in the 
        }
    }

    public void updatePlayerMoney(String name, double amount) throws IOException
    {
        //TODO: make use of the Player class, not just a string
        //for now, just assume the player is contained, but will need to add a print statement for player not found
        Scanner s = new Scanner(this.databaseFile);
        String oldString = "";

        while(s.hasNextLine())
        {
            oldString += s.nextLine();
        }
        s.close();

        // String newString = oldString.substring(0, oldString.indexOf(name)) + name + ": " + ;
        
        PrintWriter pw = new PrintWriter(new FileWriter(this.databaseFile, true));        
    }
    //idea: make one method to update all the values of the database

    //TODO: make a method for retrieving values from players in the database, and clearing the database
}
