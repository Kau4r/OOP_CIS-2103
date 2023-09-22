package version3;

import java.time.LocalDate;

public class Commission extends Employee {
    private double totalSales;

    public Commission(int empID, Name empName, LocalDate empBirthDate, LocalDate empDateHired,
            double totalSales) {
        super(empID, empName, empBirthDate, empDateHired);
        this.totalSales = Math.max(totalSales, 0);
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = Math.max(totalSales, 0);
    }

    public double computeSalary() {
        double commission;

        if (getTotalSales() < 50_000) {
            commission = getTotalSales() * 0.05;
        } else if (getTotalSales() < 100_000) {
            commission = getTotalSales() * 0.20;
        } else if (getTotalSales() < 500_000) {
            commission = getTotalSales() * 0.30;
        } else {
            commission = getTotalSales() * 0.50;
        }
        return commission;

    }

    public void displayInfo() {
        System.out.println(this);
        System.out.printf("Salary: %.2f\n", computeSalary());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Total Sales: ").append(getTotalSales());
        return sb.toString();
    }
}