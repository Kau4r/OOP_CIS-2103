package Execute;

import Clock.MyTime;

public class MyTimemain {
    public static void main(String[] args) {
        MyTime newTime=new MyTime(12,59,59,true); 
        newTime.displayTime12();
        newTime.displayTime24();
        newTime.tickByHour();
        newTime.displayTime12();
        newTime.tickByMinute();
        newTime.displayTime12();       
        newTime.tickBySecond();
        newTime.displayTime12();
        newTime.displayTime24();
    }
}   