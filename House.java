import java.util.ArrayList;
/**
 * Should be calling methods already written
 *
 * @author (last-name), (first-name) (SRN number)
 */
public class House
{
    /**
     * String, set in constructor
     * – (can be just a number, street name and post code)
     */
    private String address;

    /**
     * A collection of Electrical Appliances
     * – you decide exactly how best to store these.  
     */
    private ArrayList<ElectricalAppliance> houseAppliances;

    public House(String address)
    {
        this.address = address;
        // assign empty list of ElectricalAppliance
        houseAppliances = new ArrayList<ElectricalAppliance>();
    }   
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    /**
     * Get houseAppliances
     */
    public ArrayList<ElectricalAppliance> getHouseAppliances()
    {
        return houseAppliances;
    }
    
    /**
     * Add appliance to the House
     */
    public void addAppliance(ElectricalAppliance appliance)
    {
        houseAppliances.add(appliance);
    }

    /**
     * Find an appliance using its identifier.  
     * Returns the appliance if found or null.
     */
    public ElectricalAppliance findApplianceByID(int id)
    {
        for(int i = 0; i < houseAppliances.size(); i++)
        {
            // store each appliance from houseAppliances
            ElectricalAppliance eachAppliance = houseAppliances.get(i);
            // check each appliance's id
            if(eachAppliance.getIdentifier() == id)
            {
                // return when matched
                return eachAppliance;
            }
        }
        // finish the for loop and if not found, return null
        return null;
    }

    /**
     * Should return the appliance(s) if found or null.  
     * If there is more than one appliance with the same name 
     * (for example more than one living room light)
     * then they should all be returned. 
     * You need to decide the best way of doing this.
     */
    public ArrayList<ElectricalAppliance> findApplianceByName(String name)
    {
        ArrayList<ElectricalAppliance> matchedAppliances = 
            new ArrayList<ElectricalAppliance>();
        for(int i = 0; i < houseAppliances.size(); i++)
        {
            ElectricalAppliance eachAppliance = houseAppliances.get(i);
            // if it is the same name
            if(eachAppliance.getName().equals(name))
            {
                // store this appliance into matchedAppliances list
                matchedAppliances.add(eachAppliance);
            }
        }
        // if matchedAppliances is empty
        if(matchedAppliances.size() == 0)
        {
            // don't return the list, but return null
            return null;
        }
        else
        {
            // return matched list
            return matchedAppliances;
        }
    }
    
    /**
     * Remove an item from the house (by appliance code).  
     */
    public void removeAppliance(int id)
    {
        for(int i = 0; i < houseAppliances.size(); i++)
        {
            ElectricalAppliance eachAppliance = houseAppliances.get(i);
            if(eachAppliance.getIdentifier() == id)
            {
                houseAppliances.remove(i);
                // houseAppliances.remove(i) decreased the list size by 1
                // decreased the i by 1
                i--;
            }
        }
    }
    
    /**
     * All electrical items can be turned off by calling one method
     */
    public void turnOffAllAppliances()
    {
        for(int i = 0; i < houseAppliances.size(); i++)
        {
            ElectricalAppliance eachAppliance = houseAppliances.get(i);
            eachAppliance.switchOff();
        }
    }
    
    /**
     * Turn on a single appliance using the appliance code.
     */
    public void turnOnASingleAppliance(int id)
    {
        for(int i = 0; i < houseAppliances.size(); i++)
        {
            ElectricalAppliance eachAppliance = houseAppliances.get(i);
            if(eachAppliance.getIdentifier() == id)
            {
                eachAppliance.switchOn();
            }
        }
    }
    
    /**
     * Turn off a single appliance using the appliance code.
     */
    public void turnOffASingleAppliance(int id)
    {
        for(int i = 0; i < houseAppliances.size(); i++)
        {
            ElectricalAppliance eachAppliance = houseAppliances.get(i);
            if(eachAppliance.getIdentifier() == id)
            {
                eachAppliance.switchOff();
            }
        }
    }
    
    /**
     * All lights can be switched on 
     */
    public void turnAllLightsOn()
    {
        for(int i = 0; i < houseAppliances.size(); i++)
        {
            ElectricalAppliance eachAppliance = houseAppliances.get(i);
            eachAppliance.switchOn();
        }
    }
    
    /**
     * All lights can be switched off 
     */
    public void turnAllLightsOff()
    {
        for(int i = 0; i < houseAppliances.size(); i++)
        {
            ElectricalAppliance eachAppliance = houseAppliances.get(i);
            eachAppliance.switchOff();
        }
    }
    
    /**
     * Set all timeable lights the same on and off times 
     * (the times should be passed to the method)
     */
    public void setTimeableLight(int times)
    {
        for(int i = 0; i < houseAppliances.size(); i++)
        {
            // pick each electrical appliance
            ElectricalAppliance ea = houseAppliances.get(i);
            // check if this appliance is a TimeableLight object
            if(ea instanceof TimeableLight)
            {
                // cast it to be a TimeableLight object
                TimeableLight timeableLight = (TimeableLight) ea;
                // turn it on and off "times" times, ex. 2 times
                for(int time = 0; time < times; time++)
                {
                    timeableLight.switchOn();
                    timeableLight.switchOff();
                }
            }
        }
    }
    
    /**
     * should return a String showing the house address,
     * and listing all appliances and showing their details 
     */
    public String toString()
    {
        String text = "House Address: " + address + "\n";
        for(int i = 0; i < houseAppliances.size(); i++)
        {
            ElectricalAppliance eachAppliance = houseAppliances.get(i);
            text = text + eachAppliance.toString() + "\n";
        }
        return text;
    }
}