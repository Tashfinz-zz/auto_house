/**
 * Abstract class representing an electrical appliance in a house.
 * 
 * @author (last-name), (first-name) (SRN number)
 */
public abstract class ElectricalAppliance
{
    /**
     * An identifier for any appliance
     * – set in the constructor and thereafter immutable.
     * In a real life system this would be a unique identifier.
     */
    private int identifier;
    
    /**
     * String identifying the appliance so that a householder would know 
     * what it is (eg “Front Outside Light”)
     * - once set this cannot be changed. 
     */
    private String name;
    
    /**
     * The power rating – in watts (500, 40, etc).
     * Set in constructor and cannot be changed.
     */
    private int wattage;
    
    /**
     * Is it switched off or on? On creation an appliance should be off
     */
    protected boolean status;
    
    /**
     * Initialises fields from parameter values, or to defaults
     */
    public ElectricalAppliance(int identifier, String name, int wattage)
    {
        this.identifier = identifier;
        this.name = name;
        this.wattage = wattage;
        // on creation, it should be off
        status = false;
    }
    
    public void setStatus(boolean status)
    {
        this.status = status;
    }
    
    public int getIdentifier()
    {
        return identifier;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getWattage()
    {
        return wattage;
    }
    
    public boolean getStatus()
    {
        return status;
    }
    
    /**
     * Change to on status
     */
    public void switchOn()
    {
        status = true;
    }
    
    /**
     * Change to off status
     */
    public void switchOff()
    {
        status = false;
    }
    
    /**
     * Overidden version of toString()
     * – should return all object information and be neatly formatted.
     */
    public String toString()
    {
        String text = "ID: " + identifier + ", " + name + 
        "\nWattage: " + wattage;
        
        // displaying on/off for the status
        if(status == true)
        {
            text = text + "\nStatus: On";
        }
        else
        {
            text = text + "\nStatus: Off";
        }
        return text;
    }
}
