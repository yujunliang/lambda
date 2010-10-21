package legacy;

public class Loan extends FinancialInstrument {

    private boolean firstTimerBuyer;

    public boolean isFirstTimeBuyer() {
        return firstTimerBuyer;
    }

    public void setFirstTimeBuyer(boolean firstTimeBuyer) {
        this.firstTimerBuyer = firstTimeBuyer;
    }
}
