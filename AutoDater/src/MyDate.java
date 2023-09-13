import java.time.*;

public class MyDate {
    private LocalDate vDate;

    public MyDate(int year,int month,int day) {
        this.vDate=LocalDate.of(year,month,day);
    }

    public MyDate(int month, int day) {
        this(LocalDate.now().getYear(), month, day);
    }

    public MyDate(int day) {
        this(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), day);
    }

    public MyDate() {
        this.vDate=LocalDate.now();
    }


}
