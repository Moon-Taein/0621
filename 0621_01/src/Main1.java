import java.util.List;

public class Main1 {
	public static void main(String[] args) {
//		BookRepository br = new BookRepository();
//
//		br.selectByAuthorId(1);
//
//		AuthorRepository ar = new AuthorRepository();
//
//		ar.selectAll();

		AuthorService service = new AuthorService();

		List<Author> list = service.selectAll();

		for (Author a : list) {
			System.out.println(a + " => " + a.getBooks());
		}

		CharSequence cs = "asdasdasd";
		String str = "asdasdasd";

		System.out.println(cs.charAt(3));
		System.out.println(str.charAt(3));

		System.out.println(cs);
		System.out.println(str);

	}
}