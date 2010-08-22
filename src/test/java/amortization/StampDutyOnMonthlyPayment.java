package amortization;

import com.google.common.base.Function;

public class StampDutyOnMonthlyPayment implements Function<Worksheet,Worksheet>{

    @Override
    public Worksheet apply(Worksheet worksheet) {
        worksheet.setStampDuty(
                worksheet.getMonthPayment().doubleValue() * 0.03
        );
        return worksheet; 
    }
}
