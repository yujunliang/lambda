package jbehave.lease;

import jbehave.BaseDefinition;

public class LeaseStory extends BaseDefinition {
    public LeaseStory() {
        super(new LeaseBehaveDefinition());
    }
}
