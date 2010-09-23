package loan.composite;

import algocraft.function.CaseFunction;
import loan.atomic.GetCountry;
import loan.domain.Country;
import loan.domain.Lease;

import static loan.domain.Country.*;

public class LeaseCalculation extends CaseFunction<Lease, Lease, Country> {
    public LeaseCalculation() {
        super(new GetCountry(),
                GD, new GondorLeaseCalculation(),
                NR, new NarniaLeaseCalculation(),
                WL, new WonderlandLeaseCalculation());
    }
}
