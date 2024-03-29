package pl.jnowacki;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static pl.jnowacki.GivenLetterItemCountListMatcher.hasGivenLetterCountItems;
import static pl.jnowacki.PersonSchoolAgeMatcher.isEligibleToSchool;

public class HamcrestExercisesTest {

    @Test
    public void fiveShouldBeGreaterThanThree() {
        assertThat(5, is(greaterThan(3)));
    }

    @Test
    public void emptyStringShouldBeEmpty() {
        assertThat("", isEmptyOrNullString());
    }

    @Test
    public void doesStringContainKonfabulacja() {

        String value = "afdsfdsfdsfaqwtjjfvvjfyu";

        assertThat(value, not(containsString("konfabulacja")));
    }

    @Test
    public void doesArrayContainRightValues() {

        Integer[] values = {5, 7, 2};

        assertThat(values, arrayContaining(5, 7, 2));
    }

    @Test
    public void doesArrayContainRightValuesInAnyOrder() {

        Integer[] values = {5, 7, 2};

        assertThat(values, arrayContainingInAnyOrder(2, 5, 7));
    }

    @Test
    public void doesListContainAndHasRightLength() {

        List<String> values = Arrays.asList("raz", "dwa", "trzy");

        assertThat(values, hasItem("dwa"));
        assertThat(values, hasSize(3));
    }

    @Test
    public void shouldBeginWithA() {
        String testedValue = "aString";

        assertThat(testedValue, beginsWith(is('a')));
    }

    private static Matcher<String> beginsWith(Matcher<? super Character> matcher) {
        return new FeatureMatcher<String, Character>(matcher, "a String that begins with", "first letter") {
            @Override
            protected Character featureValueOf(String actual) {
                return actual.charAt(0);
            }
        };
    }

    @Test
    public void testIfHasOnly3LetterItems() {
        List<String> listUnderTest = Arrays.asList("one", "two");

        assertThat(listUnderTest, hasGivenLetterCountItems(3));
    }

    @Test
    public void testIfHasOnly4LetterItems() {
        List<String> listUnderTest = Arrays.asList("onea", "twoa");

        assertThat(listUnderTest, hasGivenLetterCountItems(4));
    }

    @Test
    public void testPersonAge() {

        Person person1 = new Person(0);
        Person person2 = new Person(6);
        Person person3 = new Person(12);

        assertThat(person1, not(isEligibleToSchool()));
        assertThat(person2, not(isEligibleToSchool()));
        assertThat(person3, isEligibleToSchool());
    }
}
