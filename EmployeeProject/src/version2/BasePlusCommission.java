package version2;

import java.time.LocalDate;

public class BasePlusCommission extends Commission {
    private double baseSalary;

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public BasePlusCommission(int empID, String empName, LocalDate empBirthDate, LocalDate empDateHired,
            double totalSales,
            double baseSalary) {
        super(empID, empName, empBirthDate, empDateHired, totalSales);
        this.baseSalary = baseSalary;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("Total Sales: %.2f\n", getTotalSales());
        System.out.printf("Base Salary: %.2f\n", getBaseSalary());
        System.out.printf("Salary: %.2f\n", computeSalary());
    }

    public double computeSalary() {
        return super.computeSalary() + getBaseSalary();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Total Sales: ").append(getTotalSales()).append("\n");
        sb.append("Base Sales: ").append(getBaseSalary()).append("\n");
        sb.append("Salary: ").append(String.format("%.2f", computeSalary())).append("\n");
        return sb.toString();
    }
}
