
public class GenderDeducer {

    public String setGender(String name) {
        String girl = "girl";
        String boy = "boy";
        if (name.endsWith("а")) {
            return girl;
        } else return boy;
    }
}

