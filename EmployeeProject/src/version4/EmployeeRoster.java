package version4;

public class EmployeeRoster {
    private Employee[] empList;
    private int count = 0;
    private int MAX = 10;

    public EmployeeRoster() {
        empList = new Employee[MAX];
    }

    public EmployeeRoster(int MAX) {
        this.MAX = MAX;
        this.empList = new Employee[MAX];
    }

    public int getCount() {
        return count;
    }

    public int getSize() {
        return MAX;
    }

    public void displayAllEmp() {
        System.out
                .println("|-----|------------------------------------------|--------------------|------------------|");
        System.out.printf("| %-3s | %-40s | %-19s| %-16s |\n", "ID", "Name", "Type", "Salary");
        System.out
                .println("|-----|------------------------------------------|--------------------|------------------|");
        int x;
        for (x = 0; x < count; x++) {

            if (empList[x] instanceof Hourly) {
                System.out.printf("| %-3d | %-40s | %-19s| PHP %-12.2f | \n", empList[x].getEmpID(),
                        empList[x].getEmpName(),
                        empList[x].getClass().getSimpleName(),
                        ((Hourly) empList[x]).computeSalary());
            } else if (empList[x] instanceof Piece) {
                System.out.printf("| %-3d | %-40s | %-19s| PHP %-12.2f | \n", empList[x].getEmpID(),
                        empList[x].getEmpName(),
                        empList[x].getClass().getSimpleName(),
                        ((Piece) empList[x]).computeSalary());
            } else if (empList[x] instanceof Commission) {
                System.out.printf("| %-3d | %-40s | %-19s| PHP %-12.2f | \n", empList[x].getEmpID(),
                        empList[x].getEmpName(),
                        empList[x].getClass().getSimpleName(),
                        ((Commission) empList[x]).computeSalary());
            } else {
                System.out.printf("| %-3d | %-40s | %-19s| PHP %-12.2f | \n", empList[x].getEmpID(),
                        empList[x].getEmpName(),
                        empList[x].getClass().getSimpleName(),
                        ((BasePlusCommission) empList[x]).computeSalary());
            }
        }
        System.out
                .println("|-----|------------------------------------------|--------------------|------------------|");
    }

    public void displayEmpOfType(String type) {
        Class<?> empType = switch (type.toUpperCase().charAt(0)) {
            case 'H' -> Hourly.class;
            case 'P' -> Piece.class;
            case 'C' -> Commission.class;
            case 'B' -> BasePlusCommission.class;
            default -> null;
        };

        int x;
        for (x = 0; x < count; x++) {
            if (empType.isInstance(empList[x])) {
                empList[x].displayInfo();
                System.out.println();
            }
        }

    }

    public EmployeeRoster searchEmp(String key) {
        EmployeeRoster retRoster = new EmployeeRoster();

        int x;
        for (x = 0; x < count; x++) {
            if (empList[x].toString().contains(key)) {
                retRoster.addEmp(empList[x]);
            }
        }
        return retRoster;
    }

    public boolean addEmp(Employee emp) {
        if (count < MAX) {
            empList[count] = emp;
            count++;
            System.out.println("Successfully Added Employee");
            return true;
        }
        System.out.println("ROSTER FULL!!!!");
        return false;
    }

    public boolean updateEmp(int empID, Employee emp) {
        int x;
        for (x = 0; x < count && empList[x].getEmpID() != empID; x++) {
        }
        if (x < count) {
            empList[x] = emp;
            System.out.println("Successfully Updated Employee");
        }
        return (x < count);
    }

    public Employee removeEmployee(int ID) {
        Employee rmEmp = null;
        int x;
        for (x = 0; x < count && empList[x].getEmpID() != ID; x++) {
        }
        if (x < count) {
            rmEmp = empList[x];
            for (; x < count; x++) {
                empList[x] = empList[x + 1];
            }
            count--;
            System.out.println("Successfully Removed Employee");
        }
        return rmEmp;
    }

    public int countHourlyEmp() {
        int empNo = 0;
        int x;
        for (x = 0; x < count; x++) {
            if (empList[x] instanceof Hourly) {
                empNo++;
            }
        }
        return empNo;
    }

    public int countPieceEmp() {
        int empNo = 0;
        int x;
        for (x = 0; x < count; x++) {
            if (empList[x] instanceof Piece) {
                empNo++;
            }
        }
        return empNo;
    }

    public int countCommissionEmp() {
        int empNo = 0;
        int x;
        for (x = 0; x < count; x++) {
            if (empList[x] instanceof Commission && !(empList[x] instanceof BasePlusCommission)) {
                empNo++;
            }
        }
        return empNo;
    }

    public int countBasePlusCommissionEmp() {
        int empNo = 0;
        int x;
        for (x = 0; x < count; x++) {
            if (empList[x] instanceof BasePlusCommission) {
                empNo++;
            }
        }
        return empNo;
    }

}