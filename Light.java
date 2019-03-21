/**
 * Concrete subclass of Electrical Appliance
 * 
 * @author (last-name), (first-name) (SRN number)
 */
public class Light extends ElectricalAppliance
{
    /**
     * Lights are one of 3 types (defined by an int): 
     * 1 = LED,   2  = Halogen, 3 = Energy Saving
     */
    private int type;

    /**
     * Specifies the brightness in lumens (int) e.g. 100 (lumens)
     */
    private int brightness;

    /**
     * The life in hours should be in the thousands.  
     * However, to simplify testing set LED to 3, 
     * Halogen to 5, Energy Saving to  7.
     */
    private int life;

    /**
     * Initially set to "life in". When lights are switch on their life 
     * is decreased by one.  When the life gets to zero the light fails.  
     * A failed light should not switch on.
     */
    private boolean failureStatus;

    public Light(int identifier, String name, int wattage, int type, int brightness)
    {
        // assigned to the super class
        super(identifier, name, wattage);

        // assigned to this object
        this.type = type;
        this.brightness = brightness;

        // set life according to the type
        if(type == 1)
        {
            // set LED to 3
            this.life = 3;
        }
        else if(type == 2)
        {
            // Halogen to 5
            this.life = 5;
        }
        else if(type == 3)
        {
            // Saving to 7
            this.life = 7;
        }

        // update to false when the parameter "life" is zero
        if(life <= 0)
        {
            failureStatus = true;
        }
        else
        {
            failureStatus = false;
        }
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public void setBrightness(int brightness)
    {
        this.brightness = brightness;
    }

    public void setLife(int life)
    {
        this.life = life;
        // update failure according to life
        if(life <= 0)
        {
            failureStatus = true;
        }
        else
        {
            failureStatus = false;
        }
    }

    public int getType()
    {
        return type;
    }

    public int getBrightness()
    {
        return brightness;
    }

    public int getLife()
    {
        return life;
    }

    public boolean getFailureStatus()
    {
        return failureStatus;
    }

    /**
     * Method which overrides method in ElectricalAppliance 
     * to include updates to “life in hours”
     */
    public void switchOn()
    {
        // only when the switch is off, it can then be on
        if(status == false)
        {
            // if it has at least 1 life, it can be on
            if(life > 0)
            {
                // when lights are switch on, their life is decreased by one.
                life--;
                // if life is 0, failureStatus will be true
                if(life <= 0)
                {
                    failureStatus = true;
                }
                else
                {
                    failureStatus = false;
                }
                // ElectricalAppliance is this superclass.
                // call the super class' method to do switching on part
                super.switchOn();
            }
        }
    }

    /**
     * return the details as a String. 
     * The type should be shown as a String   (not as an int)
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

        // additional text from Light
        // 1 = LED,   2  = Halogen, 3 = Energy Saving
        if(type == 1)
        {
            text = text + "\nType: LED";
        }
        else if(type == 2)
        {
            text = text + "\nType: Halogen";
        }
        else if(type == 3)
        {
            text = text + "\nType: Energy Saving";
        }

        text = text + "\nBrightness: " + brightness + "\nLife: " + life
        + "\nFailureStatus: " + failureStatus;
        // return the entire text
        return text;
    }
}
