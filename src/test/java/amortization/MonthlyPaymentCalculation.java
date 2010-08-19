package amortization;

import com.google.common.base.Function;

import java.math.BigDecimal;

public class MonthlyPaymentCalculation implements Function<Worksheet,Worksheet>{

    @Override
    public Worksheet apply(Worksheet worksheet) {
        double v = Math.pow(worksheet.getRate().divide(new BigDecimal(100)).add(new BigDecimal(1)).doubleValue(), worksheet.getTerm());

        worksheet.setMonthPayment(
                worksheet.getPrincipal().multiply(new BigDecimal(v)).divide(new BigDecimal(v - 1)).doubleValue()
        );
        return worksheet; 
    }
}
