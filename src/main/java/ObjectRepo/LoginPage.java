package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebElement getUserNameTextBox() {
		return userNameTextBox;
	}

	public WebElement getPasswordTextBox() {
		return passwordTextBox;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	@FindBy(id="user-name")
	private WebElement userNameTextBox;
	
	@FindBy(id="password")
	private WebElement passwordTextBox;
	
	
	@FindBy(id="login-button")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
