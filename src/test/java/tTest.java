import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.math3.geometry.spherical.twod.SubCircle;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tTest {
public static void main(String[] args) throws Throwable {
	// 1 navigate to url
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
// 2 check un and pswd is editable or  not
			
		
			
			// fetch the un pswd from login page and login
			
			String data=driver.findElement(By.className("login_credentials")).getText().substring(24, 38);	
             System.out.println(data);
             
             String pwd=driver.findElement(By.className("login_password")).getText().substring(24, 36);
             
             System.out.println(pwd);

             
             driver.findElement(By.id("user-name")).sendKeys(data);
             driver.findElement(By.id("password")).sendKeys(pwd);
         	driver.findElement(By.id("login-button")).click();

////6	// 6validate the sort dropdown is displaed
WebElement d=driver.findElement(By.xpath("//select[@class='product_sort_container']"));

String expecteddropdown[]= {"Name (A to Z)","Name (Z to A)","Price (low to high)","Price (high to low)"};

Select list=new  Select(d);
List<WebElement> options = list.getOptions();
for(int i=0;i<options.size();i++)
{
	
	
	System.out.println(options.get(i).getText()+"---"+expecteddropdown[i]);
	//validate 
	Assert.assertEquals(options.get(i).getText(), expecteddropdown[i]);
}
System.out.println("validated");

//7 validate the products are displad in ascending order

List<WebElement> items = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
List actProducts=new ArrayList<String>();
for(WebElement products:items)
{
actProducts.add(products.getText());
}
System.out.println(actProducts);

  //Object[] demo=actProducts.toArray(); 
	/*
	 * for(Object k:demo) { System.out.println(k); }
	 * it will print line b line
	 */
 
List expProducts=new ArrayList<String>();
expProducts.addAll(actProducts);
Collections.sort(expProducts);
Assert.assertEquals(actProducts, expProducts);
System.out.println("ascending order validated ");
//System.out.println(expProducts);

//
//for(WebElement i:items)
//{
//	System.out.println(i.getText());
//}

//8 	// 8change the sorting order  of price high to low

//WebElement price=driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();

list.selectByVisibleText("Price (high to low)");
//9  validate wheather the products are displaed according to decending order of price

//div[@class='inventory_item_name ']/../../following-sibling::div/div//following-sibling::text()[1]

List<WebElement> ProductPrices = driver.findElements(By.xpath("//div[@class='inventory_item_name ']/../../following-sibling::div/div"));

	
List priceList=new ArrayList<Integer>();
for(WebElement eachprice:ProductPrices)
{
	priceList.add(eachprice.getText().substring(1));
}
System.out.println(priceList);
List desecingPrice=new ArrayList<Integer>();
desecingPrice.addAll(priceList);
Collections.reverseOrder();
Assert.assertEquals(priceList, desecingPrice);
System.out.println("price validated");


//	//10 read all the product names and prices and store it in  json file with keValuepair

List<WebElement> productNames = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));

JSONObject obj=new JSONObject();
for(int j=0;j<productNames.size();j++)
{
	obj.put("productName"+j, productNames.get(j).getText().toString());
	obj.put("prices"+j, ProductPrices.get(j).getText().toString());
	
}

FileWriter file=new FileWriter("./src/test/resources/PRoductPricedetails.json");
file.write(obj.toJSONString());
file.close();
System.out.println("file created");

/*
 * this is to read data from json file
 */
//create json parser object
JSONParser jsonparse=new JSONParser();

//parsing  the content of the json file
JSONObject jobj =(JSONObject)jsonparse.parse(new FileReader("./src/test/resources/PRoductPricedetails.json"));
//readin the data from the json file
String product=(String) jobj.get("product");
String first=(String) jobj.get("first");

String price=(String) jobj.get("price");
System.out.println(product);





// Add all the products
List<WebElement> addToCart = driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']"));
int count=0;
for(WebElement i:addToCart)
{
	i.click();
	count ++;
}
	
	
	
	
//12 validate the number in cart Num



































}




}
