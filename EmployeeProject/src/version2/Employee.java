package version2;

import java.time.LocalDate;

public class Employee {
    private int empID;
    private String empName;
    private LocalDate empBirthDate, empDateHired;
}

public class Hourly extends Employee {
    private float totalHoursWorked;
    private float ratePerHour;
}

public class PieceWorker extends Employee {
    private int totalPiecesFinished;
    private float ratePerPiece;
}