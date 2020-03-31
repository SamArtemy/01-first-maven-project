import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.util.NoSuchElementException;

public class AppTest extends App {

    @Test
    public void testMain_ArtemInput() {
        testMain("Artem", "Enter a name\nYou're my first boyfriend!", null);
    }

    @Test
    public void testMain_MashaInput() {
        testMain("Masha", "Enter a name\nYou're my first girlfriend!", null);
    }

    @Test
    public void testMain_MikhailInput() {
        testMain("Mikhail", "Enter a name\nYou're my first boyfriend!", null);
    }

    @Test
    public void testMain_TatianaInput() {
        testMain("Tatiana", "Enter a name\nYou're my first girlfriend!", null);
    }

    @Test
    public void testMain_123Input() {
        testMain("123", "Enter a name\nYou're my first boyfriend!", null);
    }

    @Test
    public void testMain_1dot2dot3Input() {
        testMain("1.2.3", "Enter a name\nYou're my first boyfriend!", null);
    }

    @Test
    public void testMain_negative15Input() {
        testMain("-15", "Enter a name\nYou're my first boyfriend!", null);
    }

    @Test
    public void testMain_ZeroInput() {
        testMain("0", "Enter a name\nYou're my first boyfriend!", null);
    }
    
    @Test
    public void testMain_EmptyInput() {
        testMain("", null, NoSuchElementException.class);
    }

    private void testMain(String input, String expectedOutput, Class<? extends Exception> expectedException) {
        InputStream is = new ByteArrayInputStream(input.getBytes());
        OutputStream os = new ByteArrayOutputStream();
        System.setIn(is);
        System.setOut(new PrintStream(os));
        if (expectedException != null) {
            Assert.expectThrows(expectedException, () -> App.main(null));
        } else {
            App.main(null);
            Assert.assertEquals(os.toString(), expectedOutput);
        }
    }

}