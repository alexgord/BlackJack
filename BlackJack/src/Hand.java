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
		
		return true;
	}
}
