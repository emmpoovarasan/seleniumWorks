package test.keyworddriven;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class TestSuiteRunner extends TestCase {
public static Test testSuite(){
	TestSuite suite = new TestSuite();
	suite.addTestSuite(TestHomePage.class);
	suite.addTestSuite(TestLogin.class);
	return suite;
}
/*public static void main(String[] args){
	TestRunner.runAndWait(testSuite());
}*/
@org.junit.Test
public void testRuns(){
	//TestRunner.runAndWait(testSuite());
	TestRunner.run(testSuite());
}
}
