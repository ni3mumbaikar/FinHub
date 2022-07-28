package herokuapp.com.finhublti.models;

public class Documents {
long cust_id,aadhar,vaadhar,vpan;
String pan,photo,bank_info,vphoto,vbank_info,comment;
public Long getCust_id() {
	return cust_id;
}
public void setCust_id(Long cust_id) {
	this.cust_id = cust_id;
}
public Long getAadhar() {
	return aadhar;
}
public void setAadhar(Long aadhar) {
	this.aadhar = aadhar;
}
public Long getVaadhar() {
	return vaadhar;
}
public void setVaadhar(Long vaadhar) {
	this.vaadhar = vaadhar;
}
public Long getVpan() {
	return vpan;
}
public void setVpan(Long vpan) {
	this.vpan = vpan;
}
public String getPan() {
	return pan;
}
public void setPan(String pan) {
	this.pan = pan;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
public String getBank_info() {
	return bank_info;
}
public void setBank_info(String bank_info) {
	this.bank_info = bank_info;
}
public String getVphoto() {
	return vphoto;
}
public void setVphoto(String vphoto) {
	this.vphoto = vphoto;
}
public String getVbank_info() {
	return vbank_info;
}
public void setVbank_info(String vbank_info) {
	this.vbank_info = vbank_info;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
public Documents() {
	super();
	// TODO Auto-generated constructor stub
}
public Documents(Long cust_id, Long aadhar, Long vaadhar, Long vpan, String pan, String photo, String bank_info,
		String vphoto, String vbank_info, String comment) {
	super();
	this.cust_id = cust_id;
	this.aadhar = aadhar;
	this.vaadhar = vaadhar;
	this.vpan = vpan;
	this.pan = pan;
	this.photo = photo;
	this.bank_info = bank_info;
	this.vphoto = vphoto;
	this.vbank_info = vbank_info;
	this.comment = comment;
}
}


