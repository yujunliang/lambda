package jbehave;

import loan.composite.LoanCalculation;
import loan.domain.Amount;
import loan.domain.Loan;
import loan.domain.Rate;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class AmortizationSteps {

    private Loan worksheet = new Loan();

    @Given("principal of $val")
    public void givenPrincipal(double principal) {
        worksheet.setPrincipal(Amount.valueOf(principal));
    }

    @Given("term of $num years")
    public void givenTerm(int term) {
        worksheet.setTerm(term);
    }

    @Given("interest of $rate%")
    public void givenInterestRate(double interest) {
        worksheet.setRate(Rate.valueOf(interest));
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
        worksheet.setApplicationFee(Amount.valueOf(applicaitonFee.doubleValue()));
    }

    @When("we calculate periodic payment")
    public void whenPaymentIsCalculated() {
        new LoanCalculation().apply(worksheet);
    }

    @Then("$payment results")
    public void thenResultingPayment(BigDecimal expected) {
        assertEquals(expected,  worksheet.getMonthPayment().value());

    }

    @Then("first month payment is $payment")
    public void andFirstMonthPayment(BigDecimal expected) {
        assertEquals(expected, worksheet.getFirstMonthPayment().value());

    }

    @Then("$duty stampduty")
    public void andStampDuty(BigDecimal expected) {
        assertEquals(expected, worksheet.getStampDuty().value());
    }


    @Given("new worksheet")
    public void given(){
        worksheet = new Loan();
    }

}
