package legacy;

import java.math.BigDecimal;

public class Lease extends FinancialInstrument {

    private BigDecimal residualValue;

    public void setResidualValue(BigDecimal residualValue) {
        this.residualValue = residualValue;
    }

    public BigDecimal getResidualValue() {
        return residualValue;
    }
}
