import org.example.StringCalculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StringCalculatorTest {
    @Test
    public void testAddEmptyString() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void testAddSingleNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.add("1"));
    }

    @Test
    public void testAddTwoNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    public void testSeperators() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1,2,3"));
    }

    @Test
    public void testSeperators2() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    public void testAddCustomDelimiter() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//;\n1;2;3"));
    }

    @Test
    public void testAddCustomDelimiter2() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//;\n1;2;3"));
    }

    @Test
    public void testAddNegativeNumber() {
        StringCalculator calculator = new StringCalculator();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.add("-1"));
        assertEquals("Negatives not allowed: [-1]", exception.getMessage());
    }

    @Test
    public void testAddNegativeNumbers2() {
        StringCalculator calculator = new StringCalculator();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.add("2,-4,3,-5"));
        assertEquals("Negatives not allowed: [-4, -5]", exception.getMessage());
    }

    @Test
    public void testBigNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(2, calculator.add("1001,2"));
    }

    @Test
    public void testAddMultipleDelimiters() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//[|][%]\n1|2%3"));
    }

    @Test
    public void testAddCustomDelimiterAnyLength() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//[|||]\n1|||2|||3"));
    }

    @Test
    public void testAddCustomDelimiterAnyLength2() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//[|%%]\n1|%%2|%%3"));
    }

    @Test
    public void testAddMultipleDelimitersOfAnyLength() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//[|||][%%%]\n1|||2%%%3"));
    }


}
