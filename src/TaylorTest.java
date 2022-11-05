import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaylorTest {

    @Test
    public void taylorSolvingTestOne() {
          int degree = 3;
          int argument = 3;

          double actual = Taylor.TaylorSolving(degree, argument);
          double expected = 0.047;
        Assert.assertEquals(expected, actual, 0.001);
    }


    @Test
    public void taylorSolvingTestTwo() {
        int degree = 5;
        int argument = 1;

        double actual = Taylor.TaylorSolving(degree, argument);
        double expected = 0.841471;
        Assert.assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void taylorSolvingTestThree() {
        int degree = 10;
        int argument = 5;

        double actual = Taylor.TaylorSolving(degree, argument);
        double expected = -0.19178485493;
        Assert.assertEquals(expected, actual, 0.00000001);
    }
}