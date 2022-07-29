package herokuapp.com.finhublti.models;

import javax.persistence.Entity;

public class Address {
long cust_id,pincode;
String street,city,state,dist,landmark;
public long getCust_id() {
	return cust_id;
}
public void setCust_id(long cust_id) {
	this.cust_id = cust_id;
}
public long getPincode() {
	return pincode;
}
public void setPincode(long pincode) {
	this.pincode = pincode;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getDist() {
	return dist;
}
public void setDist(String dist) {
	this.dist = dist;
}
public String getLandmark() {
	return landmark;
}
public void setLandmark(String landmark) {
	this.landmark = landmark;
}
public Address() {
	super();
	// TODO Auto-generated constructor stub
}
public Address(long cust_id, long pincode, String street, String city, String state, String dist, String landmark) {
	super();
	this.cust_id = cust_id;
	this.pincode = pincode;
	this.street = street;
	this.city = city;
	this.state = state;
	this.dist = dist;
	this.landmark = landmark;
}

}
