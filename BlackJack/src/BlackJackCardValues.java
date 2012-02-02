import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
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
				list.add(0);
				break;
			case THREE: list.add(3);
				list.add(0);
				break;
			case FOUR: list.add(4);
				list.add(0);
				break;
			case FIVE: list.add(5);
				list.add(0);
				break;
			case SIX: list.add(6);
				list.add(0);
				break;
			case SEVEN: list.add(7);
				list.add(0);
				break;
			case EIGHT: list.add(8);
				list.add(0);
				break;
			case NINE: list.add(9);
				list.add(0);
				break;
			case TEN: list.add(10);
				list.add(0);
				break;
			case JACK: list.add(10);
				list.add(0);
				break;
			case QUEEN: list.add(10);
				list.add(0);
				break;
			case KING: list.add(10);
				list.add(0);
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
	
	public static void test( Scanner sc)
	{
		
		ArrayList<ArrayList<Integer>> testar = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> test1 = new ArrayList<Integer>();
		ArrayList<Integer> test2 = new ArrayList<Integer>();
		ArrayList<Integer> test3 = new ArrayList<Integer>();
		test1.add(1);
		test1.add(2);
		test1.add(3);
		
		test2.add(4);
		test2.add(5);
		test2.add(6);
		
		test3.add(7);
		test3.add(8);
		test3.add(9);
		
		testar.add(test1);
		testar.add(test2);
		testar.add(test3);
		
		for (int a = 0; a < testar.size(); a++)
		{
			for (int b = 0; b < testar.get(a).size() * testar.get(a).size() ; b++)
			{
				for (int c = 0; c < testar.get(a).size() * testar.get(a).size() ; c++)
				{
					
				}
			}
		}
		
		for ( int i = 0; i < testar.size(); i++)
		{
			for (int j = 0; j < testar.get(i).size(); j++)
			{
				System.out.print(testar.get(i).get(j));
			}
			System.out.print("\n");
		}
	}
}
