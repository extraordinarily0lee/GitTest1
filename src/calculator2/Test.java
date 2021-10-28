package calculator2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern aPattern2 = Pattern.compile("123");
        String[] aStrings = aPattern2.split("1234");
        for(int a = 0;a<aStrings.length;a++) {
        	System.out.println(aStrings[a]);
        }
	}

}
