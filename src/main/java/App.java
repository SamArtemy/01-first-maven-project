import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        GenderDeducer genderDeducer = new GenderDeducer();
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя");
        String name = in.next();
        System.out.println("You're my first " + genderDeducer.setGender(name) + " friend!");


    }
}
