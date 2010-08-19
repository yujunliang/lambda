package amortization;

import algocraft.algorithm.engine.AlgorithmComposer;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AmortizationSteps {

    BigDecimal monthPayment;

    private Worksheet worksheet = new Worksheet();

    @Given("principal of $val")
    public void givenPrincipal(BigDecimal principal) {
        worksheet.setPrincipal(principal);
    }

    @Given("term of $num years")
    public void givenTerm(int term) {
        worksheet.setTerm(term);
    }

    @Given("interest of $rate%")
    public void givenInterestRate(BigDecimal interest) {
        worksheet.setRate(interest);
    }

    @Given("i am a first-time buyer")
    public void givenAFirstTimeBuyer() {
        worksheet.setFTBuyer(true);
    }

    @Given("I am in $country")
    public void givenIamIn(String countryCode) {
        worksheet.setCountryCode(countryCode);
    }

    @When("we calculate periodic payment")
    public void whenPaymentIsCalculated() {
        new NardiaCalculation().apply(worksheet);
        monthPayment = worksheet.getMonthPayment();
    }

    @Then("$payment results")
    public void thenResultingPayment(BigDecimal expected) {
        assertEquals("312.42", "" + monthPayment.toString());
        
    }

}
