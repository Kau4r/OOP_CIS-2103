
// import InnerClass.Employee.*;
// import InnerClass.Employee.Commission.Base;
// import version1.HourlyEmployee;
import java.time.LocalDate;
import version2.*;
// import version3.*;

public class TestMain {
        public static void main(String[] args) {
                Employee john = new Hourly(3, "Julz",LocalDate.now(),LocalDate.now(), 1, 1000);

                john.displayInfo();

        }
}
