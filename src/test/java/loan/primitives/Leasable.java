package loan.primitives;

public interface Leasable extends MonthlyPaymentCaculatable {

    Amount getResidualValue();
}
