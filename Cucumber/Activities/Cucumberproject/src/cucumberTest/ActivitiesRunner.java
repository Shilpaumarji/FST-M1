package cucumberTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/*@RunWith(Cucumber.class)
	@CucumberOptions(
	    features = "Features",
	    glue = {"stepDefinitions"},
	    tags = "@activity1_1"
	)*/

/*@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@activity1_2"
)*/

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@activity1_3"
  )


	public class ActivitiesRunner {
     }

