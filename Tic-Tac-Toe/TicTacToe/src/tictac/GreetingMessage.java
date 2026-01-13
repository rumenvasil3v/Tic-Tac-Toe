package tictac;

public final class GreetingMessage {
	
	public static String introductoryMessage() {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("Hey! Welcome to the Tic Tac Toe Game!!!\n");
		buffer.append("Happy to have you here!\n");
		buffer.append("Let us begin the fun!\n");
		
		return buffer.toString().trim();
	}
}
