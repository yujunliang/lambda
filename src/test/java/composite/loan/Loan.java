package composite.loan;

import composite.FinancialInstrument;
import functions.primitives.FirstTimeBuyer;

public class Loan extends FinancialInstrument implements FirstTimeBuyer{

    private boolean firstTimerBuyer;

    public boolean isFirstTimeBuyer() {
        return firstTimerBuyer;
    }

    public void setFirstTimeBuyer(boolean firstTimeBuyer) {
        this.firstTimerBuyer = firstTimeBuyer;
    }
}
