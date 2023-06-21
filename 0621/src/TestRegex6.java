import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex6 {
	public static void main(String[] args) {
		String line = "kor=90,eng=70,math=40";

		Pattern pattern = Pattern.compile("kor=(\\d+),eng=(\\d+),math=(\\d+)");
		Matcher matcher = pattern.matcher(line);

//		System.out.println(matcher.matches());

		if (matcher.find()) {
			System.out.println(matcher.group(1));
			System.out.println(matcher.group(2));
			System.out.println(matcher.group(3));
		}
	}
}