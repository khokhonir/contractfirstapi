package io.swagger.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ToDoTests {

    @LocalServerPort
    int port;

    @Test
    public void testErrorPostTodo() {
        given().port(port)
                .contentType("application/json")
                .when().body("{\n  \"id\" : \"abc123\",\n  \"name\" : \"I'm lazy\",\n  \"completed\" : true\n}")
                .post("/todos")
                .then().statusCode(501);
    }

}
