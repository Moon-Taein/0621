import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("영단어를 입력하세요 ( 규칙 : 영대문자로 시작하고, 나머지 소문자, 최소1자, 최대 10자");
		String word = scan.nextLine();

		// 정규표현식 regex
		Pattern p1 = Pattern.compile("[A-Z][a-z]{0,9}");
		Matcher m1 = p1.matcher(word);
		System.out.println(m1.matches());
	}
}