package pl.jnowacki;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

@RunWith(value = Parameterized.class)
public class CalculatorParamTestByField {

    @Parameterized.Parameter(value = 0)
    public int a;

    @Parameterized.Parameter(value = 1)
    public int b;

    @Parameterized.Parameter(value = 2)
    public String result;

    @Parameterized.Parameters(name = "{index}: testAdd({0}+{1}) = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 5, "6"},
                {3, 6, "9"},
                {1, 1, "2"}
        });
    }

    @Test
    public void testAdd(){
        CalculatorImpl calculator = new CalculatorImpl();
        calculator.add(a, b);

        assertEquals(result, calculator.display());
    }
}
