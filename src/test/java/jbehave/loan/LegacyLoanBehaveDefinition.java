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
    public void given(final int term, final double amount, final BigDecimal rate, final String country, final String first_time, final String borrowed, final BigDecimal fee) {
        loan = new Loan() {
            {
                setRate(rate);
                setPrincipal(new BigDecimal(amount));
                setTerm(term);
                setCountryCode(country);
                setFirstTimeBuyer(first_time.equals(""));
                setBorrowLoanApplicationFee(borrowed.equals(""));
                setApplicationFee(fee);
            }
        };

    }

    @When("we calculate periodic payment")
    public void whenPaymentIsCalculated() {
        new LegacyLoanCalculation().calculate(loan);
    }

    @Then("monthly payment is <payment>, stamp duty is <stampduty> and first month payment is <first>")
    public void then(BigDecimal payment, BigDecimal stampduty, BigDecimal first) {
        assertEquals(payment.setScale(2, BigDecimal.ROUND_HALF_UP), loan.getMonthPayment());
        assertEquals(first.setScale(2, BigDecimal.ROUND_HALF_UP), loan.getFirstMonthPayment());
        assertEquals(stampduty.setScale(2, BigDecimal.ROUND_HALF_UP), loan.getStampDuty());
    }

}
