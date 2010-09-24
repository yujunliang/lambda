package composite.lease;

import composite.FinancialInstrument;
import functions.primitives.Leasable;
import functions.primitives.Amount;

public class Lease extends FinancialInstrument implements Leasable {

    private Amount residualValue;

    public void setResidualValue(Amount residualValue) {
        this.residualValue = residualValue;
    }

    public Amount getResidualValue() {
        return residualValue;
    }
}
