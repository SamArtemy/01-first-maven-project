import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.util.NoSuchElementException;

public class AppTest extends App {

    @Test
    public void testMain(){
        InputStream is = new ByteArrayInputStream("Artem".getBytes());
        OutputStream os = new ByteArrayOutputStream();
        System.setIn(is);
        System.setOut(new PrintStream(os));
        App.main(null);
        Assert.assertEquals(os.toString(), "Enter a name\nYou're my first boyfriend!");
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void testMainEmpty(){
        InputStream is = new ByteArrayInputStream("".getBytes());
        OutputStream os = new ByteArrayOutputStream();
        System.setIn(is);
        System.setOut(new PrintStream(os));
        App.main(null);
        Assert.assertEquals(NoSuchElementException.class, "Name cannot be blank");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testMainNull(){
        InputStream is = new ByteArrayInputStream(null);
        OutputStream os = new ByteArrayOutputStream();
        System.setIn(is);
        System.setOut(new PrintStream(os));
        App.main(null);
        Assert.assertEquals(NullPointerException.class, "Name cannot be null");
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testMainInt(){
        InputStream is = new ByteArrayInputStream("123".getBytes());
        OutputStream os = new ByteArrayOutputStream();
        System.setIn(is);
        System.setOut(new PrintStream(os));
        App.main(null);
        Assert.assertEquals(AssertionError.class, "");
    }
}