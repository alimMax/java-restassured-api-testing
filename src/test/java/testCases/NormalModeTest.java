package testCases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import helpers.PropertiesHelper;
import helpers.RequestHelper;
import models.Info;
import models.InfoResponse;
import models.TargetId;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import utils.BaseClass;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NormalModeTest extends BaseClass {
    final String AGENTCODE = PropertiesHelper.getAgentIdNormal();

    RequestHelper request = new RequestHelper(AGENTCODE);
    ObjectMapper objectMapper = new ObjectMapper();
    Faker faker = new Faker(new Locale("ru-RU"));
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public NormalModeTest() throws IOException {
    }

    @Test
    public void createValidData() throws JsonProcessingException {
        Info infoBody = new Info();

        // creating new data
        TargetId targetId = request.sendData(objectMapper.writeValueAsString(infoBody))
            .then()
                .log().ifError()
                .assertThat().statusCode(200)
                .body(is(not(empty())))
                .extract().as(TargetId.class);

        // get created data
        InfoResponse infoResponse = request.getData(objectMapper.writeValueAsString(targetId))
            .then()
                .assertThat().statusCode(200)
                .extract().as(InfoResponse.class);

        InfoResponse infoToCompare = new InfoResponse(
                targetId.targetId,
                infoBody.name,
                infoBody.surname,
                infoBody.birthdate,
                infoBody.street,
                infoBody.house,
                infoBody.flat,
                infoBody.balance,
                infoBody.bankAccount,
                infoBody.passport,
                infoBody.idCard,
                infoBody.carNo,
                infoBody.postNo,
                infoBody.passportIssue
        );

        // comparing two objects
        assertThat(infoResponse, samePropertyValuesAs(infoToCompare));
    }

    @Test
    public void dataWithInvalidField() throws JsonProcessingException {
        Info invalidData = new Info(
                faker.name().firstName(),
                faker.name().lastName(),
                sdf.format(faker.date().birthday()),
                faker.address().streetName(),
                faker.address().buildingNumber(),
                faker.numerify("##"),
                faker.commerce().price(),
                "this is the incorrect filed",
                faker.numerify("##########"),
                faker.numerify("#########"),
                faker.numerify("Т###АР##"),
                faker.numerify("###-###"),
                sdf.format(faker.date().past(5, TimeUnit.DAYS))
        );

        // creating new data
        request.sendData(objectMapper.writeValueAsString(invalidData))
            .then()
                .log().ifError()
                // well, the specifics of the app :)
                .assertThat().statusCode(200)
                .body(is("ERROR=Неправильно заполнено поле BANK_ACCOUNT"));
    }

    @Test
    public void fixField() {
        request.fixField("PASSPORT_ISSUE")
            .then()
                .assertThat().statusCode(200)
                .body(is("FIXED: Эта ошибка исправлена"));
    }
}
