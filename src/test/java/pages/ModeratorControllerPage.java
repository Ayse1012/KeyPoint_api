package pages;

import com.github.javafaker.Faker;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ApiUtilities;
import utilities.ConfigurationReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ModeratorControllerPage {
    Response response;
   Faker faker=new Faker();
  public void createUser(String user,String role){
      String firstName=faker.name().firstName();
      String lastName=faker.name().lastName();
      String email=firstName+lastName+"@example.com";
      String mobile=faker.number().digits(10);
      String password= ConfigurationReader.get("password");

      Map<String,Object> createRole=new HashMap<>();
      createRole.put("email",email);
      createRole.put("firstName",firstName);
      createRole.put("lastName",lastName);
      createRole.put("mobile",mobile);
      createRole.put("password",password);

     // String token=LoginPage.loginWithValidCredentials(user);


      response=given().contentType(ContentType.JSON).and().body(createRole).headers(ApiUtilities.getAccessToken(user)).log().all()
              .when().post("/moderators").prettyPeek();

      String ıd=response.jsonPath().getString("data.id");

      System.out.println("ıd = " + ıd);


  }
    public void getUserById(String role,String ıd){
        String token=LoginPage.loginWithValidCredentials(role);
        response=given().contentType(ContentType.JSON).headers("Authorization",token).and().pathParam("id", ıd).
                when().get("/moderators/{id}").prettyPeek();

        assertEquals(200,response.statusCode());
        System.out.println("response.statusCode() = " + response.statusCode());

    }
    public void putUserById(String role,String ıd){

        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String mobil= faker.number().digits(10);

        Map<String,Object> putBody=new HashMap<>();
        putBody.put("firstName",firstName);
        putBody.put("lastName",lastName);
        putBody.put("mobile",mobil);

        String token=LoginPage.loginWithValidCredentials(role);

        response=given()
                .contentType(ContentType.JSON).and()
                .body(putBody).headers("Authorization",token)
                .pathParam("id",ıd)
                .when().put("/moderators/{id}").prettyPeek();


    }

    public void verifyStatus(String statusCode){
      int status=Integer.parseInt(statusCode);
      assertEquals(response.statusCode(),status);

    }





}
