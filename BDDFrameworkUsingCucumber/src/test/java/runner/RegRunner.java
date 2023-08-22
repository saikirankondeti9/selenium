package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(glue="steps",
dryRun = true,tags = "@ramse",
stepNotifications=true,
features= //{"src\\test\\resources\\features\\regression\\validatelogin.feature",})
{"src\\test\\resources\\features\\regression\\ValidateRegisterUsingHeaders.feature"})
public class RegRunner {

}
