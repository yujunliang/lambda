package amortization;

import java.math.BigDecimal;

public class Worksheet {
    private BigDecimal principal;
    private int term;
    private BigDecimal rate;
    private boolean FTBuyer;
    private String countryCode;
    private double monthPayment;

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public void setFTBuyer(boolean FTBuyer) {
        this.FTBuyer = FTBuyer;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public boolean isFTBuyer() {
        return FTBuyer;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public int getTerm() {
        return term;
    }

    public void setMonthPayment(double monthPayment) {
        this.monthPayment = monthPayment;
    }

    public BigDecimal getMonthPayment() {
        return new BigDecimal(monthPayment);
    }
}
