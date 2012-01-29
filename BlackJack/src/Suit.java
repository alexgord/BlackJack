public enum Suit
{
	HEARTS ("H","\u2661"), DIAMONDS ("D","\u2662"), SPADES ("S","\u2660"), CLUBS ("C", "\u2663");

	private String suitStr;
	private String suitStrUTF;

	Suit(String suitStr, String suitStrUTF)
	{
		this.suitStr = suitStr;
		this.suitStrUTF = suitStrUTF;
	}

	public String toString()
	{
		return suitStr;
	}  

	public String toStringUTF()
	{
		return suitStrUTF;
	}
}