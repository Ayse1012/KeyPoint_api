package pages;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ConfigurationReader;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SuperAdminPage {

      Response response;
      Faker f =new Faker();
     String ıd1;
    public void createUser(String role,String user){

        String email=f.name().firstName() + "@example.com";
        String password= ConfigurationReader.get("password");
        String roled=user;

        ArrayList<String> roles=new ArrayList<>();
        roles.add(user);

        Map<String,Object> createBody=new HashMap<>();
        createBody.put("email",email);
        createBody.put("password",password);
        createBody.put("roles",roles);

        String token=LoginPage.loginWithValidCredentials(role);

        response=given().contentType(ContentType.JSON).body(createBody).headers("Authorization",token).log().all().
                when().post("/users").prettyPeek();

        ıd1=response.jsonPath().getString("data.id");
        System.out.println("ıd = " + ıd1);

    }

    public void createVerify(String expectedUser){
        String actualUser=response.jsonPath().getString("data.roles[0]");
        assertEquals(expectedUser,actualUser);

    }

    public void getUserById(String role,String ıd){
      //  ıd=ıd1;
        String token=LoginPage.loginWithValidCredentials(role);
        response=given().contentType(ContentType.JSON).headers("Authorization",token).and().pathParam("id", ıd).
                when().get("/users/{id}").prettyPeek();

        assertEquals(200,response.statusCode());
        System.out.println("response.statusCode() = " + response.statusCode());

    }

    public void deleteUser(String role,String ıd){

        String token=LoginPage.loginWithValidCredentials(role);
        response=given().contentType(ContentType.JSON).headers("Authorization",token).and().pathParam("id",ıd).
                when().delete("/users/{id}").prettyPeek();
        System.out.println("response.statusCode() = " + response.statusCode());

    }
    public void putUserById(String role,String ıd,String userRole){

        String firstName=f.name().firstName();
        String lastName=f.name().lastName();
        String mobil=f.number().digits(10);

        ArrayList<String> roles=new ArrayList<>();
        roles.add(userRole);

        Map<String,Object> putBody=new HashMap<>();
        putBody.put("firstName",firstName);
        putBody.put("lastName",lastName);
        putBody.put("mobile",mobil);
        putBody.put("roles",roles);

        String token=LoginPage.loginWithValidCredentials(role);

        response=given()
                .contentType(ContentType.JSON).and()
                .body(putBody).headers("Authorization",token)
                .pathParam("id",ıd)
                .when().put("/users/{id}").prettyPeek();
        response.prettyPrint();

    }
    public void verify(){
        assertEquals(204,response.statusCode());
    }



}
