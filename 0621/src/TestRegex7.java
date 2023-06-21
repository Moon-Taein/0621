import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex7 {
	public static void main(String[] args) {
		// 사용자에게 전화번호를 입력받아 (ex:010-1234-5678)
		// 올바른 입력인지 확인 후
		// 각 자리 전화번호 출력

		String line = "010-405-304433";

		Pattern pattern = Pattern.compile("^010-(\\d{3,4})-(\\d{4})$");
		Matcher matcher = pattern.matcher(line);

		System.out.println(matcher.matches());
		if (matcher.find()) {
			System.out.println(matcher.group(1));
			System.out.println(matcher.group(2));
		}
	}
}
