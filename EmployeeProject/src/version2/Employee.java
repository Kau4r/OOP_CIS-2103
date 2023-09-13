package version2;

import java.time.LocalDate;

public class Employee {
    private int empID;
    private String empName;
    private LocalDate empBirthDate, empDateHired;

    public Employee(int empID, String empName, LocalDate empBirthDate, LocalDate empDateHired) {
        this.empID = empID;
        this.empName = empName;
        this.empBirthDate = empBirthDate;
        this.empDateHired = empDateHired;
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

    public void displayInfo() {
        System.out.printf("Employee Name: %s\n", getEmpName());
        System.out.printf("Employee ID: %d\n", getEmpID());
        System.out.printf("Date Hired: %s\n", getEmpDateHired());
        System.out.printf("Date of Birth: %s\n", getEmpBirthDate());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employee Name: ").append(getEmpName()).append("\n");
        sb.append("Employee ID: ").append(getEmpID()).append("\n");
        sb.append("Date Hired: ").append(getEmpDateHired()).append("\n");
        sb.append("Date of Birth: ").append(getEmpBirthDate()).append("\n");
        return sb.toString();
    }
}