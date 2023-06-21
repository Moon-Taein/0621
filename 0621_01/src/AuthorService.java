import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dbutil.DBUtil;

public class AuthorService {
	private AuthorRepository authorRepo;
	private BookRepository bookRepo;

	public AuthorService() {
		authorRepo = new AuthorRepository();
		bookRepo = new BookRepository();
	}

	// 작가하나에 해당 작가의 책들 리스트 넣어주는 메소드
	public List<Author> selectAll() {
		Connection conn = null;

		try {
			conn = DBUtil.getConnection();
			// 트랜잭션 제어도 상위 메소드에서 하면 좋다
//			conn.setAutoCommit(false);
			List<Author> authors = authorRepo.selectAll(conn);
			for (Author a : authors) {
				int key = a.getId();
				List<Book> books = bookRepo.selectByAuthorId(conn, key);
				a.setBooks(books);
			}
			return authors;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return null;
	}
}