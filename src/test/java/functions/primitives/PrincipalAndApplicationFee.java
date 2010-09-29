package functions.primitives;

public interface PrincipalAndApplicationFee {
    Amount getPrincipal();

    Amount getApplicationFee();

    void setPrincipal(Amount amount);
}
