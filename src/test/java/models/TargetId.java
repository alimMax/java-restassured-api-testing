package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TargetId {
    @JsonProperty("TARGET_ID")
    public String targetId;

    public TargetId() {}

    public TargetId(String targetId) {
        this.targetId = targetId;
    }
}
