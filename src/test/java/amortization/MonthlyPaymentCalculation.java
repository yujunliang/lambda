package amortization;

import com.google.common.base.Function;

import java.math.BigDecimal;

import static amortization.FinancialCalculator.monthlyPayment;

public class MonthlyPaymentCalculation implements Function<Worksheet,Worksheet>{

    @Override
    public Worksheet apply(Worksheet worksheet) {

        worksheet.setMonthPayment(
               monthlyPayment(worksheet.getRate().doubleValue(), worksheet.getTerm()*12, worksheet.getPrincipal().doubleValue())
        );
        return worksheet; 
    }    
}
