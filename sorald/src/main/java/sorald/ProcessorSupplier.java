package sorald;

import java.util.Collection;
import sorald.processor.SoraldAbstractProcessor;

public interface ProcessorSupplier {

    /**
     * Get a processor for the given rule.
     *
     * @param rule The rule to get a processor for.
     * @return A processor for the given rule.
     */
    Class<? extends SoraldAbstractProcessor<?>> getProcessor(String rule);

    Collection<Class<? extends SoraldAbstractProcessor<?>>> getAllProcessors();
}
