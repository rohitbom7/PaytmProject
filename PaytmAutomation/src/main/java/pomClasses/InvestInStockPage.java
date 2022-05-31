package pomClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvestInStockPage {

	@FindBy (xpath = "//div[text()='Products']")
	private WebElement products;
	@FindBy (xpath = "(//a[@href='/mutual-funds'])[1]")
	private WebElement mutualFund;
	@FindBy (xpath = "(//div[@class='_1HXsW9QWFxVkCfw2bCnhT2'])[2]")
	private WebElement bestReturnTab;
	@FindBy (xpath = "(//div[@class='btbnvd-3 ixkIui'])[1]")
	private WebElement selectFirst;
	@FindBy (xpath = "//h1[@class='pm7u8-4 dOizIq']")
	private WebElement fundName;
	@FindBy (xpath = "//div[text()='Equity Funds']")
	private WebElement equity;
	
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions a;
	public InvestInStockPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,5);
		js=(JavascriptExecutor)driver;
		a=new Actions(driver);}
	
	public void clickOnMutualFund() {
//		js.executeScript("window.scrollBy(0,1000)");
		wait.until(ExpectedConditions.visibilityOf(products));
		a.moveToElement(products).click().build().perform();
		a.moveToElement(mutualFund).click().build().perform();}
//		mutualFundTab.click();}
	public void scroll() {
		js.executeScript("window.scrollBy(0,900)");}
	public void clickOnbestReturn() {
		a.moveToElement(bestReturnTab).click().build().perform();}
//		bestReturnTab.click();}
	
	public void clickOnFirstFund() {
		wait.until(ExpectedConditions.visibilityOf(selectFirst));
		selectFirst.click();}
	
	public void getNameOfFund() {
		String text=fundName.getText();
		
	}
}
