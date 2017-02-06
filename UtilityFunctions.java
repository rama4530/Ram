/**
 * 
 */
package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Rama krishna
 *
 */
public class UtilityFunctions {

	/**
	 * @param args
	 */
	 public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "I:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.amazon.in/");
		String xpath=".//a[contains(text(),'Advertise')]";
		if(UtilityFunctions.isElementPresnt(driver, xpath, 5)){
			System.out.println("element found");
			WebElement element = driver.findElement(By.xpath(xpath));	
			UtilityFunctions.scrollIntoView(driver, element);
			UtilityFunctions.highLightElement(driver, element);
			element.click();
		}
	}	
		 /**
		  * This code will help you to find whether the element is present or not
		  * @param driver
		  * @param xpath
		  * @param time
		  * @return
		  */
		public static Boolean isElementPresnt(WebDriver driver,String xpath,int time)
		{
		 	WebElement ele = null;
		 		for(int i=0;i<time;i++)
					{
					try{
						ele=driver.findElement(By.xpath(xpath));
						break;
					}
					catch(Exception e)
					{
						try 
						{
							Thread.sleep(1000);
						} catch (InterruptedException e1) 
						{
							System.out.println("Waiting for element to appear on DOM");
						}	
					}
				 }
				return true;
		}
		/**
		 * This code will help you to Highlight the element
		 * @param driver
		 * @param element
		 */
		public static void highLightElement(WebDriver driver, WebElement element)
		{
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		try 
		{
		Thread.sleep(500);
		} 
		catch (InterruptedException e) {
		System.out.println(e.getMessage());
		} 
		je.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
		}
		
		/**
		 * This code will help you to scroll the page to view the element 
		 * @param driver
		 * @param element
		 */
		public static void scrollIntoView(WebDriver driver, WebElement element){
			try{
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true);",element);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}

