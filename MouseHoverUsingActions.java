package week4.day2.Assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverUsingActions {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/mouseOver.html");         
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Actions actions = new Actions(driver);
		WebElement coursesOptions = driver.findElement(By.xpath("//a[contains(text(),'TestLeaf Courses')]"));
		actions.moveToElement(coursesOptions).perform();
		
		List<WebElement> coursesList = driver.findElements(By.xpath("//a[@class='listener']"));
		System.out.println(coursesList.size());
		for(int i=0;i<coursesList.size();i++)
		{
		System.out.println(coursesList.get(i).getAttribute("href"));
		}
	
		
		WebElement clickSelenium = driver.findElement(By.xpath("//a[contains(text(),'Selenium')]"));
		clickSelenium.click();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		alert.accept();	
		
		
	}

}
