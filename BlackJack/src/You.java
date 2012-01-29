import java.util.Scanner;


public class You extends Player
{	
	public You()
	{
	}
	
	public void Play(Deck d, Scanner sc, int r)
	{
		String options = GenerateOptions(r);
		
		System.out.println(toString());
		
		if (r == 0)
		{
			initHand(d);
			GetBet(sc);
		}
		
		System.out.println("Choose from the following options");
		System.out.println(options);
		System.out.print("choose corresponding number: ");
		
	}
	
	
	private String GenerateOptions(int ir)
	{
		String r = new String();
		
		boolean addHit = false;
		
		for ( int i = 0; i < hand.size(); i++)
		{
			if (this.hand.get(i).isHandPlayable())
			{
				addHit = true;
				break;
			}
		}
		
		if ( addHit )
		{
			r += "Hit - 1\n";
		}
		
		r += "Stand - 2\n";
		
		if (ir == 0)
		{
			r += "Surrender - 3\n";
			r += "Double - 4\n";
		}
		
		if (hand.size() == 0 && hand.get(0).getHand().size() == 2 &&
			hand.get(0).getHand().get(0) == hand.get(0).getHand().get(1))
		{
			r += "Split\n";
		}
		
		return r;
	}
	
	private void GetBet(Scanner sc)
	{
		int entered;
		do
		{
			System.out.println("Bet must be between 1 and" + getMoney());
			System.out.print("Enter Bet: ");
			entered = sc.nextInt();
		}
		while ( !Bet(entered));
		
	}
	
	public boolean Lost()
	{
		return money == 0;
	}
}
