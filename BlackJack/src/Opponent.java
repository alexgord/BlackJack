
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
		//if ( r == 0 )
		//{
		//	initHand(d);
		//}
		
		System.out.println("Opponent's turn");
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
		
		System.out.println("Dealer's first card from their hand: " + hand.get(0).getHand().get(0).toString());
		//System.out.println("Hand Value: " + BlackJackCardValues.getCombinedValuesOfCardHand(hand.get(handWillPlay).getHand()));
		
		//System.out.println(toString());
	}
}
