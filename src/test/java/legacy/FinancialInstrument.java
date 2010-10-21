package legacy;

import java.math.BigDecimal;

public abstract class FinancialInstrument {
    private BigDecimal principal;
    private int term;
    private BigDecimal rate;

    private BigDecimal monthPayment;
    private BigDecimal stampDuty;
    private String country;
    private boolean borrowLoanApplicationFee;
    private BigDecimal applicationFee;
    private BigDecimal firstMonthPayment;

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public void setRate(BigDecimal BigDecimal) {
        this.rate = BigDecimal;
    }

    public void setCountryCode(String countryCode) {
        this.country = countryCode;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public int getTerm() {
        return term;
    }

    public void setMonthPayment(BigDecimal monthPayment) {
        this.monthPayment = monthPayment;
    }

    public BigDecimal getMonthPayment() {
        return monthPayment;
    }

    public void setStampDuty(BigDecimal stampDuty) {
        this.stampDuty = stampDuty;
    }

    public BigDecimal getStampDuty() {
        return stampDuty;
    }

    public String getCountry() {
        return country;
    }

    public boolean isFinanceApplicationFee() {
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
