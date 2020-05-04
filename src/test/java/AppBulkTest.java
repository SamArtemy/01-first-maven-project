import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.NoSuchElementException;

public class AppBulkTest extends AppBulk {

    @DataProvider
    public static Object[][] charsAndSymbols() {
        return new Object[][]{
                {"123\n\n", "Enter the names\n123 is a boy\n"},
                {"1.2.3\n\n", "Enter the names\n1.2.3 is a boy\n"},
                {"-15\n\n", "Enter the names\n-15 is a boy\n"},
                {"0\n\n", "Enter the names\n0 is a boy\n"},
                {"Artem\n\n", "Enter the names\nArtem is a boy\n"},
                {"Mikhail\n\n", "Enter the names\nMikhail is a boy\n"},
                {"Masha\n\n", "Enter the names\nMasha is a girl\n"},
                {"Tatiana\n\n", "Enter the names\nTatiana is a girl\n"}};
    }

    @DataProvider
    public static Object[][] emptySymbol() {
        return new Object[][]{{""}};
    }

    @Test(dataProvider = "charsAndSymbols")
    public void testMain_charsAndSymbolsInput(String inputText, String expectedOutput) {
        testMain(inputText, expectedOutput);
    }

    @Test(dataProvider = "emptySymbol")
    public void testMain_EmptyInput(String inputText) {
        testMain(inputText, NoSuchElementException.class);
    }

    private void testMain(String input, Class<? extends Exception> expectedException) {
        InputStream is = new ByteArrayInputStream(input.getBytes());
        OutputStream os = new ByteArrayOutputStream();
        System.setIn(is);
        System.setOut(new PrintStream(os));
        Assert.expectThrows(expectedException, () -> AppBulk.main(null));
    }

    private void testMain(String input, String expectedOutput) {
        InputStream is = new ByteArrayInputStream(input.getBytes());
        OutputStream os = new ByteArrayOutputStream();
        System.setIn(is);
        System.setOut(new PrintStream(os));
        AppBulk.main(null);
        Assert.assertEquals(os.toString(), expectedOutput);
    }


}
