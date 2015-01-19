Compalgo
========

Compalgo is a lightweight framework helping you to split complex business
logic and rules into individual atomic functions and assemble them together
to any complexity level. It enables functional programming paradigm with
Object Oriented features from Java Programming Language. It has been
refactored to utilize the Function and Predicate from Google collections.
They used to be called Solution and Applicability.

Benefit
-------

So instead of writing code like this,

    if (lease.getCountry().equals("GD")) {

        double depreciationFee = (lease.getPrincipal().doubleValue() - lease.getResidualValue().doubleValue()) / (lease.getTerm() * 12);
        double financeFee = (lease.getPrincipal().doubleValue() + lease.getResidualValue().doubleValue()) * lease.getRate().doubleValue() / 100;


        lease.setMonthPayment(new BigDecimal(depreciationFee + financeFee).setScale(2, BigDecimal.ROUND_HALF_UP));
        lease.setStampDuty(
            lease.getMonthPayment().multiply(new BigDecimal(0.02)).setScale(2, BigDecimal.ROUND_HALF_UP)
        );
        lease.setFirstMonthPayment(
            lease.getMonthPayment().add(
                lease.getStampDuty()
            ).setScale(2, BigDecimal.ROUND_HALF_UP)

        );
    } else if (lease.getCountry().equals("NR")) {
        double depreciationFee = (lease.getPrincipal().doubleValue() - lease.getResidualValue().doubleValue()) / (lease.getTerm() * 12);
        double financeFee = (lease.getPrincipal().doubleValue() + lease.getResidualValue().doubleValue()) * lease.getRate().doubleValue() / 100;


        lease.setMonthPayment(new BigDecimal(depreciationFee + financeFee).setScale(2, BigDecimal.ROUND_HALF_UP));

        lease.setStampDuty(
            lease.getMonthPayment().multiply(new BigDecimal(0.03)).setScale(2, BigDecimal.ROUND_HALF_UP)
        );

        lease.setFirstMonthPayment(
            lease.getMonthPayment().add(
                lease.getStampDuty().setScale(2, BigDecimal.ROUND_HALF_UP)
            )
        );

        lease.setFirstMonthPayment(lease.getFirstMonthPayment().add(lease.getApplicationFee()));


    } else if (lease.getCountry().equals("WL")) {
        double depreciationFee = (lease.getPrincipal().doubleValue() - lease.getResidualValue().doubleValue()) / (lease.getTerm() * 12);
        double financeFee = (lease.getPrincipal().doubleValue() + lease.getResidualValue().doubleValue()) * lease.getRate().doubleValue() / 100;


        lease.setMonthPayment(new BigDecimal(depreciationFee + financeFee).setScale(2, BigDecimal.ROUND_HALF_UP));

        lease.setStampDuty(
            lease.getPrincipal().multiply(new BigDecimal(0.03)).setScale(2, BigDecimal.ROUND_HALF_UP)
        );
        lease.setFirstMonthPayment(
            lease.getMonthPayment().add(
                lease.getStampDuty()
            ).setScale(2, BigDecimal.ROUND_HALF_UP)

        );
    }

We write code like this, and you won't see any function composing,

    public class LeaseCalculation extends CaseFunction<Lease, Lease, Country> {
        public LeaseCalculation() {
            super(new GetCountry(),
                GD, new GondorLeaseCalculation(),
                NR, new NarniaLeaseCalculation(),
                WL, new WonderlandLeaseCalculation());
        }
    }


    public final class GondorLeaseCalculation extends CompositeFunction<Lease, Lease> {

        public GondorLeaseCalculation() {
            super(
                new SetMonthlyPayment<>(new MonthlyLeasePayment<>()),
                new SetStampDuty<>(new StampDutyOnMonthlyPayment<>(RATE_2)),
                new SetFirstMonthPayment<>(new SumMonthlyPaymentAndStampDuty<>())
            );
        }
    }

Example
-------

Please run LoanStory.java to test. The implementation is LoanCalculation.java.
LegacyLoanCalculation.java is an alternative solution without using the
framework.

The LoanStory.java demonstrates how to use Compalgo to solve the following
complex business problems.

    In Narnia, if the buyers borrow the application fee, the application fee
    will be added to the loan principal, otherwise it will be added to the
    first month payment; first time buyers don't pay stamp duty, other buyers
    pay stamp duty on the monthly payment at the rate is 3%.

    In Wonderland, the buyers pay stamp duty on the loan principal at the
    rate of 3% and it will be collected on the first month payment, together
    with the application fee.

    In Gondor, the buyers pay stamp duty on the monthly payment at the rate
    of 2%. The application fee will be added to the first month payment.

    The formula to calculate loan payment can be found here

            http://www.kbapps.com/finance.html

Note
----

When learning this framework, please pay more attention to how to wire
atomic functions into a complex function than how individual functions
work. The example of wiring can be found in GondorCalculation,
NarniaCalculation and WonderlandCalculation.


Exercise
--------

Now we need add functionality to support lease business, assume everything
remaining same but there is no first time buyer rule for lease business
and application fee need to be paid on first month payment. How to add the
new function? The formula to calculate lease payment can be found here

            http://www.leaseguide.com/lease08.htm

Solution
--------

The implementation is LeaseCalculation.java and please run LeaseStory.java to test.
