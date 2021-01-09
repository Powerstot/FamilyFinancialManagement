package other_test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import utils.JDBCUtils;
/**
 * JDBC������
 * @author Powers
 *
 */
class JDBCTest {
	/**
	 * ���������Ƿ�ɹ�
	 */
	@Test
	public void ConnectionTest() {
		JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
		Connection conn = null;
		try {
			conn = template.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(conn);
	}
}
