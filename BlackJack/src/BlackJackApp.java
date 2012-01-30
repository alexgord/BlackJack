import java.util.Scanner;

public class BlackJackApp
{

	/**
	 * @param args
	 */
	private static You player;
	private static Opponent opponent;
	private static Scanner sc;
	private static Deck deck;
	private static int rounds;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		rounds = 0;
		deck = new Deck();
		sc = new Scanner(System.in);
		player = new You();
		opponent = new Opponent();
		
		deck.shuffle();
		System.out.println("Alexandre's Casino!");
		
		do
		{
			player.Play(deck, sc, rounds);
			opponent.Play(deck, rounds);
			rounds++;
		}
		while (!player.Lost() && player.getWillPlay());
	
	}
}
