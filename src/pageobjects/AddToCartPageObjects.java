package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCartPageObjects {
	
	private static WebElement webelement = null;
	private static List <WebElement> listelement = null;

	/**
  	 * Error message for color not selected
  	 * @param driver
  	 * @return
  	 */
  	public static WebElement errormessagecolor_txt(WebDriver driver){
  		
  		webelement = driver.findElement(By.id("super_attribute[93]-error"));	 
  		return webelement;
  	}
  	
	/**
  	 * Error message for size not selected
  	 * @param driver
  	 * @return
  	 */
  	public static WebElement errormessagesize_txt(WebDriver driver){
  		
  		webelement = driver.findElement(By.id("super_attribute[142]-error"));	 
  		return webelement;
  	}
  	
	/**
  	 * beaumont submit kit - add to cart - item image
  	 * @param driver
  	 * @return
  	 */
  	public static WebElement itembeaumontsubmitkit_img(WebDriver driver){
  		
  		webelement = driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div[3]/div[1]"));	 
  		return webelement;
  	}
  	
  	/**
  	 * Option color red
  	 * @param driver
  	 * @return
  	 */
  	public static WebElement colorRed_slct(WebDriver driver){
  		
  		webelement = driver.findElement(By.xpath("//*[@id='product-options-wrapper']/div/div/div[1]/div/div[2]"));	 
  		return webelement;
  	}
  	
  	/**
  	 * Option size medium
  	 * @param driver
  	 * @return
  	 */
  	public static WebElement sizeMedium_slct(WebDriver driver){
  		
  		webelement = driver.findElement(By.xpath("//*[@id='product-options-wrapper']/div/div/div[2]/div/div[3]"));	 
  		return webelement;
  	}
  	
  	/**
  	 * Cart Link
  	 * @param driver
  	 * @return
  	 */
  	public static WebElement minicart_lnk(WebDriver driver){
  		
  		webelement = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/a"));	 
  		return webelement;
  	}
  	
  

  	/**
  	 * View and Edit Cart Link
  	 * @param driver
  	 * @return
  	 */
  	public static WebElement viewAndEditCart_lnk(WebDriver driver){
  		
  		webelement = driver.findElement(By.xpath("//*[@id='minicart-content-wrapper']/div[2]/div[5]/div/a/span/span"));	 
  		return webelement;
  	} 
  	/**
  	 * item in the cart
  	 * @param driver
  	 * @return
  	 */
  	public static WebElement itemInMiniCart_lnk(WebDriver driver){
  		
  		webelement = driver.findElement(By.xpath("//*[@id='mini-cart']/li[1]/div/div"));	 
  		return webelement;
  	}
  	
 	/**
  	 * Page title class
  	 * @param driver
  	 * @return
  	 */
  	public static WebElement classpagetitle_txt(WebDriver driver){
  		
  		webelement = driver.findElement(By.className("page-title"));	 
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
  	 * item added to cart success message
  	 * @param driver
  	 * @return
  	 */
  	public static WebElement itemAddedSuccessMessage_txt(WebDriver driver){
  		
  		webelement = driver.findElement(By.className("message-success success message"));	 
  		return webelement;
  	}
}
