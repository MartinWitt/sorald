package sorald.sonar;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.kohsuke.MetaInfServices;
import sorald.ProcessorSupplier;
import sorald.processor.ArrayHashCodeAndToStringProcessor;
import sorald.processor.BigDecimalDoubleConstructorProcessor;
import sorald.processor.CastArithmeticOperandProcessor;
import sorald.processor.CollectionIsEmptyProcessor;
import sorald.processor.CollectionsEmptyConstantsProcessor;
import sorald.processor.CompareStringsBoxedTypesWithEqualsProcessor;
import sorald.processor.CompareToReturnValueProcessor;
import sorald.processor.DeadStoreProcessor;
import sorald.processor.EqualsArgumentTypeProcessor;
import sorald.processor.EqualsOnAtomicClassProcessor;
import sorald.processor.GetClassLoaderProcessor;
import sorald.processor.InterruptedExceptionProcessor;
import sorald.processor.IteratorNextExceptionProcessor;
import sorald.processor.MathOnFloatProcessor;
import sorald.processor.PublicStaticFieldShouldBeFinalProcessor;
import sorald.processor.SelfAssignementProcessor;
import sorald.processor.SerialVersionUidProcessor;
import sorald.processor.SerializableFieldInSerializableClassProcessor;
import sorald.processor.SoraldAbstractProcessor;
import sorald.processor.StringLiteralInsideEqualsProcessor;
import sorald.processor.SynchronizationOnGetClassProcessor;
import sorald.processor.SynchronizationOnStringOrBoxedProcessor;
import sorald.processor.ThreadLocalWithInitial;
import sorald.processor.ThreadRunProcessor;
import sorald.processor.ToStringReturningNullProcessor;
import sorald.processor.UnclosedResourcesProcessor;
import sorald.processor.UnusedLocalVariableProcessor;
import sorald.processor.UnusedPrivateFieldProcessor;
import sorald.processor.UnusedThrowableProcessor;
import sorald.processor.UtilityClassWithPublicConstructorProcessor;
import sorald.processor.XxeProcessingProcessor;

@MetaInfServices(ProcessorSupplier.class)
public class SonarProcessorSupplier implements ProcessorSupplier {

    private static final Map<String, Class<? extends SoraldAbstractProcessor<?>>>
            RULE_KEY_TO_PROCESSOR =
                    new HashMap<>() {
                        {
                            put("S1068", UnusedPrivateFieldProcessor.class);
                            put("S1118", UtilityClassWithPublicConstructorProcessor.class);
                            put("S1132", StringLiteralInsideEqualsProcessor.class);
                            put("S1155", CollectionIsEmptyProcessor.class);
                            put("S1217", ThreadRunProcessor.class);
                            put("S1444", PublicStaticFieldShouldBeFinalProcessor.class);
                            put("S1481", UnusedLocalVariableProcessor.class);
                            put("S1596", CollectionsEmptyConstantsProcessor.class);
                            put("S1656", SelfAssignementProcessor.class);
                            put("S1854", DeadStoreProcessor.class);
                            put("S1860", SynchronizationOnStringOrBoxedProcessor.class);
                            put("S1948", SerializableFieldInSerializableClassProcessor.class);
                            put("S2057", SerialVersionUidProcessor.class);
                            put("S2095", UnclosedResourcesProcessor.class);
                            put("S2097", EqualsArgumentTypeProcessor.class);
                            put("S2111", BigDecimalDoubleConstructorProcessor.class);
                            put("S2116", ArrayHashCodeAndToStringProcessor.class);
                            put("S2142", InterruptedExceptionProcessor.class);
                            put("S2164", MathOnFloatProcessor.class);
                            put("S2167", CompareToReturnValueProcessor.class);
                            put("S2184", CastArithmeticOperandProcessor.class);
                            put("S2204", EqualsOnAtomicClassProcessor.class);
                            put("S2225", ToStringReturningNullProcessor.class);
                            put("S2272", IteratorNextExceptionProcessor.class);
                            put("S2755", XxeProcessingProcessor.class);
                            put("S3032", GetClassLoaderProcessor.class);
                            put("S3067", SynchronizationOnGetClassProcessor.class);
                            put("S3984", UnusedThrowableProcessor.class);
                            put("S4065", ThreadLocalWithInitial.class);
                            put("S4973", CompareStringsBoxedTypesWithEqualsProcessor.class);
                        }
                    };

    @Override
    public Class<? extends SoraldAbstractProcessor<?>> getProcessor(String ruleKey) {
        return RULE_KEY_TO_PROCESSOR.get(ruleKey);
    }

    @Override
    public Collection<Class<? extends SoraldAbstractProcessor<?>>> getAllProcessors() {
        return RULE_KEY_TO_PROCESSOR.values().stream()
                .sorted(Comparator.comparing(Class::getName))
                .collect(Collectors.toList());
    }
}
