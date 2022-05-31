package testPaytm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClasses.InvestInStockPage;
import pomClasses.MobRechargePage;
import pomClasses.PaytmHomePage;

public class Paytm {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Browsers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
//	driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
//	driver.get("https://paytm.com/");
//	driver.manage().window().maximize();
//	Thread.sleep(2000);
	//1st test case to verify Paytm Homepage
//	String url=driver.getCurrentUrl();
//	String title=driver.getTitle();
//	if(url.equals("https://paytm.com/") && title.equals("Paytm: Secure & Fast UPI Payments, Recharge Mobile & Pay Bills"))
//	{System.out.println("Pass");}
//	else
//	{System.out.println("Fail");}
	//2nd test case to verify Recharge page
	PaytmHomePage paytmHomePage= new PaytmHomePage(driver);
//	paytmHomePage.rechargeButton();
//	Thread.sleep(2000);
//	String url1=driver.getCurrentUrl();
//	String title1=driver.getTitle();
//	if(url1.equals("https://paytm.com/recharge") && title1.equals("Online Recharge - Online Mobile Recharge & Prepaid Recharge Plans"))
//	{System.out.println("Pass");}
//	else
//	{System.out.println("Fail");}
//	
//	MobRechargePage mobRechargePage=new MobRechargePage(driver);
//	mobRechargePage.prepaidRechargeManual();
//	mobRechargePage.prepaidRechargeByPlan();
//	Thread.sleep(4000);
//	mobRechargePage.toGetTextOfPaymentTab();
	
//	mobRechargePage.postpaidRecharge();
//	Thread.sleep(1000);
//	mobRechargePage.postpaidData();
	driver.get("https://paytm.com/");
//	driver.manage().window().maximize();
//	paytmHomePage.clickOnStockTab();
//	Thread.sleep(3000);
//	InvestInStockPage investInStockPage= new InvestInStockPage(driver);
//	investInStockPage.clickOnMutualFund();
//	Thread.sleep(5000);
//	investInStockPage.scroll();
//	Thread.sleep(3000);
//	investInStockPage.clickOnbestReturn();
//	
//	investInStockPage.clickOnFirstFund();
//	Thread.sleep(3000);
//	investInStockPage.getNameOfFund();
//	System.out.println(investInStockPage);
}
}
