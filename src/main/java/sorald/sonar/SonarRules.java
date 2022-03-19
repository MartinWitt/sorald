package sorald.sonar;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import org.kohsuke.MetaInfServices;
import sorald.rule.IRuleType;
import sorald.rule.Rule;
import sorald.rule.RuleProvider;

/** Class that knows about all Sonar rules. Should ONLY be used by {@link sorald.rule.Rules}. */
@MetaInfServices(RuleProvider.class)
public class SonarRules implements RuleProvider {
    private SonarRules() {}

    /**
     * Get all SonarJava rules.
     *
     * @return All SonarJava rules.
     */
    public Collection<Rule> getAllRules() {
        return Checks.getAllChecks().stream()
                .map(Checks::getRuleKey)
                .map(Rule::of)
                .collect(Collectors.toList());
    }

    @Override
    public Rule getRule(String key) {
        return getAllRules().stream().filter(v -> v.getKey().equals(key)).findFirst().orElse(null);
    }

    @Override
    public Collection<Rule> getRulesByType(IRuleType... types) {
        return getRulesByType(Arrays.asList(types));
    }

    @Override
    public Collection<Rule> getRulesByType(Collection<IRuleType> types) {
        return getAllRules().stream()
                .filter(v -> types.contains(v.getType()))
                .collect(Collectors.toList());
    }
}
