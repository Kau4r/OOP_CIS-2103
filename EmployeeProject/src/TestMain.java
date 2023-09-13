import java.time.LocalDate;

import version2.Employee;

public class TestMain {
    public static void main(String[] args) {
        Employee.Commission julz=new Employee.Commission(22102606 , "Julz", LocalDate.of(2003, 9, 24), LocalDate.now(), 400000);
        julz.displayInfo();
    }
}
