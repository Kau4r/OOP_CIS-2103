package Clock;

public class MyTime {
    private int hours, mins, secs;
    private boolean meridian; // AM/PM

    public MyTime(int hours, int mins, int secs, boolean meridian) {
        this.hours = hours;
        this.mins = mins;
        this.secs = secs;
        this.meridian = meridian;
        uTime();
    }

    public int getHours() {
        return hours;
    }

    public int getMins() {
        return mins;
    }

    public int getSecs() {
        return secs;
    }

    public String isMeridian() {
        return meridian ? "AM" : "PM";
    }

    public void uTime() {
        if (this.secs >= 60) {
            this.mins += this.secs / 60;
            this.secs %= 60;
        }
        if (this.mins >= 60) {
            this.hours += this.mins / 60;
            this.mins %= 60;
        }
        if (this.hours > 12) {
            this.hours %= 12;
            this.meridian = !(meridian);
        }
    }

    public void advanceTime(int seconds) {
        this.secs += seconds;
        uTime();
    }

    public void tickBySecond() {
        this.secs++;
        uTime();
    }

    public void tickByMinute() {
        this.mins++;
        uTime();
    }

    public void tickByHour() {
        this.hours++;
        uTime();
    }

    public void displayTime12() {
        System.out.printf("%02d:%02d:%02d %s\n", getHours(), getMins(), getSecs(), isMeridian());
    }

    public void displayTime24() {
        int hourm = getHours() + (this.meridian ? 0 : 12);
        System.out.printf("%02d:%02d:%02d%n", hourm, getMins(), getSecs());
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d %s", getHours(), getMins(), getSecs(), isMeridian());
    }

}
