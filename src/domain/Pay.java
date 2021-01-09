package domain;

import java.util.Date;
/**
 * ֧��ʵ����
 * @author Powers
 *
 */
public class Pay {
	private int payId;//֧�����
	private String payPayer;//������
	private String payContent;//֧������
	private Date payDate;//֧������
	private int payMoney;//֧�����
	public Pay(int payId, String payPayer, String payContent, Date payDate, int payMoney) {
		super();
		this.payId = payId;
		this.payPayer = payPayer;
		this.payContent = payContent;
		this.payDate = payDate;
		this.payMoney = payMoney;
	}
	public Pay() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPayId() {
		return payId;
	}
	public void setPayId(int payId) {
		this.payId = payId;
	}
	public String getPayPayer() {
		return payPayer;
	}
	public void setPayPayer(String payPayer) {
		this.payPayer = payPayer;
	}
	public String getPayContent() {
		return payContent;
	}
	public void setPayContent(String payContent) {
		this.payContent = payContent;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public int getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(int payMoney) {
		this.payMoney = payMoney;
	}
	@Override
	public String toString() {
		return "Pay [payId=" + payId + ", payPayer=" + payPayer + ", payContent=" + payContent + ", payDate=" + payDate
				+ ", payMoney=" + payMoney + "]";
	}
	
}
