import java.util.Scanner;

public class BlackJackApp
{

	/**
	 * @param args
	 */
	private static Player player;
	private static Player opponent;
	private static Scanner sc;
	private static Deck deck;
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		deck = new Deck();
		sc = new Scanner(System.in);
		player = new Player();
		opponent = new Player();
		System.out.println("Alexandre's Casino!");
		
		player.initHand(deck);
		opponent.initHand(deck);
		
		System.out.print("Opponent: ");
		System.out.println(opponent.toString());
		
		System.out.print("You: ");
		System.out.println(player.toString());
	}
	
	private static void getBet()
	{
		int entered;
		do
		{
			System.out.println("Bet must be between 1 and" + player.getMoney());
			System.out.print("Enter Bet: ");
			entered = sc.nextInt();
		}
		while ( !player.Bet(entered));
	}
	
	private static void OpponentPlay()
	{
		
	}
}
