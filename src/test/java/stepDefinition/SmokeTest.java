package stepDefinition;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import resources.CommonLibraries;

public class SmokeTest {
	
	CommonLibraries driver = new CommonLibraries();
	
	@Given("^user launch \"([^\"]*)\"$")
	public void user_launch(String browser) throws NoSuchElementException {
	    // Write code here that turns the phrase above into concrete actions
	   driver.openBrowser(browser);
	}

	@When("^user navigate to WCC URL \"([^\"]*)\"$")
	public void user_navigate_to_WCC_URL(String url) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   driver.openWebpage(url);
	}

	@When("^clicks on Term of use link$")
	public void clicks_on_Term_of_use_link() throws Throwable {
		driver.waitFor(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/div[2]/div/div/a"), 30);
	    driver.clickElement(By.xpath("//a[contains(text(),'Terms of Use')]"));
	    
	}

	@When("^clicks on hamburger icon at the top left$")
	public void clicks_on_hamburger_icon_at_the_top_left() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.switchTab(1);
		driver.waitFor(By.cssSelector("i.hamburger.icon-menu"), 30);
	    driver.clickElement(By.cssSelector("i.hamburger.icon-menu"));   
	}

	@When("^enter \"([^\"]*)\" in search field$")
	public void enter_in_search_field(String searchValue) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.waitFor(By.cssSelector("input.search-field"), 30);
	    driver.enterText(searchValue, By.cssSelector("input.search-field"));
	}

	@When("^clicks on search icon$")
	public void clicks_on_search_icon() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    driver.waitFor(By.cssSelector("i.icon-search"), 10);
	    driver.clickElement(By.cssSelector("i.icon-search"));
	}

	@When("^navigates to last page$")
	public void navigates_to_last_page() throws InterruptedException {
		 driver.waitFor(By.xpath("//a[@href='https://www.on24.com/page/9/?s=elite']"),20);
	     driver.clickElement(By.xpath("//a[@href='https://www.on24.com/page/9/?s=elite']"));
	   
	}

	@Then("^verify the \"([^\"]*)\" is present$")
	public void verify_the_is_present(String givenText) throws InterruptedException {
	    driver.waitFor(By.xpath("//a[@href='https://www.on24.com/news/on24-makes-business-webcasting-easier/']"), 30);
	    driver.sCompvalue(By.xpath("//a[@href='https://www.on24.com/news/on24-makes-business-webcasting-easier/']"), "ON24 Makes Business Webcasting Easier");
	   
	}

	@Then("^user close the browser$")
	public void user_close_the_browser() {
	       driver.closeAllBrowser();
	}
	
	@When("^verify link for \"([^\"]*)\"is present$")
	public void verify_link_for_is_present(String socialMediaLink) {
		driver.socialMedia(socialMediaLink);
		
		
	}
