package dao;

import java.util.Date;
import java.util.List;

import domain.Income;
import domain.Pay;

/**
 * ����֧���������ݿ�ӿ�
 * @author Powers
 *
 */
public interface WorkDao {
	public List findAllIncome();
	
	//������ط���
	/**
	 * ���������Ϣ
	 * @param income �������
	 */
	public void addIncome(Income income);
	/**
	 * �޸�������Ϣ
	 * @param income �������
	 */
	public void updateIncome(Income income);
	/**
	 * ɾ��������Ϣ
	 * @param income �������
	 */
	public void deleteIncome(Income income);
	/**
	 * ͨ���տ��˲���������Ϣ
	 * @param payee �տ���
	 * @return list �������list����
	 */
	public List findByPayee(String payee);
	/**
	 * ͨ���������ݲ���������Ϣ
	 * @param content ��������
	 * @return list �������list����
	 */
	public List findByContent(String content);
	/**
	 * ͨ���������ڲ���������Ϣ
	 * @param date ��������
	 * @return list �������list����
	 */
	public List findByDate(Date date);
	/**
	 * ͨ�����������������Ϣ
	 * @param money ������
	 * @return list �������list����
	 */
	public List findByMoney(Integer money);
	//֧����ط���
	/**
	 * ���֧��
	 * @param pay ֧������
	 */
	public void addPay(Pay pay);
	/**
	 * ɾ��֧��
	 * @param pay ֧������
	 */
	public void deletePay(Pay pay);
	/**
	 * �޸�֧��
	 * @param pay ֧������
	 */
	public void updatePay(Pay pay);
	/**
	 * ͨ�������˻��֧������
	 * @param payer ������
	 * @return list ֧������list����
	 */
	public List findByPayer(String payer);
	/**
	 * ͨ��֧�����ݻ�ȡ֧������
	 * @param content ֧������
	 * @return list ֧������list����
	 */
	public List findPayByContent(String content);
	/** 
	 * ͨ��֧�����ڻ��֧������
	 * @param date ֧������
 	 * @return list ֧������list����
	 */
	public List findPayByDate(Date date);
	/**
	 * ͨ��֧������ȡ֧������
	 * @param money ֧�����
	 * @return list ֧������list����
	 */
	public List findPayByMoney(Integer money);
	/**
	 * ��ȡ����֧������
	 * @return list ֧������list����
	 */
	public List findAllPay();
	/**
	 * ��ȡ������
	 * @return int ������
	 */
	public int getTotalIncome();
	/**
	 * ��ȡ��֧��
	 * @return int ��֧��
	 */
	public int getTotalPay();
	/**
	 * ͨ���꣬�»�ȡ������
	 * @param year ��
	 * @param month ��
	 * @return int ������
	 */
	public int getMonthIncome(String year, String month);
	/**
	 * ͨ���꣬�»�ȡ��֧��
	 * @param year ��
	 * @param month ��
	 * @return int ��֧��
	 */
	public int getMonthPay(String year, String month);
	/**
	 * ͨ�����ڻ��������
	 * @param date ����
	 * @return int ������
	 */
	public int getDayIncome(Date date);
	/**
	 * ͨ�����ڻ����֧��
	 * @param date ����
	 * @return int ��֧��
	 */
	public int getDayPay(Date date);

	
}
