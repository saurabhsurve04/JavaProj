package PlaceValidations;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(strict = true,features="src/test/resources/features",glue={"PlaceValidations"},tags = "@Place")
public class PlaceValidationsTest extends AbstractTestNGCucumberTests{

}
