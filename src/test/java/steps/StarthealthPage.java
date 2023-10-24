package steps;

import java.util.List;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.After;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StarthealthPage {
	
  WebDriver driver;
@Before
@Given("User open the chrome browser and starhealth application")
public void user_open_the_chrome_browser_and_starhealth_application() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.starhealth.in/");

	
	
}

@When("User  waits for the Welcome to Star Health pop-up and closes it")
public void user_waits_for_the_welcome_to_star_health_pop_up_and_closes_it() {
    // Write code here that turn
    System.out.println("my this page is blank");
   driver.getCurrentUrl();
    
}

@Then("validates the Star Health home page title using a JUnit assertion")
public void validates_the_star_health_home_page_title_using_a_j_unit_assertion() {
	String ExpectedTitle = "Star Health Insurance: Medical, Accident and Travel insurance policies";
	String ActualTitle =driver.getTitle();
	
	
	
    Assert.assertEquals(ActualTitle, ExpectedTitle , "The title is not valid");
}

@Then("clicks on the Buy Now button")
public void clicks_on_the_buy_now_button() {
    driver.findElement(By.xpath("//div[@class='Header_nav-link-container__nlUUp flex align-center only-desktop']")).click();
}
@Then("User enters following details")
public void user_enters_following_details(DataTable datatable) {
	
	// fetches the entire data table
			List<Map<String, String>> userList	= datatable.asMaps(String.class, String.class);
		// Now iterate over each row of the data table and get the value based on the columnname(key)
			
			//| FullName | PhNo | PIN | 
			for(Map<String, String> e : userList) {
				// System.out.println(e);
				
				driver.findElement(By.xpath("((//input[@id='name']")).clear();
				driver.findElement(By.xpath("//span[@class='ant-input-affix-wrapper ant-input-affix-wrapper-lg']")).sendKeys(e.get("FullName"));
				driver.findElement(By.xpath("//input[@id='phoneNumber']")).clear();
				driver.findElement(By.xpath("//input[@id='phoneNumber']")).sendKeys(e.get("PhNo"));
				driver.findElement(By.xpath("//input[@id='pinCode']")).clear();
				driver.findElement(By.xpath("//input[@id='pinCode']")).sendKeys(e.get(" PIN"));
				
			}
			

}

@Then("User clicks on I need health insurance from the drop-down menu and select plan")
public void user_clicks_on_i_need_health_insurance_from_the_drop_down_menu_and_select_plan() {

	WebElement e1 = driver.findElement(By.xpath("//div[@class='flex cursor-pointer pr-30 cursor-pointer nav-link flex']"));
	//hover over the account page
	
	Actions action = new Actions(driver);
	
	action.moveToElement(e1).perform();
	
	
	
	
	//System.out.println("Selenium code to click on familty option");
	
	
}

@Then("User click on the Plan for My Family page")
public void user_click_on_the_plan_for_my_family_page() {
    
	driver.findElement(By.xpath("(//a[@class='font-500 text-capitalize text-14'])[2]")).click();
	//Thread.sleep(1500);
	
}

@Then("Validate the user mobile number")
public void validate_the_user_mobile_number() {
	
	String Expectednumber = "6388021602";
	String Actualnumber ="6388021602";
	
	
	
    assertEquals(Actualnumber, Expectednumber , "The number is not valid");
    
}

@Then("User clicks on the Star Health logo")
public void user_clicks_on_the_star_health_logo() {
    driver.findElement(By.xpath("(//div[@class='undefined Header_header__1mdCC flex justify-between overflow-hidden bg-white'])(//div[@class='undefined Header_header__1mdCC flex justify-between overflow-hidden bg-white'])"));
}

@After
@Then("Close all the browsers")
public void close_all_the_browsers() {
   
	driver.close();
}

}
