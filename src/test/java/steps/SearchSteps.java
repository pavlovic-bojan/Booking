package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Reporter;
import pages.SearchHomePage;
import tests.BaseTest;

public class SearchSteps extends BaseTest {

    String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
    String wait = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("wait");
    String quit = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("quit");
    String env = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("env");


    @Before
    public void setup() throws Exception {
        init(browser, wait);

    }

    @After
    public void tearDown() {
        if (quit.equalsIgnoreCase("Yes")) {
            quit();
        }
    }

    @Given("I am on the booking home page")
    public void i_am_on_the_booking_home_page() throws Exception {
        openApp(env);
        new SearchHomePage(driver).clickXOnPopUp();
    }

    @When("I enter my desired destination {string}")
    public void i_enter_my_desired_destination(String destination) throws Exception {
        new SearchHomePage(driver).enterDestination(destination);
    }

    @And("Choose the duration of the stay")
    public void choose_the_duration_of_the_stay() throws Exception {
        SearchHomePage searchHomePage = new SearchHomePage(driver);
        searchHomePage.clickSearchDate();
        searchHomePage.clickStartDate();
        searchHomePage.clickFinishDate();
        searchHomePage.clickSearchDate();
    }

    @And("Choose number of guests and rooms")
    public void choose_number_of_guests_and_rooms() throws Exception {
        SearchHomePage searchHomePage = new SearchHomePage(driver);
        searchHomePage.clickNumberGuestsRooms();
        searchHomePage.clickIncreaseGuests();
        searchHomePage.clickIncreaseRoom();
        //searchHomePage.clickButtonOk();
    }

    @And("Click Search")
    public void click_search() throws Exception {
        SearchHomePage searchHomePage = new SearchHomePage(driver);
        searchHomePage.clickButtonSearch();
    }

    @Then("Verify that the search results are displayed")
    public void verify_that_the_search_results_are_displayed() {
        SearchHomePage searchHomePage = new SearchHomePage(driver);
        searchHomePage.searchResultsShouldBeVisible();
    }
}
