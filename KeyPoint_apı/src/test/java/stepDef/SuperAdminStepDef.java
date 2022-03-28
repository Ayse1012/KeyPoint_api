package stepDef;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import pages.SuperAdminPage;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SuperAdminStepDef {
    SuperAdminPage superAdminPage=new SuperAdminPage();

    @When("verify if the successful {string}")
    public void verify_if_the_create_successful(String expectedUser) {
       superAdminPage.createVerify(expectedUser);
    }

    @Given("user {string} creates {string}")
    public void userCreate(String role, String createUser) {
        superAdminPage.createUser(role,createUser);
    }

    @When("verify if the delete successful")
    public void verifyIfTheDeleteSuccessful() {
        superAdminPage.verify();

    }

    @When("verify if the successful")
    public void verifyIfTheGetSuccessful(String expecteduser) {
        superAdminPage.createVerify(expecteduser);
    }

    @Given("user logs in as {string} and gets user by {string}")
    public void userLogsInAsAndGetsUserBy(String role, String ıd) {
        superAdminPage.getUserById(role,ıd);
    }

    @Given("user logs in as {string} and deletes user by {string}")
    public void userLogsInAsAndDeletesUserBy(String role, String ıd) {
        superAdminPage.deleteUser(role,ıd);

    }

    @Given("user logs in as {string} and put user by {string} {string}")
    public void userLogsInAsAndPutUserBy(String role, String ıd,String userRole) {
        superAdminPage.putUserById(role,ıd,userRole);
    }
}
