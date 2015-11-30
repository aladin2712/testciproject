package developertest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PaymentInstrumentController {

	@Autowired
	private PaymentInstrumentService paymentInstrumentService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		final Map<String, Object> model = new HashMap<String, Object>();
		final List<PaymentInstrument> paymentInstruments = paymentInstrumentService.findPaymentInstruments();
		model.put("paymentInstruments", paymentInstruments);
		return new ModelAndView("home", model);
	}
	
	@RequestMapping(value="/lockPaymentInstrument", method=RequestMethod.POST)
	public String lockPaymentInstrument(
			@RequestParam Long paymentInstrumentId,
			RedirectAttributes redirectAttributes
		) {
		paymentInstrumentService.lockPaymentInstrument(paymentInstrumentId);
		redirectAttributes.addFlashAttribute("message", String.format("Payment instrument %s locked.", paymentInstrumentId));
		return "redirect:/";
	}
	
	@RequestMapping(value="/unlockPaymentInstrument", method=RequestMethod.POST)
	public String unlockPaymentInstrument(
			@RequestParam Long paymentInstrumentId,
			RedirectAttributes redirectAttributes
		) {
		paymentInstrumentService.unlockPaymentInstrument(paymentInstrumentId);
		redirectAttributes.addFlashAttribute("message", String.format("Payment instrument %s activated.", paymentInstrumentId));
		return "redirect:/";
	}
	
	@RequestMapping(value="/createBankAccount", method=RequestMethod.POST)
	public String createBankAccount(
			@RequestParam String accountHolder,
			@RequestParam String bankName,
			@RequestParam String iban,
			@RequestParam String bic,
			RedirectAttributes redirectAttributes
		) {
		long bankAccountId = paymentInstrumentService.createBankAccount(accountHolder, bankName, iban, bic);
		redirectAttributes.addFlashAttribute("message", String.format("Bank account with ID %s created.", bankAccountId));
		return "redirect:/";
	}
	
	@RequestMapping(value="/createCreditCard", method=RequestMethod.POST)
	public String createCreditCard(
			@RequestParam String accountHolder,
			@RequestParam CreditCardScheme scheme,
			@RequestParam String pan,
			@RequestParam Integer expiryMonth,
			@RequestParam Integer expiryYear,
			RedirectAttributes redirectAttributes
		) {
		long creditCardId = paymentInstrumentService.createCreditCard(accountHolder, scheme, pan, expiryMonth, expiryYear);
		redirectAttributes.addFlashAttribute("message", String.format("Credit card with ID %s created.", creditCardId));
		return "redirect:/";
	}
	
}
