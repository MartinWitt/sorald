package sonarquberepair.processor;

import org.sonar.java.checks.CompareToReturnValueCheck;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.code.CtReturn;
import spoon.reflect.code.CtLiteral;

public class CompareToReturnValueProcessor extends SQRAbstractProcessor<CtReturn<?>> {

	public CompareToReturnValueProcessor(String originalFilesPath) {
		super(originalFilesPath, new CompareToReturnValueCheck());
	}

	@Override
	public boolean isToBeProcessed(CtReturn<?> ctReturn) {
		if (!super.isToBeProcessedAccordingToSonar(ctReturn)) {
			return false;
		}
		CtMethod ctMethod = ctReturn.getParent(CtMethod.class);
		String returnTypeName = ctMethod.getType().getSimpleName();
		if (ctMethod.getSimpleName().equals("compareTo") && (returnTypeName.equals("int") || returnTypeName.equals("Integer"))
				&& ctReturn.getReturnedExpression().toString().indexOf("Integer.MIN_VALUE") != -1) {
			return true;
		}
		return false;
	}

	@Override
	public void process(CtReturn<?> ctReturn) {
		super.process(ctReturn);

		CtLiteral<?> elem2Replace = ctReturn.getFactory().createLiteral(-1);
		ctReturn.getReturnedExpression().replace(elem2Replace);
	}

}