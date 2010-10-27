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
    public void given(int term,  double amount, BigDecimal residual_value, BigDecimal rate, String country, BigDecimal fee) {
        lease = new Lease();
        lease.setRate(rate);
        lease.setPrincipal(new BigDecimal(amount));
        lease.setTerm(term);
        lease.setCountryCode(country);
        lease.setResidualValue(residual_value);
        lease.setApplicationFee(fee);

    }

    @When("we calculate periodic payment")
    public void whenPaymentIsCalculated() {
        LegacyLeaseCalculation.calculate(lease);
    }

    @Then("monthly payment is <payment>, stamp duty is <stampduty> and first month payment is <first>")
    public void then(BigDecimal payment, BigDecimal stampduty, BigDecimal first) {
        assertEquals(payment,  lease.getMonthPayment());
        assertEquals(first, lease.getFirstMonthPayment());
        assertEquals(stampduty, lease.getStampDuty());
    }

}
