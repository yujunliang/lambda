package amortization;

import com.google.common.base.Function;

public class StampDutyCalculation implements Function<Worksheet,Worksheet>{

    @Override
    public Worksheet apply(Worksheet worksheet) {
        return worksheet; 
    }
}
