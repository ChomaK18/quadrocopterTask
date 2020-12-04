import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of transmitters");

        int numberOfTransmitters = sc.nextInt();
        List<Transmitter> transmitterList = new ArrayList<>();

        for (int i = 1; i <= numberOfTransmitters; i++) {
            System.out.println("Enter the coordinate X of the " + i + ". transmitter:");
            int x = sc.nextInt();
            System.out.println("Enter the coordinate Y of the " + i + ". transmitter:");
            int y = sc.nextInt();
            Point center = new Point(x, y);

            System.out.println("Enter the power of the " + i + ". transmitter:");
            int power = sc.nextInt();
            Transmitter transmitter = new Transmitter(i, center, power);
            transmitterList.add(transmitter);
        }

        System.out.println("Enter the coordinate X of the start:");
        int xOfStart = sc.nextInt();
        System.out.println("Enter the coordinate Y of the start:");
        int yOfStart = sc.nextInt();
        Point start = new Point(xOfStart, yOfStart);
        System.out.println("Enter the coordinate X of the end:");
        int xOfEnd = sc.nextInt();
        System.out.println("Enter the coordinate Y of the end:");
        int yOfEnd = sc.nextInt();
        Point end = new Point(xOfEnd, yOfEnd);

        TransmiterService transmiterService = new TransmiterService();

        boolean result = (transmiterService.checkIfPassageIsPossible(transmitterList, start, end));

        if (result) {
            System.out.println(transmiterService.pass);
        } else {
            System.out.println(transmiterService.notPass);
        }
    }
}
