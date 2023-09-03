package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InfoResponse {
    @JsonProperty("TARGETID")
    public String targetId;
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

    public InfoResponse() {}

    public InfoResponse(
            String targetId,
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
        this.targetId = targetId;
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
