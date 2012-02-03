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
		
		//System.out.println(deck.toString());
		//deck.shuffle();
		System.out.println("---Alexandre's Casino!---");
		
		do
		{
			System.out.println("New Round\n");
			while ( true)
			{
				if ( opponent.getWillPlay() || rounds == 0)
				{
					System.out.println("--------dealer----------------------");
					opponent.Play(deck, rounds);
				}
				else
				{
					break;
				}
				
				if ( player.getWillPlay() || rounds == 0)
				{
					System.out.println("--------you----------------------");
					player.Play(deck, sc, rounds);
				}
				rounds++;
			}
			
			boolean won = false;
			for ( int c = 0; c < player.hand.size(); c++)
			{
				if (!player.isBust(c) || (opponent.isBust(0) || player.getScore(c) >= opponent.getScore(0)))
				{
					if ( player.getScore(c) == opponent.getScore(0) && player.isBlackJack() && !opponent.isBlackJack())
					{
						//System.out.println("it was a draw");
						//player.draw();
					}
					else
					{
						//System.out.println("you won");
						//player.win();
						won = true;
						break;
					}
				}
				else
				{
					//System.out.println("dealer won");
				}
			}
			
			if ( won )
			{
				System.out.println("you won");
				player.win();
			}
			else
			{
				System.out.println("Dealer won");
			}
			
			rounds = 0;
		}
		while ( !player.Lost() );
	}
}
