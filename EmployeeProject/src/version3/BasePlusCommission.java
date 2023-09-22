package version3;

import java.time.LocalDate;

public class BasePlusCommission extends Commission {
    private double baseSalary;

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public BasePlusCommission(int empID, Name empName, LocalDate empBirthDate, LocalDate empDateHired,
            double totalSales,
            double baseSalary) {
        super(empID, empName, empBirthDate, empDateHired, totalSales);
        this.baseSalary = baseSalary;
    }

    public double computeSalary() {
        return super.computeSalary() + getBaseSalary();
    }

    public void displayInfo() {
        System.out.println(this);
        System.out.printf("Salary: %.2f\n", computeSalary());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Total Sales: ").append(getTotalSales()).append("\n");
        sb.append("Base Sales: ").append(getBaseSalary());
        return sb.toString();
    }
}
