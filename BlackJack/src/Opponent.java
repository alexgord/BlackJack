import java.util.ArrayList;


public class Opponent extends Player
{
	public String toString2()
	{
		String r = new String();
		
		r += "Hand " + 0 + ": ";
		r += this.hand.get(0).getHand().get(0).toString();
		r += "\n";
		
		return r;
	}
	
	public void Play(Deck d, int r)
	{		
		System.out.println("Opponent's turn");
		while ( this.getWillPlay() )
		{
			if (BlackJackCardValues.getCombinedValuesOfCardHand(this.hand.get(0).getHand()) < 17)
			{
				hit(d);
				System.out.println("opponent hit");
			}
			else
			{
				stand();
				System.out.println("Opponent stands");
			}
		}
		
		
		//System.out.println("Hand Value: " + BlackJackCardValues.getCombinedValuesOfCardHand(hand.get(handWillPlay).getHand()));
		
		//System.out.println(toString());
	}
	
	public String toString()
	{
		String r = new String();
		
		for ( int i = 0; i < this.hand.size(); i++)
		{
			r += "Hand : ";
			r += this.hand.get(i).toString();
			r += "\n";
		}
				
		return r;
	}
	
	public void initHand()
	{
		ArrayList<Hand> n = new ArrayList<Hand>();
		hand = n;
	}
}
