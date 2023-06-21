import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex2 {
	public static void main(String[] args) {
		String input1 = "abcde";
		String input2 = "ABCDE";

		Pattern p = Pattern.compile("[a-z]{5}");
		Matcher m1 = p.matcher(input1);

		System.out.println(m1.matches());
		System.out.println(p.matcher(input2).matches());

		// [abcde] a~e
		Pattern p2 = Pattern.compile("[a-e]{1,5}");
		System.out.println(p2.matcher(input1).matches());

		Pattern upper = Pattern.compile("[A-Z]{5}");

	}
}
