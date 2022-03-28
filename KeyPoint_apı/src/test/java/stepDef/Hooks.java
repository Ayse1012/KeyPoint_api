package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.*;

public class Hooks {

    @Before
    public void setup(Scenario scenario){
      //  baseURI="http://kps-qa.sytes.net:9001/api";


    }

    @After
    public void tearDown(Scenario scenario){

                reset();
    }



}
