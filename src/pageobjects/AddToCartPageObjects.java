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
  		
  		webelement = driver.findElement(By.className("fotorama__img"));	 
  		return webelement;
  	}
}
