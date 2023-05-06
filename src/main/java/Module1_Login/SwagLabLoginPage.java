package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabLoginPage
{
	@FindBy(xpath = "//input[@id='user-name']") private WebElement UN;
	@FindBy(xpath = "//input[@id='password']")private	WebElement PWD;
	@FindBy(xpath = "//input[@id='login-button']") private WebElement LoginBtn;
	
	public SwagLabLoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void inpSwagLabLoginPageUsername(String Username)
	{
		UN.sendKeys(Username);
	}
	
	public void inpSwagLabLoginPagePassword(String Password)
	{
		PWD.sendKeys(Password);
	}
	
	public void clickSwagLabLoginPageLoginButton()
	{
		LoginBtn.click();
	}

}
