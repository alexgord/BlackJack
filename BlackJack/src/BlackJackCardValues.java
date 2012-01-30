import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class BlackJackCardValues
{
	public static ArrayList<Integer> getValue(Card c)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		switch (c.getFace())
		{
			case ACE: list.add(1);
				list.add(11);
				break;
			case TWO: list.add(2);
				break;
			case THREE: list.add(3);
				break;
			case FOUR: list.add(4);
				break;
			case FIVE: list.add(5);
				break;
			case SIX: list.add(6);
				break;
			case SEVEN: list.add(7);
				break;
			case EIGHT: list.add(8);
				break;
			case NINE: list.add(9);
				break;
			case TEN: list.add(10);
				break;
			case JACK: list.add(10);
				break;
			case QUEEN: list.add(10);
				break;
			case KING: list.add(10);
				break;
		}
		return list;
	}
	
	public static int getCombinedValuesOfCardHand(ArrayList<Card> c)
	{
		ArrayList<Integer> possibleValues = new ArrayList<Integer>();
		int returnedValue = 0;
		
		for (int i = 0; i < c.size(); i++  )
		{
			int currentValue = 0;
			for (int j = 0; j < c.get(i).getValues().size(); j++ )
			{
				currentValue += c.get(i).getValues().get(j);
			}
			
			possibleValues.add(currentValue);
		}
		
		Collections.sort(possibleValues);
		int a;
		for ( a = possibleValues.size(); a > 0; a-- )
		{
			if (possibleValues.get(a - 1) <= 21)
			{
				returnedValue = possibleValues.get(a -1);
				break;
			}
		}
		if ( a < 0)
		{
			returnedValue = possibleValues.get(0);
		}
		return returnedValue;
	}
}
