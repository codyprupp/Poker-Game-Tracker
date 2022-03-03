import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
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

    public void updateDatabase(Player[] players) throws IOException
    {
        for (Player newPlayer : players)
        {
            File newFile = new File("temp.txt");
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(newFile, true)));
            Scanner s = new Scanner(this.databaseFile);
            boolean playerFound = false;

            while(s.hasNextLine())
            {
                String playerData = s.nextLine();
                if (playerData.substring(0, playerData.indexOf(":")).equals(newPlayer.username))
                {
                    int playerDataBuyIns = Integer.parseInt(playerData.substring(playerData.indexOf(":") + 2, playerData.indexOf(" ", playerData.indexOf(":") + 2)));
                    double playerDataBank = Double.parseDouble(playerData.substring(playerData.indexOf("$") + 1, playerData.indexOf(" ", playerData.indexOf("$"))));
                    Player replacement = new Player(newPlayer.username, newPlayer.numBuyIns + playerDataBuyIns, newPlayer.currMoney + playerDataBank);
                    pw.println(replacement.toString());
                    playerFound = true;
                }
                else
                {
                    pw.println(playerData);
                }
            }

            if (!playerFound)
            {
                pw.println(newPlayer.toString());
            }

            s.close();
            pw.flush();
            pw.close();
            this.databaseFile.delete();
            File dump = new File("PlayerDatabase.txt");
            newFile.renameTo(dump);
        }
    }

    public String winsAndLosses() throws FileNotFoundException
    {
        String winsAndLosses = "";

        Scanner s = new Scanner(this.databaseFile);

        while (s.hasNextLine())
        {
            String playerData = s.nextLine();
            String playerName = playerData.substring(0, playerData.indexOf(":"));
            int playerBuyIns = Integer.parseInt(playerData.substring(playerData.indexOf(":") + 2, playerData.indexOf(" ", playerData.indexOf(":") + 2)));
            double playerBank = Double.parseDouble(playerData.substring(playerData.indexOf("$") + 1, playerData.indexOf(" ", playerData.indexOf("$"))));
            double playerNetWorth = playerBank - (playerBuyIns * 5);

            if (playerNetWorth >= 0)
            {
                winsAndLosses += playerName + " is up $" + playerNetWorth + " so far\n";
            }
            else
            {
                winsAndLosses += playerName + " is down $" + (playerNetWorth * -1) + " so far\n";
            }
        }

        s.close();
        return winsAndLosses;
    }
}
