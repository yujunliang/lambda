package functions.primitives;

public interface FirstMonthPayment {
    Amount getFirstMonthPayment();

    Amount getApplicationFee();

    void setFirstMonthPayment(Amount amount);
}
