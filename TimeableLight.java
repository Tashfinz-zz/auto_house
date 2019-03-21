/**
 * Concrete subclass of Light that implements the interface Timeable 
 * (supplied with this assignment)
 * – please also see documentation in the interface itself.
 * 
 * @author (last-name), (first-name) (SRN number)
 */
public class TimeableLight extends Light implements Timeable
{
    /**
     * The time at which processing is taking place
     */
    private Time currentTime;

    /**
     * for use with switch on/of aspects
     */
    private Time startTime;
    private Time stopTime;

    /**
     * current time, start time and stop time set to null. 
     * Other parameters, as required by parent classes
     */
    public TimeableLight(int identifier, String name, int wattage, int type, int brightness)
    {
        super(identifier, name, wattage, type, brightness);
        currentTime = null;
        startTime = null;
        stopTime = null;
    }

    /**
     * sets the current time
     */
    public void setCurrentTime(Time currentTime)
    {
        this.currentTime = currentTime;
    }

    /**
     * sets start and stop time. 
     * Start time should be before stop time. 
     * (if not, then do not set the times)
     * 
     * @param startTime
     * @param stopTime
     */
    public void setTimes(Time startTime, Time stopTime)
    {
        // Start time should be before stop time
        if(startTime.isBefore(stopTime))
        {
            this.startTime = startTime;
            this.stopTime = stopTime;
        }
        // if not, then do not set the times
    }

    /**
     * Sets the start and stop times to null.
     * @param startTime
     * @param stopTime
     */
    public void unsetTimes(Time startTime, Time stopTime)
    {
        this.startTime = null;
        this.stopTime = null;
    }

    /**
     * Get the start time of this object
     * @return the start time
     */
    public Time getStartTime()
    {
        return startTime;
    }

    /**
     *
     * @return the stop time
     */
    public Time getStopTime()
    {
        return stopTime;
    }

    /**
     * Overrides switchOn in parent but only switches on if 
     * the currentTime is null or equals the startTime
     */
    public void switchOn()
    {
        // only when switch is off, it can be on
        if(status == false)
        {
            // if currentTime is null or equals the startTime
            // also check if startTime is not null before checking equality
            if(currentTime == null || 
            (startTime != null && currentTime.equals(startTime)) )
            {
                // call super class' method to check life and turn it on
                super.switchOn();
            }
        }
    }

    /**
     * Overrides switchOff in parent but only switches off 
     * if the currentTime is null or equals the stopTime
     */
    public void switchOff()
    {
        if(currentTime == null || 
        (stopTime != null && currentTime.equals(stopTime)) )
        {
            // call ElectricalAppliance's method to switch it off
            super.switchOff();
        }
    }

    /**
     * returns all details including current time, 
     * and should indicate that times are not set if they are null.
     */
    public String toString()
    {
        String text = "ID: " + getIdentifier() + ", " + getName() + 
            "\nWattage: " + getWattage();

        // displaying on/off for the status
        if(status == true)
        {
            text = text + "\nStatus: On";
        }
        else
        {
            text = text + "\nStatus: Off";
        }

        // 1 = LED,   2  = Halogen, 3 = Energy Saving
        if(getType() == 1)
        {
            text = text + "\nType: LED";
        }
        else if(getType() == 2)
        {
            text = text + "\nType: Halogen";
        }
        else if(getType() == 3)
        {
            text = text + "\nType: Energy Saving";
        }

        text = text + "\nBrightness: " + getBrightness() + "\nLife: " + getLife()
        + "\nFailureStatus: " + getFailureStatus();
        
        // additional text from TimableLight
        if(currentTime != null)
        {
            text = text + "\nCurrent: " + currentTime.getTime();
        }
        else
        {
            // indicate that times are not set
            text = text + "\nCurrent: Not Set";
        }

        if(startTime != null)
        {
            text = text + "\nStart: " + startTime.getTime();
        }
        else
        {
            text = text + "\nStart: Not Set";
        }

        if(stopTime != null)
        {
            text = text + "\nStop: " + stopTime.getTime();
        }
        else
        {
            text = text + "\nStop: Not Set";
        }
        return text;
    }
}