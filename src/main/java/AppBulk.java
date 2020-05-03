import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppBulk {

    public static void main(String[] args) {
        GenderDeducer genderDeducer = new GenderDeducer();
        List<String> names = new ArrayList<String>();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a names");
        try {
            String name;
            while ((name = in.nextLine()) != "stop") {
                if (name.equals("stop")) {
                    for (String i : names) {
                        System.out.println(i + " is a " + genderDeducer.deduceGender(i));
                    }
                    break;
                } else {
                    names.add(name);

                }
            }
        } catch (IllegalArgumentException e) {
            System.err.print(e.getMessage());
            System.err.print("Exception was processed. Program continues");


        }
    }
}
