package loan.atomic;

import com.google.common.base.Function;
import loan.domain.Worksheet;

public class AddApplicationFeeToFirstMonthPaymentCalculation implements Function<Worksheet, Worksheet> {
    @Override
    public Worksheet apply(Worksheet worksheet) {
        worksheet.setFirstMonthPayment(worksheet.getFirstMonthPayment().add(worksheet.getApplicationFee()));
        return worksheet;
    }
}
