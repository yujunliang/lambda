package jbehave.lease;

import composite.lease.Lease;
import composite.lease.LeaseCalculation;
import functions.primitives.Amount;
import functions.primitives.Rate;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import traditional.TranditionalLeaseCalculation;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class LeaseBehaveDefinition {

    private Lease lease;

    @Given("<term> year lease of <amount> with <residual_value> at <rate> in <country> with application fee <fee>")
    public void given(int term,  double amount, double residual_value, double rate, String country, double fee) {
        lease = new Lease();
        lease.setRate(Rate.valueOf(rate));
        lease.setPrincipal(Amount.valueOf(amount));
        lease.setTerm(term);
        lease.setCountryCode(country);
        lease.setResidualValue(Amount.valueOf(residual_value));
        lease.setApplicationFee(Amount.valueOf(fee));

    }

    @When("we calculate periodic payment")
    public void whenPaymentIsCalculated() {
        new LeaseCalculation().apply(lease);
        //TranditionalLeaseCalculation.calculate(lease);
    }

    @Then("monthly payment is <payment>, stamp duty is <stampduty> and first month payment is <first>")
    public void then(BigDecimal payment, BigDecimal stampduty, BigDecimal first) {
        assertEquals(payment,  lease.getMonthPayment().value());
        assertEquals(first, lease.getFirstMonthPayment().value());
        assertEquals(stampduty, lease.getStampDuty().value());
    }

}
