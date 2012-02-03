import java.util.ArrayList;

public class Player
{
	protected ArrayList<Hand> hand;
	protected static int money;
	protected static int bet;
	protected int handWillPlay;
	
	public Player()
	{
		this.hand = new ArrayList<Hand>();
		money = 1000;
		bet = 0;
	}
	
	public void initHand(Deck d)
	{
		Hand tmp = new Hand();
		tmp.Add(d.draw());
		hand = new ArrayList<Hand>();
		hand.add(tmp);
		handWillPlay = 0;
	}
	
	public boolean hit(Deck d)
	{
		boolean r = false;
		
		if (hand.get(handWillPlay).isHandPlayable())// TODO: make sure this applies to all hands
		{
			hand.get(handWillPlay).Add(d.draw());
			r = true;
		}
		
		return r;
	}
	
	public void stand()
	{
		hand.get(handWillPlay).willPlay = false;
	}
	
	public void surrender()
	{
		hand.get(handWillPlay).willPlay = false;
		money += bet / 2;
	}
	
	public boolean doubl(Deck d, int amt)
	{		
		return true;
	}
	
	public boolean split(Deck d)
	{
		boolean r = false;
		
		if ( money > bet * 2)
		{
			Hand tmp = new Hand();		
			tmp.Add(hand.get(handWillPlay).Pop());
			hand.add(tmp);
			r = true;
		}
		
		return r;
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
			r += "Hand " + (i+ 1) + ": ";
			r += this.hand.get(i).toString();
			r += "\n";
		}
		
		r += "Money: " + money + "\n";
		r += "Bet: " + bet + "\n";
		
		return r;
	}
	
	public boolean getWillPlay()
	{
		boolean r = false;
		for ( int i = 0; i < hand.size(); i++ )
		{
			if ( hand.get(i).willPlay )
			{
				r = true;
				break;
			}
		}
		return r;
	}
	
	public int getScore(int h)
	{
		return hand.get(h).getValue();
	}
	
	public static int getMoney()
	{
		return money;
	}
	
	public int getBet()
	{
		return bet;
	}
	
	public boolean isBust(int h)
	{
		return hand.get(h).isHandPlayable();
	}
	
	public boolean isBlackJack()
	{
		boolean rv = false;
		for ( int i = 0; i < hand.size(); i++)
		{
			if ( hand.get(i).isBlackJack() )
			{
				rv = true;
				break;
			}
		}
		return rv;
	}
}
