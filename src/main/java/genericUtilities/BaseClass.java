package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	protected WebDriver driver;
	@BeforeClass
	public void openBrowser() throws Throwable
	{
		PropertyFileUtility putil=new PropertyFileUtility();
		String BROWSER=putil.fetchKey("browser");
		if(BROWSER.contains("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		String URL=putil.fetchKey("url");
		
		driver.get(URL);
	
	}
}
