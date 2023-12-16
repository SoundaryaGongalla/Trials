package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/*
 * This class consists of All propertyUtility methods
 * @author soundarya
 */
public class PropertyFileUtility {

	public String fetchKey(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties");
		
		Properties p=new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
	
	
	
	
	
}
