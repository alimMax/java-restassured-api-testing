package testCases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import helpers.PropertiesHelper;
import helpers.RequestHelper;
import models.ID;
import models.InfoResponse;
import models.TargetId;
import org.junit.jupiter.api.Test;
import utils.BaseClass;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

public class EzModeTest extends BaseClass {
    final String AGENTCODE = PropertiesHelper.getAgentIdEasy();

    RequestHelper request = new RequestHelper(AGENTCODE);
    ObjectMapper objectMapper = new ObjectMapper();

    public EzModeTest() throws IOException {
    }

    @Test
    public void sendId() throws JsonProcessingException {
        ID idBody = new ID();

        // creating new data
        TargetId targetId = request.sendData(objectMapper.writeValueAsString(idBody))
            .then()
                .log().ifError()
                .assertThat().statusCode(200)
                .body(is(not(empty())))
                .extract().as(TargetId.class);

        // get created data
        InfoResponse idResponse = request.getData(objectMapper.writeValueAsString(targetId))
                .then()
                .assertThat().statusCode(200)
                .extract().as(InfoResponse.class);

        // comparing two objects
        assertThat(idResponse, samePropertyValuesAs(idBody));
    }

    @Test
    public void fixField() {
        request.fixField("SNILS")
            .then()
                .log().ifError()
                .assertThat().statusCode(200)
                .body(is("FIXED: Эта ошибка исправлена"));
    }
}
