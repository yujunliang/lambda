package loan.primitives;

import loan.primitives.Amount;

public interface FirstMonthPayment {
    Amount getFirstMonthPayment();

    Amount getApplicationFee();

    void setFirstMonthPayment(Amount amount);
}
