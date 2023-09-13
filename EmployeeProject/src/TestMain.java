import java.time.LocalDate;

import InnerClass.Employee.*;
import InnerClass.Employee.Commission.Base;

public class TestMain {
    public static void main(String[] args) {
        Base julz = new Base(22102606, "Julz", LocalDate.of(2003, 9, 24), LocalDate.now(), 400000, 50000);
        julz.displayInfo();

        System.out.println("\n\n\n");
        //
        Piece juan = new Piece(22102606, "Juan", LocalDate.of(2003, 9, 24), LocalDate.now(), 50, 20);
        juan.displayInfo();

    }
}
