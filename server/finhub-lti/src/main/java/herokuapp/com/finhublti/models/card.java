package herokuapp.com.finhublti.models;

import java.util.Date;

public class card {

	long card_no,cust_id,cvv;
	int card_type;
	Date valid_thr;
	public long getCard_no() {
		return card_no;
	}
	public void setCard_no(long card_no) {
		this.card_no = card_no;
	}
	public long getCust_id() {
		return cust_id;
	}
	public void setCust_id(long cust_id) {
		this.cust_id = cust_id;
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
	public card(long card_no, long cust_id, long cvv, int card_type, Date valid_thr) {
		super();
		this.card_no = card_no;
		this.cust_id = cust_id;
		this.cvv = cvv;
		this.card_type = card_type;
		this.valid_thr = valid_thr;
	}
	
}
