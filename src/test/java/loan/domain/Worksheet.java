package loan.domain;

import loan.domain.Country;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Worksheet {
    private BigDecimal principal;
    private int term;
    private BigDecimal rate;
    private boolean FTBuyer;
    private double monthPayment;
    private double stampDuty;
    private Country country;
    private boolean borrowLoanApplicationFee;
    private BigDecimal applicationFee;
    private BigDecimal firstMonthPayment;

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
        this.country = Country.valueOf(countryCode);
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
        return new BigDecimal(monthPayment).setScale(2, RoundingMode.HALF_UP);
    }

    public void setStampDuty(double stampDuty) {
        this.stampDuty = stampDuty;
    }

    public BigDecimal getStampDuty() {
        return new BigDecimal(stampDuty).setScale(2, RoundingMode.HALF_UP);
    }

    public Country getCountry() {
        return country;
    }

    public boolean isBorrowLoanApplicationFee() {
        return borrowLoanApplicationFee;
    }

    public void setBorrowLoanApplicationFee(boolean borrowLoanApplicationFee) {
        this.borrowLoanApplicationFee = borrowLoanApplicationFee;
    }

    public BigDecimal getApplicationFee() {
        return applicationFee;
    }

    public void setApplicationFee(BigDecimal applicationFee) {
        this.applicationFee = applicationFee;
    }

    public BigDecimal getFirstMonthPayment() {
        return firstMonthPayment;
    }

    public void setFirstMonthPayment(BigDecimal firstMonthPayment) {
        this.firstMonthPayment = firstMonthPayment;
    }
}
