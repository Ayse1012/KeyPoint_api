package pages;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import pojoPage.ModeratorBody;
import utilities.ApiUtilities;
import utilities.ConfigurationReader;
import io.restassured.response.Response;
import static org.junit.Assert.*;

import static io.restassured.RestAssured.*;


public class ModeratorControllerPOJO {

  /*  {
        "firstName": "Cedrick",
            "lastName": "Jacobson",
            "password": "Test123456!",
            "mobile": "7089532061",
            "email": "CedrickJacobson@example.com"
    } */

    ModeratorBody moderatorBody=new ModeratorBody();
    Faker f=new Faker();
    Response response;
    public void createUserByPojo(String user){
        moderatorBody.setFirstName(f.name().firstName());
        moderatorBody.setLastName(f.name().lastName());
        moderatorBody.setPassword(ConfigurationReader.get("password"));
        moderatorBody.setMobile(f.number().digits(10));
        moderatorBody.setEmail(f.name().firstName()+f.name().lastName()+"@example.com");

       response=given().contentType(ContentType.JSON).and().body(moderatorBody).headers(ApiUtilities.getAccessToken(user)).log().all()
                .when().post("/moderators").prettyPeek();


    }

    public void getUserByPojo(String role,String ıd){
        String token=LoginPage.loginWithValidCredentials(role);

        response=given().contentType(ContentType.JSON).headers("Authorization",token).and().pathParam("id", ıd).
                when().get("/moderators/{id}").prettyPeek();

        assertEquals(200,response.statusCode());


    }

    public void verifyPojo(String statusCode){
        int code=Integer.parseInt(statusCode);
        assertEquals(response.statusCode(),code);
    }



}
