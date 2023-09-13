package InnerClass;


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

    public static class Hourly extends Employee {
        private float totalHoursWorked;
        private float ratePerHour;

        public Hourly(int empID, String empName, LocalDate empBirthDate, LocalDate empDateHired, float totalHoursWorked,
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
            double overtime = (getTotalHoursWorked() - 40) * ratePerHour * 1.5;
            double totalSalary = Math.min(getTotalHoursWorked(), 40) * ratePerHour + overtime;

            return totalSalary;
        }

        public void displayInfo() {
            super.displayInfo();
            System.out.printf("Rate per hour: %.2f\n", getRatePerHour());
            System.out.printf("Total Hours Worked: %.2f hrs\n", getTotalHoursWorked());
            System.out.printf("Salary: %.2f\n", computeSalary());
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append("Rate per hour: ").append(getRatePerHour()).append("\n");
            sb.append("Total Hours Worked: ").append(getTotalHoursWorked()).append(" hrs").append("\n");
            sb.append("Salary: ").append(String.format("%.2f", computeSalary())).append("\n");
            return sb.toString();
        }

    }

    public static class Piece extends Employee {
        private int totalPiecesFinished;
        private float ratePerPiece;

        public Piece(int empID, String empName, LocalDate empBirthDate, LocalDate empDateHired, int totalPiecesFinished,
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
            super.displayInfo();
            System.out.printf("Rate per piece: %.2f\n", getRatePerPiece());
            System.out.printf("Total piece finished: %d\n", getTotalPiecesFinished());
            System.out.printf("Salary: %.2f\n", computeSalary());
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append("Rate per piece: ").append(getRatePerPiece()).append("\n");
            sb.append("Total piece finished: ").append(getTotalPiecesFinished()).append("\n");
            sb.append("Salary: ").append(String.format("%.2f", computeSalary())).append("\n");
            return sb.toString();
        }
    }

    public static class Commission extends Employee {
        private double totalSales;

        public Commission(int empID, String empName, LocalDate empBirthDate, LocalDate empDateHired,
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
            super.displayInfo();
            System.out.printf("Total Sales: %.2f\n", getTotalSales());
            System.out.printf("Salary: %.2f\n", computeSalary());
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append("Total Sales: ").append(getTotalSales()).append("\n");
            sb.append("Salary: ").append(String.format("%.2f", computeSalary())).append("\n");
            return sb.toString();
        }

        public static class Base extends Commission {
            private double baseSalary;

            public double getBaseSalary() {
                return baseSalary;
            }

            public void setBaseSalary(double baseSalary) {
                this.baseSalary = baseSalary;
            }

            public Base(int empID, String empName, LocalDate empBirthDate, LocalDate empDateHired, double totalSales,
                    double baseSalary) {
                super(empID, empName, empBirthDate, empDateHired, totalSales);
                this.baseSalary = baseSalary;
            }

            @Override
            public void displayInfo() {
                super.displayInfo();
                System.out.printf("Total Sales: %.2f\n", getTotalSales());
                System.out.printf("Base Salary: %.2f\n", getBaseSalary());
                System.out.printf("Salary: %.2f\n", computeSalary());
            }

            public double computeSalary() {
                return super.computeSalary() + getBaseSalary();
            }

            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(super.toString());
                sb.append("Total Sales: ").append(getTotalSales()).append("\n");
                sb.append("Base Sales: ").append(getBaseSalary()).append("\n");
                sb.append("Salary: ").append(String.format("%.2f", computeSalary())).append("\n");
                return sb.toString();
            }
        }
    }
}