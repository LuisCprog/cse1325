import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner object =new Scanner(System.in);
        Clock clock=new Clock();

        System.out.println("Hours?");
        Integer hour = object.nextInt();
        System.out.println("Minutes?");
        Integer minute = object.nextInt();
        System.out.println("Seconds?");
        Integer seconds = object.nextInt();

        clock.setHours(hour);
        clock.setMinutes(minute);
        clock.setSeconds(seconds);

        System.out.println(clock.toString());
    }
    
}
