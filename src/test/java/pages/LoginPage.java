package pages;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import utilities.ConfigurationReader;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoginPage {

   static Response response;
   static String expectedRole="";
   static String iamPort=ConfigurationReader.get("iamPort");
   static String baseURILogin=ConfigurationReader.get("baseURI");
   static String password= ConfigurationReader.get("password");
   static public String loginWithValidCredentials(String role){
       String email="";
       expectedRole=role;

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

      //  assertEquals(expectedRole,actualRole);

    }
    public void loginAll(){

        ArrayList<String> usersEmail=new ArrayList<>();

        usersEmail.add("superadmin@example.com");
        usersEmail.add("moderator@example.com");
        usersEmail.add("editor@example.com");
        usersEmail.add("expert@example.com");
        usersEmail.add("schooladmin@example.com");
        usersEmail.add("teacher@example.com");
        usersEmail.add("student@example.com");

        Map<String,Object> credentials=new HashMap<>();

        for (int i = 0; i <usersEmail.size(); i++) {

            credentials.put("email",usersEmail.get(i));
            credentials.put("password",password);
            response=given().contentType(ContentType.JSON).body(credentials).log().all()
                    .when().post(baseURILogin+iamPort+"/auth/login").prettyPeek();

        }

    }

}
