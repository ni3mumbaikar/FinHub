package herokuapp.com.finhublti.models;

public class Bank {
 long cust_id,acc_no;
 String bank_name,ifsc;
public long getCust_id() {
	return cust_id;
}
public void setCust_id(long cust_id) {
	this.cust_id = cust_id;
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
	// TODO Auto-generated constructor stub
}
public Bank(long cust_id, long acc_no, String bank_name, String ifsc) {
	super();
	this.cust_id = cust_id;
	this.acc_no = acc_no;
	this.bank_name = bank_name;
	this.ifsc = ifsc;
}
 
 
}
