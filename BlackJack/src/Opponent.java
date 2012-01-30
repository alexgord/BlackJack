
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
		if ( r == 0)
		{
			initHand(d);
		}
		
		if (BlackJackCardValues.getCombinedValuesOfCardHand(this.hand.get(0).getHand()) < 17)
		{
			hit(d);
		}
		else
		{
			stand();
		}
		
		System.out.println("Opponent's turn");
		System.out.println(toString());
	}
}
