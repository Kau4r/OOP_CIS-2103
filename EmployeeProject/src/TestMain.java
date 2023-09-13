import java.time.LocalDate;

import version1.*;

public class TestMain {
    public static void main(String[] args) {
        CommissionEmployee Julz = new CommissionEmployee(22102066, "Julz", LocalDate.now(), LocalDate.of(2003, 9, 24));
        Julz.displayInfo();
    }
}
