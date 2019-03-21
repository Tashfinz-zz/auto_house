/**
 * Tests all types of Light objects 
 * – class must have a main method (so it can be run outside BlueJ)
 *
 * @author (last-name), (first-name) (SRN number)
 */
public class ApplianceTester
{
    /**
     * "declares/creates the following objects in Appendix A and tests them.
     * Tests should be commented saying what they are testing.
     * Ensure tests cover the functionality available in the class
     * Note: it is likely that you will be expected to add further 
     * objects to this class during the demo"
     */
    public static void main()
    {
        // create time objects to be used later
        Time t1 = new Time(10, 00); // 10:00
        Time t2 = new Time(10, 01); // 10:01
        Time t3 = new Time(10, 02); // 10:02
        
        // create light and timeable light objects
        Light light1 = new Light(1, "Porch Light", 40, 1, 47);
        Light light2 = new Light(2, "Kitchen Light", 100, 2, 67);
        Light light3 = new Light(3, "Porch Light", 60, 3, 124);
        TimeableLight timeablelight4 = new TimeableLight(4, "Hall Light", 40, 1, 67);
        TimeableLight timeablelight5 = new TimeableLight(5, "Garden Light", 20, 2, 27);
        TimeableLight timeablelight6 = new TimeableLight(6, "Porch Light", 40, 1, 47);
        
        // adding currentTime, startTime and stopTime to timeablelight4, 5
        timeablelight4.setCurrentTime(t1); // current 10:00
        timeablelight4.setTimes(t1, t3); // start 10:00 stop 10:02
        // timeablelight4 can be switched on as current = start
        
        // should not work because stopTime is before startTime
        timeablelight5.setCurrentTime(t2); // current 10:01
        timeablelight5.setTimes(t3, t1); // start 10:02 stop 10:00
        // timeablelight5 cannot be switched on 
        // because current is not null but stop is null.
        
        timeablelight6.setCurrentTime(t1); // current 10:00
        timeablelight6.setTimes(t2, t3); // start 10:01 stop 10:02
        // timeablelight5 cannot be switched on
        // because currentTime is not equal to startTime
        
        // print all 6 lights
        System.out.println(light1.toString());
        System.out.println(light2.toString());
        System.out.println(light3.toString());
        System.out.println(timeablelight4.toString());
        System.out.println(timeablelight5.toString());
        System.out.println(timeablelight6.toString());
        
        // try to turn on all lights
        light1.switchOn();
        light2.switchOn();
        light3.switchOn();
        timeablelight4.switchOn();
        timeablelight5.switchOn();
        timeablelight6.switchOn();
        System.out.println("// ---------- Turn on all lights");

        // print all 6 lights again
        System.out.println(light1.toString());
        System.out.println(light2.toString());
        System.out.println(light3.toString());
        System.out.println(timeablelight4.toString());
        System.out.println(timeablelight5.toString());
        System.out.println(timeablelight6.toString());
        
        // turn on + off light1 (LED life = 3, now life = 2)
        System.out.println("// ---------- Turning off light1");
        light1.switchOff();
        System.out.println(light1.toString());
        
        System.out.println("// ---------- Turning on light1");
        light1.switchOn(); // life = 1
        System.out.println(light1.toString());
        
        System.out.println("// ---------- Turning off light1");
        light1.switchOff();
        System.out.println(light1.toString());
        
        System.out.println("// ---------- Turning on light1");
        light1.switchOn(); // life = 0
        System.out.println(light1.toString());
        
        System.out.println("// ---------- Turning off light1");
        light1.switchOff();
        System.out.println(light1.toString());
        
        System.out.println("// ---------- Turning on light1");
        light1.switchOn(); // life = 0
        System.out.println(light1.toString());
        
        System.out.println("// ---------- Turning off timablelight4");
        timeablelight4.switchOff();
        // cannot switch off because currentTime is not equal to stopTime
        System.out.println(timeablelight4.toString());
        
        System.out.println("// ---------- Set currentTime to 10:01 for timablelight6");
        timeablelight6.setCurrentTime(t2);
        System.out.println("// ---------- Turning on timablelight6");
        timeablelight6.switchOn();
        // now it can turn on because currentTime == startTime
        System.out.println(timeablelight6.toString());
    }
}