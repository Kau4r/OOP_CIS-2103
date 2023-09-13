package version1;

import java.time.*;

public class CommissionEmployee {
    private int empID;
    private String empName;
    private LocalDate empBirthDate, empDateHired;
    private double totalSales;

    public CommissionEmployee() {
    }

    public CommissionEmployee(int empID, String empName, LocalDate empBirthDate, LocalDate empDateHired,
            double totalSales) {
        this.empID = empID;
        this.empName = empName;
        this.empBirthDate = empBirthDate;
        this.empDateHired = empDateHired;
        this.totalSales = totalSales;
    }

    public CommissionEmployee(int empID, String empName, LocalDate empDateHired, LocalDate empBirthHired) {
        this.empID = empID;
        this.empName = empName;
        this.empDateHired = empDateHired;
        this.empBirthDate = empBirthHired;
        totalSales = 50000.00;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public LocalDate getEmpBirthDate() {
        return empBirthDate;
    }

    public void setEmpBirthDate(LocalDate empBirthDate) {
        this.empBirthDate = empBirthDate;
    }

    public LocalDate getEmpDateHired() {
        return empDateHired;
    }

    public void setEmpDateHired(LocalDate empDateHired) {
        this.empDateHired = empDateHired;
    }

    public double getTotalSales() {
        return Math.max(totalSales, 0);
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
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
        System.out.printf("Employee Name: %s\n", getEmpName());
        System.out.printf("Employee ID: %d\n", getEmpID());
        System.out.printf("Date Hired: %s\n", getEmpDateHired());
        System.out.printf("Date of Birth: %s\n", getEmpBirthDate());
        System.out.printf("Total Sales: %.2f\n", getTotalSales());
        System.out.printf("Salary: %.2f\n", computeSalary());
    }

    @Override
    public String toString() {
        return String.format(
                "Employee Name: %s\nEmployee ID: %d\nDate Hired: %s\nDate of Birth: %s\nTotal Sales: %.2f hrs\nSalary: %.2f\n",
                getEmpName(), getEmpID(), getEmpDateHired(), getEmpBirthDate(), getTotalSales(),
                computeSalary());
    }

}
