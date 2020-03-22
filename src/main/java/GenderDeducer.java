
public class GenderDeducer {

    public String deduceGender(String name) {
            String girl = "girl";
            String boy = "boy";
            if (name.endsWith("a")) {
                return girl;
            } else return boy;

            try {
                if (name == null)
                    throw new IllegalArgumentException("Name cannot be null");
                if (name.isEmpty())
                    throw new IllegalArgumentException("Name cannot be blank");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}


