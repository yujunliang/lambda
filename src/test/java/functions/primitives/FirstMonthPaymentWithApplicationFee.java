package functions.primitives;

public interface FirstMonthPaymentWithApplicationFee {
    Amount getFirstMonthPayment();

    Amount getApplicationFee();

    void setFirstMonthPayment(Amount amount);
}
