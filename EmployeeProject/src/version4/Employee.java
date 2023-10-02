package version4;
import java.time.LocalDate;
public class Employee {
    private int empID;
    private Name empName;
    private LocalDate empBirthDate;
    private LocalDate empDateHired;

    public Employee(int empID, Name empName, LocalDate empBirthDate, LocalDate empDateHired) {
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

    public Name getEmpName() {
        return empName;
    }

    public void setEmpName(Name empName) {
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
        System.out.println(this);
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
