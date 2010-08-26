package jbehave;

import loan.composite.LoanCalculation;
import loan.domain.Amount;
import loan.domain.Loan;
import loan.domain.Rate;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class AmortizationSteps {

    private Loan loan;

    @Given("<term> year loan of <amount> at <rate> in <country> for <buyer> first time buyer with <borrowed> application fee <applicationfee>")
    public void aStock(@Named("term") int term, @Named("amount") double principal, @Named("rate") double interest,
                       @Named("country")String countryCode, @Named("buyer") String  firstTimeBuyer,
                       @Named("borrowed") String borrowed, @Named("applicationfee") double applicationFee) {
        loan = new Loan();
        loan.setRate(Rate.valueOf(interest));
        loan.setPrincipal(Amount.valueOf(principal));
        loan.setTerm(term);
        loan.setCountryCode(countryCode);
        loan.setFTBuyer(firstTimeBuyer.equals(""));
        loan.setBorrowLoanApplicationFee(!borrowed.equals(""));
        loan.setApplicationFee(Amount.valueOf(applicationFee));

    }

    @When("we calculate periodic payment")
    public void whenPaymentIsCalculated() {
        new LoanCalculation().apply(loan);
        //TranditionalLoanCalculation.calculate(loan);
    }

    @Then("monthly payment is <payment>, stamp duty is <stampduty> and first month payment is <first>")
    public void then(@Named("payment") BigDecimal payment, @Named("stampduty") BigDecimal stampduty,
                     @Named("first") BigDecimal firstMonthPayment) {
        assertEquals(payment,  loan.getMonthPayment().value());
        assertEquals(firstMonthPayment, loan.getFirstMonthPayment().value());
        assertEquals(stampduty, loan.getStampDuty().value());

    }

}
