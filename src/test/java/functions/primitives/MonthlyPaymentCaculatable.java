package functions.primitives;

public interface MonthlyPaymentCaculatable {
    void setMonthPayment(Amount amount);

    Rate getRate();

    int getTerm();

    Amount getPrincipal();
}
