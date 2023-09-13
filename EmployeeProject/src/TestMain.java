import java.time.LocalDate;

import version2.Employee;

public class TestMain {
    public static void main(String[] args) {
        Employee.Commission.Base julz=new Employee.Commission.Base(22102606 , "Julz", LocalDate.of(2003, 9, 24), LocalDate.now(), 400000,50000);
        julz.displayInfo();
    }
}
