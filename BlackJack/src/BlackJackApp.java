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
		int seed;		
		
		System.out.print("Enter seed to use when shuffling deck: ");
		seed = sc.nextInt();
		
		System.out.println("---Alexandre's Casino!---");
		
		do
		{
			deck.shuffle(seed);
			System.out.println("\n------------------New Round---------------------------\n");
			opponent.initHand();
			player.initHand();
			for ( int i = 0; i < 2; i++ )
			{
				opponent.deal(deck, 0, false);
				player.deal(deck, 0, true);
			}
			

			for ( int s = 0; s < player.hand.size(); s++)
			{
				player.hand.get(s).madeFromSplit = false;
			}
			String otc = "Dealer's first card from their hand: " + opponent.hand.get(0).getHand().get(0).toString();
			if ( player.getWillPlay() )
			{
				System.out.println("--------you-------------------------");
				player.Play(deck, sc, rounds, otc);
			}
			
			if ( opponent.getWillPlay() && player.hasHandNotBust() )
			{
				System.out.println("--------dealer----------------------");
				opponent.Play(deck, rounds);
			}		
			
				
			rounds++;

			
			for ( int c = 0; c < player.hand.size(); c++)
			{
				System.out.println( "\nYour hand: " + player.hand.get(c).toString() );
				System.out.println( "Dealer's hand: " + opponent.hand.get(0).toString() );
				if (!player.hand.get(c).hasSurrendered)
				{
					if (!player.isBust(c) && (opponent.isBust(0) || player.getScore(c) >= opponent.getScore(0)))
					{						
						if ( player.getScore(c) == opponent.getScore(0) && !opponent.isBlackJack(0))
						{
							System.out.println("This hand was a draw");
							player.draw(c);
							
						}
						else
						{
							System.out.println("you won this hand");
							player.win(c);
						}
					}
					else
					{
						System.out.println("dealer won this hand");
					}
				}
				else
				{
					System.out.println("you surrendered this hand");
				}
			}
			
			rounds = 0;
		}
		while ( !player.Lost() );
		System.out.println("you've lost all your money! Oh, no!");
	}
}
