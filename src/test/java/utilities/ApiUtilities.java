package utilities;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.response.Response.*;

import java.util.HashMap;
import java.util.Map;

public class ApiUtilities {

    /**
     * get access token method to create token for all users
     * @param role
     * @return
     * //
     */

    public static Map<String,Object> getAccessToken(String role){

        String email="";
        String password=ConfigurationReader.get("password");
        String baseURI=ConfigurationReader.get("baseURI");
        String iamPort= ConfigurationReader.get("iamPort");
        String endPointToken="/auth/login";

        switch (role){
            case "SUPER_ADMIN":
                email= ConfigurationReader.get("superAdminEmail");
                break;
            case "EDITOR":
                email=ConfigurationReader.get("editorEmail");
                break;
            case "MODERATOR":
                email=ConfigurationReader.get("moderatorEmail");
                break;
            case "EXPERT":
                email=ConfigurationReader.get("expertEmail");
                break;
            case "SCHOOL_ADMIN":
                email=ConfigurationReader.get("schoolAdminEmail");
                break;
            case "SALESMAN":
                email=ConfigurationReader.get("salesmanEmail");
                break;
            case "STUDENT":
                email=ConfigurationReader.get("studentEmail");
                break;
        }

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("email", email);
        requestMap.put("password", password);


      Response response=given().contentType(ContentType.JSON).log().all()
                .body(requestMap).when().post(baseURI+iamPort+endPointToken).prettyPeek();

        String token = response.path("data.token");

        String finalToken = "Bearer "+ token;
        System.out.println("finalToken = " + finalToken);

        Map<String,Object> authorization=new HashMap<>();
        authorization.put("Authorization",finalToken);

        return authorization;

    }











}
