/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonmethods.RandomDataGenerator;
import pageobjects.AccountDashboardObjects;
import pageobjects.AddToCartPageObjects;
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
	//	driver.close();
	}
	
	@Test
	/**
	 * Validate User Checkout
	 * Open browser and navigate to URl
	 */
	public void ValidateUserCheckout() {
		String firstname = RandomDataGenerator.generateRandomString(6);
		String lastname = RandomDataGenerator.generateRandomString(6);
		String email = RandomDataGenerator.getEmailString()+"@gmail.com";
		String password = RandomDataGenerator.generateRandomPassword();
		
		//Make sure that site logo is displayed
		assertTrue("Logo on Main page is not displayed", MainScreenObjects.lumaLogo_img(driver).isDisplayed()); //Make sure the logo in displayed on the main page
		
		//Click on create account
		MainScreenObjects.CreateAccount_lnk(driver).click();
		assertTrue("Create account page is not open - url not found", driver.getCurrentUrl().equalsIgnoreCase("http://magento2-demo.nexcess.net/customer/account/create/"));
		
		//Enter First Name
		CreateNewCustomerAccountsObjects.firstname_txtfield(driver).sendKeys(firstname); 
		
		//Enter Last Name
		CreateNewCustomerAccountsObjects.lastname_txtfield(driver).sendKeys(lastname); 
		
		//Check box Sign up to Newsletter
		CreateNewCustomerAccountsObjects.signupnewsletter_chkbox(driver).click(); 
				
		//Enter Email
		CreateNewCustomerAccountsObjects.email_txtfield(driver).sendKeys(email); 
			 
		//Enter Password
		CreateNewCustomerAccountsObjects.password_txtfield(driver).sendKeys(password); 
		
		//Confirm Password
		CreateNewCustomerAccountsObjects.passwordConfirmation_txtfield(driver).sendKeys(password); 
		
		//Click Submit
		CreateNewCustomerAccountsObjects.createaccount_btn(driver).click(); 
		
		//Verify Account is created
		assertTrue("account page is not open - url not found", driver.getCurrentUrl().equalsIgnoreCase("http://magento2-demo.nexcess.net/customer/account/"));
		assertTrue("Account created confirmation message is not displayed", AccountDashboardObjects.accountcreatedconfirmationmessage_txt(driver).isDisplayed()); 
		assertTrue("Page title: My Dashboard is not correctly displayed", AccountDashboardObjects.pagetitle_txt(driver).getText().equalsIgnoreCase("My Dashboard"));
		assertTrue("Page title: My Dashboard is not displayed", AccountDashboardObjects.pagetitle_txt(driver).isDisplayed());
		assertTrue("Account information is not displayed", AccountDashboardObjects.accountinformation_txt(driver).isDisplayed());
		assertTrue("Contact information is not displayed", AccountDashboardObjects.contactinformation_txt(driver).isDisplayed());
		assertTrue("Contact information does not include the first name", AccountDashboardObjects.contactinformation_txt(driver).getText().contains(firstname));
		assertTrue("Contact information does not include the last name", AccountDashboardObjects.contactinformation_txt(driver).getText().contains(lastname));
		assertTrue("Contact information does not include the email", AccountDashboardObjects.contactinformation_txt(driver).getText().contains(email));
		
		//Click Men and then Tops and then jackets and order
		//First click on the Men link and make sure you land on the correct page. and same thing for jackets
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		AccountDashboardObjects.menTab_lnk(driver).click();
		assertTrue("Men page title is not displayed", AccountDashboardObjects.pageTitleHeading_txt(driver).isDisplayed());
		assertTrue("Men page title is not correct", AccountDashboardObjects.pageTitleHeading_txt(driver).getText().equalsIgnoreCase("Men"));
		AccountDashboardObjects.menJackets_lnk(driver).click();
		assertTrue("Men Jackets page title is not displayed", AccountDashboardObjects.pageTitleHeading_txt(driver).isDisplayed());
		assertTrue("Men Jackets page title is not correct", AccountDashboardObjects.pageTitleHeading_txt(driver).getText().equalsIgnoreCase("Jackets"));
		
		//Select the beaumont submit kit jacket to add to the cart
		AccountDashboardObjects.BeaumontSummitJacket_img(driver).click();
		assertTrue("BeaumontSubmitJacket page title is loaded", AccountDashboardObjects.classpagetitle_txt(driver).getText().equalsIgnoreCase("Beaumont Summit Kit"));
		assertTrue("BeaumontSubmitJacket page title is loaded", AccountDashboardObjects.classpagetitle_txt(driver).isDisplayed());
		assertTrue("The url is incorrect", driver.getCurrentUrl().equalsIgnoreCase("http://magento2-demo.nexcess.net/beaumont-summit-kit.html"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(AddToCartPageObjects.itembeaumontsubmitkit_img(driver)));
		
		//Click add to cart without selecting a color and a size
		AccountDashboardObjects.addToCart_btn(driver).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		//Validate error when no color and no size are selected
		assertTrue("Error message for color not picked is not displayed", AddToCartPageObjects .errormessagecolor_txt(driver).getText().equalsIgnoreCase("This is a required field."));
		assertTrue("Error message for color not picked is incorrect", AddToCartPageObjects .errormessagecolor_txt(driver).isDisplayed());
		assertTrue("Error message for size not selected is not displayed", AddToCartPageObjects .errormessagesize_txt(driver).getText().equalsIgnoreCase("This is a required field."));
		assertTrue("Error message for size not selected is incorrect", AddToCartPageObjects .errormessagesize_txt(driver).isDisplayed());
		
		//Select Color and Size and add to cart.
	}
	


}
