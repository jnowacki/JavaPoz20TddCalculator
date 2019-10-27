package pl.jnowacki;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.List;

public class PersonSchoolAgeMatcher extends TypeSafeMatcher<Person> {

    static PersonSchoolAgeMatcher isEligibleToSchool() {
        return new PersonSchoolAgeMatcher();
    }

    @Override
    protected boolean matchesSafely(Person person) {
        return person.getAge() > 6;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("person is above 6yo");
    }
}

