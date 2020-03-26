import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        GenderDeducer genderDeducer = new GenderDeducer();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a name");
        try {
            String name = in.next();
            System.out.print("You're my first " + genderDeducer.deduceGender(name) + "friend!");
        } catch (IllegalArgumentException e) {
            System.err.print(e.getMessage());
            System.err.print("Exception was processed. Program continues");

        }


    }
}
