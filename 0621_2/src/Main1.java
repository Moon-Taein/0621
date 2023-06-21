import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main1 {
	public static void main(String[] args) {
		System.out.println("숫자를 입력하세요!");
		Scanner scan = new Scanner(System.in);
		String target = scan.nextLine();

		// 정수의 형태이거나 실수의 형태인지 확인하기
		Pattern pt = Pattern.compile("^[+-]?\\d+\\.[1-9]\\d+$"); // 실수인지
		Matcher mc = pt.matcher(target);
		Pattern pt2 = Pattern.compile("[+-]?\\d+(\\.[0]+)?"); // 정수인지
		Matcher mc2 = pt2.matcher(target);

		if (mc.matches()) {
			System.out.println("숫자가 실수입니다.");
		} else if (mc2.matches()) {
			System.out.println("숫자가 정수입니다.");
		} else {
			System.out.println("제대로 입력해라");
		}
	}
}