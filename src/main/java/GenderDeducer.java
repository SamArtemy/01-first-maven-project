
public class GenderDeducer {

    public String deduceGender(String name) {
        String girl = "girl";
        String boy = "boy";
        if (name.endsWith("a")) {
            return girl;
        } else return boy;
    }
}

