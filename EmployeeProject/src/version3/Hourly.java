package version3;

import java.time.LocalDate;

public class Hourly extends Employee {
    private float totalHoursWorked;
    private float ratePerHour;

    public Hourly(int empID, Name empName, LocalDate empBirthDate, LocalDate empDateHired, float totalHoursWorked,
            float ratePerHour) {
        super(empID, empName, empBirthDate, empDateHired);
        this.totalHoursWorked = Math.max(totalHoursWorked, 0);
        this.ratePerHour = ratePerHour;
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
        double overtime = (Math.max(getTotalHoursWorked(), 40) - 40) * ratePerHour * 1.5;
        double totalSalary = Math.min(getTotalHoursWorked(), 40) * ratePerHour + overtime;

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
        sb.append("Rate per hour: ").append(getRatePerHour()).append("\n");
        sb.append("Total Hours Worked: ").append(getTotalHoursWorked()).append(" hrs");
        return sb.toString();
    }

}
