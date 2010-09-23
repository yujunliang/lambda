package jbehave;

import loan.composite.LeaseCalculation;
import loan.composite.LoanCalculation;
import loan.domain.Amount;
import loan.domain.Lease;
import loan.domain.Rate;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class LeaseAmortizationSteps {

    private Lease loan;

    @Given("<term> year lease of <amount> with <residual_value> at <rate> in <country> for <buyer> first time buyer with <borrowed> borrowed application fee <fee>")
    public void given(int term,  double amount, double residual_value, double rate, String country, String  buyer, String borrowed, double fee) {
        loan = new Lease();
        loan.setRate(Rate.valueOf(rate));
        loan.setPrincipal(Amount.valueOf(amount));
        loan.setTerm(term);
        loan.setCountryCode(country);
        loan.setFirstTimeBuyer(buyer.equals(""));
        loan.setResidualValue(Amount.valueOf(residual_value));
        loan.setBorrowLoanApplicationFee(borrowed.equals(""));
        loan.setApplicationFee(Amount.valueOf(fee));

    }

    @When("we calculate periodic payment")
    public void whenPaymentIsCalculated() {
        new LeaseCalculation().apply(loan);
        //TranditionalLoanCalculation.calculate(loan);
    }

    @Then("monthly payment is <payment>, stamp duty is <stampduty> and first month payment is <first>")
    public void then(BigDecimal payment, BigDecimal stampduty, BigDecimal first) {
        assertEquals(payment,  loan.getMonthPayment().value());
        assertEquals(first, loan.getFirstMonthPayment().value());
        assertEquals(stampduty, loan.getStampDuty().value());
    }

}
