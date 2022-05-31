package testPaytm;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browsers.Base;
import pomClasses.MobRechargePage;
import pomClasses.PaytmHomePage;
import utils.Utility;

public class VerifyRechargeAndStockTabs {

	WebDriver driver;
	PaytmHomePage paytmHomePage;
	MobRechargePage mobRechargePage;
	int row=1;
	int column=0;
	int col1=1;
	int testID;
	
	@Parameters ("browserName")
	@BeforeTest
	public void launchBrowser(String browser) {
		if(browser.equals("Chrome"))
		{driver= Base.launchChromeBrowser();}
		if(browser.equals("Edge"))
	    {driver=Base.launchEdgeBrowser();}
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);} 
	
	@BeforeClass
	public void createPomClassObject() {
		paytmHomePage= new PaytmHomePage(driver);
		mobRechargePage=new MobRechargePage(driver);
	}
	
	@BeforeMethod
	public void launchPaytmAppl() throws InterruptedException {
		driver.get("https://paytm.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);}
	
	@Test (invocationCount=3)
	public void verifyRechargeTab() throws EncryptedDocumentException, IOException, InterruptedException  {
		testID=10101;
		paytmHomePage= new PaytmHomePage(driver);
		mobRechargePage=new MobRechargePage(driver);
		paytmHomePage.rechargeButton();
		mobRechargePage=new MobRechargePage(driver);
//		text=mobRechargePage.getTextOfButton();
//		Assert.assertEquals("Proceed to Recharge", text);
//		mobRechargePage.prepaidRechargeByPlan();
		String datas=Utility.fetchExcelSheetData("Rohit",row,column);
		mobRechargePage.toEnterMobNo(datas);
		Thread.sleep(2000);
		datas=Utility.fetchExcelSheetData("Rohit",row,col1);
		mobRechargePage.toEnterAmount(datas);
		Thread.sleep(2000);
//		mobRechargePage.toClickOnProceedAndClosePopup();
		String url1=driver.getCurrentUrl();
		String title1=driver.getTitle();
		Assert.assertEquals("https://paytm.com/recharge", url1);
		Assert.assertEquals("Online Recharge - Online Mobile Recharge & Prepaid Recharge Plans", title1);
		row++;}
//		if(url1.equals("https://paytm.com/recharge") && title1.equals("Online Recharge - Online Mobile Recharge & Prepaid Recharge Plans"))
//		{System.out.println("Pass");}
//		else
//		{System.out.println("Fail");}}
	
//	@Test 
//	public void verifyStockTab() throws InterruptedException {
//		testID=10102;
//		Thread.sleep(1000);
//		paytmHomePage.clickOnStockTab();
//		String url2=driver.getCurrentUrl();
//		String title2=driver.getTitle();
//		Assert.assertEquals("https://www.paytmmone.com/", url2);
//		Assert.assertEquals("Paytm Money - Online Demat Account, Trading, Direct Mutual Funds & NPS", title2);}
//		if(url2.equals("https://www.paytmmoney.com/") && title2.equals("Paytm Money - Online Demat Account, Trading, Direct Mutual Funds & NPS"))
//		{System.out.println("Pass");}
//		else
//		{System.out.println("Fail");}}
	
	@AfterMethod
	public void toCaptureScreenshot(ITestResult result) throws IOException, InterruptedException {
		if(ITestResult.FAILURE == result.getStatus())
		{Utility.captureSnapshot(driver,testID);}
		Thread.sleep(2000);}
	
	@AfterClass
	public void clearPomClassObjects() {
		paytmHomePage=null;
		mobRechargePage=null;}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver=null;
		System.gc();}
}
