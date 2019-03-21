import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * This is a simple GUI that allows 
 * a User to administer a House and its appliances
 *
 * @author (last-name), (first-name) (SRN number)
 */
public class HouseGUI
{
    /**
     * a House variable
     */
    private House myHouse;

    private JFrame jframe;
    private JButton option1;
    private JButton option2;
    private JButton option3;
    private JPanel centerPanel;

    public HouseGUI()
    {
        setupHouse();
        jframe = new JFrame(myHouse.getAddress());

        option1 = new JButton("Turn on a single appliance");
        option1.addActionListener(new Option1Listener());
        option2 = new JButton("Switch on all lights");
        option2.addActionListener(new Option2Listener());
        option3 = new JButton("Set a Timeable light with on/off times");
        option3.addActionListener(new Option3Listener());

        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.add(option1);
        panel.add(option2);
        panel.add(option3);
        jframe.add(panel, BorderLayout.NORTH);

        // List 8 appliances into 2 x 4 grid
        centerPanel = new JPanel(new GridLayout(2, 4));
        updateHouseAppliances();

        jframe.setSize(800, 600);
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }

    /**
     * "This is for testing and assessment purposes.  
     * It is where a House is setup and at least 
     * eight electrical appliances (of all kinds) are added to the house.  
     * (see Appendix A for some of them, add others)"
     */
    private void setupHouse()
    {
        myHouse = new House("3225 21th Ave, 31000");
        myHouse.addAppliance(new Light(1, "Porch Light", 40, 1, 47));
        myHouse.addAppliance(new Light(2, "Kitchen Light", 100, 2, 67));
        myHouse.addAppliance(new Light(3, "Porch Light", 60, 3, 124));

        Time t1 = new Time(10, 00); // 10:00
        Time t2 = new Time(10, 01); // 10:01
        Time t3 = new Time(10, 02); // 10:02
        
        TimeableLight tl4 = new TimeableLight(4, "Hall Light", 40, 1, 67);
        tl4.setTimes(t1, t3);
        tl4.setCurrentTime(t1);
        myHouse.addAppliance(tl4);
        
        TimeableLight tl5 = new TimeableLight(5, "Garden Light", 20, 2, 27);
        tl5.setTimes(t1, t3);
        tl5.setCurrentTime(t2);
        myHouse.addAppliance(tl5);
        
        TimeableLight tl6 = new TimeableLight(6, "Porch Light", 40, 1, 47);
        tl6.setTimes(t1, t3);
        tl6.setCurrentTime(t3);
        myHouse.addAppliance(tl6);
        
        myHouse.addAppliance(new TimeableLight(7, "A Light", 99, 3, 97));
        myHouse.addAppliance(new TimeableLight(8, "B Light", 69, 2, 67));
    }

    /**
     * User supplies an appliance code and 
     * if it is in the house it is switched on.  
     */
    public void turnOnASingleAppliance(int id)
    {
        myHouse.turnOnASingleAppliance(id);
    }

    /**
     * User presses a button (or selects menu item) 
     * which switches on all house lights.
     */
    public void switchOnAllLights()
    {
        myHouse.turnAllLightsOn();
    }

    /**
     * User supplies on and off times (perhaps using JOptionPane) 
     * and all timeable lights are set with on and off times.
     */
    public void setATimeableLightWithOnOffTimes(int times)
    {
        myHouse.setTimeableLight(times);
    }

    /**
     * Update GUI
     */
    public void updateHouseAppliances()
    {
        centerPanel.removeAll();
        for(int i = 0; i < myHouse.getHouseAppliances().size(); i++)
        {
            JTextArea text = new JTextArea(
                    myHouse.getHouseAppliances().get(i).toString());
            text.setEditable(false);
            centerPanel.add(text);
        }
        jframe.add(centerPanel, BorderLayout.CENTER);
        // update the screen
        jframe.validate();
        jframe.repaint();
    }

    public class Option1Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) { 
            String input = JOptionPane.showInputDialog(
                    jframe, "Enter appliance ID to turn on");
            try
            {
                int id = Integer.parseInt(input);
                turnOnASingleAppliance(id);
                // update the panel to see the change
                updateHouseAppliances();
            }
            catch(Exception err)
            {
            }
        } 
    }

    public class Option2Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) { 
            switchOnAllLights();
            // update the panel to see the change
            updateHouseAppliances();
        } 
    }

    public class Option3Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) { 
            String input = JOptionPane.showInputDialog(
                    jframe, "How many times you want timeable light(s) to turn on and off?");
            try
            {
                int amount = Integer.parseInt(input);
                if(amount > 0)
                {
                    setATimeableLightWithOnOffTimes(amount);
                    // update the panel to see the change
                    updateHouseAppliances();
                }
            }
            catch(Exception err)
            {
            }
        } 
    }
}
