package jbehave;

import loan.composite.LoanCalculation;
import loan.domain.Worksheet;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class AmortizationSteps {

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

    @Given("$i am a first-time buyer")
    public void givenAFirstTimeBuyer() {
        worksheet.setFTBuyer(true);
    }

    @Given("I am in $country")
    public void givenIamIn(String countryCode) {
        worksheet.setCountryCode(countryCode);
    }

    @Given("$I borrow application fee")
     public void andIborrowApplicaitonFee() {
        worksheet.setBorrowLoanApplicationFee(true);
    }

    @Given("application fee $fee")
    public void andApplciationFee(BigDecimal applicaitonFee) {
        worksheet.setApplicationFee(applicaitonFee);
    }

    @When("we calculate periodic payment")
    public void whenPaymentIsCalculated() {
        new LoanCalculation().apply(worksheet);
    }

    @Then("$payment results")
    public void thenResultingPayment(BigDecimal expected) {
        assertEquals(expected,  worksheet.getMonthPayment());

    }

    @Then("first month payment is $payment")
    public void andFirstMonthPayment(BigDecimal expected) {
        assertEquals(expected, worksheet.getFirstMonthPayment());

    }

    @Then("$duty stampduty")
    public void andStampDuty(BigDecimal expected) {
        assertEquals(expected, worksheet.getStampDuty());
    }


    @Given("new worksheet")
    public void given(){
        worksheet = new Worksheet();
    }

}
