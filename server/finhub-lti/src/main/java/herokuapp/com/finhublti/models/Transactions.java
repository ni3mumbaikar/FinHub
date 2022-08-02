package herokuapp.com.finhublti.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TRANSACTIONS")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long txn_id;

    long custid;

    @ManyToOne
    @JoinColumn(name = "custid", insertable = false, updatable = false)
    Customer c;


    @ManyToOne
    @JoinColumn(name = "pid", insertable = false, updatable = false)
    Product p;

    long pid;

    int emi_months;

    long pending_inst;

    public void setP(Product p) {
        this.p = p;
    }



    Date txn_date, due_date;

    public long getCustid() {
        return custid;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public Product getP() {
        return p;
    }

    public void setCustid(long custid) {
        this.custid = custid;
    }

    public Transactions() {
        super();
    }

    public Transactions(long txn_id, Date txn_date, long pending_inst, Date due_date) {
        super();
        this.txn_id = txn_id;
        this.txn_date = txn_date;
        this.pending_inst = pending_inst;
        this.due_date = due_date;
    }


    public int getEmi_months() {
        return emi_months;
    }

    public void setEmi_months(int emi_months) {
        this.emi_months = emi_months;
    }

    public long getTxn_id() {
        return txn_id;
    }

    public void setTxn_id(long txn_id) {
        this.txn_id = txn_id;
    }

    public Date getTxn_date() {
        return txn_date;
    }

    public void setTxn_date(Date txn_date) {
        this.txn_date = txn_date;
    }

    public long getPending_inst() {
        return pending_inst;
    }

    public void setPending_inst(long pending_inst) {
        this.pending_inst = pending_inst;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

}
