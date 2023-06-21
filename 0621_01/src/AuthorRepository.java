import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbutil.DBUtil;

public class AuthorRepository {

	public List<Author> selectAll(Connection conn) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Author> list = new ArrayList<>();
		String sql = "select * from authors";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");

				list.add(new Author(id, firstName, lastName));
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
		}
		return list;
	}
}
