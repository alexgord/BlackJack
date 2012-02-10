import java.util.ArrayList;
import java.util.Scanner;

public class Player
{
	protected ArrayList<Hand> hand;
	protected int money;
	protected int handWillPlay;
	
	public Player()
	{
		this.hand = new ArrayList<Hand>();
		money = 1000;
		handWillPlay = 0;
	}
	
	public boolean hit(Deck d)
	{
		boolean r = false;
		
		if (hand.get(handWillPlay).isHandPlayable())
		{
			hand.get(handWillPlay).Add(d.draw());
			r = true;
		}
		
		return r;
	}
	
	public void stand()
	{
		hand.get(handWillPlay).willPlay = false;
	}
	
	public void surrender()
	{
		hand.get(handWillPlay).willPlay = false;
		money += hand.get(handWillPlay).getBet() / 2;
		hand.get(handWillPlay).hasSurrendered = true;
	}
	
	public void doubl( Scanner sc, Deck d )
	{
		int addedBet = getDoubleBet(sc);
		hand.get(handWillPlay).setBet(hand.get(handWillPlay).getBet() + addedBet, money);
		hit(d);
		stand();
	}
	
	public int getDoubleBet(Scanner sc)
	{
		int r = 0;
		do
		{
			System.out.print("By how much do you want to increase your initial bet (limit: " + hand.get(handWillPlay).getBet() + " )?: ");
			r = sc.nextInt();
		}
		while (r < 1 && r > hand.get(handWillPlay).getBet());
		return r;
	}
	
	public boolean split(Deck d, boolean db)
	{
		boolean r = false;
		
		if ( money >= hand.get(handWillPlay).getBet() )
		{
			Hand tmp = new Hand(db);		
			tmp.Add(hand.get(handWillPlay).Pop());
			hand.add(tmp);
			hand.get(hand.size()-1).setBet(hand.get(handWillPlay).getBet(), money);
			hand.get(hand.size()-1).madeFromSplit = true;
			r = true;
			hand.get(hand.size() - 2).Add(d.draw());
			hand.get(hand.size() - 1).Add(d.draw());			
		}		
		
		return r;
	}
	
	protected boolean Bet(int b)
	{
		boolean r = false;
		
		if ( hand.get(handWillPlay).setBet(b, money) )
		{			
			money -= b;
			r = true;
		}
		return r;
	}
	
	public boolean getWillPlay()
	{
		boolean r = false;
		for ( int i = 0; i < hand.size(); i++ )
		{
			if ( hand.get(i).willPlay )
			{
				r = true;
				break;
			}
		}
		return r;
	}
	
	public int getScore(int h)
	{
		return hand.get(h).getValue();
	}
	
	public int getMoney()
	{
		return money;
	}
	
	public boolean isBust(int h)
	{
		return !hand.get(h).isHandPlayable();
	}
	
	public boolean isBlackJack(int h)
	{
		return hand.get(h).isBlackJack() && h == 0;
	}
	
	public void deal ( Deck d, int h, boolean db )
	{
		Hand a = new Hand(db);
		if ( hand.size() <= h )
		{
			a.Add(d.draw());
			hand.add(a);
		}
		else
		{
			hand.get(h).Add(d.draw());
		}
	}
	
	public boolean hasHandNotBust()
	{
		boolean r = false;
		
		for ( int i = 0; i < hand.size(); i ++)
		{
			if (hand.get(i).isHandPlayable())
			{
				r = true;
				break;
			}
		}
		
		return r;
	}
}
