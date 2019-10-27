package pl.jnowacki;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

public class NumberWrapper {
    public int getNumber(){
        return 15;
    }

    public static Matcher<NumberWrapper> returnsRightNumber(Matcher<? super Integer> matcher) {
        return new FeatureMatcher<NumberWrapper, Integer>(matcher, "a wrapper that returns", "returned value") {
            @Override
            protected Integer featureValueOf(NumberWrapper actual) {
                return actual.getNumber();
            }
        };
    }
}
