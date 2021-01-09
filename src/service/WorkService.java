package service;

import java.util.List;

import domain.Income;
import domain.Pay;

/**
 * ����֧��ҵ��ӿ�
 * @author Powers
 *
 */
public interface WorkService {
	public List showAllIncome();
	//����ҵ��
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
	 * @return list �����list����
	 */
	public List showByPayee(String payee);
	/**
	 * ͨ���������ݲ���������Ϣ
	 * @param content ��������
	 * @return list �����list����
	 */
	public List showByContent(String content);
	/**
	 * ͨ���������ڲ���������Ϣ
	 * @param date ��������
	 * @return list �����list����
	 */
	public List showByDate(String date);
	/**
	 * ͨ�����������������Ϣ
	 * @param money ������
	 * @return list �����list����
	 */
	public List showByMoney(String money);
	//֧��ҵ��
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
	 * ͨ�������˻�ȡ֧������
	 * @param payer ������
	 * @return list ֧����list����
	 */
	public List showByPayer(String payer);
	/**
	 * ͨ��֧�����ݻ�ȡ֧������
	 * @param content ֧������ 
	 * @return list ֧����list����
	 */
	public List showPayByContent(String content);
	/**
	 * ͨ��֧�����ڻ�ȡ֧������
	 * @param date ֧������
	 * @return list ֧����list����
	 */
	public List showPayByDate(String date);
	/**
	 * ͨ��֧������ȡ֧������
	 * @param money ֧�����
	 * @return list ֧����list����
	 */
	public List showPayByMoney(String money);
	/**
	 * ��ȡ���е�֧������
	 * @return list ֧����list����
	 */
	public List showAllPay();
	/**
	 * ��ȡ������
	 * @return int ������
	 */
	public int showTotalIncome();
	/**
	 * ��ȡ��֧��
	 * @return int ��֧��
	 */
	public int showTotalPay();
	/**
	 * ��ȡ������
	 * @return int ������
	 */
	public int showTotalProfit();
	/**
	 * �����꣬�»�ȡ������
	 * @param year ��
	 * @param month ��
	 * @return int ������
	 */
	public int showMonthIncome(String year, String month);
	/**
	 * �����꣬�»�ȡ��֧��
	 * @param year ��
	 * @param month ��
	 * @return int ��֧��
	 */
	public int showMonthPay(String year, String month);
	/**
	 * �������ڻ�ȡ������
	 * @param date ����
	 * @return int ������
	 */
	public int showDayIncome(String date);
	/**
	 * �������ڻ�ȡ��֧��
	 * @param date ����
	 * @return int ��֧��
	 */
	public int showDayPay(String date);
	
}
