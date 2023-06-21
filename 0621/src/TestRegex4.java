import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("영단어를 입력하세요 최소 3자 이상");
		String word = scan.nextLine();

		// 정규표현식 regex
//		Pattern p1 = Pattern.compile("[a-zA-Z]{3,}");
		// //w -> a-zA-Z0-9
//		Pattern p1 = Pattern.compile("\\w{3,}");
//		Matcher m1 = p1.matcher(word);
//		System.out.println(m1.matches());

		// 사용자 입력값이 정수일때만 true 출력하기
//		Pattern p2 = Pattern.compile("[0-9]{1,}");
		Pattern p2 = Pattern.compile("\\d+");
		Matcher m2 = p2.matcher(word);
		System.out.println(m2.matches());

	}
}