package herokuapp.com.finhublti.models;

import java.util.Date;

public class card {

	long card_no, custid, cvv;
	int card_type;
	Date valid_thr;

	public long getCard_no() {
		return card_no;
	}

	public void setCard_no(long card_no) {
		this.card_no = card_no;
	}

	public long getCust_id() {
		return custid;
	}

	public void setCust_id(long custid) {
		this.custid = custid;
	}

	public long getCvv() {
		return cvv;
	}

	public void setCvv(long cvv) {
		this.cvv = cvv;
	}

	public int getCard_type() {
		return card_type;
	}

	public void setCard_type(int card_type) {
		this.card_type = card_type;
	}

	public Date getValid_thr() {
		return valid_thr;
	}

	public void setValid_thr(Date valid_thr) {
		this.valid_thr = valid_thr;
	}

	public card() {
		super();
		// TODO Auto-generated constructor stub
	}

	public card(long card_no, long custid, long cvv, int card_type, Date valid_thr) {
		super();
		this.card_no = card_no;
		this.custid = custid;
		this.cvv = cvv;
		this.card_type = card_type;
		this.valid_thr = valid_thr;
	}

}
