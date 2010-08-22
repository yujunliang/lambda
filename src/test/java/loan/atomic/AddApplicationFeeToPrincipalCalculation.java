package loan.atomic;

import com.google.common.base.Function;
import loan.domain.Worksheet;

import java.math.BigDecimal;

public class AddApplicationFeeToPrincipalCalculation implements Function<Worksheet, Worksheet> {
    @Override
    public Worksheet apply(Worksheet worksheet) {
        worksheet.setPrincipal(worksheet.getPrincipal().add(worksheet.getApplicationFee()));
        return worksheet;
    }
}
