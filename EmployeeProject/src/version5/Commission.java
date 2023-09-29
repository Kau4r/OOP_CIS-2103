package version5;
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
        double com = 0.05;
        
        if (getTotalSales() >= 50_000 && getTotalSales() < 100_000 ) {
            com = 0.20;
        } else if (getTotalSales() < 500_000) {
            com = 0.30;
        } else {
            com = 0.50;
        }

        return getTotalSales() * com;
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