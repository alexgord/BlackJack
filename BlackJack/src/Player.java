import java.util.ArrayList;

public class Player
{
	protected ArrayList<Hand> hand;
	protected static int money;
	protected static int bet;
	private int score;
	protected boolean willPlay;
	
	public Player()
	{
		this.hand = new ArrayList<Hand>();
		money = 1000;
		this.score = 0;
		this.willPlay = true;
		bet = 0;
	}
	
	public void initHand(Deck d)
	{
		Hand tmp = new Hand();
		tmp.Add(d.draw());
		hand = new ArrayList<Hand>();
		hand.add(tmp);
	}
	
	public boolean hit(Deck d)
	{
		boolean r = false;
		
		if (hand.get(0).isHandPlayable())// TODO: make sure this applies to all hands
		{
			for ( int i = 0; i < hand.size(); i++ )
			{
				if ( hand.get(i).isHandPlayable())
				{
					hand.get(i).Add(d.draw());
					r = true;
					break;
				}
			}
		}
		
		return r;
	}
	
	public void stand()
	{
		this.willPlay = false;
	}
	
	public void surrender()
	{
		this.willPlay = false;
		money += bet / 2;
	}
	
	public boolean doubl(Deck d, int amt)
	{
		
		return true;
	}
	
	public void split(Deck d)
	{
		Hand tmp = new Hand();		
		tmp.Add(hand.get(0).Pop());
		hand.add(tmp);
	}
	
	protected static boolean Bet(int b)
	{
		boolean r = false;
		
		if ( b <= money && b > 0)
		{
			bet = b;
			money -= b;
			r = true;
		}
		return r;
	}
	
	public String toString()
	{
		String r = new String();
		
		for ( int i = 0; i < this.hand.size(); i++)
		{
			r += "Hand " + i + ": ";
			r += this.hand.get(i).toString();
			r += "\n";
		}
		
		r += "Money: " + this.money + "\n";
		r += "Score: " + this.score + "\n";
		
		return r;
	}

	private void updateScore()
	{
		
	}	
	
	public boolean getWillPlay()
	{
		return this.willPlay;
	}
	
	public int getScore()
	{
		return this.score;
	}
	
	public static int getMoney()
	{
		return money;
	}
	
	private int getBet()
	{
		return bet;
	}
}
