package domain;

import java.util.Date;
/**
 * ����ʵ����
 * @author Powers
 *
 */
public class Income {
	private int incomeId;//������
	private String incomePayee;//�տ���
	private String incomeContent;//��������
	private Date incomeDate;//��������
	private int incomeMoney;//������
	public Income(int incomeId, String incomePayee, String incomeContent, Date incomeDate, int incomeMoney) {
		super();
		this.incomeId = incomeId;
		this.incomePayee = incomePayee;
		this.incomeContent = incomeContent;
		this.incomeDate = incomeDate;
		this.incomeMoney = incomeMoney;
	}
	public Income( String incomePayee, String incomeContent, Date incomeDate, int incomeMoney) {
		super();
		this.incomePayee = incomePayee;
		this.incomeContent = incomeContent;
		this.incomeDate = incomeDate;
		this.incomeMoney = incomeMoney;
	}
	public Income() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIncomeId() {
		return incomeId;
	}
	public void setIncomeId(int incomeId) {
		this.incomeId = incomeId;
	}
	public String getIncomePayee() {
		return incomePayee;
	}
	public void setIncomePayee(String incomePayee) {
		this.incomePayee = incomePayee;
	}
	public String getIncomeContent() {
		return incomeContent;
	}
	public void setIncomeContent(String incomeContent) {
		this.incomeContent = incomeContent;
	}
	public Date getIncomeDate() {
		return incomeDate;
	}
	public void setIncomeDate(Date incomeDate) {
		this.incomeDate = incomeDate;
	}
	public int getIncomeMoney() {
		return incomeMoney;
	}
	public void setIncomeMoney(int incomeMoney) {
		this.incomeMoney = incomeMoney;
	}
	@Override
	public String toString() {
		return "Income [incomeId=" + incomeId + ", incomePayee=" + incomePayee + ", incomeContent=" + incomeContent
				+ ", incomeDate=" + incomeDate + ", incomeMoney=" + incomeMoney + "]";
	}
	
	
}
