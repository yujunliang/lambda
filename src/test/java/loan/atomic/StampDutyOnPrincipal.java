package loan.atomic;

import com.google.common.base.Function;
import loan.domain.Worksheet;

public class StampDutyOnPrincipal implements Function<Worksheet,Worksheet>{

    @Override
    public Worksheet apply(Worksheet worksheet) {
        worksheet.setStampDuty(
                worksheet.getPrincipal().doubleValue() * 0.03
        );
        return worksheet; 
    }
}
