//TODO: add method/class headers and clean up comments

public class Player
{
    String username;
    int numBuyIns;
    double currMoney;

    public Player(String username, int numBuyIns, double currMoney)
    {
        this.username = username;
        this.numBuyIns = numBuyIns;
        this.currMoney = currMoney;
    }

    public void addMoney(double amount)
    {
        this.currMoney += amount;
    }

    public void removeMoney(double amount)
    {
        this.currMoney -= amount;
    }

    public void buyIn()
    {
        if (this.currMoney >= 5)
        {
            // shouldn't be able to buy in, just subtract 5 from currMoney
            this.currMoney -= 5.0;
            //this looks like it just removes the money from the player, but money will be added back to the player if they win any
            //  consider it like converting the money to chips, which are not stored in this program (they are kept track of by real people)
        }
        else
        {
            this.currMoney = 5.0;
            this.numBuyIns++;
        }
    }

    public double amountOwed()
    {
        return (this.numBuyIns * 5) - this.currMoney;
    }

    public String toString()
    {
        return this.username + ": " + this.numBuyIns + " buy ins, $" + this.currMoney + " current bank";
    }

    //TODO: add a toString method for a player
    //  should look like "Cody: 5 buy ins, $12.68 current bank"


}