package soap;

import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SoapXMLSchemaValidationTest {

    @Test
    public void xmlSchemaValidation() throws IOException {
        File file = new File("./SoapReq/NumberToWords.xml");
        FileInputStream fileInputStream = new FileInputStream(file);
        String reqBody = IOUtils.toString(fileInputStream , StandardCharsets.UTF_8);
        baseURI = "https://www.dataaccess.com/";

        given()
                .contentType("text/xml")
                .accept(ContentType.XML)
                .body(reqBody)
                .when()
                .post("/webservicesserver/numberconversion.wso/")
                .then()
                .statusCode(200)
                .log().all()
                .and()
                .body("//*:NumberToWordsResult.text()" , equalTo("two hundred "));
    }
}
