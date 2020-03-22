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
        String res1 = genderDeducer.deduceGender(null);
        throw new IllegalArgumentException(res1);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void exceptionEmptyTes() throws IllegalArgumentException {
        GenderDeducer genderDeducer = new GenderDeducer();
        String res1 = genderDeducer.deduceGender("");
        throw new IllegalArgumentException(res1);
    }
}