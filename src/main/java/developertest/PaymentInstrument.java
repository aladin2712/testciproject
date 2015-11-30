package developertest;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
//change class import from javax.persistence.Transaction to Transaction Entity class for correct mapping
import developertest.Transaction;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class PaymentInstrument {

	private transient PaymentInstrumentType type;
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private PaymentInstrumentStatus status;
	
	@Column
	private Date creationDateTime;
	
	@Column
	private String accountHolder;
		
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="paymentInstrument")
	private List<Transaction> transactions;
	
	public PaymentInstrument(PaymentInstrumentType type) {
		this.type = type;
	}
	
	public PaymentInstrumentType getType() {
		return type;
	}

	public void setType(PaymentInstrumentType type) {
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public PaymentInstrumentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentInstrumentStatus status) {
		this.status = status;
	}

	public Date getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(Date creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}	

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public abstract String getDescription();
	
}
