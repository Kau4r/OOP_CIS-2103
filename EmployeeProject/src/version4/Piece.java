package version4;
import java.time.LocalDate;
public class Piece extends Employee {
    private int totalPiecesFinished;
    private float ratePerPiece;

    public Piece(int empID, Name empName, LocalDate empBirthDate, LocalDate empDateHired, int totalPiecesFinished,
            float ratePerPiece) {
        super(empID, empName, empBirthDate, empDateHired);
        this.totalPiecesFinished = Math.max(totalPiecesFinished, 0);
        this.ratePerPiece = ratePerPiece;
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = Math.max(totalPiecesFinished, 0);
    }

    public float getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(float ratePerPiece) {
        this.ratePerPiece = ratePerPiece;
    }

    public double computeSalary() {
        int bonus = (getTotalPiecesFinished() > 100)
                ? (int) ((Math.round(getTotalPiecesFinished()) / 100) * (10 * ratePerPiece))
                : 0;

        double totalSalary = (getTotalPiecesFinished() * ratePerPiece) + bonus;

        return totalSalary;
    }

    public void displayInfo() {
        System.out.println(this);
        System.out.printf("Salary: %.2f\n", computeSalary());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Rate per piece: ").append(getRatePerPiece()).append("\n");
        sb.append("Total piece finished: ").append(getTotalPiecesFinished());
        return sb.toString();
    }
}
