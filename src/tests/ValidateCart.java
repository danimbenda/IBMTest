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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonmethods.RandomDataGenerator;
import pageobjects.AccountDashboardObjects;
import pageobjects.AddToCartPageObjects;
import pageobjects.CheckoutPageObjects;
import pageobjects.CreateNewCustomerAccountsObjects;
import pageobjects.MainScreenObjects;
import pageobjects.ShoppingCartPageObjects;

/**
 * This set of tests are the QA tests from IBM
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
	 * Validate User Checkout as required in the test
	 * Open Firefox browser and navigate to "http://magento2-demo.nexcess.net/"
	 * Create new account. Validate new account is created successfully.
	 * Navigate to Men's>>Tops>>Jackets Section and Order "Beaumont Summit Kit". 
	 * Validate errors displayed if color and Size not selected.
	 * Select Color and Size and add to cart.
	 * Navigate to cart and validate if the item selected is displayed in the cart.
	 * Proceed with checkout and validate order is created with item displayed in the cart.
	 */
	public void ValidateUserCheckout() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		String firstname = RandomDataGenerator.generateRandomString(6);
		String lastname = RandomDataGenerator.generateRandomString(6);
		String email = RandomDataGenerator.getEmailString()+"@gmail.com";
		String password = RandomDataGenerator.generateRandomPassword();
		String company = "IBM";
		String zipcode = "78759";
		String address = "11501 Burnet Rd";
		String city = "Austin";
		String state = "Texas";
		String country = "United States";
		String phonenumber = "2222222222";
		String beaumontSummitKit ="Beaumont Summit Kit";
		String beaumontSummitKitUrl = "http://magento2-demo.nexcess.net/beaumont-summit-kit.html";
											
		Actions action = new Actions(driver);
		
		//Make sure that site logo is displayed
		assertTrue("Logo on Main page is not displayed", MainScreenObjects.lumaLogo_img(driver).isDisplayed()); //Make sure the logo in displayed on the main page
		assertTrue("Mainpage not loaded - URL not correct", driver.getCurrentUrl().equalsIgnoreCase("http://magento2-demo.nexcess.net/"));
		
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
		assertTrue("Account information is not displayed", AccountDashboardObjects.accountinformation_txt(driver).isDisplayed());
		assertTrue("Contact information is not displayed", AccountDashboardObjects.contactinformation_txt(driver).isDisplayed());
		assertTrue("Contact information does not include the first name", AccountDashboardObjects.contactinformation_txt(driver).getText().contains(firstname));
		assertTrue("Contact information does not include the last name", AccountDashboardObjects.contactinformation_txt(driver).getText().contains(lastname));
		assertTrue("Contact information does not include the email", AccountDashboardObjects.contactinformation_txt(driver).getText().contains(email));
		
		//Click Men and then Tops and then jackets and order
		//First click on the Men link and make sure you land on the correct page. and same thing for jackets
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		AccountDashboardObjects.menTab_lnk(driver).click();
		assertTrue("Men items page is not open - url not found", driver.getCurrentUrl().equalsIgnoreCase("http://magento2-demo.nexcess.net/men.html"));
		AccountDashboardObjects.menJackets_lnk(driver).click();
		assertTrue("Men - Jackets page is not open - url not found", driver.getCurrentUrl().equalsIgnoreCase("http://magento2-demo.nexcess.net/men/tops-men/jackets-men.html"));
		
		//Select the Beaumont summit kit jacket to add to the cart
		AccountDashboardObjects.BeaumontSummitJacket_img(driver).click();
		assertTrue("BeaumontSubmitKit Jacket page title is not loaded - url is incorrect", driver.getCurrentUrl().equalsIgnoreCase(beaumontSummitKitUrl));
		assertTrue("BeaumontSubmitJacket page title is not displayed", AccountDashboardObjects.classpagetitle_txt(driver).isDisplayed());
		
		wait.until(ExpectedConditions.visibilityOf(AddToCartPageObjects.itembeaumontsubmitkit_img(driver)));
		
		//Click add to cart without selecting a color and a size
		AccountDashboardObjects.addToCart_btn(driver).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		//Validate error when no color and no size selected
		assertTrue("Error message for color not picked is not displayed", AddToCartPageObjects .errormessagecolor_txt(driver).getText().equalsIgnoreCase("This is a required field."));
		assertTrue("Error message for color not picked is incorrect", AddToCartPageObjects .errormessagecolor_txt(driver).isDisplayed());
		assertTrue("Error message for size not selected is not displayed", AddToCartPageObjects .errormessagesize_txt(driver).getText().equalsIgnoreCase("This is a required field."));
		assertTrue("Error message for size not selected is incorrect", AddToCartPageObjects .errormessagesize_txt(driver).isDisplayed());
		
		//Select Color and Size and add to cart.
		AddToCartPageObjects.colorRed_slct(driver).click();
		AddToCartPageObjects.sizeMedium_slct(driver).click();
		AccountDashboardObjects.addToCart_btn(driver).click();
		
		//Navigate to cart and validate if the item selected is displayed in the cart.
		AddToCartPageObjects.minicart_lnk(driver).click();
		Thread.sleep(5000);
		assertTrue("Cart page not loaded - URL not shown", driver.getCurrentUrl().equalsIgnoreCase("http://magento2-demo.nexcess.net/checkout/cart/"));
		assertTrue("Beaumont Summer Kit has not been added to the shopping cart", AddToCartPageObjects.itemListInCart_lst(driver).get(0).findElement(By.tagName("a")).getAttribute("href").equalsIgnoreCase(beaumontSummitKitUrl));
		assertTrue("Beaumont Summer Kit is not shown in the shopping cart", AddToCartPageObjects.itemListInCart_lst(driver).get(0).findElement(By.tagName("a")).getAttribute("innerHTML").equalsIgnoreCase(beaumontSummitKit));
		
		//Proceed with checkout and validate order is created with item displayed in the cart.
		wait.until(ExpectedConditions.visibilityOf(ShoppingCartPageObjects.proceedToCheckout_btn(driver)));
		Thread.sleep(5000);
		
		action.moveToElement(ShoppingCartPageObjects.proceedToCheckout_btn(driver)).build().perform();
		ShoppingCartPageObjects.proceedToCheckout_btn(driver).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		assertTrue("Checkout page not displayed - URL not shown", driver.getCurrentUrl().equalsIgnoreCase("http://magento2-demo.nexcess.net/checkout/"));
		
		CheckoutPageObjects.company_txtfield(driver).sendKeys(company);
		CheckoutPageObjects.city_txtfield(driver).sendKeys(city);
		CheckoutPageObjects.streetAddress_txtfield(driver).sendKeys(address);Thread.sleep(3000);
		CheckoutPageObjects.state_drpdown(driver).selectByVisibleText(state);
		CheckoutPageObjects.zipcode_txtfield(driver).sendKeys(zipcode);
		CheckoutPageObjects.country_drpdown(driver).selectByVisibleText(country);
		CheckoutPageObjects.phonenumber_txtfield(driver).sendKeys(phonenumber);
		CheckoutPageObjects.shippingFlat_chkbox(driver).click();
		
		assertTrue("Beaumont Summer Kit has been added to the checkout", CheckoutPageObjects.itemListInCart_lst(driver).get(0).getAttribute("innerHTML").equalsIgnoreCase(beaumontSummitKit));
		CheckoutPageObjects.next_btn(driver).click(); Thread.sleep(2000);
		assertTrue("Review and payments  page title is not loaded - url is incorrect", driver.getCurrentUrl().equalsIgnoreCase("http://magento2-demo.nexcess.net/checkout/#payment"));
		assertTrue("Beaumont Summer Kit has been added to the checkout on order summary", CheckoutPageObjects.itemListInCart_lst(driver).get(0).getAttribute("innerHTML").equalsIgnoreCase(beaumontSummitKit));
		CheckoutPageObjects.placeOrder_btn(driver).click();Thread.sleep(5000);
		assertTrue("Success order placed page is not open - url is incorrect", driver.getCurrentUrl().equalsIgnoreCase("http://magento2-demo.nexcess.net/checkout/onepage/success/"));
		assertTrue("Success message for order created not found", CheckoutPageObjects.checkoutSuccessMessagess_lst(driver).get(0).findElements(By.tagName("p")).get(0).getText().contains("Your order number is"));
		
		
		
		
	}
	


}
