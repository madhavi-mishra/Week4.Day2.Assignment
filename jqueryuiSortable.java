package week4.day2.Assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jqueryuiSortable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable");         
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement frame1 = driver.findElement(By.xpath("//div[@class='demo-list']//following::iframe"));
		driver.switchTo().frame(0);
		
		Actions action = new Actions(driver);
	    List<WebElement> list = driver.findElements(By.xpath("//ul[@id='sortable']/li"));
	    WebElement target = list.get(2);
	    WebElement dest = list.get(6);
	    action.click(target).clickAndHold(target).moveToElement(dest).moveByOffset(0, 10).release().build().perform();


	}

}
