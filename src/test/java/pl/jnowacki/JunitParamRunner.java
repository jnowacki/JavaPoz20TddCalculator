package pl.jnowacki;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class JunitParamRunner {

    @Test
    @Parameters({"1, 2, 3", "2, 5, 7"})
    public void testAdd(int a, int b, String result) {
        CalculatorImpl calculator = new CalculatorImpl();
        calculator.add(a, b);

        assertEquals(result, calculator.display());
    }

}
