/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import commonmethods.RandomDataGenerator;
import pageobjects.CreateNewCustomerAccountsObjects;
import pageobjects.MainScreenObjects;

/**
 * @author danielle Mbenda
 * @version 1.0
 */
public class ValidateCart {

	private static WebDriver driver;
	private static String baseUrl; //Defining this variable for the application url

		
	/*
	 * This method will run before the class
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		File file = new File ("drivers\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
		baseUrl = "http://magento2-demo.nexcess.net/";
	}
	/* 
	 * This method will run before every test
	 * This open the browser, navigate to the url and maximize the page
	 */
	@Before
	public void setUp() throws Exception{
		driver = new FirefoxDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();

	}

	/*
	 * This method will run after every test
	 */
	@After
	public void tearDown() throws Exception {
		driver.close();
	}
	
	@Test
	/**
	 * Validate User Checkout
	 * Open browser and navigate to URl
	 */
	public void ValidateUserCheckout() {
		String username = RandomDataGenerator.generateRandomString(6);
		
		//Make sure that site logo is displayed
		assertTrue("Logo on Main page is not displayed", MainScreenObjects.lumaLogo_img(driver).isDisplayed()); //Make sure the logo in displayed on the main page
		
		//Click on create account
		MainScreenObjects.CreateAccount_lnk(driver).click();
		
		//Enter Username
		CreateNewCustomerAccountsObjects.firstname_txtfield(driver).sendKeys(username); 
			 
								
	}
	


}
