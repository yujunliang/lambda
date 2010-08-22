package loan.atomic;

import com.google.common.base.Function;
import loan.domain.Worksheet;

import java.math.BigDecimal;

public class StampDutyOnMonthlyPayment implements Function<Worksheet,Worksheet>{

    private final BigDecimal rate;

    public StampDutyOnMonthlyPayment(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public Worksheet apply(Worksheet worksheet) {
        worksheet.setStampDuty(
                worksheet.getMonthPayment().doubleValue() * rate.doubleValue()
        );
        return worksheet; 
    }
}
