package loan.atomic;

import com.google.common.base.Function;
import loan.domain.Worksheet;

import static loan.domain.FinancialCalculator.monthlyPayment;

public class MonthlyPaymentCalculation implements Function<Worksheet, Worksheet>{

    @Override
    public Worksheet apply(Worksheet worksheet) {

        worksheet.setMonthPayment(
               monthlyPayment(worksheet.getRate().doubleValue(), worksheet.getTerm()*12, worksheet.getPrincipal().doubleValue())
        );
        return worksheet; 
    }    
}
