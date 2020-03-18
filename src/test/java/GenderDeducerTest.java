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
}