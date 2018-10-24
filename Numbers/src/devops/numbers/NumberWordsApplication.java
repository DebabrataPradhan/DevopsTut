package devops.numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class NumberWordsApplication {
	private final NumberToWords numberToWords ;
	private final BufferedReader reader ;
	
	public NumberWordsApplication() {
		//System.out.println("step 1");
		numberToWords = new NumberToWords() ;
		reader = new BufferedReader( new InputStreamReader( System.in ) ) ;
	}
	
	//public void writeReport(char text) {
	//	System.out.println(text);
	//}
	
	public void execute() {
		while( true ) {
			try {
				System.out.print( "Enter number (0 to exit): " ) ;
				String value = reader.readLine() ;
				int number = Integer.parseInt( value ) ;
				if(number == 0) {
					System.out.println("Bye  bye");
					System.exit(0);
				}
				if (number > 0 && number < 1000) {
					System.out.println(number + " is converted to " + numberToWords.convert(number));
				} else {
					System.out.println(number + " is out of range");
				}
			} catch ( NumberFormatException | IOException e ) {
				System.out.println( "Invalid number" ) ;
			}
		}
	}

	public static void main(String[] args) {
		new NumberWordsApplication().execute() ;
	}

}
