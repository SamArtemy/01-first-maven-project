import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GenderDeducerTest {


    @Test
    public void testSexDetermination() {
        GenderDeducer genderDeducer = new GenderDeducer();

        String res1 = genderDeducer.sexDetermination("Alexander");
        assertEquals("boy", res1);

        String res2 = genderDeducer.sexDetermination("Marina");
        assertEquals("girl", res2);
    }
}