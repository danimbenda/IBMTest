package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateNewCustomerAccountsObjects {
	
	private static WebElement webelement = null;
	
	/**
	 * First Name Text field
	 * @param driver
	 * @return
	 */
	 public static WebElement firstname_txtfield(WebDriver driver){
	 
	    webelement = driver.findElement(By.id("firstname"));	 
	    return webelement;
	 }
	 
	 /**
	  * Last Name Text field
	  * @param driver
	  * @return
	  */
	  public static WebElement lastname_txtfield(WebDriver driver){
		 
		  webelement = driver.findElement(By.id("lastname"));	 
	    return webelement;
	    }
		 
	  /**
	   * Email
	   * @param driver
	   * @return
	   */
	  	public static WebElement email_txtfield(WebDriver driver){
			 
	  		webelement = driver.findElement(By.xpath("email_address"));	 
	  		return webelement;
	  	}
			 
	  	/**
	  	 * Password
	  	 * @param driver
	  	 * @return
	  	 */
	  	public static WebElement password_txtfield(WebDriver driver){
	  		
	  		webelement = driver.findElement(By.id("password"));	 
	  		return webelement;
	  	}
		 
	  	/**
	  	 * Password Confirmation
	  	 * @param driver
	  	 * @return
	  	 */
	  	public static WebElement passwordConfirmation_txtfield(WebDriver driver){
	  		
	  		webelement = driver.findElement(By.id("password-confirmation"));	 
	  		return webelement;
	  	} 
	  
	  	
		 
	  	/**
	  	 * Create a new account - submit button
	  	 * @param driver
	  	 * @return
	  	 */
	  	public static WebElement createaccount_btn(WebDriver driver){
	  		
	  		webelement = driver.findElement(By.xpath("//*[@id='form-validate']/div/div[1]/button"));	 
	  		return webelement;
	  	} 
	  	
		 
	  	/**
	  	 * Sign up newsletter checkbox
	  	 * @param driver
	  	 * @return
	  	 */
	  	public static WebElement signupnewsletter_chkbox(WebDriver driver){
	  		
	  		webelement = driver.findElement(By.id("is_subscribed"));	 
	  		return webelement;
	  	} 
	  	
	  	/**
	  	 * Create New customer account page title
	  	 * @param driver
	  	 * @return
	  	 */
	  	public static WebElement createaccount_txt(WebDriver driver){
	  		
	  		webelement = driver.findElement(By.id("page=title=wrapped"));	 
	  		return webelement;
	  	} 

}
