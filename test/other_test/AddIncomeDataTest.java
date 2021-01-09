package other_test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.jupiter.api.Test;

import utils.JDBCUtils;

public class AddIncomeDataTest {
	/**
	 * 用批处理向数据库收入表添加10000条数据
	 * @throws Exception
	 */
	@Test
	public void testAddIncome() throws Exception{
		String sql = "insert into income values(null,?,?,?,?)";
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		for(int i=1;i<=10000;i++){
			ps.setString(1, "张三");//income_payee
			ps.setString(2, "第"+i+"次中彩票");//income_content
			ps.setString(3, "2020-01-01");//income_date
			ps.setString(4, "10");//income_money
			//将sql语句添加到批处理包
			ps.addBatch();
			if(i % 1000 == 0){
				//执行批处理包的所有语句
				ps.executeBatch();
				//清空批处理包的sql语句
				ps.clearBatch();
			}
		}
	}
}
