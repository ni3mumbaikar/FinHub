package herokuapp.com.finhublti.models;

import javax.persistence.*;

@Embeddable
@Table(name = "bank")
public class Bank {
	@Column(name="custid")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="custid",referencedColumnName = "custid")
	Customer bank_cust;
	long acc_no;
	String bank_name, ifsc;

	public Customer getBank_cust() {
		return bank_cust;
	}

	public void setBank_cust(Customer bank_cust) {
		this.bank_cust = bank_cust;
	}

	public long getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(long acc_no) {
		this.acc_no = acc_no;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public Bank() {
		super();
	}

	public Bank(long acc_no, String bank_name, String ifsc) {
		super();
		this.acc_no = acc_no;
		this.bank_name = bank_name;
		this.ifsc = ifsc;
	}

}
