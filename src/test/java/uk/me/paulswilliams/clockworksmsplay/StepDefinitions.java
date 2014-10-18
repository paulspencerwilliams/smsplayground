package uk.me.paulswilliams.clockworksmsplay;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import retrofit.RestAdapter;


public class StepDefinitions {

    @When("^I register my position$")
    public void i_register_my_position() throws Throwable {

        TheApi theApi = new RestAdapter.Builder()
                .setEndpoint("http://localhost:3000")
                .build().create(TheApi.class);
        theApi.registerPosition(123, new Coordinate(52.633584000000000000, -1.691031999999950100));
    }

    @Then("^the system will record my position$")
    public void the_system_will_record_my_position() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
