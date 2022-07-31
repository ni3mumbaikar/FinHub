package herokuapp.com.finhublti.models;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    long custid, pincode;
    String street, city, state, dist, landmark;
    @Id
    private Long id;

	@ManyToOne
	@JoinColumn(name = "custid", insertable = false, updatable = false)
	Customer addressCustomer;

    public Address() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Address(long custid, long pincode, String street, String city, String state, String dist, String landmark, Long id) {
        this.custid = custid;
        this.pincode = pincode;
        this.street = street;
        this.city = city;
        this.state = state;
        this.dist = dist;
        this.landmark = landmark;
        this.id = id;
    }

    public long getCustid() {
		return custid;
	}

	public void setCustid(long custid) {
		this.custid = custid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
}
