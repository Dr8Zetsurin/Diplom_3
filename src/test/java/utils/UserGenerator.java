package utils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;

public class UserGenerator {
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api";
    
    public static String createUser(String email, String password, String name) {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("email", email);
        requestBody.put("password", password);
        requestBody.put("name", name);
            
        Response response = given()
            .header("Content-type", "application/json")
            .body(requestBody)
            .post(BASE_URL + "/auth/register");
            
        return response.path("accessToken");
    }
    
    public static void deleteUser(String token) {
        if (token != null) {
            given()
                .header("Authorization", token)
                .delete(BASE_URL + "/auth/user");
        }
    }
}