package jbehave.lease;

import jbehave.BaseAmortizationStory;
import jbehave.lease.LeaseAmortizationSteps;

public class LeaseStory extends BaseAmortizationStory {
    public LeaseStory() {
        super(new LeaseAmortizationSteps());
    }
}
