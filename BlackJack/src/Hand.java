import java.util.ArrayList;

public class Hand
{
	private ArrayList<Card> hand;
	public boolean willPlay;
	private int bet;
	public boolean madeFromSplit;
	public boolean hasSurrendered;
	private boolean displayBet;
	
	public Hand(boolean db)
	{
		hand = new ArrayList<Card>();
		willPlay = true;
		bet = 0;
		madeFromSplit = false;
		hasSurrendered = false;
		displayBet = db;
	}
	
	public void Add(Card c)
	{
		hand.add(c);
	}
	
	public Card Pop()
	{
		return hand.remove(hand.size() - 1);
	}
	
	public String toString( )
	{
		String p = new String();
		for (int i = 0; i < hand.size(); i++)
		{
			p += hand.get(i).toString();
			if ( i < hand.size() - 1 )
			{
				p += ", ";
			}
			else
			{
				p += " ";
			}
			 
		}
		
		p += "Score: " + BlackJackCardValues.getCombinedValuesOfCardHand(hand) + " ";
		
		if ( displayBet )
		{
			p += "Bet: " + bet;
		}
		
		return p;
	}
	
	public int getValue()
	{
		return BlackJackCardValues.getCombinedValuesOfCardHand(this.hand);
	}
	
	public ArrayList<Card> getHand()
	{
		return this.hand;
	}
	
	public boolean isBlackJack()
	{
		boolean hasAce = false;
		boolean hasTen = false;
		
		for ( int i = 0; i < hand.size(); i++ )
		{
			if ( hand.get(i).getFace() == Rank.ACE )
			{
				hasAce = true;
				break;
			}
		}
		
		for ( int i = 0; i < hand.size(); i++ )
		{
			if ( hand.get(i).getValues().get(0) == 10 )
			{
				hasTen = true;
				break;
			}
		}
		
		return hasTen && hasAce && hand.size() == 2;
	}
	
	public boolean isHandPlayable( )
	{
		return BlackJackCardValues.getCombinedValuesOfCardHand(hand) <= 21;
	}
	
	public int getBet()
	{
		return bet;
	}
	
	public boolean setBet(int b, int money)
	{
		boolean r = false;
		
		if ( b > 0 && b <= money )
		{
			r = true;
			this.bet = b;
		}
		
		return r;
	}
}
