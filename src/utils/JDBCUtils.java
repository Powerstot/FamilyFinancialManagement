package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * JDBC�����࣬ʹ��Durid���ӳ�
 */
public class JDBCUtils {

    private static DataSource ds;

    static{
        try {
            //���������ļ�
            Properties pro = new Properties();
            //ʹ��CLassLoader���������ļ�����ȡ�ֽ�������
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);

            //��ʼ�����ӳض���
            ds = (DataSource) DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * ��ȡ���ӳض���
     * @return
     */
    public static DataSource getDataSource(){
        return ds;
    }

    /**
     * ��ȡConnection����
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
