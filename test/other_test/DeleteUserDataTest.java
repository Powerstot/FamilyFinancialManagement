package other_test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.jupiter.api.Test;

import utils.JDBCUtils;

public class DeleteUserDataTest {
	/**
	 * ������������ݿ��û���ɾ������
	 * @throws Exception
	 */
	@Test
	public void testDeleteUser() throws Exception{
			String sql = "delete from user where user_id = ?";
			Connection connection = JDBCUtils.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			for(int i=10000;i<=100000;i++){
				ps.setInt(1, i);//userId
				ps.addBatch();//��sql�����ӵ��������
				if(i % 1000 == 0){
					ps.executeBatch();//ִ������������������
					ps.clearBatch();//������������sql���
				}
			}
	}
}
