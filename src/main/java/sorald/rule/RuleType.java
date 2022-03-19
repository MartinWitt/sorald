package sorald.rule;

/** Enumeration of Sonar rule types */
public enum RuleType implements IRuleType {
    BUG,
    VULNERABILITY,
    CODE_SMELL,
    SECURITY_HOTSPOT;

    @Override
    public String getRuleType() {
        return toString();
    }
}
