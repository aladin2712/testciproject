package developertest;

import java.util.List;

public interface PaymentInstrumentService {
	
	List<PaymentInstrument> findPaymentInstruments();
	
	void lockPaymentInstrument(
			long paymentInstrumenId
		);
	
	void unlockPaymentInstrument(
			long paymentInstrumenId
		);
	
	long createBankAccount(
			String accountHolder,
			String bankName,
			String iban,
			String bic
		);
	
	long createCreditCard(
			String accountHolder,
			CreditCardScheme scheme,
			String pan,
			int expiryMonth,
			int expiryYear
		);

}
