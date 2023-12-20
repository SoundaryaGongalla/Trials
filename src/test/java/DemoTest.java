import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
	
	// 1 navigate to url
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.saucedemo.com/v1/");
	
	// enter valid sername password
	/check visible text without hVING Tag
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();
	
	// 2 valdate the UN PSWD are  editabble
	
	
	//  3 verify the  page title with swag labs
	String Title =driver.getTitle();
	System.out.println(Title);
	Assert.assertEquals(Title, "Swag Labs");
	System.out.println("Title is validated");
	
	//4 get the username and pswd  from the page and login
	// 5 handle the password expiry alert and proceed 
	
	// 6validate the sort dropdown is displaed
	
	WebElement ele=driver.findElement(By.className("product_sort_container"));
	
	
	if(ele.isDisplayed()==true);
	{
		System.out.println("sort container is displayed");
	}
	
	
	//7  validate the produucts are displayd  according to ascending  order or default
	WebElement products = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
	System.out.println(products);

	
	// 8change the sorting order  of price high to low
	
	
	//9  validate wheather the products are displaed according to decending order of price

	List<WebElement> productsDesing = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));

	List <String>itemInDescending=new ArrayList<String>();
	for(WebElement products:productsDesing)
	{
	itemInDescending.add(products.getText());

	}
	System.out.println(itemInDescending);
	List  expectedDescendinProducts=new ArrayList<String>();
	expectedDescendinProducts.addAll(itemInDescending);
	Collections.reverseOrder();
	System.out.println(expectedDescendinProducts);
	Assert.assertEquals(itemInDescending, expectedDescendinProducts);
	System.out.println("After changing Price to low  produsta are in desecnding order validated");

	//10 read all the product names and prices and store it in  json file with keValuepair
	
	
	
	
	
	//  11 click all products add to cart
	List<WebElement> addtocart = driver.findElements(By.xpath("//button[.='ADD TO CART']"))	;
	
	for(WebElement e:addtocart)
	{
		e.click();
	}
	
	// validate  the cart num6
	
	WebElement count=driver.findElement(By.className("shopping_cart_link fa-layers fa-fw"));
	count.click();
	//click on add to cart
	driver.findElement(By.className("svg-inline--fa fa-shopping-cart fa-w-18 fa-3x ")).click();
	
	
	
	
	
	
	
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
