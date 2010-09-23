package loan.domain;

public class Lease extends FinancialInstrument{

    private Amount residualValue;

    public void setResidualValue(Amount residualValue) {
        this.residualValue = residualValue;
    }

    public Amount getResidualValue() {
        return residualValue;
    }
}
