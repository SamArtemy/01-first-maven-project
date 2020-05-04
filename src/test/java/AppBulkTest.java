import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.NoSuchElementException;

public class AppBulkTest {

    @DataProvider
    public static Object[][] charsAndSymbols() {
        return new Object[][]{
                {"123\n1.2.3\n-15\n0\nArtem\nMikhail\nMasha\nTatiana\n\n",
                        "Enter the names\n" +
                                "123 is a boy\n" +
                                "1.2.3 is a boy\n" +
                                "-15 is a boy\n" +
                                "0 is a boy\n" +
                                "Artem is a boy\n" +
                                "Mikhail is a boy\n" +
                                "Masha is a girl\n" +
                                "Tatiana is a girl\n"}};
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
