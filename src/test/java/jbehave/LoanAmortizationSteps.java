package jbehave;

import loan.composite.LoanCalculation;
import loan.domain.Amount;
import loan.domain.FinancialInstrument;
import loan.domain.Loan;
import loan.domain.Rate;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class LoanAmortizationSteps {

    private Loan financialInstrument;

    @Given("<term> year financialInstrument of <amount> at <rate> in <country> for <buyer> first time buyer with <borrowed> borrowed application fee <fee>")
    public void given(int term,  double amount, double rate, String country, String  buyer, String borrowed, double fee) {
        financialInstrument = new Loan();
        financialInstrument.setRate(Rate.valueOf(rate));
        financialInstrument.setPrincipal(Amount.valueOf(amount));
        financialInstrument.setTerm(term);
        financialInstrument.setCountryCode(country);
        financialInstrument.setFirstTimeBuyer(buyer.equals(""));
        financialInstrument.setBorrowLoanApplicationFee(borrowed.equals(""));
        financialInstrument.setApplicationFee(Amount.valueOf(fee));

    }

    @When("we calculate periodic payment")
    public void whenPaymentIsCalculated() {
        new LoanCalculation().apply(financialInstrument);
        //TranditionalLoanCalculation.calculate(financialInstrument);
    }

    @Then("monthly payment is <payment>, stamp duty is <stampduty> and first month payment is <first>")
    public void then(BigDecimal payment, BigDecimal stampduty, BigDecimal first) {
        assertEquals(payment,  financialInstrument.getMonthPayment().value());
        assertEquals(first, financialInstrument.getFirstMonthPayment().value());
        assertEquals(stampduty, financialInstrument.getStampDuty().value());
    }

}
