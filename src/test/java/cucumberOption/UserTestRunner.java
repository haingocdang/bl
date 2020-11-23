package cucumberOption;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features="src/test/resources/user",
	glue="user.stepDefinations",
	monochrome=true,
	dryRun = false,
	plugin= {"pretty",
			"html:target/site/cucumber-report-default",
			"json:target/site/cucumber.json"},
	snippets=SnippetType.CAMELCASE,
	tags= {"@user_login"})
public class UserTestRunner {
	
}