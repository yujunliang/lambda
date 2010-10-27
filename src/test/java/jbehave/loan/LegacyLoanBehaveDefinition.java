package jbehave.loan;

import legacy.LegacyLoanCalculation;
import legacy.Loan;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class LegacyLoanBehaveDefinition {

    private Loan loan;

    @Given("<term> year loan of <amount> at <rate> in <country> for <first_time> first time buyer with <borrowed> borrowed application fee <fee>")
    public void given(int term,  double amount, BigDecimal rate, String country, String  first_time, String borrowed, BigDecimal fee) {
        loan = new Loan();
        loan.setRate(rate);
        loan.setPrincipal(new BigDecimal(amount));
        loan.setTerm(term);
        loan.setCountryCode(country);
        loan.setFirstTimeBuyer(first_time.equals(""));
        loan.setBorrowLoanApplicationFee(borrowed.equals(""));
        loan.setApplicationFee(fee);

    }

    @When("we calculate periodic payment")
    public void whenPaymentIsCalculated() {
        new LegacyLoanCalculation().calculate(loan);
    }

    @Then("monthly payment is <payment>, stamp duty is <stampduty> and first month payment is <first>")
    public void then(BigDecimal payment, BigDecimal stampduty, BigDecimal first) {
        assertEquals(payment.setScale(2, BigDecimal.ROUND_HALF_UP),  loan.getMonthPayment());
        assertEquals(first.setScale(2, BigDecimal.ROUND_HALF_UP), loan.getFirstMonthPayment());
        assertEquals(stampduty.setScale(2, BigDecimal.ROUND_HALF_UP), loan.getStampDuty());
    }

}
