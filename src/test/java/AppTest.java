import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.NoSuchElementException;

public class AppTest extends App {

    @DataProvider
    public static Object[][] charsAndSymbols() {
        return new Object[][]{{"123"}, {"1.2.3"}, {"-15"}, {"0"}};
    }

    @DataProvider
    public static Object[][] maleName() {
        return new Object[][]{{"Artem"}, {"Mikhail"}};
    }

    @DataProvider
    public static Object[][] femaleName() {
        return new Object[][]{{"Masha"}, {"Tatiana"}};
    }

    @DataProvider
    public static Object[][] emptySymbol() {
        return new Object[][]{{""}};
    }

    @Test(dataProvider = "maleName")
    public void testMain_maleNameInput(String expectedText) {
        testMain(expectedText, "Enter a name\nYou're my first boyfriend!", null);
    }

    @Test(dataProvider = "femaleName")
    public void testMain_femaleNameInput(String expectedText) {
        testMain(expectedText, "Enter a name\nYou're my first girlfriend!", null);
    }

    @Test(dataProvider = "charsAndSymbols")
    public void testMain_charsAndSymbolsInput(String expectedText) {
        testMain(expectedText, "Enter a name\nYou're my first boyfriend!", null);
    }

    @Test(dataProvider = "emptySymbol")
    public void testMain_EmptyInput(String expectedText) {
        testMain(expectedText, null, NoSuchElementException.class);
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