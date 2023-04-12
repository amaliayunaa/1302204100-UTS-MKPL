package lib;

public class TaxFunction {

	private static final int NonTaxableSingle = 54000000;
	private static final int NonTaxableMarried = NonTaxableSingle + 4500000;
	private static final int NonTaxableChild = 1500000;

	private static final double TaxRate = 0.05;

	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible,
			boolean isMarried, int numberOfChildren) {
		int tax = 0;

		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 month working per year");
		}

		numberOfChildren = Math.min(numberOfChildren, 3);

		int nonTaxableIncome = NonTaxableSingle;
		if (isMarried) {
			nonTaxableIncome = NonTaxableMarried;
		}
		nonTaxableIncome += numberOfChildren * NonTaxableChild;
		int taxableIncome = ((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible
				- nonTaxableIncome;
		if (taxableIncome > 0) {
			tax = (int) Math.round(TaxRate * taxableIncome);
		}

		return tax;

	}

}
