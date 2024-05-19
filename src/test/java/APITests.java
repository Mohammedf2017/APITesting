import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITests {

    @Test
    void test1(){
        Response response =  RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println();
        int statusCode = response.getStatusCode();
        String body = String.valueOf(response.getBody());
        String contentType = response.getContentType();
        String headers = String.valueOf(response.getHeaders());

        System.out.println("The Status Code is " +statusCode);
        System.out.println("The Body is " + body);
        System.out.println("The contentType is " + contentType);
        System.out.println("The Header is " + headers);
        System.out.println("==================== * ==================== * =====================");
        System.out.println("The Response is " + response.asString());

        Assert.assertEquals(statusCode , 200);
    }

    @Test
    void test2(){
        given().
                get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200);
    }
}
