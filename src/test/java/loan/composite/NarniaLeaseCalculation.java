package loan.composite;


import algocraft.function.CompositeFunction;
import loan.atomic.*;
import loan.domain.Lease;

import static algocraft.function.Functions.conditional;
import static com.google.common.base.Predicates.not;
import static loan.domain.Rate.valueOf;

public final class NarniaLeaseCalculation extends CompositeFunction<Lease, Lease> {

	public NarniaLeaseCalculation() {
        super(
              conditional(BorrowLoanApplicationFeePredicate.INSTANCE, new AddApplicationFeeToPrincipalCalculation()),
              MonthlyLeasePaymentCalculation.INSTANCE,
              conditional(not(new FirstTimeBuyerPredicate()), new StampDutyOnMonthlyPaymentCalculation(valueOf(0.03))),
              new FirstMonthPaymentCalculation(),
              conditional(not(BorrowLoanApplicationFeePredicate.INSTANCE), new AddApplicationFeeToFirstMonthPaymentCalculation())
        );
	}
}
