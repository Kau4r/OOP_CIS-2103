package version1;

import java.time.*;

public class BasePlusCommissionEmployee {
    private int empID;
    private String empName;
    private LocalDate empBirthDate, empDateHired;
    private double BaseSalary;
    private double totalSales;

    public BasePlusCommissionEmployee() {
    }

    public BasePlusCommissionEmployee(int empID, String empName, LocalDate empBirthDate, LocalDate empDateHired,
            double BaseSalary) {
        this.empID = empID;
        this.empName = empName;
        this.empBirthDate = empBirthDate;
        this.empDateHired = empDateHired;
        this.BaseSalary = Math.max(BaseSalary, 0);
    }

    public BasePlusCommissionEmployee(int empID, String empName, LocalDate empDateHired, LocalDate empBirthDate) {
        this.empID = empID;
        this.empName = empName;
        this.empBirthDate = empBirthDate;
        this.empDateHired = empDateHired;
        BaseSalary = 20000;
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

    public double getBaseSalary() {
        return BaseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        BaseSalary = Math.max(baseSalary, 0);
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = Math.max(totalSales, 0);
    }

    public double computeSalary() {
        double com = 0.05;

        if (getTotalSales() >= 50_000 && getTotalSales() < 100_000) {
            com = 0.20;
        } else if (getTotalSales() < 500_000) {
            com = 0.30;
        } else {
            com = 0.50;
        }

        return getTotalSales() * com + BaseSalary;
    }

    public void displayInfo() {
        System.out.println(this);
        System.out.printf("Salary: %.2f\n", computeSalary());
    }

    @Override
    public String toString() {
        return String.format(
                "Employee Name: %s\nEmployee ID: %d\nDate Hired: %s\nDate of Birth: %s\nBase Salary: %.2f \nTotal Sales: %.2f",
                getEmpName(), getEmpID(), getEmpDateHired(), getEmpBirthDate(), getBaseSalary(), getTotalSales());
    }

}
