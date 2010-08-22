package loan.atomic;

import com.google.common.base.Function;
import loan.domain.Worksheet;

public class FirstMonthPayment implements Function<Worksheet,Worksheet>{

    @Override
    public Worksheet apply(Worksheet worksheet) {
        worksheet.setFirstMonthPayment(
                worksheet.getMonthPayment().add(
                        worksheet.getStampDuty())

        );
        return worksheet; 
    }
}
