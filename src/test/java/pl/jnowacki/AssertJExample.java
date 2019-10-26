package pl.jnowacki;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class AssertJExample {
    private static CalculatorImpl calculator;

    @BeforeClass
    public static void setUp() {
        System.out.println("BeforeClass");

        calculator = new CalculatorImpl();
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("AfterClass");
    }

    @After
    public void tearDownAfterMethod() {
        System.out.println("After");
        calculator.clear();
    }

    @Test
    public void shouldDisplayValuesOfMultipleNumbersPressed() {
        //when
        calculator.pressNumber(5);
        calculator.pressNumber(3);
        calculator.pressNumber(7);

        //then
        assertThat(calculator.display()).isEqualTo("537");
        assertThat(1 + 4).isLessThan(10);
    }

    @Test
    @Parameters({"4, 2, 2", "12, 3, 4"})
    public void shouldDivideWithoutException(int a, int b, String result) {
        CalculatorImpl calculator = new CalculatorImpl();
        calculator.div(a, b);

        assertThat(calculator.display()).isEqualTo(result);
    }
}
