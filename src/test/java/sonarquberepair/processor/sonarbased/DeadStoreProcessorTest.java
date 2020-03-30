package sonarquberepair.processor.sonarbased;

import org.junit.Test;
import org.sonar.java.checks.DeadStoreCheck;
import org.sonar.java.checks.verifier.JavaCheckVerifier;
import sonarquberepair.Constants;
import sonarquberepair.Main;

public class DeadStoreProcessorTest {

	@Test
	public void test() throws Exception {
		String fileName = "DeadStores.java";
		String pathToBuggyFile = Constants.PATH_TO_FILE + fileName;
		String pathToRepairedFile = "./spooned/" + fileName;

		JavaCheckVerifier.verify(pathToBuggyFile, new DeadStoreCheck());
		Main.repair(pathToBuggyFile, Constants.PROJECT_KEY, 1854, false);
		JavaCheckVerifier.verifyNoIssue(pathToRepairedFile, new DeadStoreCheck());
	}

}
