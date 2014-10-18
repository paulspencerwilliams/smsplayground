package uk.me.paulswilliams.clockworksmsplay;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matcher;
import retrofit.RestAdapter;
import uk.me.paulswilliams.clockworksmsplay.daos.UserDao;

import static org.junit.Assert.assertThat;
import static uk.me.paulswilliams.clockworksmsplay.matchers.CoordinateMatcher.matchesCoordinate;


public class StepDefinitions {

    private Coordinate coordinate;

    @When("^I register my position$")
    public void i_register_my_position() throws Throwable {

        TheApi theApi = new RestAdapter.Builder()
                .setEndpoint("http://localhost:9292")
                .build().create(TheApi.class);
        coordinate = new Coordinate(52.633584000000000000, -1.691031999999950100);
        theApi.registerPosition(123, coordinate);
    }

    @Then("^the system will record my position$")
    public void the_system_will_record_my_position() throws Throwable {
        UserDao userDao = new UserDao();
        assertThat(userDao.getPositionForUser(123), matchesCoordinate(coordinate));
    }
}
