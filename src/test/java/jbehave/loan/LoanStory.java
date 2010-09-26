package jbehave.loan;

import jbehave.BaseAmortizationStory;
import jbehave.loan.LoanAmortizationSteps;

public class LoanStory extends BaseAmortizationStory {
    public LoanStory() {
        super(new LoanAmortizationSteps());
    }
}
