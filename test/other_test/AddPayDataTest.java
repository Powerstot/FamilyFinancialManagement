package other_test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.jupiter.api.Test;

import utils.JDBCUtils;

public class AddPayDataTest {
	/**
	 * 用批处理向数据库收入表添加10000条数据
	 * @throws Exception
	 */
	@Test
	public void testAddPay() throws Exception{
		String sql = "insert into pay values(null,?,?,?,?)";
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		for(int i=1;i<=10000;i++){
			ps.setString(1, "李四");//pay_payer
			ps.setString(2, "第"+i+"次聚餐");//pay_content
			ps.setString(3, "2020-01-01");//pay_date
			ps.setString(4, "10");//pay_money
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
