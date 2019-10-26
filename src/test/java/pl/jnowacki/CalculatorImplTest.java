package pl.jnowacki;

import org.junit.*;

import static org.junit.Assert.*;

public class CalculatorImplTest {

    @BeforeClass
    public static void setUp() {
        System.out.println("BeforeClass");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("AfterClass");
    }

    @After
    public void tearDownAfterMethod() {
        System.out.println("After");
    }

    @Before
    public void setUpBeforeMethod(){
        System.out.println("Before");
    }

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

    @Test
    public void shouldClearDisplay() {
        //given
        CalculatorImpl calculator = new CalculatorImpl();

        //when
        calculator.pressNumber(5);
        assertEquals("5", calculator.display());
        calculator.clear();

        assertTrue(calculator.display().isEmpty());
    }
}