package sonarquberepair.processor.spoonbased;

import org.junit.Test;
import org.sonar.java.checks.BigDecimalDoubleConstructorCheck;
import org.sonar.java.checks.verifier.JavaCheckVerifier;
import sonarquberepair.Constants;
import sonarquberepair.Main;
import sonarquberepair.TestHelper;

public class BigDecimalDoubleConstructorProcessorTest {

	@Test
	public void test() throws Exception {
		String fileName = "BigDecimalDoubleConstructor.java";
		String pathToBuggyFile = Constants.PATH_TO_FILE + fileName;
		String pathToRepairedFile = "./spooned/" + fileName;

		JavaCheckVerifier.verify(pathToBuggyFile, new BigDecimalDoubleConstructorCheck());
		Main.repair(pathToBuggyFile, Constants.PROJECT_KEY, 2111, true);
		TestHelper.removeComplianceComments(pathToRepairedFile);
		JavaCheckVerifier.verifyNoIssue(pathToRepairedFile, new BigDecimalDoubleConstructorCheck());
	}

}
