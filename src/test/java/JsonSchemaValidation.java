import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class JsonSchemaValidation {
    @Test
    void demoGetTest1(){
        RestAssured.given().get("https://reqres.in/api/users?page=2")
                .then()
                .assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
                .statusCode(200)
                .body("data[4].first_name" , equalTo("George"))
                .body("data.first_name", hasItems("Michael","Byron", "Lindsay" , "Rachel"))
                .log().all();
    }
}
