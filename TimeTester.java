/**
 *
 * @author ian
 */
public class TimeTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Time t1 = new Time(17, 15);
        System.out.println(t1);
        Time t2 = new Time(7, 5);
        System.out.println(t2);
        Time t3 = new Time(19, 16);
        Time t4 = new Time(17, 16);
        Time t5 = new Time(17,15);
        System.out.println("17:15 before 19:16 " + t1.isBefore(t3));
        System.out.println("19:16 before 17:15 " + t3.isBefore(t1));
        System.out.println("17:15 before 17:16 " + t1.isBefore(t4));
        System.out.println("17:16 before 17:15 " + t4.isBefore(t1));
        System.out.println("17:15 before 17:15 " + t1.isBefore(t5));
        System.out.println("17:15 before 17:15 " + t5.isBefore(t1));
        System.out.println("17:15 equals 17:15:" + t1.equals(t5));
        System.out.println("17:15 equals 17:15:" + t5.equals(t5));
        System.out.println("17:15 equals 17:16 " + t1.equals(t4));
        System.out.println("17:16 before 17:15 " + t4.equals(t1));
    }

}
