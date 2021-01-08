package commons;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import cucumber.api.PendingException;
import junit.framework.AssertionFailedError;
import org.apache.commons.logging.Log;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertionError;
import org.assertj.core.api.SoftAssertionsProvider;
import org.junit.Assert;
import org.assertj.core.api.SoftAssertions;
import org.junit.internal.Throwables;
import org.junit.runner.Description;
//import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import static org.assertj.core.api.Assertions.*;


import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import net.masterthought.cucumber.ReportResult;
import gherkin.formatter.model.Result;
import org.junit.internal.runners.model.EachTestNotifier;

import static commons.Logger.log;

public class VerifyHelper {

    //private Object thow;
    EachTestNotifier stepNotifier;
    EachTestNotifier executionUnitNotifier;
    private boolean failedStep;
    private boolean ignoredStep;
    Failure failure;

    public static VerifyHelper getData() {
        return new VerifyHelper();

    }

    private boolean checkTrue(boolean condition) {
        boolean pass = true;

        try {
            if (condition == true) {
                log.info(" -------------------------- PASSED -------------------------- ");
            } else {
                log.info(" -------------------------- FAILED -------------------------- ");
            }
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            e.printStackTrace();
            pass = false;
        }
        return pass;
    }

    public boolean verifyTrue(boolean condition) {
        return checkTrue(condition);
    }

    private boolean checkFailed(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            pass = false;
        }
        return pass;
    }

    public boolean verifyFalse(boolean condition) {
        return checkFailed(condition);
    }

    private boolean checkEquals(Object actual, Object expected) {
        boolean pass = true;
        Result result = null;
        SoftAssertions sa = new SoftAssertions();
      //  Description description = executionUnitRunner.describeChild(runnerStep);
       // stepNotifier = new EachTestNotifier(runNotifier, description);
        try {
            //Assert.assertEquals(actual, expected);
            sa.assertThat(actual).isEqualTo(expected);
            sa.assertAll();

        } catch (Throwable e) {
            /*if (e == null) {
                e = new PendingException();
            }
            failedStep = true;
            stepNotifier.addFailure(e);
            executionUnitNotifier.addFailure(e);*/
           // System.out.println("Failed at " +failure.getDescription().getMethodName());
            pass = false;
        }
        return pass;
    }

    public boolean verifyEquals(Object actual, Object expected) {
        return checkEquals(actual, expected);
    }


}