import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testData.APITestsdata;


public class DataDrivenTests extends APITestsdata {


    @Test(dataProvider = "DataForPost")
    void demoPostTest2(String name , int userID){

        JSONObject req = new JSONObject();
        req.put("name" , name);
        req.put("subjectId" , userID);

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(req.toJSONString())
                .when()
                .post("http://localhost:3000/users")
                .then()
                .statusCode(201);
    }

    @Test(dataProvider =  "DataForDelete")
    void demoDelete(int subjectId){
        System.out.println("subjectId is " + subjectId);
        RestAssured.when()
                .delete("http://localhost:3000/users/" + subjectId)
                .then()
                .statusCode(200)
                .log().all();
    }
}
