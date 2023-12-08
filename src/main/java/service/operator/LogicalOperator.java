package service.operator;

public enum LogicalOperator {
    AND("and"),
    OR("or"),
    NOT("not");

    private final String key;

    LogicalOperator(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static LogicalOperator fromKey(String key) {
        for (LogicalOperator operator : LogicalOperator.values()) {
            if (operator.getKey().equalsIgnoreCase(key)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("No such operator with key: " + key);
    }
}
