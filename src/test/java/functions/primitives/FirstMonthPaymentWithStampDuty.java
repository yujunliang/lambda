package functions.primitives;

public interface FirstMonthPaymentWithStampDuty {
    Amount getMonthPayment();

    Amount getStampDuty();

    void setFirstMonthPayment(Amount amount);
}
