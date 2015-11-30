package developertest;

import java.math.BigDecimal;

public class Money {
	// change property type from double to bigdecimal to avoid floating point
	// problem
	private final BigDecimal amount;
	private final String currency;

	public Money(double amount, String currency) {
		// modify constructor for fit with new type without changing public interface
		this.amount = BigDecimal.valueOf(amount);
		this.currency = currency;
	}

	public double getAmount() {
		// modify method for fit with new type without changing public interface
		return amount.doubleValue();
	}

	public String getCurrency() {
		return currency;
	}

	public Money add(Money what) {
		// add check parameter when null is passed
		if (null == what || !what.getCurrency().equals(currency))
			throw new IllegalArgumentException();
		// modify method for fit with new type without changing public interface
		return new Money(amount.add(BigDecimal.valueOf(what.getAmount())).doubleValue(), currency);
	}

	public Money subtract(Money what) {
		// add check parameter when null is passed
		if (null == what || !what.getCurrency().equals(currency))
			throw new IllegalArgumentException();
		// modify method with new type without changing public interface
		return new Money(amount.subtract(BigDecimal.valueOf(what.getAmount())).doubleValue(), currency);
	}

	@Override
	public int hashCode() {
		//override hashcode method when override equals method 
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		// modify method for fit with new type without changing public interface
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		return true;
	}

}
