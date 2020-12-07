package org.sash.funqy;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@QuarkusTest
public class FunqyTest {

    @Test
    public void testSash() {
        given()
                .given().get("/sash")
                .then()
                .statusCode(200)
                .body(equalTo("\"Hello Sash\""));
    }

    @Test
    public void testLowercase() {
        given()
                .given()
                .contentType("application/json")
                .body("\"HELLO WORLD\"")
                .post("/lower")
                .then()
                .statusCode(200)
                .body(equalTo("\"hello world\""));
    }

    @Test
    public void testDouble() {
        given()
                .given()
                .contentType("application/json")
                .body("\"2\"")
                .post("/double")
                .then()
                .statusCode(200)
                .body(equalTo("4"));
    }

    @Test
    public void testGreeting() {
        given()
                .given()
                .contentType("application/json")
                .body("{\"name\": \"Moses\"}")
                .post("/greet")
                .then()
                .statusCode(200)
                .body("message", equalTo("Hello Moses"));

        given()
                .given()
                .contentType("application/json")
                .body(new Friend("John"))
                .post("/greet")
                .then()
                .statusCode(200)
                .body("message", equalTo("Hello John"));
    }

}
