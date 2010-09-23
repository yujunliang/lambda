package loan.primitives;

import loan.primitives.Amount;

public interface FirstMonthPaymentWithStampDuty {
    Amount getMonthPayment();

    Amount getStampDuty();

    void setFirstMonthPayment(Amount amount);
}
