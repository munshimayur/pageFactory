package resources;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.session.FirefoxFilter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonLibraries {
	
	static WebDriver driver;
	Select oSelect;
	DateFormat dateFormat = new SimpleDateFormat("HH:mm a");

	public void openBrowser(String Browser) {
		
		if (Browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
			driver = new FirefoxDriver();

		}
		
		else if ((Browser.equalsIgnoreCase("Chrome")|| Browser.equalsIgnoreCase("Google Chrome"))){
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		}
		
		else {
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		
		}
	}
	
	public void openWebpage(String URL) {
		driver.get(URL);
	}
	
	public void waitFor(By Locator, int sec) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
				
	}
	
	public void enterText(String text, By Locator) {
		driver.findElement(Locator).sendKeys(text);;
		
	}
	
	public void clickElement (By Locator) {
		driver.findElement(Locator).click();
	}
	
	public void closeCurrentBrowser(){
		driver.close();
	}
	
	public void closeAllBrowser() {
		driver.quit();
	}
	
	public WebElement find (By Locator) {
		return driver.findElement(Locator);
	}
	
	public void ddSelect(By Locator, String Option) {
		oSelect = new Select(find(Locator));
		oSelect.selectByVisibleText(Option);
		java.util.List<WebElement> elementList = oSelect.getOptions();
		
	}
	
	public void ddCount(By Locator, String Option) {
		oSelect = new Select(find(Locator));
		java.util.List<WebElement> elementList = oSelect.getOptions();
		System.out.println(elementList.size());
				
	}
	
	public void ddPrint (By Locator) {
		oSelect = new Select(find(Locator));
		java.util.List<WebElement> elementList = oSelect.getOptions();
		int iSize = elementList.size();
		
		for(int i =0; i<iSize ; i++){
			String sValue = elementList.get(i).getText();
			System.out.println(sValue);
		}
	}
	
	public void dateSelect(By calenderLocator, By Date) {
		clickElement(calenderLocator);
		clickElement(Date);
				
	}
	
	public void enterTime(By textbox) {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, 10);
		String newTime = dateFormat.format(cal.getTime());
		enterText(newTime, textbox);
		
	}
	
	public void clearText(By Locator){
		driver.findElement(Locator).clear();
		
	}
	

	public void tab(By Locator) {
		find(Locator).sendKeys(Keys.TAB);
		
	}
	
	public void switchTab(int tabno) {
		 ArrayList<String> tab = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tab.get(1));
		   
	}
	
	public void sCompvalue(By Locator, String expected) {
		 (find(Locator).getText()).equals(expected);
		 System.out.println((find(Locator).getAttribute("innerHTML")));
	}
	
	public void socialMedia(String CustomLink) {
		
		
		
		if (CustomLink.equalsIgnoreCase("Twitter")) {
			 driver.findElement(By.xpath("//a[@href='//www.twitter.com/on24/']"));
			 Assert.assertTrue(false);
		     System.out.println("Twitter Link Is Present");
			
		}
	
		
		else if (CustomLink.equalsIgnoreCase("Facebook")) {
			  driver.findElement(By.xpath("//a[@href='https://www.facebook.com/ON24inc']"));
			  System.out.println("Facebook Link Is Present");
			}
		
		else if (CustomLink.equalsIgnoreCase("Linkedin")) {
			 driver.findElement(By.xpath("//a[@href='//www.linkedin.com/company/on24']"));
			 System.out.println("Linkedin Link Is Present");
		}
		
		else if (CustomLink.equalsIgnoreCase("Youtube")) {
			 driver.findElement(By.xpath("//a[@href='//www.youtube.com/user/ON24Inc']"));
			 System.out.println("Youtube Link Is Present");
		}
		
		else if (CustomLink.equalsIgnoreCase("Instagram")) {
			 driver.findElement(By.xpath("//a[@href='//www.instagram.com/ON24Inc/']"));
			 System.out.println("Instagram Link Is Present");
		}
		
		else {
			System.out.println("Invalid Parameters in example");
			
		}
				
	}
	
	
}
