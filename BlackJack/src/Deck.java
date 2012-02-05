import java.util.Random;

public class Deck
{

	private static final int DECK_SIZE = 52;

	private Card[] deck;
	private int current;
	
	/**
	 * Constructs a deck and initialises it with all possible cards.
	 * The deck will be sorted from Ace to King.
	 */
	public Deck()
	{
		deck = new Card[DECK_SIZE];
		current = 0;
		
		int i = 0;
		for(Rank r : Rank.values()) 
			for(Suit s : Suit.values()) 
				deck[i++] = new Card(r, s);
	}
	
	/**
	 * Shuffles the deck.
	 * @param seed 
	 */
	public void shuffle(int seed)
	{
		int s;
		if ( seed < 0 )
		{
			s = 0;
		}
		else
		{
			s = seed;
		}
		Random generator = new Random(s);
		for(int i=0; i<deck.length; i++) {
			int randPos = generator.nextInt(deck.length);
			Card tmp = deck[randPos];
			deck[randPos] = deck[i];
			deck[i] = tmp;
		}
		current = 0;
	}
	
	/**
	 * Draws the card from the top of the deck.
	 * @return top card
	 */
	public Card draw()
	{
		if (hasCards())
			return deck[current++];
		else
			return null;
	}
	
	/**
	 * Checks for remaining cards.
	 * @return
	 */
	public boolean hasCards()
	{
		return current < deck.length;
	}
	
	public String toString()
	{
		String r = "";
		for ( int i = 0; i < deck.length; i++ )
		{
			r += deck[i].toString() + "\n";
		}
		return r;
	}
	
}
