import java.util.ArrayList;

public class Player
{
	private ArrayList<Hand> hand;
	private int money;
	private int bet;
	private int score;
	private boolean willPlay;
	
	public Player()
	{
		this.hand = new ArrayList<Hand>();
		this.money = 1000;
		this.score = 0;
		this.willPlay = true;
		this.bet = 0;
	}
	
	public void initHand(Deck d)
	{
		hand = new ArrayList<Hand>();
		hand.add(new Hand());
		hand.get(0).Add(d.draw());
	}
	
	public boolean hit(Deck d)
	{
		boolean r = false;
		for ( int i = 0; i < hand.size(); i++ )
		{
			if ( isHandPlayable(hand.get(i)))
			{
				hand.get(i).Add(d.draw());
				r = true;
				break;
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
		this.money += this.bet / 2;
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
	
	public boolean Bet(int b)
	{
		boolean r = false;
		
		if ( b <= this.money && b > 0)
		{
			this.bet = b;
			this.money -= b;
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
	
	private boolean isHandPlayable( Hand h )
	{
		return BlackJackCardValues.getCombinedValuesOfCardHand(h.getHand()) <= 21;
	}
	
	public boolean getWillPlay()
	{
		return this.willPlay;
	}
	
	public int getScore()
	{
		return this.score;
	}
	
	public int getMoney()
	{
		return this.money;
	}
	
	public int getBet()
	{
		return this.bet;
	}
}
