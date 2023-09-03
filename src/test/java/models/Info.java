package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Info {
    @JsonProperty("NAME")
    public String name;
    @JsonProperty("SURNAME")
    public String surname;
    @JsonProperty("BIRTHDATE")
    public String birthdate;
    @JsonProperty("STREET")
    public String street;
    @JsonProperty("HOUSE")
    public String house;
    @JsonProperty("FLAT")
    public String flat;
    @JsonProperty("BALANCE")
    public String balance;
    @JsonProperty("BANK_ACCOUNT")
    public String bankAccount;
    @JsonProperty("PASSPORT")
    public String passport;
    @JsonProperty("ID_CARD")
    public String idCard;
    @JsonProperty("CAR_NO")
    public String carNo;
    @JsonProperty("POST_NO")
    public String postNo;
    @JsonProperty("PASSPORT_ISSUE")
    public String passportIssue;

    public Info() {
        Faker faker = new Faker(new Locale("ru-RU"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        name = faker.name().firstName();
        surname = faker.name().lastName();
        birthdate = sdf.format(faker.date().birthday());
        street = faker.address().streetName();
        house = faker.address().buildingNumber();
        flat = faker.numerify("##");
        balance = faker.commerce().price();
        bankAccount = faker.numerify("##########");
        passport = faker.numerify("##########");
        idCard = faker.numerify("#########");
        carNo = faker.numerify("Т###АР##");
        postNo = faker.numerify("###-###");
        passportIssue = sdf.format(faker.date().past(5, TimeUnit.DAYS));
    }

    public Info(
            String name,
            String surname,
            String birthdate,
            String street,
            String house,
            String flat,
            String balance,
            String bankAccount,
            String passport,
            String idCard,
            String carNo,
            String postNo,
            String passportIssue
            ) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.balance = balance;
        this.bankAccount = bankAccount;
        this.passport = passport;
        this.idCard = idCard;
        this.carNo = carNo;
        this.postNo = postNo;
        this.passportIssue = passportIssue;
    }
}
