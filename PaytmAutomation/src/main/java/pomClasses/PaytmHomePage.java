package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaytmHomePage {

	@FindBy (xpath = "(//div[@class='_2EGQY cqA0P'])[1]")
	private WebElement rechargeTab;
	
	@FindBy (xpath = "(//div[@class='_2EGQY'])[7]")
	private WebElement stockTab;
	
	public PaytmHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);}
	
	public void rechargeButton() {
		rechargeTab.click();}
	//or
	public void clickOnStockTab() {
		stockTab.click();}
}
