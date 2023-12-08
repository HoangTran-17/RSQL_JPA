package service.operator;

public enum ComparisonOperator {
    EQUALS("eq"),
    NOT_EQ("ne"),
    GREATER_THAN("gt"),
    LESS_THAN("lt");

    private final String key;

    ComparisonOperator(String key) {
        this.key = key;
    }
    public String getKey() {
        return key;
    }

    public static ComparisonOperator fromKey(String key) {
        for (ComparisonOperator operator : ComparisonOperator.values()) {
            if (operator.getKey().equalsIgnoreCase(key)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("No such operator with key: " + key);
    }
}
