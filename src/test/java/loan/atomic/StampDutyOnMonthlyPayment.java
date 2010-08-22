package loan.atomic;

import com.google.common.base.Function;
import loan.domain.Worksheet;

public class StampDutyOnMonthlyPayment implements Function<Worksheet,Worksheet>{

    @Override
    public Worksheet apply(Worksheet worksheet) {
        worksheet.setStampDuty(
                worksheet.getMonthPayment().doubleValue() * 0.03
        );
        return worksheet; 
    }
}
