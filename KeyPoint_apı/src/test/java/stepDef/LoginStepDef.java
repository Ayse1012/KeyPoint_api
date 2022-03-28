package stepDef;

import io.cucumber.java.en.*;
import pages.LoginPage;

public class LoginStepDef {
  LoginPage loginPage=new LoginPage();

    @Given("user logs in with {string}")
    public void user_logs_in_with(String role) {
       loginPage.loginWithValidCredentials(role);
    }
    @When("verify if the login successful")
    public void verify_if_the_login_successful() {
       loginPage.verifyUserLogin();
     //   System.out.println("LoginPage.token = " + LoginPage.token("SUPER_ADMIN"));
    }

}
