package loan.domain;

import loan.primitives.Leasable;
import loan.primitives.Amount;

public class Lease extends FinancialInstrument implements Leasable {

    private Amount residualValue;

    public void setResidualValue(Amount residualValue) {
        this.residualValue = residualValue;
    }

    public Amount getResidualValue() {
        return residualValue;
    }
}
