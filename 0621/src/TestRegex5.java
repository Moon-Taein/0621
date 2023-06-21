import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex5 {
	public static void main(String[] args) {
		String line = "abc123def";

		// 정수값을 찾아서 출력해보기

		Pattern p1 = Pattern.compile("\\d+");
		Matcher m1 = p1.matcher(line);
		if (m1.find()) {
			System.out.println(m1.start());
			System.out.println(m1.end());
			System.out.println(line.substring(m1.start(), m1.end()));
		}
	}
}
