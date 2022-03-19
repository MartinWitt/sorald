package sorald.rule;

import java.util.Collection;

public interface RuleProvider {

    Rule getRule(String key);

    Collection<Rule> getAllRules();

    /**
     * Get all rules matching one of the given types.
     *
     * @param types Types to filter rules by.
     * @return All rules with any of the given types.
     */
    public Collection<Rule> getRulesByType(IRuleType... types);

    /**
     * Get all rules matching one of the given types.
     *
     * @param types Types to filter rules by.
     * @return All rules with any of the given types.
     */
    public Collection<Rule> getRulesByType(Collection<IRuleType> types);
}