//------------------------------------
	@When("^enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enters_and(String invalidUsername, String invalidPassword) throws Throwable {
	driver.clearText(By.xpath("//*[@id=\"login\"]/div/div[1]/input"));
	driver.enterText(invalidUsername, By.xpath("//*[@id=\"login\"]/div/div[1]/input"));
	driver.enterText(invalidPassword, By.xpath("//*[@id=\"login\"]/div/div[2]/input"));
	   
	}

	@When("^user clicks on Login button$")
	public void user_clicks_on_Login_button() throws Throwable {
	    driver.clickElement(By.cssSelector("input.submit.btn.bg-grad-blue.round"));
	}

	@Then("^verify invalid username / password combination error shold be displayed and user should not be able to login$")
	public void verify_invalid_username_password_combination_error_shold_be_displayed_and_user_should_not_be_able_to_login() throws Throwable {
	    driver.sCompvalue(By.xpath("//*[@id=\"login\"]/div/div[4]/div[1]"), "Incorrect username/password combination.");
	   // This method will check whether we are on the same page or not
	    driver.find(By.xpath("//*[@id=\"login\"]/div/div[1]/input"));
	    driver.find(By.xpath("//*[@id=\"login\"]/div/div[2]/input"));
	}

	@When("^user enters blank username and blank password$")
	public void user_enters_blank_username_and_blank_password() throws Throwable {
		driver.clearText(By.xpath("//*[@id=\"login\"]/div/div[1]/input"));
		driver.clearText(By.xpath("//*[@id=\"login\"]/div/div[2]/input"));
	    
	}

	@When("^user enters  \"([^\"]*)\" and blank password$")
	public void user_enters_and_blank_password(String invalidUsername) throws Throwable {
		driver.clearText(By.xpath("//*[@id=\"login\"]/div/div[1]/input"));
		driver.clearText(By.xpath("//*[@id=\"login\"]/div/div[2]/input"));
		driver.enterText(invalidUsername, By.xpath("//*[@id=\"login\"]/div/div[1]/input"));
		
	   
	}

	@When("^user enters blank username and \"([^\"]*)\"$")
	public void user_enters_blank_username_and(String invalidPassword) throws Throwable {
		driver.clearText(By.xpath("//*[@id=\"login\"]/div/div[1]/input"));
		driver.clearText(By.xpath("//*[@id=\"login\"]/div/div[2]/input"));
		driver.enterText(invalidPassword, By.xpath("//*[@id=\"login\"]/div/div[2]/input"));
	}


	@Then("^verify blank username error should be displayed and user should not be able to login$")
	public void verify_blank_username_error_should_be_displayed_and_user_should_not_be_able_to_login() throws Throwable {
		 driver.sCompvalue(By.xpath("//*[@id=\"login\"]/div/div[4]/div[1]"), "Username is missing.");
		 // This method will check whether we are on the same page or not
		    driver.find(By.xpath("//*[@id=\"login\"]/div/div[1]/input"));
		    driver.find(By.xpath("//*[@id=\"login\"]/div/div[2]/input"));
	}

	@Then("^verify blank password should error should  be displayed and user should not be able to login$")
	public void verify_blank_password_should_error_should_be_displayed_and_user_should_not_be_able_to_login() throws Throwable {
	   driver.sCompvalue(By.xpath("//*[@id=\"login\"]/div/div[4]/div[1]"), "Password is missing.");
	   // This method will check whether we are on the same page or not
	    driver.find(By.xpath("//*[@id=\"login\"]/div/div[1]/input"));
	    driver.find(By.xpath("//*[@id=\"login\"]/div/div[2]/input"));
	}
	
	//---------------------------
	@When("^enters first name \"([^\"]*)\"$")
	public void enters_first_name(String firstname) throws Throwable {
		driver.waitFor(By.cssSelector("input#firstname"), 60);
		driver.enterText(firstname, By.cssSelector("input#firstname"));
	
	}

	@When("^enters last name \"([^\"]*)\"$")
	public void enters_last_name(String lastname) throws Throwable {
	   driver.enterText(lastname, By.cssSelector("input#lastname"));
	   
	}

	@When("^enters email \"([^\"]*)\"$")
	public void enters_email(String email) throws Throwable {
	    driver.enterText(email, By.cssSelector("input#email"));
	   
	}

	@When("^clicks on Producer button$")
	public void clicks_on_Producer_button() throws Throwable {
	  driver.sCompvalue(By.xpath("//*[@id=\"loginButton\"]/div"), "PRODUCER");
	  driver.clickElement((By.xpath("//*[@id=\"loginButton\"]")));
				
			}

	

	@Then("^verify Webcam window is enabled$")
	public void verify_Webcam_window_is_enabled() throws Throwable {
	  driver.waitFor(By.cssSelector("span.windowTitle.float_left"), 180);
	  driver.sCompvalue(By.cssSelector("span.windowTitle.float_left"), "Webcam");
	}


	

}
