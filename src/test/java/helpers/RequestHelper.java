package helpers;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RequestHelper {
    String agentId;

    public RequestHelper(String agentId) {
        this.agentId = agentId;
    }

    // new data creation request
    public Response sendData(String body) {
        return RestAssured.given()
                .header("agent", agentId)
                .header("Content-Type", "application/json")
                .body(body)
            .when()
                .post("/send");
    }

    // get data request
    public Response getData(String body) {
        return RestAssured.given()
                .header("agent", agentId)
                .header("Content-Type", "application/json")
                .body(body)
            .when()
                .post("/receive");
    }

    // fix field request
    public Response fixField(String field) {
        return RestAssured.given()
                .header("agent", agentId)
                .header("field", field)
            .when()
                .get("/fix");
    }
}
