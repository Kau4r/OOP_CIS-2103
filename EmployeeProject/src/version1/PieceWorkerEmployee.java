package version1;

import java.time.*;

public class PieceWorkerEmployee {
    private int empID;
    private String empName;
    private LocalDate empBirthDate;
    private LocalDate empDateHired;
    private int totalPiecesFinished;
    private float ratePerPiece;

    public PieceWorkerEmployee() {
    }

    public PieceWorkerEmployee(int empID, String empName, LocalDate empBirthDate, LocalDate empDateHired,
            int totalPiecesFinished,
            float ratePerPiece) {
        this.empID = empID;
        this.empName = empName;
        this.empBirthDate = empBirthDate;
        this.empDateHired = empDateHired;
        this.totalPiecesFinished = Math.max(totalPiecesFinished, 0);
        this.ratePerPiece = Math.max(ratePerPiece, 0);
    }

    public PieceWorkerEmployee(int empID, String empName, LocalDate empDateHired, LocalDate empBirthDate) {
        this.empID = empID;
        this.empName = empName;
        this.empDateHired = empDateHired;
        this.empBirthDate = empBirthDate;
        totalPiecesFinished = 50;
        ratePerPiece = 10.00f;
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

    public int getTotalPiecesFinished() {
        return Math.max(totalPiecesFinished, 0);
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public void setRatePerPiece(float ratePerPiece) {
        this.ratePerPiece = Math.max(ratePerPiece, 0);
    }

    public float getRatePerPiece() {
        return ratePerPiece;
    }

    public double computeSalary() {
        int bonus = totalPiecesFinished / 100;

        return totalPiecesFinished * ratePerPiece + bonus * 10 * ratePerPiece;
    }

    public void displayInfo() {
        System.out.println(this);
        System.out.printf("Salary: %.2f\n", computeSalary());
    }

    @Override
    public String toString() {
        return String.format(
                "Employee Name: %s\nEmployee ID: %d\nDate Hired: %s\nDate of Birth: %s\nRate per piece: %.2f\n Total pieces finished: %.2f hrs",
                getEmpName(), getEmpID(), getEmpDateHired(), getEmpBirthDate(), getRatePerPiece(),
                getTotalPiecesFinished());
    }

}
