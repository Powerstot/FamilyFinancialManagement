package other_test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.jupiter.api.Test;

import utils.JDBCUtils;

public class AddPayDataTest {
	/**
	 * �������������ݿ���������10000������
	 * @throws Exception
	 */
	@Test
	public void testAddPay() throws Exception{
		String sql = "insert into pay values(null,?,?,?,?)";
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		for(int i=1;i<=10000;i++){
			ps.setString(1, "����");//pay_payer
			ps.setString(2, "��"+i+"�ξ۲�");//pay_content
			ps.setString(3, "2020-01-01");//pay_date
			ps.setString(4, "10");//pay_money
			//��sql�����ӵ��������
			ps.addBatch();
			if(i % 1000 == 0){
				//ִ������������������
				ps.executeBatch();
				//������������sql���
				ps.clearBatch();
			}
		}
	}
}
