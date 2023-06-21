import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
	public static void main(String[] args) {
		// 정규표현식 연습

		String input = "userinput";

		Pattern p = Pattern.compile("userinput");
		Matcher m = p.matcher(input);

		System.out.println(m.matches());

		String input2 = "hi. This is a book";
		Pattern p2 = Pattern.compile("is");
		Matcher m2 = p2.matcher(input2);
		if (m2.find()) {
			System.out.println(m2.start());
			System.out.println(m2.end());
		}
		if (m2.find()) {
			System.out.println(m2.start());
			System.out.println(m2.end());
		}
		System.out.println(m2.find());
	}
}
