public class GenderDeducer {

    public String setGender(String name) {
        String girl = "girl";
        String boy = "boy";
        if (name.endsWith("a")) {
            System.out.println(girl);
        } else System.out.println(boy);
        return name;

}}
