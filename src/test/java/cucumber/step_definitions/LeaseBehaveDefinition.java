package cucumber.step_definitions;

import composite.lease.Lease;
import composite.lease.LeaseCalculation;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import functions.primitives.Amount;
import functions.primitives.Rate;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class LeaseBehaveDefinition {

    private Lease lease;

    @Given("^(\\d+) year lease of ([-+]?[0-9]*\\.?[0-9]+) with ([-+]?[0-9]*\\.?[0-9]+) at ([-+]?[0-9]*\\.?[0-9]+) in (.+) with application fee ([-+]?[0-9]*\\.?[0-9]+.)$")
    public void given(final int term, final double amount, final double residual_value, final double rate, final String country, final double fee) {
        lease = new Lease() {{
            setRate(Rate.valueOf(rate));
            setPrincipal(Amount.valueOf(amount));
            setTerm(term);
            setCountryCode(country);
            setResidualValue(Amount.valueOf(residual_value));
            setApplicationFee(Amount.valueOf(fee));
        }};

    }

    @When("we calculate periodic payment")
    public void whenPaymentIsCalculated() {
        new LeaseCalculation().apply(lease);
    }

    @Then("monthly payment is ([-+]?[0-9]*\\.?[0-9]+), stamp duty is ([-+]?[0-9]*\\.?[0-9]+) and first month payment is ([-+]?[0-9]*\\.?[0-9]+)")
    public void then(BigDecimal payment, BigDecimal stampduty, BigDecimal first) {
        assertEquals(payment.setScale(2), lease.getMonthPayment().value());
        assertEquals(first.setScale(2), lease.getFirstMonthPayment().value());
        assertEquals(stampduty.setScale(2), lease.getStampDuty().value());
    }

}
