import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.print.Book;
import java.io.*;
import java.util.GregorianCalendar;
import java.util.NoSuchElementException;

public class AppTest extends App {

    @Test
    public void testMain() {
        InputStream is = new ByteArrayInputStream("Artem".getBytes());
        OutputStream os = new ByteArrayOutputStream();
        System.setIn(is);
        System.setOut(new PrintStream(os));
        App.main(null);
        Assert.assertEquals(os.toString(), "Enter a name\nYou're my first boyfriend!");
    }

    @Test(expectedExceptions = {NoSuchElementException.class})
    public void testMainEmpty() {
        InputStream is = new ByteArrayInputStream("".getBytes());
        OutputStream os = new ByteArrayOutputStream();
        System.setIn(is);
        System.setOut(new PrintStream(os));
        App.main(null);

    }

    @Test(expectedExceptions = {NullPointerException.class})
    public void testMainNull() {
        InputStream is = new ByteArrayInputStream(null);
        OutputStream os = new ByteArrayOutputStream();
        System.setIn(is);
        System.setOut(new PrintStream(os));
        App.main(null);
    }

    @Test()
    public void testMainArray() {
        byte[] array = new byte[]{1, 3, 5, 7};
        InputStream is = new ByteArrayInputStream(array, 1, 1);
        OutputStream os = new ByteArrayOutputStream();
        System.setIn(is);
        System.setOut(new PrintStream(os));
        App.main(null);
        Assert.assertEquals(os.toString(), "Enter a name\nYou're my first boyfriend!");


    }
}