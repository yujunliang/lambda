package jbehave.loan;

import jbehave.BaseDefinition;

public class LoanStory extends BaseDefinition {
    public LoanStory() {
      super(new LoanBehaveDefinition(), new LegacyLoanBehaveDefinition());
      //  super(new LegacyLoanBehaveDefinition());
    }
}
