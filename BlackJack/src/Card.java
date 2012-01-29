import java.util.ArrayList;

public class Card
{

	private Rank rank;
	private Suit suit;
	private ArrayList<Integer> values;

	/**
	 * Constructs a Card object
	 * @param rank The face value of the card 
	 * @param suit The suit of the card
	 */
	public Card(Rank rank, Suit suit)
	{
		this.rank = rank;
		this.suit = suit;
		this.values = BlackJackCardValues.getValue(this);
	}

	/**
	 * Get the rank (face value) of the card.
	 * @return the rank
	 */
	public Rank getFace() { return rank; }
	
	/**
	 * Get the suit of the card
	 * @return the suit
	 */
	public Suit getSuit() { return suit; }

	@Override
	public String toString()
	{
		return rank.toString() + " of " + suit.toString(); 
	}
	
	public ArrayList<Integer> getValues()
	{
		return this.values;
	}
}
