package loan.primitives;

public interface Principal {
    Amount getPrincipal();

    Amount getApplicationFee();

    void setPrincipal(Amount amount);
}
