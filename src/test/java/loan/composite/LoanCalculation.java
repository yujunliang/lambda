package loan.composite;

import com.google.common.base.Function;
import loan.domain.Country;
import loan.domain.Worksheet;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

public class LoanCalculation implements Function<Worksheet, Worksheet> {
    private static final Map<Country, Function<Worksheet, Worksheet>> functions = init();

    private static Map<Country, Function<Worksheet, Worksheet>> init() {
        Map<Country, Function<Worksheet, Worksheet>> functions = newHashMap();
        functions.put(Country.NR, new NarniaCalculation());
        functions.put(Country.WL, new WonderlandCalculation());
        return functions;
    }

    @Override
    public Worksheet apply(Worksheet worksheet) {
        return functions.get(worksheet.getCountry()).apply(worksheet);
    }
}
