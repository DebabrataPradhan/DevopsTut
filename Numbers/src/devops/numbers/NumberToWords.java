package devops.numbers;

import java.text.DecimalFormat;

public class NumberToWords {

	private static final String[] tensNames = {
    "",
    " ten",
    " twenty",
    " thirty",
    " forty",
    " fifty",
    " sixty",
    " seventy",
    " eighty",
    " ninety"
  };

  private static final String[] numNames = {
    "",
    " one",
    " two",
    " three",
    " four",
    " five",
    " six",
    " seven",
    " eight",
    " nine",
    " ten",
    " eleven",
    " twelve",
    " thirteen",
    " fourteen",
    " fifteen",
    " sixteen",
    " seventeen",
    " eighteen",
    " nineteen"
  };

  public NumberToWords() {}

  private static String convertLessThanOneThousand(int number) {
    String soFar;

    if (number % 100 < 20){
      soFar = numNames[number % 100];
      number /= 100;
    }
    else {
      soFar = numNames[number % 10];
      number /= 10;

      soFar = tensNames[number % 10] + soFar;
      number /= 10;
    }
    if (number == 0) return soFar;
    return numNames[number] + " hundred" + soFar;
  }


  public String convert(long number) {
	//System.out.println("Step 2");
    // 0 to 999 999 999 999
	if(number == 0) {
		return "Bye bye";
	}
	if (number > 0 && number < 1000000000) {
	    if (number == 0) { return "zero"; }
	
	    String snumber = Long.toString(number);
	
	    // pad with "0"
	    String mask = "000000000000";
	    DecimalFormat df = new DecimalFormat(mask);
	    snumber = df.format(number);
	
	    // XXXnnnnnnnnn
	    int billions = Integer.parseInt(snumber.substring(0,3));
	    // nnnXXXnnnnnn
	    int millions  = Integer.parseInt(snumber.substring(3,6));
	    // nnnnnnXXXnnn
	    int hundredThousands = Integer.parseInt(snumber.substring(6,9));
	    // nnnnnnnnnXXX
	    int thousands = Integer.parseInt(snumber.substring(9,12));
	
	    String tradBillions;
	    switch (billions) {
	    case 0:
	      tradBillions = "";
	      break;
	    case 1 :
	      tradBillions = convertLessThanOneThousand(billions)
	      + " billion ";
	      break;
	    default :
	      tradBillions = convertLessThanOneThousand(billions)
	      + " billion ";
	    }
	    String result =  tradBillions;
	
	    String tradMillions;
	    switch (millions) {
	    case 0:
	      tradMillions = "";
	      break;
	    case 1 :
	      tradMillions = convertLessThanOneThousand(millions)
	         + " million ";
	      break;
	    default :
	      tradMillions = convertLessThanOneThousand(millions)
	         + " million ";
	    }
	    result =  result + tradMillions;
	
	    String tradHundredThousands;
	    switch (hundredThousands) {
	    case 0:
	      tradHundredThousands = "";
	      break;
	    case 1 :
	      tradHundredThousands = "one thousand ";
	      break;
	    default :
	      tradHundredThousands = convertLessThanOneThousand(hundredThousands)
	         + " thousand ";
	    }
	    result =  result + tradHundredThousands;
	
	    String tradThousand;
	    tradThousand = convertLessThanOneThousand(thousands);
	    result =  result + tradThousand;
	
	    // remove extra spaces!
	    return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
	} else {
		return "Out of range";
	}
  }

  /**
   * testing
   * @param args
   */
//  public static void main(String[] args) {
//	  NumberToWords numberToWord = new NumberToWords();

//	  System.out.println(numberToWord.convert(4567));
	  
//    System.out.println(NumberToWords.convert(0));
//    System.out.println(NumberToWords.convert(1));
//    System.out.println(NumberToWords.convert(16));
//    System.out.println(NumberToWords.convert(100));
//    System.out.println(NumberToWords.convert(118));
//    System.out.println(NumberToWords.convert(200));
//    System.out.println(NumberToWords.convert(219));
//    System.out.println(NumberToWords.convert(800));
//    System.out.println(NumberToWords.convert(801));
//    System.out.println(NumberToWords.convert(1316));
//    System.out.println(NumberToWords.convert(1000000));
//    System.out.println(NumberToWords.convert(2000000));
//    System.out.println(NumberToWords.convert(3000200));
//    System.out.println(NumberToWords.convert(700000));
//    System.out.println(NumberToWords.convert(9000000));
//    System.out.println(NumberToWords.convert(9001000));
//    System.out.println(NumberToWords.convert(123456789));
//    System.out.println(NumberToWords.convert(2147483647));
//    System.out.println(NumberToWords.convert(3000000010L));

    /*
     *** zero
     *** one
     *** sixteen
     *** one hundred
     *** one hundred eighteen
     *** two hundred
     *** two hundred nineteen
     *** eight hundred
     *** eight hundred one
     *** one thousand three hundred sixteen
     *** one million
     *** two millions
     *** three millions two hundred
     *** seven hundred thousand
     *** nine millions
     *** nine millions one thousand
     *** one hundred twenty three millions four hundred
     **      fifty six thousand seven hundred eighty nine
     *** two billion one hundred forty seven millions
     **      four hundred eighty three thousand six hundred forty seven
     *** three billion ten
     **/
//  }
}
