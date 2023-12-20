import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepo.LoginPage;
import genericUtilities.BaseClass;
import genericUtilities.PropertyFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceLabsTest   {
	
	@Test
	public void login() throws Throwable
	{
		// 1 navigate to url
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.saucedemo.com/v1/");
		// 2 valdate the UN PSWD are  editabble
		WebElement username = driver.findElement(By.id("user-name"));
				username.click();
		WebElement password = driver.findElement(By.id("password"));
				password.click();
		
	if(username.isSelected()==true)
	{
		System.out.println("username is editable");
	}
		
	if(password.isSelected()==true)
	{
		System.out.println("password is editable");
	}
	
	//  3 verify the  page title with swag labs

	WebElement actual=driver.findElement(By.xpath("//title[.='Swag Labs']")); // no printing
	String expected=driver.getTitle();
	System.out.println("exp"+expected);
	System.out.println("act"+actual);
	//Assert.assertEquals(actual, expected);
	if(actual.equals(expected))
	{
	System.out.println("Title is validated");

	}
	 else 
	{
		System.out.println("not validated");
	}
//	String un  = driver.findElement(By.xpath("//*[@id=\"login_credentials\"]/br[1]")).getText();
//	System.out.println(un);
	//4 get the username and pswd  from the page and login
////div[@id='login_credentials']/h4
	//standard_user
	//secret_sauce
	
//	
//	username.sendKeys("standard_user");
//	password.sendKeys("secret_sauce");
	String data=driver.findElement(By.className("login_credentials")).getText().substring(24, 38);	
    System.out.println(data);
    
    String pwd=driver.findElement(By.className("login_password")).getText().substring(24, 36);
    
    System.out.println(pwd);	//String PWD=driver.findElement(By.xpath("//h4[text()='Password for all users:']/following-sibling::text()[1]")).getText();
	
	//System.out.println("username"+UN);
	//
	//System.out.println("password"+PWD);
	// clik on loinbutton
	driver.findElement(By.id("login-button")).click();

	// 5 handle the password expiry alert and proceed 

	
	//6	// 6validate the sort dropdown is displaed

WebElement dropdrown=driver.findElement(By.className("product_sort_container"));	
	if(dropdrown.isDisplayed()== true)
	{
		System.out.println("dropdown is displayed");
	}
	else {
		System.out.println("dropdown is  not displayed");	
	}
	
	////7  validate the produucts are displayd  according to ascending  order or default<A_Z
	
	
	
	
	

	// 8change the sorting order  of price high to low
	
//	dropdrown.click();
//	Select s=new Select(dropdrown);
//	s.selectByVisibleText("Price (high to low)");
//	
	
	
	//9  validate wheather the products are displaed according to decending order of price
	
	
//	4743
	

	//10 read all the product names and prices and store it in  json file with keValuepair
	
//	String price =driver.findElement(By.xpath("//div[@class='inventory_item_name']/../../following-sibling::div/div")).getText();
//	System.out.println(price);
//	
//	String product=driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
//	System.out.println(product);
	
	//  11 click all products add to cart
	
	
	// validate  the cart num6
	
	
	
	
	
	
	
	
	//12 validate the No of items are displaed on cart icon symbol
	//13 click on cart ion to naviagate to checkout page
	
	
	//14 validate all the items,names,and price   ,desciptions that are displaed 
	//in cart are valid(the data should be read from the json file that was created earlier)
	
	
	//15 clik on checkout butn
	
	//16 validate first name lastname and zip code are editable
	
	
	//17 provide the details and click on contimue btn
	
	//18 valdate the total price is corrct(sum of item +fixed tax)
	
	//19 click on finish button and validate thank u msg
	
	
	//20 click on sanwich menu on top left and logout and validate the  user is loed out
	
	
	
	
	
}
	}
	
	

