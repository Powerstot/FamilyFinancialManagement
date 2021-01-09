package other_test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.jupiter.api.Test;

import utils.JDBCUtils;

public class AddUserDataTest {
	/**
	 * 用批处理向数据库用户表添加10000条数据
	 * @throws Exception
	 */
	@Test
	public void testAddUser() throws Exception{
			String sql = "insert into user values(null,?,?,?,0,0)";
			Connection connection = JDBCUtils.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			for(int i=1;i<=100000;i++){
				ps.setString(1, "superman"+i);//userUsername
				ps.setString(2, "123123");//userPassword
				ps.setString(3, "123123@qq.com");//userEmail
				ps.addBatch();//将sql语句添加到批处理包
				if(i % 1000 == 0){
					ps.executeBatch();//执行批处理包的所有语句
					ps.clearBatch();//清空批处理包的sql语句
				}
			}
	}
}
