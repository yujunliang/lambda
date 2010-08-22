package amortization;


import algocraft.algorithm.engine.AbstractFunction;

public final class WonderlandCalculation extends AbstractFunction<Worksheet, Worksheet> {

    public WonderlandCalculation() {
        super(new MonthlyPaymentCalculation(),
              new StampDutyOnPrincipal()
        );
    }
}
