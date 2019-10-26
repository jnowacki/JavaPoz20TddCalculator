package pl.jnowacki;

import org.junit.*;

import static org.junit.Assert.*;

public class CalculatorImplTest {

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

    @Before
    public void setUpBeforeMethod(){
        System.out.println("Before");
    }

    @Test
    public void shouldDisplayValuesOfMultipleNumbersPressed() {
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
        calculator.pressNumber(5);
        assertEquals("5", calculator.display());

        //when
        calculator.clear();

        //then
        assertTrue(calculator.display().isEmpty());
    }

    @Test
    public void shouldAddTwoNumbers() {

        //given
        int numberA = 1;
        int numberB = 2;

        //when
        calculator.add(numberA, numberB);

        //then
        assertEquals("3", calculator.display());
    }

    @Test
    public void shouldAddTwoNumbersTwoAndThree() {
        //given
        int numberA = 2;
        int numberB = 3;

        //when
        calculator.add(numberA, numberB);

        //then
        assertEquals("5", calculator.display());
    }

    @Test
    public void shouldSubtractTwoNumbersTwoAndThree() {
        //given
        int numberA = 5;
        int numberB = 3;

        //when
        calculator.sub(numberA, numberB);

        //then
        assertEquals("2", calculator.display());
    }

    @Test
    public void testMultipleNumberSets() {
        testSub(1, 4, -3);
        testSub(5, 3, 2);
    }

    private void testSub(int a, int b, int result) {

        calculator.sub(a, b);
        assertEquals(String.valueOf(result), calculator.display());
    }
}