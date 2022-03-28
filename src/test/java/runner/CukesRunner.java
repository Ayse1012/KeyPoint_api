package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
       // plugin={""},
        features = {"src/test/resources/Features"},
        glue = {"stepDef"},
        dryRun = true,
        tags ="@login1"

)

public class CukesRunner {


}
