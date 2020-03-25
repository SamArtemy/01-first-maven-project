import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        GenderDeducer genderDeducer = new GenderDeducer();
        Scanner in = new Scanner(System.in);
        try {
            String name = in.next();
            System.out.print("You're my first " + genderDeducer.deduceGender(name) + "friend!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Exception was processed. Program continues");

        }


    }
}
