package herokuapp.com.finhublti.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "card")
public class Card {

    @Id
    long card_no;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "custid", insertable = false, updatable = false)
    Customer card_cust;

    long custid, cvv, limit;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    CardType ct;

    int card_type;
    Date valid_thr;

    public Card() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Customer getCard_cust() {
        return card_cust;
    }

    public void setCard_cust(Customer card_cust) {
        this.card_cust = card_cust;
    }

    public CardType getCt() {
        return ct;
    }

    public void setCt(CardType ct) {
        this.ct = ct;
    }

    public Card(long card_no, long custid, long cvv, long limit, int card_type, Date valid_thr) {
        this.card_no = card_no;
        this.custid = custid;
        this.cvv = cvv;
        this.limit = limit;
        this.card_type = card_type;
        this.valid_thr = valid_thr;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }

    public long getCard_no() {
        return card_no;
    }

    public void setCard_no(long card_no) {
        this.card_no = card_no;
    }

    public long getCustid() {
        return custid;
    }

    public void setCustid(long custid) {
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

}
