import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoTest {
@Test
public void scenario()
{
	WebDriverManager.chromedriver().setup();
	
	
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.saucedemo.com/v1/");
	
	// enter valid sername password
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();
	// verify the title
	String Title =driver.getTitle();
	System.out.println(Title);
	Assert.assertEquals(Title, "Swag Labs");
	System.out.println("Title is validated");
	
	
	// verify product container is dispaled or not
	
	WebElement ele=driver.findElement(By.className("product_sort_container"));
	
	
	if(ele.isDisplayed()==true);
	{
		System.out.println("sort container is displayed");
	}
	
	
	// validate the produucts are in ascending 
	WebElement products = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
	System.out.println(products);

	
	//change the sorting order high to low
	
	ele.click();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

}
