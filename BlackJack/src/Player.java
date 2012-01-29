import java.util.ArrayList;

public class Player
{
	ArrayList<Hand> hand;
	int money;
	int score;
	
	public Player()
	{
		hand = new ArrayList<Hand>();
		money = 1000;
		score = 0;
	}
	
	public boolean hit(Deck d)
	{
		return true;
	}
	
	public void stand()
	{
		
	}
	
	public boolean doubl(Deck d, int amt)
	{
		return true;
	}
	
	public void split(Deck d)
	{
		
	}
	
	public String toString()
	{
		return "hello";
	}

	private void updateScore()
	{
		
	}
}
