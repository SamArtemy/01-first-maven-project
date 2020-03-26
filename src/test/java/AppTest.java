import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;

public class AppTest extends App {

    @Test
    public void testMain() throws IllegalArgumentException {
        InputStream is = new ByteArrayInputStream("Artem".getBytes());
        OutputStream os = new ByteArrayOutputStream();
        System.setIn(is);
        System.setOut(new PrintStream(os));
        App.main(null);
        Assert.assertEquals(os.toString(), "Enter a name\nYou're my first boyfriend!");
    }
}