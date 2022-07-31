package herokuapp.com.finhublti.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TRANSACTIONS")
public class Transactions {
    @Id
    long txn_id;
    @ManyToOne
    @JoinColumn(name = "custid")
    Customer c;

    @ManyToOne
    @JoinColumn(name = "pid")
    Product p;

    long pending_inst;
    Date txn_date, due_date;

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
