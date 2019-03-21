/** 
 * Simple Time class.  This is a very simple class and could  
 * not in any way be used for real dates and times.
 * The assumption is that times referred to in methods 
 * isBefore() and equals()fall within 00.00 and 23.59 and
 * do not cross the day boundary at midnight
 * 
 * @author A.Marczyk
 */
public class Time{
    private int hour;
    private int minute;

    /**
     *Construct new Time with hour and minutes as int.  Note that this class is very basic 
     * and does not check for "impossible" times 
     */
    public Time (int hour, int minute){

        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public boolean isBefore(Time b){
        if (this.hour > b.hour){
            return false;
        }
        else {
            if (this.minute >= b.minute){
                return false;
            }
            return true;
        }
    }

    public boolean equals(Time b)
    {
        if (this.hour == b.hour && this.minute == b.minute) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     *Get this date as a String in the format: d-m-y
     */
    public String getTime(){
        return getDisplayValue(hour)+":"+getDisplayValue(minute);
    }

    public String toString (){
        return getTime();

    }

    private String getDisplayValue(int value)
    {
        if(value < 10) {
            return "0" + value;
        }
        else {
            return "" + value;
        }

    }
}
