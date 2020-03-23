import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GenderDeducerTest {


    @Test
    public void testSexDetermination() {
        GenderDeducer genderDeducer = new GenderDeducer();

        String res1 = genderDeducer.deduceGender("Alexander");
        assertEquals("boy", res1);

        String res2 = genderDeducer.deduceGender("Marina");
        assertEquals("girl", res2);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void exceptionNullTest() throws IllegalArgumentException {
        GenderDeducer genderDeducer = new GenderDeducer();
        genderDeducer.deduceGender(null);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void exceptionEmptyTest() throws IllegalArgumentException {
        GenderDeducer genderDeducer = new GenderDeducer();
        genderDeducer.deduceGender("");
    }
}