package pl.jnowacki;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.List;

public class GivenLetterItemCountListMatcher extends TypeSafeMatcher<List<String>> {

    private int count;

    static GivenLetterItemCountListMatcher hasGivenLetterCountItems(int count) {
        return new GivenLetterItemCountListMatcher(count);
    }

    private GivenLetterItemCountListMatcher(int count) {
        this.count = count;
    }

    @Override
    protected boolean matchesSafely(List<String> strings) {
        return strings.stream().allMatch(item -> item.length() == count);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("has only items with " + count + " letters");
    }
}

