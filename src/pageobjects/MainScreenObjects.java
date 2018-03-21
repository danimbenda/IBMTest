package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class contains all needed objects and locators on the main screen
 * @author danielle mbenda
 *
 */
public class MainScreenObjects {

	private static WebElement webelement = null;
	
	/**
	 * Luma Logo
	 * @param driver
	 * @return
	 */
	 public static WebElement lumaLogo_img(WebDriver driver){
	 
	    webelement = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/strong/img"));	 
	    return webelement;
	 }
	 
	 /**
	  * Main Demo Media
	  * @param driver
	  * @return
	  */
	  public static WebElement maindemomedia_img(WebDriver driver){
		 
	    webelement = driver.findElement(By.xpath("//*[@id='maincontent']/div[3]/div/div[2]/div[1]/a/img"));	 
	    return webelement;
	    }
		 
	  /**
	   * Footer Copyright
	   * @param driver
	   * @return
	   */
	  	public static WebElement footercopyright(WebDriver driver){
			 
	  		webelement = driver.findElement(By.xpath("/html/body/div[1]/small/span"));	 
	  		return webelement;
	  	}
			 
	  	/**
	  	 * Create an account - link
	  	 * @param driver
	  	 * @return
	  	 */
	  	public static WebElement CreateAccount_lnk(WebDriver driver){
	  		
	  		webelement = driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[3]/a"));	 
	  		return webelement;
	  	}
		 
		 
}
