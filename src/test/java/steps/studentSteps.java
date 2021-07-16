package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.junit.Assert.assertEquals;

public class studentSteps {
    private Response response;

    @When("I check the details of student {int}")
    public void i_check_the_details_of_student(Integer studentId) {
        RestAssured.baseURI = "https://it-foundations.app.ap.assurity.cloud/";
        response = RestAssured.get("people/" + studentId);
        System.out.println(response.asPrettyString());
        String firstName = response.path("firstName");
        System.out.println(firstName);
    }

    @Then("I can see that their name is {string}")
    public void i_can_see_that_their_name_is(String name) {
        String response_FirstName = response.path("firstName");
        String response_LastName = response.path("lastName");
        assertEquals(response_FirstName + " " + response_LastName, name);
    }

    @Then("they have a {string} from {string}")
    public void they_have_a_from(String degree, String school) {
        String response_Degree = response.path("degree");
        String response_School = response.path("university");
        assertEquals(response_Degree + " from " + response_School, degree + " from " + school);
    }
}
