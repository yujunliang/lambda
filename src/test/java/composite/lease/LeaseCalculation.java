package composite.lease;

import algocraft.function.CaseFunction;
import functions.atomic.GetCountry;
import composite.Country;

import static composite.Country.*;

public class LeaseCalculation extends CaseFunction<Lease, Lease, Country> {
    public LeaseCalculation() {
        super(new GetCountry(),
                GD, new GondorLeaseCalculation(),
                NR, new NarniaLeaseCalculation(),
                WL, new WonderlandLeaseCalculation());
    }
}
