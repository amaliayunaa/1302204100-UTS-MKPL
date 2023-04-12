package lib;

import java.time.LocalDate;

public class Employee {
	private enum Gender {
		Male,
		Female
	}

	private LocalDate DateJoined;
	private int monthWorkingInYear;

	private boolean isForeigner;
	private Gender gender;

	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;
	private Family_Employee family_Employee;
	private InformationOfEmployee info;

	public Employee(boolean isForeigner, Gender gender, Family_Employee family_Employee, InformationOfEmployee info,
			LocalDate DateJoined) {

		this.isForeigner = isForeigner;
		this.gender = gender;
		this.family_Employee = family_Employee;
		this.info = info;

	}

	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya
	 * (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3:
	 * 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */

	public void setMonthlySalary(int grade) {
		if (grade == 1) {
			monthlySalary = 3000000;
			if (isForeigner) {
				monthlySalary = (int) (3000000 * 1.5);
			}
		} else if (grade == 2) {
			monthlySalary = 5000000;
			if (isForeigner) {
				monthlySalary = (int) (3000000 * 1.5);
			}
		} else if (grade == 3) {
			monthlySalary = 7000000;
			if (isForeigner) {
				monthlySalary = (int) (3000000 * 1.5);
			}
		}
	}

	public void setAnnualDeductible(int deductible) {
		this.annualDeductible = deductible;
	}

	public void setAdditionalIncome(int income) {
		this.otherMonthlyIncome = income;
	}

	public int getAnnualIncomeTax() {

		// Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah
		// bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate date = LocalDate.now();

		if (date.getYear() == DateJoined.getYear()) {
			monthWorkingInYear = date.getMonthValue() - DateJoined.getMonthValue();
		} else {
			monthWorkingInYear = 12;
		}
		String spouseIdNumber = family_Employee.getSpouseIdNumber();
		int numOfChild = family_Employee.getChildIdNumbers().size();
		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible,
				spouseIdNumber.equals(""), numOfChild);
	}
}
