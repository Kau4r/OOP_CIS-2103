import version4.*;
import java.time.LocalDate;

public class TestMain {
        public static void main(String[] args) {
                EmployeeRoster roster = new EmployeeRoster();
                Hourly h1 = new Hourly(186, new Name("Isla", "Hjalmar"),
                                LocalDate.of(1768, 2, 6),
                                LocalDate.of(1964, 9, 2), 40, 412.0f);
                Piece p1 = new Piece(128,
                                Name.wPrefix(new Name("Oddo", "Peppi"), "Mrs."),
                                LocalDate.of(1852, 11, 23), LocalDate.of(2041, 6, 1), 100, 32);
                Commission c1 = new Commission(155, Name.wSuffix(new Name("Leontine", "Gabi"), "III"),
                                LocalDate.of(2014, 10, 13), LocalDate.of(2002, 9, 27), 50_000.0);
                BasePlusCommission b1 = new BasePlusCommission(135,
                                Name.wSuffixandPrefix(new Name("Soren", "Ruzica", "Madadaro"), "Atty.",
                                                "IIV"),
                                LocalDate.of(1995, 2, 10), LocalDate.of(1974, 11, 11), 50_000.0, 13_120.0);
                roster.addEmp(h1);
                roster.addEmp(p1);
                roster.addEmp(c1);
                roster.addEmp(b1);
                roster.displayAllEmp();
                roster.removeEmployee(155);
                roster.displayAllEmp();
                System.out.printf("Hourly employees: %d\n", roster.countHourlyEmp());
                System.out.printf("Piece worker employees: %d\n", roster.countPieceEmp());
                System.out.printf("Commission employees: %d\n", roster.countCommissionEmp());
                System.out.printf("Base plus commission employees: %d\n\n", roster.countBasePlusCommissionEmp());
                roster.displayEmpOfType("Hourly");
                roster.displayEmpOfType("Piece worker");
                roster.displayEmpOfType("Commission");
                roster.displayEmpOfType("Base plus commission");
                
                EmployeeRoster carlo=roster.searchEmp("18");
                carlo.displayAllEmp();
        }

}