package uk.me.paulswilliams.clockworksmsplay.matchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import uk.me.paulswilliams.clockworksmsplay.Coordinate;

public class CoordinateMatcher extends TypeSafeMatcher<Coordinate> {
    private final Coordinate expected;

    private CoordinateMatcher(Coordinate expected) {

        this.expected = expected;
    }
    @Override
    protected boolean matchesSafely(Coordinate coordinate) {
        return coordinate.equals(expected);
    }

    @Override
    public void describeTo(Description description) {
        description.appendValue(expected);
    }

    public static CoordinateMatcher matchesCoordinate(Coordinate expected){
        return new CoordinateMatcher(expected);
    }
}
