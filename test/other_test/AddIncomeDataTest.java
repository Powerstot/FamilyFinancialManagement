package other_test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.jupiter.api.Test;

import utils.JDBCUtils;

public class AddIncomeDataTest {
	/**
	 * �������������ݿ���������10000������
	 * @throws Exception
	 */
	@Test
	public void testAddIncome() throws Exception{
		String sql = "insert into income values(null,?,?,?,?)";
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		for(int i=1;i<=10000;i++){
			ps.setString(1, "����");//income_payee
			ps.setString(2, "��"+i+"���в�Ʊ");//income_content
			ps.setString(3, "2020-01-01");//income_date
			ps.setString(4, "10");//income_money
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
