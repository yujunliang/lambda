package jbehave;

import loan.primitives.Amount;
import loan.primitives.Rate;
import loan.composite.LeaseCalculation;
import loan.domain.Lease;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class LeaseAmortizationSteps {

    private Lease lease;

    @Given("<term> year lease of <amount> with <residual_value> at <rate> in <country> for <buyer> first time buyer with <borrowed> borrowed application fee <fee>")
    public void given(int term,  double amount, double residual_value, double rate, String country, String  buyer, String borrowed, double fee) {
        lease = new Lease();
        lease.setRate(Rate.valueOf(rate));
        lease.setPrincipal(Amount.valueOf(amount));
        lease.setTerm(term);
        lease.setCountryCode(country);
        lease.setFirstTimeBuyer(buyer.equals(""));
        lease.setResidualValue(Amount.valueOf(residual_value));
        lease.setBorrowLoanApplicationFee(borrowed.equals(""));
        lease.setApplicationFee(Amount.valueOf(fee));

    }

    @When("we calculate periodic payment")
    public void whenPaymentIsCalculated() {
        new LeaseCalculation().apply(lease);
        //TranditionalLoanCalculation.calculate(lease);
    }

    @Then("monthly payment is <payment>, stamp duty is <stampduty> and first month payment is <first>")
    public void then(BigDecimal payment, BigDecimal stampduty, BigDecimal first) {
        assertEquals(payment,  lease.getMonthPayment().value());
        assertEquals(first, lease.getFirstMonthPayment().value());
        assertEquals(stampduty, lease.getStampDuty().value());
    }

}
