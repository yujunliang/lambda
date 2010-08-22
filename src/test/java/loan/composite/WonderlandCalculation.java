package loan.composite;


import algocraft.algorithm.engine.AbstractFunction;
import loan.atomic.MonthlyPaymentCalculation;
import loan.atomic.StampDutyOnPrincipal;
import loan.domain.Worksheet;

public final class WonderlandCalculation extends AbstractFunction<Worksheet, Worksheet> {

    public WonderlandCalculation() {
        super(new MonthlyPaymentCalculation(),
              new StampDutyOnPrincipal()
        );
    }
}
