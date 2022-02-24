import java.io.IOException;

public class PokerGame 
{
    // currently only have one database, might want to change this later to be initialized in the startGame method
    PlayerDatabase database = new PlayerDatabase("PlayerDatabase.txt");
    public static void main(String[] args) throws IOException
    {
        PokerGame p = new PokerGame();

        if (args[0].equals("start"))
        //TODO: add a print statement that there must at least one argument for starting the game
        {
            String[] players = new String[args.length - 1];

            for (int i = 1; i < args.length; i++)
            {
                players[i - 1] = args[i];
            }
            
            p.startGame(players);
        }
        else if (args[0].equals("add")) //this command name kinda sucks, might wanna change it later
        {
            
        }
    }

    public void startGame(String[] players) throws IOException
    {
        for (String player : players)
        {
            //if player is already in database, use their values
            if (this.database.contains(player))
            {
                //TODO
                //buy the player in
            }
            else // create a new player and initialize their values, adding them to the database
            {
                this.database.addPlayerToDatabase(player);
            }
        }
    }
}
