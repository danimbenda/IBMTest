package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPageObjects {

	private static WebElement webelement = null;
	private static Select dropdown = null;
	private static List <WebElement> listelement = null;
	
 	/**
  	 * Page title class
  	 * @param driver
  	 * @returne
  	 */
  	public static WebElement classpagetitle_txt(WebDriver driver){
  		
  		webelement = driver.findElement(By.className("page-title"));	 
  		return webelement;
  	}
  	
  	/**
  	 * Company Name field
  	 * @param driver
  	 * @return
  	 */
  	public static WebElement company_txtfield(WebDriver driver){
  		
  		webelement = driver.findElement(By.name("company"));	 
  		return webelement;
  	}
  	
  	/**
  	 * Street Address field
  	 * @param driver
  	 * @return
  	 */
  	public static WebElement streetAddress_txtfield(WebDriver driver){
  		
  		webelement = driver.findElement(By.name("street[0]"));	 
  		return webelement;
  	}
  	
  	/**
  	 * City field
  	 * @param driver
  	 * @return
  	 */
  	public static WebElement city_txtfield(WebDriver driver){
  		
  		webelement = driver.findElement(By.name("city"));	 
  		return webelement;
  	}
  	
  	/**
  	 * Zip code
  	 * @param driver
  	 * @return
  	 */
  	public static WebElement zipcode_txtfield(WebDriver driver){
  		
  		webelement = driver.findElement(By.name("postcode"));	 
  		return webelement;
  	}
  	
	/**
  	 * Phone Number 
  	 * @param driver
  	 * @return
  	 */
  	public static WebElement phonenumber_txtfield(WebDriver driver){
  		
  		webelement = driver.findElement(By.name("telephone"));	 
  		return webelement;
  	}
  	
	/**
  	 * State Dropdown
  	 * @param driver
  	 * @return
  	 */
  	public static Select state_drpdown(WebDriver driver){
  		
  		dropdown = new Select(driver.findElement(By.name("region_id")));	 
  		return dropdown;
  	}
  	
	/**
  	 * Country Dropdown
  	 * @param driver
  	 * @return
  	 */
  	public static Select country_drpdown(WebDriver driver){
  		
  		dropdown = new Select (driver.findElement(By.name("country_id")));	 
  		return dropdown;
  	}
  	
  	/**
  	 * Check box Shipping rate flat
  	 * @param driver
  	 * @return
  	 */
  	public static WebElement shippingFlat_chkbox(WebDriver driver){
  		
  		webelement = driver.findElement(By.id("s_method_flatrate_flatrate"));	 
  		return webelement;
  	}
  	
  	/**
  	 * Next For Checkout
  	 * @param driver
  	 * @return
  	 */
  	public static WebElement next_btn(WebDriver driver){
  		
  		webelement = driver.findElement(By.xpath("//*[@id='shipping-method-buttons-container']/div/button"));	 
  		return webelement;
  	}
  	
  
  	
	/**
  	 * List of items in the mini cart
  	 * @param driver
  	 * @return
  	 */
  	public static List< WebElement> itemListInCart_lst(WebDriver driver){
  		
  		listelement = driver.findElements(By.className("product-item-name"));	 
  		return listelement;
  	}
  	
  	/**
  	 * Customer Email
  	 * @param driver
  	 * @return
  	 */
  	public static WebElement customerEmail_txtfield(WebDriver driver){
  		
  		webelement = driver.findElement(By.id("customer-email"));	 
  		return webelement;
  	}
  	
  	/**
  	 * place order button
  	 * @param driver
  	 * @return
  	 */
  	public static WebElement placeOrder_btn(WebDriver driver){
  		
  		webelement = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[3]/div[2]/form/fieldset/div[1]/div/div/div[2]/div[4]/div/button"));	 
  		return webelement;
  	}
  	
  	/**
  	 * Checkout success messages
  	 * @param driver
  	 * @return
  	 */
  	public static List< WebElement> checkoutSuccessMessagess_lst(WebDriver driver){
  		
  		listelement = driver.findElements(By.className("checkout-success"));	 
  		return listelement;
  	}
  	
  		
  	
}
