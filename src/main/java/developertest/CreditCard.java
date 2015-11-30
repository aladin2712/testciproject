package developertest;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CreditCard extends PaymentInstrument {
	
	@Column
	private String pan;
	
	@Column
	private CreditCardScheme scheme;
	
	@Column
	private int expiryMonth;
	
	@Column
	private int expiryYear;
	
	public CreditCard() {
		super(PaymentInstrumentType.CreditCard);
	}
	
	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public CreditCardScheme getScheme() {
		return scheme;
	}

	public void setScheme(CreditCardScheme scheme) {
		this.scheme = scheme;
	}

	public int getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(int expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public int getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(int expiryYear) {
		this.expiryYear = expiryYear;
	}

	@Override
	public String getDescription() {
		return String.format("Credit Card %s (%s)", getId(), getStatus() == PaymentInstrumentStatus.Active ? "Active": "Locked");
	}

}
