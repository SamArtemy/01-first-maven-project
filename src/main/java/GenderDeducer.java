
public class GenderDeducer {

    public String deduceGender(String name) throws IllegalArgumentException {
        String girl = "girl";
        String boy = "boy";
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        if (name.endsWith("a")) {
            return girl;
        } else return boy;
    }
}




