package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountDashboardObjects {
	
private static WebElement webelement = null;
	
	/**
	 * Confirmation message after account is created
	 * @param driver
	 * @return
	 */
	 public static WebElement accountcreatedconfirmationmessage_txt(WebDriver driver){
	 
	    webelement = driver.findElement(By.cssSelector("#maincontent > div.page.messages > div:nth-child(2) > div:nth-child(1) > div"));	 
	    return webelement;
	 }
	 
	 /**
	  * Account Page Title 
	  * @param driver
	  * @return
	  */
	  public static WebElement pagetitle_txt(WebDriver driver){
		 
		  webelement = driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div[1]/div[1]/h1/span"));	 
	    return webelement;
	    }
	  
	  /**
	   * Account information
	   * @param driver
	   * @return
	   */
	public static WebElement accountinformation_txt(WebDriver driver){
			 
		webelement = driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div[1]/div[3]/div[1]/strong"));	 
		return webelement;
	}

	  /**
	   * Contact information
	   * @param driver
	   * @return
	   */
	public static WebElement contactinformation_txt(WebDriver driver){
			 
		webelement = driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/p"));	 
		return webelement;
	}
	
	
	 /**
	   * Men tab
	   * @param driver
	   * @return
	   */
	public static WebElement menTab_lnk(WebDriver driver){
			 
		webelement = driver.findElement(By.id("ui-id-5"));	 
		return webelement;
	}
		 
	 /**
	   * Page title heading
	   * @param driver
	   * @return
	   */
	public static WebElement pageTitleHeading_txt(WebDriver driver){
			 
		webelement = driver.findElement(By.id("page-title-heading"));	 
		return webelement;
	}
	
	 /**
	   * Men Jackets
	   * @param driver
	   * @return
	   */
	public static WebElement menJackets_lnk(WebDriver driver){
			 
		webelement = driver.findElement(By.xpath("//*[@id='maincontent']/div[4]/div[2]/div/div/ul[1]/li[2]/a"));	 
		return webelement;
	}
	
	/**
  	 * Men Jackets Beaummont Summit Jacket
  	 * @param driver
  	 * @return
  	 */
  	public static WebElement BeaumontSummitJacket_img(WebDriver driver){
  		
  		webelement = driver.findElement(By.cssSelector("	#maincontent > div.columns > div.column.main > div.products.wrapper.grid.products-grid > ol > li:nth-child(1) > div > a > span > span > img"));	 
  		return webelement;
  	}
	
  	/**
  	 * Add to cart Button
  	 * @param driver
  	 * @return
  	 */
  	public static WebElement addToCart_btn(WebDriver driver){
  		
  		webelement = driver.findElement(By.id("product-addtocart-button"));	 
  		return webelement;
  	}

  	
  	/**
  	 * Message notice when adding item to cart
  	 * @param driver
  	 * @return
  	 */
  	public static WebElement messagenotice_txt(WebDriver driver){
  		
  		webelement = driver.findElement(By.className("message-notice notice message"));	 
  		return webelement;
  	}
  	
  	/**
  	 * MPage title class
  	 * @param driver
  	 * @return
  	 */
  	public static WebElement classpagetitle_txt(WebDriver driver){
  		
  		webelement = driver.findElement(By.className("page-title"));	 
  		return webelement;
  	}
  	

  	
  	
  	

}
