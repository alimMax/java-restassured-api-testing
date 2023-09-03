package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;

import java.util.Locale;

public class ID {
    @JsonProperty("SNILS")
    public String snils;
    @JsonProperty("PASSPORT")
    public String passport;

    public ID() {
        Faker faker = new Faker(new Locale("ru-RU"));

        snils = faker.numerify("###-###-### ##");
        passport = faker.numerify("##########");
    }

    public ID(String snils, String passport) {
        this.snils = snils;
        this.passport = passport;
    }
}
