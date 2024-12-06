package utils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserGenerator {
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api";
    
    public static String createUser(String email, String password, String name) {
        String json = String.format("{\"email\":\"%s\",\"password\":\"%s\",\"name\":\"%s\"}", 
            email, password, name);
            
        Response response = given()
            .header("Content-type", "application/json")
            .body(json)
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