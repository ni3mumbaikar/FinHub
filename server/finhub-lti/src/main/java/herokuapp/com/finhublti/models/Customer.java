package herokuapp.com.finhublti.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    long custid;
    String first_name, middle_name, last_name;
    long phone_no;
    String email, username, password;

    @OneToMany(mappedBy = "c")
    Set<Transactions> transactions = new HashSet<>();

    @OneToMany(mappedBy = "documentCustid", cascade = CascadeType.ALL)
    Set<Document> documents = new HashSet<>();

    @OneToMany(mappedBy = "addressCustomer", cascade = CascadeType.ALL)
    Set<Address> addresses = new HashSet<>();

    @OneToMany(mappedBy = "bank_cust", cascade = CascadeType.ALL)
    Set<Bank> banks = new HashSet<>();

    @OneToMany(mappedBy = "card_cust", cascade = CascadeType.ALL)
    Set<Card> cards = new HashSet<>();

    long card_type, alternate_phone, card_no, is_approved, balance, aadhar;
    String pan;

    public Customer() {
        super();
    }

    public Customer(long custid, String first_name, String middle_name, String last_name, long phone_no, String email,
                    String username, String password, long card_type, long alternate_phone, long card_no, long is_approved,
                    long balance, long aadhar, String pan, String myname) {
        super();
        this.custid = custid;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.phone_no = phone_no;
        this.email = email;
        this.username = username;
        this.password = password;
        this.card_type = card_type;
        this.alternate_phone = alternate_phone;
        this.card_no = card_no;
        this.is_approved = is_approved;
        this.balance = balance;
        this.aadhar = aadhar;
        this.pan = pan;
    }



    public Set<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transactions> transactions) {
        this.transactions = transactions;
    }

    public long getCustid() {
        return custid;
    }

    public void setCustid(long custid) {
        this.custid = custid;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public long getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(long phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getCard_type() {
        return card_type;
    }

    public void setCard_type(long card_type) {
        this.card_type = card_type;
    }

    public long getAlternate_phone() {
        return alternate_phone;
    }

    public void setAlternate_phone(long alternate_phone) {
        this.alternate_phone = alternate_phone;
    }

    public long getCard_no() {
        return card_no;
    }

    public void setCard_no(long card_no) {
        this.card_no = card_no;
    }

    public long getIs_approved() {
        return is_approved;
    }

    public void setIs_approved(long is_approved) {
        this.is_approved = is_approved;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getAadhar() {
        return aadhar;
    }

    public void setAadhar(long aadhar) {
        this.aadhar = aadhar;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

}
