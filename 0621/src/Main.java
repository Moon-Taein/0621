import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbutil.DBUtil;

public class Main {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from books A left join authors B on A.authorId = B.id";
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("id");
				String title = rs.getString("title");
				int price = rs.getInt("price");
				int discountRate = rs.getInt("discountRate");
				int authorId = rs.getInt("authorId");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");

				Book b = new Book(id, title, price, discountRate, new Author(authorId, firstname, lastname));
				System.out.println(b);

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