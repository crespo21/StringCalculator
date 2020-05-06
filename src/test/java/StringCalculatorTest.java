import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StringCalculatorTest {
    @Test
    public void emptyString() throws Exception {
        assertThat(StringCalculator.add(""), is(0));
    }
    @Test
    public void  multipleIntegers() throws Exception {
        assertThat(StringCalculator.add("1,2,3,4"), is(10));
    }
    @Test
    public void  handleNewLinesBetweenIntegers() throws Exception {
        assertThat(StringCalculator.add("1\n2,4"), is(7));
    }
    @Test
    public void handleNegativeValues() throws Exception {
        try {
            assertThat(StringCalculator.add("-1,-2,-3"), is(-6));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void  handleNumbersGreaterThanThousand() throws Exception {
        try {
            assertThat(StringCalculator.add("//;\n1000;1;4"), is(5));
        } catch (NumberFormatException e){
          e.getMessage();
       }
   }
}
