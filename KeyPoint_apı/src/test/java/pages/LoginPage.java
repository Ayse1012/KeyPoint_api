package pages;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import utilities.ConfigurationReader;
import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Map;

public class LoginPage {

   static Response response;
   static String expectedRole="";

   static public String loginWithValidCredentials(String role){
       String email="";
       expectedRole=role;
       String password= ConfigurationReader.get("password");
       String iamPort=ConfigurationReader.get("iamPort");
       String baseURILogin=ConfigurationReader.get("baseURI");

       switch (role){
           case "SUPER_ADMIN" :
               email=ConfigurationReader.get("superAdminEmail");
               break;
           case "MODERATOR" :
               email=ConfigurationReader.get("moderatorEmail");
               break;
           case "EDİTOR" :
               email=ConfigurationReader.get("editorEmail");
               break;
           case "EXPERT" :
               email=ConfigurationReader.get("expertEmail");
               break;
           case "SCHOOL_ADMIN" :
               email=ConfigurationReader.get("schoolAdminEmail");
               break;
           case "TEACHER" :
               email=ConfigurationReader.get("teacherEmail");
               break;
           case "STUDENT" :
               email=ConfigurationReader.get("studentEmail");
               break;

       }
        Map<String,Object> loginBody=new HashMap<>();
       loginBody.put("email",email);
       loginBody.put("password",password);

       response=given().contentType(ContentType.JSON).body(loginBody).log().all().
               when().post(baseURILogin+iamPort+"/auth/login").prettyPeek();

       String token="Bearer "+ response.jsonPath().getString("data.token");

       System.out.println("token = " + token);

       return token;

    }
    public void verifyUserLogin(){
        String actualRole=response.jsonPath().getString("data.roles[0]");
        assertEquals(response.statusCode(),200);
        assertEquals(expectedRole,actualRole);

    }

   /* public static String token(String role){
        loginWithValidCredentials(role);
       String token="Bearer "+ response.jsonPath().getString("data.token");

        return token;
    }*/

}
