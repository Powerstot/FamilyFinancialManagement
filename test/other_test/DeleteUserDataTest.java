package other_test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.jupiter.api.Test;

import utils.JDBCUtils;

public class DeleteUserDataTest {
	/**
	 * 用批处理对数据库用户表删除数据
	 * @throws Exception
	 */
	@Test
	public void testDeleteUser() throws Exception{
			String sql = "delete from user where user_id = ?";
			Connection connection = JDBCUtils.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			for(int i=10000;i<=100000;i++){
				ps.setInt(1, i);//userId
				ps.addBatch();//将sql语句添加到批处理包
				if(i % 1000 == 0){
					ps.executeBatch();//执行批处理包的所有语句
					ps.clearBatch();//清空批处理包的sql语句
				}
			}
	}
}
