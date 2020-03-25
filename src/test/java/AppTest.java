import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.util.List;

public class AppTest extends App{

    @Test
    public void testMain() throws IllegalArgumentException {
        InputStream is = new ByteArrayInputStream("Artem".getBytes());
        OutputStream os = new ByteArrayOutputStream();
        System.setIn(is);
        System.setOut(new PrintStream(os));
        App.main(null);
        os.toString();
        Assert.assertEquals(os.toString(), "You're my first boyfriend!");
    }
}