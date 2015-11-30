package developertest;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class BankAccount extends PaymentInstrument {

	@Column
	private String bankName;
	
	@Column
	private String iban;
	
	@Column
	private String bic;
	
	public BankAccount() {
		super(PaymentInstrumentType.BankAccount);
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public String getDescription() {
		return String.format("Bank Account %s (%s)", getId(), getStatus() == PaymentInstrumentStatus.Active ? "Active": "Locked");
	}
}
