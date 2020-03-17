import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GenderDeducerTest {


    @Test
    public void setGenderMethodStringTest() {
        GenderDeducer genderDeducer = new GenderDeducer();

        String res1 = genderDeducer.setGender("Дмитрий");
        assertEquals("boy", res1);

        String res2 = genderDeducer.setGender("Татьяна");
        assertEquals("girl", res2);
    }
}