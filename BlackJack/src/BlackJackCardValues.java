import java.util.ArrayList;

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
		int returnedValue = 0;
		ArrayList<ArrayList<Integer>> values = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> sum = new ArrayList<Integer>();
		
		for ( int i = 0; i < c.size(); i++)
		{
			values.add(c.get(i).getValues());
		}
		
		generateSums(sum, 0, values, 0);
		
		sort(sum);
		
		for ( int a = 0; a < sum.size(); a++ )
		{
			returnedValue = sum.get(a);
			if ( returnedValue <= 21 )
			{
				break;
			}
		}
		
		return returnedValue;
	}
	
	private static void generateSums(ArrayList<Integer> sum, int prefix, ArrayList<ArrayList<Integer>> arr, int cindex)
	{
		if ( cindex == arr.size() -1 )
		{
			for ( int c = 0; c < arr.get(cindex).size(); c++ )
			{
				sum.add(prefix + arr.get(cindex).get(c));
			}
		}
		else
		{
			for ( int c = 0; c < arr.get(cindex).size(); c++ )
			{
				generateSums(sum, prefix + arr.get(cindex).get(c), arr, cindex + 1);
			}
		}
	}
	
	private static void sort(ArrayList<Integer> sum)
	{
		int n = sum.size();
	    boolean doMore = true;
	    while (doMore) {
	        n--;
	        doMore = false;  // assume this is our last pass over the array
	        for (int i=0; i<n; i++) {
	            if (sum.get(i) < sum.get(i+1)) {
	                // exchange elements
	                int temp = sum.get(i);
	                sum.set(i, sum.get(i+1));
	                sum.set(i+1, temp);
	                doMore = true;  // after an exchange, must look again 
	            }
	        }
	    }
	}
}
