package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPageObjects {
	
	private static WebElement webelement = null;
	
	/**
  	 * Beaumonkit summer kit item link in shopping cart
  	 * @param driver
  	 * @return
  	 */
  	public static WebElement itemInCart_lnk(WebDriver driver){
  		
  		webelement = driver.findElement(By.linkText("Beaumont Summit Kit"));	 
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
  	 * Proceed to checkout button
  	 * @param driver
  	 * @return
  	 */
  	public static WebElement proceedToCheckout_btn(WebDriver driver){
  		
  		webelement = driver.findElement(By.xpath("//*[@id='maincontent']/div[3]/div/div[2]/div[1]/ul/li[1]/button"));	 
  		return webelement;
  	}
}
