package week4.day2.Assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PlayWithSortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sortable.html");         
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		Actions action = new Actions(driver);
	    List<WebElement> list = driver.findElements(By.xpath("//ul[@id='sortable']/li"));
	    WebElement target = list.get(0);
	    WebElement dest = list.get(3);
	    action.click(target).clickAndHold(target).moveToElement(dest).moveByOffset(0, 10).release().build().perform();

	}

}
