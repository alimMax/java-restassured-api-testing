package utils;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseClass {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8000";
    }
}
