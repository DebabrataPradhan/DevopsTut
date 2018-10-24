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
	public void numberThreeDegit() {
		Assert.assertEquals("Success", "five hundred sixty seven", numberToWords.convert(567)) ;
	}

	@Test
	public void numberTwoDigit() {
		Assert.assertEquals("Success", "twelve", numberToWords.convert(12)) ;
	}
	
	@Test
	public void numberOneDigit() {
		Assert.assertEquals("Success", "one", numberToWords.convert(1)) ;
	}
/*	@Test
	public void exitApplication() {
		Assert.assertEquals("Failure", "Zero", numberToWords.convert(0)) ;
	}
	
	@Test
	public void numberNegative() {
		Assert.assertEquals("Failure", "Sixty seven", numberToWords.convert(-67)) ;
	}*/
}
