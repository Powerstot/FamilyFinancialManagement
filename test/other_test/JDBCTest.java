package other_test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import utils.JDBCUtils;
/**
 * JDBC测试类
 * @author Powers
 *
 */
class JDBCTest {
	/**
	 * 测试连接是否成功
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
