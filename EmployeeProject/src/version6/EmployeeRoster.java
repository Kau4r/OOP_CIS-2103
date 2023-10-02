package version6;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;

public class EmployeeRoster {
    LinkedList<Employee> empRoster;

    public EmployeeRoster() {
        empRoster = new LinkedList<>();
    }

    public EmployeeRoster(Employee[] empList){ 
        empRoster.addAll(Arrays.asList(empList));
    }

    public void displayAllEmp() {
        System.out
                .println("|-----|------------------------------------------|--------------------|------------------|");
        System.out.printf("| %-3s | %-40s | %-19s| %-16s |\n", "ID", "Name", "Type", "Salary");
        System.out
                .println("|-----|------------------------------------------|--------------------|------------------|");
        for (Employee emp : empRoster) {
            System.out.printf("| %-3d | %-40s | %-19s| PHP %-12.2f | \n", emp.getEmpID(),
                    emp.getEmpName(),
                    emp.getClass().getSimpleName(),
                    emp.computeSalary());
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

        for (Employee emp : empRoster) {
            if (empType.isInstance(emp)) {
                emp.displayInfo();
                System.out.println();
            }
        }

    }

    public EmployeeRoster searchEmp(String key) {
        EmployeeRoster empList = new EmployeeRoster();

        empRoster.stream()
                .filter(emp -> emp.toString().contains(key))
                .forEach(empList::addEmp);

        return empList;
    }

    public boolean addEmp(Employee emp) {
        return empRoster.add(emp);
    }

    public boolean updateEmp(int empID, Employee emp) {
        Optional<Employee> Exist = empRoster.stream()
                .filter(e -> e.getEmpID() == empID)
                .findFirst();

        if (Exist.isPresent()) {
            empRoster.set(empRoster.indexOf(Exist.get()), emp);
            System.out.println("Successfully Updated Employee");
        }

        return Exist.isPresent();
    }

    public Employee removeEmployee(int ID) {
        return empRoster.removeIf(emp -> emp.getEmpID() == ID)
                ? empRoster.stream().filter(emp -> emp.getEmpID() == ID).findFirst().orElse(null)
                : null;
    }

    public int countHourlyEmp() {
        return (int) empRoster.stream()
                .filter(emp -> emp instanceof Hourly)
                .count();
    }

    public int countPieceEmp() {
        return (int) empRoster.stream()
                .filter(emp -> emp instanceof Piece)
                .count();
    }

    public int countCommissionEmp() {
        return (int) empRoster.stream()
                .filter(emp -> emp instanceof Commission && !(emp instanceof BasePlusCommission))
                .count();
    }

    public int countBasePlusCommissionEmp() {
        return (int) empRoster.stream()
                .filter(emp -> emp instanceof BasePlusCommission)
                .count();
    }
}