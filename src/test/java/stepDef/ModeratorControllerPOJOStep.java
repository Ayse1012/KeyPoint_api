package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.ModeratorControllerPOJO;

public class ModeratorControllerPOJOStep {
      ModeratorControllerPOJO moderatorPOJO =new ModeratorControllerPOJO();

    @Given("by {string} creates by pojo")
    public void by_creates_by_pojo(String user) {

     moderatorPOJO.createUserByPojo(user);
    }


    @When("verify Pojo if the login successful {string}")
    public void verifyPojoIfTheLoginSuccessful(String statusCode) {

        moderatorPOJO.verifyPojo(statusCode);

    }


}
