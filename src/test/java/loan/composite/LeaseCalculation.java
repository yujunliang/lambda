package loan.composite;

import algocraft.function.CaseFunction;
import com.google.common.base.Function;
import loan.atomic.GetCountry;
import loan.domain.Country;
import loan.domain.Lease;

import static loan.domain.Country.GD;
import static loan.domain.Country.NR;
import static loan.domain.Country.WL;

public class LeaseCalculation extends CaseFunction<Lease, Lease, Country> {
    public LeaseCalculation() {
        super(new GetCountry(),
                GD, new GondorLeaseCalculation(),
                NR, new NarniaLeaseCalculation(),
                WL, new WonderlandLeaseCalculation());
    }
}
