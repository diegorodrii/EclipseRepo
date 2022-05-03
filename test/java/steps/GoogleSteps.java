package steps;

import cucumber.api.java.en.*;
import pages.GooglePage;

public class GoogleSteps {
    
    GooglePage google = new GooglePage();

    @Given("^I am on the Google search page$")
    public void navigateGoogle(){
        google.navigateToGoogle();
        google.clickAcceptCookies();
    } 

    @And("^I accept cookies$")
    public void clickCookies(){
        google.clickAcceptCookies();
    } 


    @When("^I enter a search criteria$")
    public void clickSearchCriteria(){
        google.enterSearchCriteria("Córdoba");

    } 

    @And("^click on the search button$")
    public void clickSearchButton(){
        google.clickGoogleSearch();

    } 

}
