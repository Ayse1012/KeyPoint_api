package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.ModeratorControllerPage;

public class ModeratorControllerStepDef {

    ModeratorControllerPage moderatorControllerPage=new ModeratorControllerPage();

    @Given("by {string} creates {string}")
    public void by_creates(String user, String role) {
        moderatorControllerPage.createUser(user,role);

    }

    @Given("{string} gets user by {string}")
    public void getsUserBy(String user, String role) {

        moderatorControllerPage.getUserById(user,role);
    }

    @Given("{string} put user by {string}")
    public void putUserBy(String user, String role) {
        moderatorControllerPage.putUserById(user,role);
    }

    @When("verify if the login successful {string}")
    public void verifyIfTheLoginSuccessful(String statusCode) {
        moderatorControllerPage.verifyStatus(statusCode);
    }
}
