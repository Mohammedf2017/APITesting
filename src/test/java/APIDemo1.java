import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.*;


public class APIDemo1 {
    @Test
    void demoGetTest1(){
        RestAssured.given().get("https://reqres.in/api/users?page=2").then().
                statusCode(200).
                body("data[4].first_name" , equalTo("George")).
                body("data.first_name", hasItems("Michael","Byron", "Lindsay" , "Rachel")).
                log().all();
    }

    @Test
    void demoPostTest2(){
        HashMap<String , Object> map = new HashMap<>();
        map.put("name" , "John");
        map.put("job" , "Teacher");
        System.out.println(map);

        JSONObject mapToJson = new JSONObject(map);
        System.out.println(mapToJson);

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(mapToJson.toJSONString())
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201);
    }

    @Test
    void demoPut(){
        HashMap<String , Object> map = new HashMap<>();
        map.put("name" , "John");
        map.put("job" , "Teacher");
        System.out.println(map);

        JSONObject mapToJson = new JSONObject(map);
        System.out.println(mapToJson);

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(mapToJson.toJSONString())
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void demoPatch(){
        HashMap<String , Object> map = new HashMap<>();
        map.put("name" , "John");
        map.put("job" , "Teacher");
        System.out.println(map);

        JSONObject mapToJson = new JSONObject(map);
        System.out.println(mapToJson);

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(mapToJson.toJSONString())
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void demoDelete(){
        RestAssured.when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204)
                .log().all();
    }
}
