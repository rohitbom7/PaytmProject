package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {

	public static WebDriver launchChromeBrowser() {
		System.setProperty("webdriver.chrome.driver","src\\test\\resources\\Browsers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		return driver;}
	
	public static WebDriver launchEdgeBrowser() {
		System.setProperty("webdriver.edge.driver","src\\test\\resources\\Browsers\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		return driver;}
}
