import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalculatorTest {
    @Test
    public void noNumberTest() {
        int result = StringCalculator.add("");
        assertEquals(0, result);
    }

    @Test
    public void oneNumberTest() {
        int result = StringCalculator.add("5");
        assertEquals(5, result);
    }

    @Test
    public void twoNumberTest() {
        int result = StringCalculator.add("5,3");
        assertEquals(8, result);
    }

    @Test
    public void lineSplitTest()
    {
        int result = StringCalculator.add("2\n3");
        assertEquals(5, result);
    }

    @Test
    public void delimiterInputTestSemiColon()
    {
      int result = StringCalculator.add("//;\n2;2");
      assertEquals(4, result);

    }

    @Test
    public void delimiterInputTestSlash()
    {
        int result = StringCalculator.add("///\n3/3");
        assertEquals(6, result);
    }

    @Test
    public void delimiterInputTestBracket()
    {
        int result = StringCalculator.add("//(\n3(3");
        assertEquals(6, result);
    }

    @Test(expected = RuntimeException.class)
    public void negativeInputTest()
    {
        StringCalculator.add("-2,4");
    }

    @Test
    public void numberOver1000Test()
    {
        int result = StringCalculator.add("1001,5,3");
        assertEquals(8, result);
    }


    @Test(expected = RuntimeException.class)
    public void nonNumericTest() {
        StringCalculator.add("1,X");
    }

    @Test
    public void moreThanTwoTest() {
        int result = StringCalculator.add("1,2,3");
        assertEquals(6, result);
    }

    @Test(expected = RuntimeException.class)
    public void missingMiddleTest() {
        StringCalculator.add("2,,2");
    }
    
    @Test(expected = RuntimeException.class)
    public void missingSecondTest() {
        StringCalculator.add("2,");
    }
    
    @Test(expected = RuntimeException.class)
    public void missingFirstTest() {
        StringCalculator.add(",2");
    }
    
}