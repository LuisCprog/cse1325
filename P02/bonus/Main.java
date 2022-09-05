
import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner object =new Scanner(System.in);
        Clock clock=new Clock();

        System.out.println("Hours?");
        int hour = object.nextInt();
        System.out.println("Minutes?");
        int minute = object.nextInt();
        System.out.println("Seconds?");
        int seconds = object.nextInt();

        clock.setHours(hour);
        clock.setMinutes(minute);
        clock.setSeconds(seconds);

        System.out.println(clock.toString());
    }
    
}
