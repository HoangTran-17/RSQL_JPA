package service;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum QueryOperator {
    GREATER_THAN("gt"),
    LESS_THAN("lt"),
    EQUALS("eq"),
    NOT_EQ("ne"),
    IN("in");

    private final String key;

    QueryOperator(String key) {
        this.key = key;
    }
}
