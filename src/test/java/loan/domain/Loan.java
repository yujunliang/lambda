package loan.domain;

import loan.domain.Country;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Loan {
    private Amount principal;
    private int term;
    private Rate rate;
    private boolean FTBuyer;
    private Amount monthPayment;
    private Amount stampDuty;
    private Country country;
    private boolean borrowLoanApplicationFee;
    private Amount applicationFee;
    private Amount firstMonthPayment;

    public void setPrincipal(Amount principal) {
        this.principal = principal;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public void setFTBuyer(boolean FTBuyer) {
        this.FTBuyer = FTBuyer;
    }

    public void setCountryCode(String countryCode) {
        this.country = Country.valueOf(countryCode);
    }

    public Amount getPrincipal() {
        return principal;
    }

    public boolean isFTBuyer() {
        return FTBuyer;
    }

    public Rate getRate() {
        return rate;
    }

    public int getTerm() {
        return term;
    }

    public void setMonthPayment(Amount monthPayment) {
        this.monthPayment = monthPayment;
    }

    public Amount getMonthPayment() {
        return monthPayment;
    }

    public void setStampDuty(Amount stampDuty) {
        this.stampDuty = stampDuty;
    }

    public Amount getStampDuty() {
        return stampDuty == null? Amount.valueOf(0):stampDuty;
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

    public Amount getApplicationFee() {
        return applicationFee;
    }

    public void setApplicationFee(Amount applicationFee) {
        this.applicationFee = applicationFee;
    }

    public Amount getFirstMonthPayment() {
        return firstMonthPayment;
    }

    public void setFirstMonthPayment(Amount firstMonthPayment) {
        this.firstMonthPayment = firstMonthPayment;
    }
}
