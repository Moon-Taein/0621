import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import dbutil.DBUtil;

public class Main2 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select A.id, A.firstname, A.lastname, B.id as bookId, B.title, B.price, B.discountRate from authors A left join books B on A.id = B.authorId";
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			Map<Integer, Author> authors = new HashMap<>();
			while (rs.next()) {
				int authorId = rs.getInt("id");

				if (!authors.containsKey(authorId)) {
					String firstname = rs.getString("firstname");
					String lastname = rs.getString("lastname");

					Author p = new Author(authorId, firstname, lastname);
					authors.put(authorId, p);
				}

				int bookId = rs.getInt("bookId");
				String title = rs.getString("title");
				int price = rs.getInt("price");
				int discountRate = rs.getInt("discountRate");

				Author a = authors.get(authorId);
				Book bk1 = new Book(bookId, title, price, discountRate, a);
				a.getBooks().add(bk1);
			}

			for (Entry<Integer, Author> entry : authors.entrySet()) {
				Author a = entry.getValue();
				System.out.println(a);
				System.out.println(a.getBooks());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}

	}
}