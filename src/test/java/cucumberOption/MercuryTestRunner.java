package cucumberOption;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import utils.excelutils.FeatureOverright;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/chucnang",
        glue = "stepDefinations",
        monochrome=true,
        dryRun = false,
        plugin= {"pretty",
                "html:target/site/cucumber-report-default",
                "json:target/site/cucumber.json"},
        snippets = SnippetType.CAMELCASE,
        tags = {"@Vo_Hieu_Chuc_Nang"})
public class MercuryTestRunner {
    /*
     * @Before public static void test() throws InvalidFormatException, IOException
     * { FeatureOverright.overrideFeatureFiles(System.getProperty("user.dir")+
     * "/src/test/resources/chucnang"); }
     */
}
