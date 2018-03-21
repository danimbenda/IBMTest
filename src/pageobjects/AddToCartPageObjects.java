package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCartPageObjects {
	
	private static WebElement webelement = null;

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
}
