
public class GenderDeducer {

    public String sexDetermination(String name) {
        String girl = "girl";
        String boy = "boy";
        if (name.endsWith("a")) {
            return girl;
        } else return boy;
    }
}

