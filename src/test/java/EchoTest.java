import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class EchoTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGetRequestWoops() {
        given()
                .param("foo1", "bar1")
                .param("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200);
    }

    @Test
    public void testPostRequest() {
        given()
                .param("foo1", "bar1")
                .param("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .body("headers.x-forwarded-proto", equalTo("https"));
    }

    @Test
    public void testJsonResponse() {
        given()
                .post("/post")
                .then()
                .contentType(ContentType.JSON);
    }

    @Test
    public void testPatchRequest() {
        String requestText = "This is expected to be sent back as part of response body.";

        given()
                .contentType("text/plain")
                .body(requestText)
                .then()
                .body("data", equalTo(requestText))
                .body("json", nullValue());
    }

    @Test
    public void testDeleteRequest() {

        given()
                .contentType("text/plain")
                .when()
                .delete("https://postman-echo.com/delete")
                .then()
                .body("headers.host", equalTo("postman-echo.com"));
    }

    private Matcher<?> nullValue() {
        return equalTo(null); //я не знаю, что это
    }
}
