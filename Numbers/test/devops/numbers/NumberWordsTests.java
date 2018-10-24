package devops.numbers;

import org.junit.*;

import devops.numbers.NumberToWords;

public class NumberWordsTests {
	private NumberToWords numberToWords ;
	
	@Before
	public void setup() {
		numberToWords = new NumberToWords();
	}

	@Test
	public void numberFourDigit() {
		Assert.assertEquals("Success", "four thousand five hundred sixty seven", numberToWords.convert(4567)) ;
	}

	@Test
	public void numberMillion() {
		Assert.assertEquals("Success", "two hundred twelve million three hundred forty five thousand six hundred seventy eight", numberToWords.convert(212345678)) ;
	}

	@Test
	public void numberTwoDigit() {
		Assert.assertEquals("Success", "twelve", numberToWords.convert(12)) ;
	}
	
	@Test
	public void numberOneDigit() {
		Assert.assertEquals("Success", "one", numberToWords.convert(1)) ;
	}
	
	@Test
	public void exitApplication() {
		Assert.assertEquals("Success", "Bye bye", numberToWords.convert(0)) ;
	}
	
	@Test
	public void numberNegative() {
		Assert.assertEquals("Success", "Out of range", numberToWords.convert(-67)) ;
	}
}
