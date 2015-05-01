package jbehave.lease;

import composite.lease.Lease;
import composite.lease.LeaseCalculation;
import functions.primitives.Amount;
import functions.primitives.Rate;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class LeaseBehaveDefinition {

    private Lease lease;

    @Given("<term> year lease of <amount> with <residual_value> at <rate> in <country> with application fee <fee>")
    public void given(final int term, final double amount, final double residual_value, final double rate, final String country, final double fee) {
        lease = new Lease() {
            {
                setRate(Rate.valueOf(rate));
                setPrincipal(Amount.valueOf(amount));
                setTerm(term);
                setCountryCode(country);
                setResidualValue(Amount.valueOf(residual_value));
                setApplicationFee(Amount.valueOf(fee));
            }
        };

    }

    @When("we calculate periodic payment")
    public void whenPaymentIsCalculated() {
        new LeaseCalculation().apply(lease);
        //LegacyLeaseCalculation.calculate(lease);
    }

    @Then("monthly payment is <payment>, stamp duty is <stampduty> and first month payment is <first>")
    public void then(BigDecimal payment, BigDecimal stampduty, BigDecimal first) {
        assertEquals(payment, lease.getMonthPayment().value());
        assertEquals(first, lease.getFirstMonthPayment().value());
        assertEquals(stampduty, lease.getStampDuty().value());
    }

}
