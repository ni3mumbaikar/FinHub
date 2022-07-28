package herokuapp.com.finhublti.models;

import java.util.Date;

public class Transactions {
	long txn_id, cust_id, pid, pending_inst;
	Date txn_date, due_date;

	public long getTxn_id() {
		return txn_id;
	}

	public void setTxn_id(long txn_id) {
		this.txn_id = txn_id;
	}

	public long getCust_id() {
		return cust_id;
	}

	public void setCust_id(long cust_id) {
		this.cust_id = cust_id;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
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

	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transactions(long txn_id, long cust_id, long pid, Date txn_date, long pending_inst, Date due_date) {
		super();
		this.txn_id = txn_id;
		this.cust_id = cust_id;
		this.pid = pid;
		this.txn_date = txn_date;
		this.pending_inst = pending_inst;
		this.due_date = due_date;
	}

}
