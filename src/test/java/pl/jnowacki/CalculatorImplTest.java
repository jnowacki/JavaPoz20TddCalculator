package pl.jnowacki;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorImplTest {

    @Test
    public void shouldDisplayValuesOfMultipleNumbersPressed() {
        //given
        CalculatorImpl calculator = new CalculatorImpl();

        //when
        calculator.pressNumber(5);
        calculator.pressNumber(3);
        calculator.pressNumber(7);

        //then
        assertEquals("537", calculator.display());
    }
}