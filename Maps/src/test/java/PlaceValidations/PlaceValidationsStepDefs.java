package PlaceValidations;

import actors.BuildData;
import actors.ResourceAPI;
import actors.Utils;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PlaceValidationsStepDefs extends Utils {
    private static Response response;
    private static String place_id;
    final BuildData tdb = new BuildData();
    private RequestSpecification reqSpec;

    @Given("a payload with {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void providePayloadParameters(String name, String language, String address, String strAccuracy, String phone_num, String strLatitude, String strLongitude) throws IOException {
        int accuracy = Integer.parseInt(strAccuracy);
        double latitude = Double.parseDouble(strLatitude);
        double longitude = Double.parseDouble(strLongitude);
        reqSpec = given().spec(requestSpecification())
                .body(tdb.addPlacePayload(name, language, address, accuracy, phone_num, latitude, longitude));
    }

    @When("user calls {string} with {string} http request")
    public void apiCall(String api, String request) {
        ResourceAPI resourceAPI = ResourceAPI.valueOf(request);
        if (api.equalsIgnoreCase("POST"))
            response = reqSpec.when().post(resourceAPI.getResource());
        else if (api.equalsIgnoreCase("GET"))
            response = reqSpec.when().get(resourceAPI.getResource());
        else if (api.equalsIgnoreCase("DELETE"))
            response = reqSpec.when().delete(resourceAPI.getResource());
    }

    @Then("the API call is {string} with {string}")
    public void getApiResponse(String status, String strResponseCode) {
        int responseCode = Integer.parseInt(strResponseCode);
        assertEquals(response.getStatusCode(), responseCode);
    }

    @And("the {string} in the response body is {string}")
    public void verifyKeysInResponse(String key, String value) {
        assertEquals(getJsonPath(response, key), value);
    }

    @And("the place_id in the response body maps to {string} from {string}")
    public void verifyPlaceId(String expectedName, String request) throws IOException {
        place_id = getJsonPath(response, "place_id");
        reqSpec = given().spec(requestSpecification()).queryParam("place_id", place_id);
        apiCall("GET", request);
        String actualName = getJsonPath(response, "name");
        assertEquals(expectedName, actualName);


    }
}
