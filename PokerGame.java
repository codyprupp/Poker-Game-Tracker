import java.io.IOException;

public class PokerGame 
{
    // currently only have one database, might want to change this later to be initialized in the startGame method
    PlayerDatabase database = new PlayerDatabase("PlayerDatabase.txt");
    public static void main(String[] args) throws IOException
    {
        PokerGame pg = new PokerGame();

        Player[] players = new Player[args.length / 3];

        for (int i = 0; i < args.length; i += 3)
        {
            players[i / 3] = new Player(args[i], Integer.parseInt(args[i + 1]), Double.parseDouble(args[i + 2]));
        }

        pg.database.updateDatabase(players);
        System.out.println(pg.database.winsAndLosses());

        // NOTE: player names cannot have any special characters in them bc they will mess with the updateDatabase method
        // System.out.println(pg.database.updateDatabase(players));
    }

    // public Player[] startGame(String[] players) throws IOException
    // {
    //     //TODO
    //     Player[] toReturn = new Player[players.length];

    //     for (Player p : toReturn)
    //     {
    //         this.database.updateDatabase(p);
    //     }

    //     return toReturn;
    // }
}
