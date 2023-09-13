package version1;

import java.time.*;

public class HourlyEmployee {
    private int empID;
    private String empName;
    private LocalDate empBirthDate, empDateHired;
    private float totalHoursWorked;
    private float ratePerHour;

    public HourlyEmployee() {
    }

    public HourlyEmployee(int empID, String empName, LocalDate empBirthDate, LocalDate empDateHired,
            float totalHoursWorked,
            float ratePerHour) {
        this.empID = empID;
        this.empName = empName;
        this.empBirthDate = empBirthDate;
        this.empDateHired = empDateHired;
        this.totalHoursWorked = Math.max(totalHoursWorked, 0);
        this.ratePerHour = ratePerHour;
    }

    public HourlyEmployee(int empID, String empName, LocalDate empDateHired, LocalDate empBirthHired) {
        this.empID = empID;
        this.empName = empName;
        this.empDateHired = empDateHired;
        this.empBirthDate = empBirthHired;
        totalHoursWorked = 50.00f;
        ratePerHour = 300.00f;
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

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = Math.max(totalHoursWorked, 0);
    }

    public float getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(float ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    public double computeSalary() {
        double overtime=(getTotalHoursWorked() - 40) * ratePerHour * 1.5;
        double totalSalary= Math.min(getTotalHoursWorked(),40) * ratePerHour + overtime;

        return totalSalary;
    }

    public void displayInfo() {
        System.out.printf("Employee Name: %s\n", getEmpName());
        System.out.printf("Employee ID: %d\n", getEmpID());
        System.out.printf("Date Hired: %s\n", getEmpDateHired());
        System.out.printf("Date of Birth: %s\n", getEmpBirthDate());
        System.out.printf("Rate per hour: %.2f\n", getRatePerHour());
        System.out.printf("Total Hours Worked: %.2f hrs\n", getTotalHoursWorked());
        System.out.printf("Salary: %.2f\n", computeSalary());
    }

    @Override
    public String toString() {
        return String.format(
                "Employee Name: %s\nEmployee ID: %d\nDate Hired: %s\nDate of Birth: %s\nRate per hour: %.2f\nTotal Hours Worked: %.2f hrs\nSalary: %.2f\n",
                getEmpName(), getEmpID(), getEmpDateHired(), getEmpBirthDate(), getRatePerHour(), getTotalHoursWorked(),
                computeSalary());
    }

}
