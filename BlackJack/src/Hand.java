import java.util.ArrayList;

public class Hand
{
	private ArrayList<Card> hand;
	public Hand()
	{
		hand = new ArrayList<Card>();
	}
	
	public void Add(Card c)
	{
		hand.add(c);
	}
	
	public Card Pop()
	{
		return hand.remove(hand.size());
	}
	
	public String toString()
	{
		String p = new String();
		for (int i = 0; i < hand.size(); i++)
		{
			p += hand.get(i).toString() + " ";
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
		return BlackJackCardValues.getCombinedValuesOfCardHand(this.hand) <= 21;
	}
}
