import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


//TODO: add method headers and stuff
public class PlayerDatabase {
    File databaseFile;

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

    public String updateDatabase(Player[] players) throws IOException
    {
        //idea: read through the entire file and compare player names to the strings in the file
        FileWriter fw = null;
        String oldContent = "";
        int count = 0;

        for (Player p : players)
        {
            //if the player is already in the file, update the file's current values
            BufferedReader br = new BufferedReader(new FileReader(this.databaseFile));
            String line = br.readLine();
            boolean playerAdded = false;

            //based on the number of times a person has been updated, start at a new line
            for (int i = 0; i < count; i++)
            {
                line = br.readLine();
            }

            while (line != null)
            {
                if (line.contains(p.username))
                {
                    //update the file's current values
                    p.numBuyIns += Integer.parseInt(line.substring(line.indexOf(":") + 2, line.indexOf(" ", line.indexOf(":") + 2)));
                    p.currMoney += Double.parseDouble(line.substring(line.indexOf("$") + 1, line.indexOf(" ", line.indexOf("$") + 1)));
                    oldContent += p.toString() + System.lineSeparator();
                    count++;
                    playerAdded = true;
                    break;
                }
                else
                {
                    oldContent += line + System.lineSeparator();
                }
                
                line = br.readLine();
            }
            //if I reached the end of the database and nothing was updated (player was not in database), add the player to the database
            if (!playerAdded)
            {
                oldContent += p.toString() + System.lineSeparator();
            }

            br.close();
        }

        fw = new FileWriter(this.databaseFile);
        fw.write(oldContent);
        fw.close();

        return "Database updated!";
    }
}
