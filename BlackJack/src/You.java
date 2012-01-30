import java.util.ArrayList;
import java.util.Scanner;


public class You extends Player
{	
	ArrayList<Integer> iOptions;
	public void Play(Deck d, Scanner sc, int r)
	{
		int choice;
		iOptions = new ArrayList<Integer>();
		if (r == 0)
		{
			initHand(d);
		}
		String options = GenerateOptions(r);
		
		System.out.println("Now it's your turn!");
		System.out.println(toString());
		System.out.println("Hand Value" + BlackJackCardValues.getCombinedValuesOfCardHand(hand.get(0).getHand()));
		
		if (r == 0)
		{
			GetBet(sc);
		}
		
		System.out.println("Choose from the following options");
		System.out.println(options);
		
		choice = GetOption(sc);
		
		switch (choice)
		{
			case 1: if (!hit(d)){willPlay = false;}
				break;
			case 2: stand();
				break;
			case 3: surrender();
				break;
			case 4:	doubl(d, bet);
				break;
			case 5: split(d);
				break;
		}
		
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
			iOptions.add(1);
		}
		
		r += "Stand - 2\n";
		iOptions.add(2);
		
		if (ir == 0)
		{
			r += "Surrender - 3\n";
			iOptions.add(3);
			r += "Double - 4\n";
			iOptions.add(4);
		}
		
		if (hand.size() == 0 && hand.get(0).getHand().size() == 2 &&
			hand.get(0).getHand().get(0) == hand.get(0).getHand().get(1))
		{
			r += "Split5\n";
			iOptions.add(5);
		}
		
		return r;
	}
	
	private int GetOption( Scanner sc )
	{
		int entered;
		do
		{
			System.out.print("choose corresponding number: ");
			entered = sc.nextInt();
		}
		while ( !IsOptionAvailable(entered));
		
		return entered;
	}
	
	private boolean IsOptionAvailable(int e)
	{
		boolean r = false;
		for ( int i = 0; i < iOptions.size(); i++ )
		{
			if ( e == iOptions.get(i) )
			{
				r = true;
				break;
			}
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
