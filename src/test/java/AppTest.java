import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.NoSuchElementException;

public class AppTest extends App {

    @DataProvider
    public static Object[][] charsAndSymbols() {
        return new Object[][]{
                {"123", "Enter a name\nYou're my first boyfriend!"},
                {"1.2.3", "Enter a name\nYou're my first boyfriend!"},
                {"-15", "Enter a name\nYou're my first boyfriend!"},
                {"0", "Enter a name\nYou're my first boyfriend!"},
                {"Artem", "Enter a name\nYou're my first boyfriend!"},
                {"Mikhail", "Enter a name\nYou're my first boyfriend!"},
                {"Masha", "Enter a name\nYou're my first girlfriend!"},
                {"Tatiana", "Enter a name\nYou're my first girlfriend!"}};
    }

    @DataProvider
    public static Object[][] emptySymbol() {
        return new Object[][]{{"", null}};
    }

    @Test(dataProvider = "charsAndSymbols")
    public void testMain_charsAndSymbolsInput(String expectedText, String expectedOutput) {
        testMain(expectedText, expectedOutput);
    }

    @Test(dataProvider = "emptySymbol")
    public void testMain_EmptyInput(String expectedText) {
        testMain(expectedText, NoSuchElementException.class);
    }

    private void testMain(String input, Class<? extends Exception> expectedException) {
        InputStream is = new ByteArrayInputStream(input.getBytes());
        OutputStream os = new ByteArrayOutputStream();
        System.setIn(is);
        System.setOut(new PrintStream(os));
        Assert.expectThrows(expectedException, () -> App.main(null));
    }

    private void testMain(String input, String expectedOutput) {
        InputStream is = new ByteArrayInputStream(input.getBytes());
        OutputStream os = new ByteArrayOutputStream();
        System.setIn(is);
        System.setOut(new PrintStream(os));
        App.main(null);
        Assert.assertEquals(os.toString(), expectedOutput);
        }

}