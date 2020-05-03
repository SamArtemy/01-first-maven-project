import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.NoSuchElementException;

public class AppBulkTest extends AppBulk {

    @DataProvider
    public static Object[][] emptySymbol() {
        return new Object[][]{{""}};
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


}
