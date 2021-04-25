package testFiles;

public class Ticket {
	
	private static int ticketCount=0;
	
	private int value;
	
	public Ticket() {
		value=ticketCount++;
	}
	
	public int getValue() {
		return value;
	}
}
