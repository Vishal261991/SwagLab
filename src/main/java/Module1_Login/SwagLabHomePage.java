package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabHomePage 
{
	@FindBy(xpath = "//div[text()='Swag Labs']") private WebElement logo;
	@FindBy(xpath = "//button[text()='Add to cart']")private	WebElement addToCartBtn;
	@FindBy(xpath = "//button[text()='Remove']") private WebElement RemoveBtn;
	@FindBy(xpath = "//button[text()='Open Menu']") private WebElement Menu;
	
	public SwagLabHomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifySwagLabHmePageLogo()
	{
		boolean result = logo.isDisplayed();
		return result;
	}
	
	public void clickSwagLabHomePageAddToCartButton()
	{
		addToCartBtn.click();
	}
	
	public String verifySwagLabHomePageRemoveButton()
	{
		String actResult = RemoveBtn.getText();
		return actResult;
	}
	
	public void clickSwagLabHomePageMenuButton()
	{
		Menu.click();
	}
	

}
