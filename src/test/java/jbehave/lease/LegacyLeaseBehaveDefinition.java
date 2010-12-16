package jbehave.lease;

import functions.primitives.Amount;
import functions.primitives.Rate;
import legacy.Lease;
import legacy.LegacyLeaseCalculation;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class LegacyLeaseBehaveDefinition {

    private Lease lease;

    @Given("<term> year lease of <amount> with <residual_value> at <rate> in <country> with application fee <fee>")
    public void given(final int term, final double amount, final BigDecimal residual_value, final BigDecimal rate, final String country, final BigDecimal fee) {
        lease = new Lease() {{
            setRate(rate);
            setPrincipal(new BigDecimal(amount));
            setTerm(term);
            setCountryCode(country);
            setResidualValue(residual_value);
            setApplicationFee(fee);
        }};
    }

    @When("we calculate periodic payment")
    public void whenPaymentIsCalculated() {
        LegacyLeaseCalculation.calculate(lease);
    }

    @Then("monthly payment is <payment>, stamp duty is <stampduty> and first month payment is <first>")
    public void then(BigDecimal payment, BigDecimal stampduty, BigDecimal first) {
        assertEquals(payment, lease.getMonthPayment());
        assertEquals(first, lease.getFirstMonthPayment());
        assertEquals(stampduty, lease.getStampDuty());
    }

}
