package Login_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibararyFile.Base_Class;
import LibararyFile.Utility_Class;
import Module1_Login.SwagLabHomePage;
import Module1_Login.SwagLabLoginPage;
import Module1_Login.SwagLabMenuPage;

public class SwagLabLoginTest extends Base_Class
{
	SwagLabLoginPage login;
	SwagLabHomePage home;
	SwagLabMenuPage menu;
	int TCID;
	@BeforeClass
	public void openBrowser() throws IOException
	{
		intializeBrowser();
		 login=new SwagLabLoginPage(driver);
		 home=new SwagLabHomePage(driver);
		 menu=new SwagLabMenuPage(driver);
	}
	
	@BeforeMethod
	public void loginToApp() throws IOException
	{
		login.inpSwagLabLoginPageUsername(Utility_Class.getPFData("UN"));
		login.inpSwagLabLoginPagePassword(Utility_Class.getPFData("PWD"));
		login.clickSwagLabLoginPageLoginButton();
	}
	
	@Test
	public void verifylogo()
	{
		TCID= 101;
		boolean result = home.verifySwagLabHmePageLogo();
		Assert.assertTrue(result,"TC failed :LOGO NOT DISPLAYED");
	}
	
	@Test
	public void verifyAddToCartButtonConvertedToRemoveButton() throws EncryptedDocumentException, IOException
	{
		TCID=102;
		home.clickSwagLabHomePageAddToCartButton();
		String actResult = home.verifySwagLabHomePageRemoveButton();
		String expResult=Utility_Class.getTestData(0, 2);
		Assert.assertEquals(actResult, expResult,"TC Failed:Add to Cart Button Not Converted to Remove Button");
	}
	
	@AfterMethod
	public void logoutFromApp(ITestResult s1) throws IOException
	{
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			Utility_Class.captureScreenShot(driver, TCID);
		}
		home.clickSwagLabHomePageMenuButton();
		menu.clickSwagLabMenuPageLogoutButton();
		
	}
	
	@AfterClass
	public void closeTheBrowser()
	{
		driver.quit();
	}

}
