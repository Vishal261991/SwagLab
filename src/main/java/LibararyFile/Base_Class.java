package LibararyFile;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base_Class
{
	public WebDriver driver; 
	public void intializeBrowser() throws IOException
	{
		driver=new ChromeDriver();
		driver.get(Utility_Class.getPFData("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

}
