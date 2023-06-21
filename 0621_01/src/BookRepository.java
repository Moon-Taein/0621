import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbutil.DBUtil;

public class BookRepository {
	// CRUD 생략

	// 외래키로 검색하여 책 목록 반환
	public List<Book> selectByAuthorId(Connection conn, int authorId) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Book> list = new ArrayList<>();

		String sql = "select * from books where authorId = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, authorId);

			rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				int price = rs.getInt("price");
				int discountRate = rs.getInt("discountRate");
				Book bk1 = new Book(id, title, price, discountRate);
				list.add(bk1);

			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
		}
		return list;

	}

}
