
/**
 * The interface Timeable specifies the minumum behaviour of a Timeable object.
 * @author A.Marczyk
 *
 */
public interface Timeable {

    /**
     * Sets the start and stop times.
     * @param startTime
     * @param stopTime
     */
    void setTimes(Time startTime, Time stopTime);

    /**
     * Sets the start and stop times to null.
     * @param startTime
     * @param stopTime
     */
    void unsetTimes(Time startTime, Time stopTime);

    /**
     * Get the start time of this object
     * @return the start time
     */
    Time getStartTime();

    /**
     *
     * @return the stop time
     */
    Time getStopTime();
}
