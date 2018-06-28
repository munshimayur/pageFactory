package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;



@CucumberOptions(
		
		features= {"feature"},
		glue= {"stepDefinition"},
		plugin= {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json", "junit:target/cucumber.xml"},
		dryRun=false,
		monochrome=true,
		tags= {"@q2"},
		strict=false
		
				
		)

public class TestRunner extends AbstractTestNGCucumberTests{
	



}

