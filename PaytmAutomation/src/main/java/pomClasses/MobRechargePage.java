package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobRechargePage {

	//For PostPaid
	@FindBy (xpath = "//label[@class='']")
	private WebElement postpaidButton;
	@FindBy (xpath = "//button[text()='Proceed to Pay Bill']")
	private WebElement proceesToPay;
	//For Pre-paid
	@FindBy (xpath = "//input[@type='tel']")
	private WebElement mobNo;
	@FindBy (xpath = "(//input[@autocomplete='new-password'])[2]")
	private WebElement amount;
	@FindBy (xpath = "//button[text()='Proceed to Recharge']")
	private WebElement rechargeButton;
	@FindBy (xpath = "(//div[@class='_1aEZ'])[1]")
	private WebElement firstplan;
	@FindBy (xpath = "//img[@alt='close']")
	private WebElement paymentTabClose;
	
	public MobRechargePage(WebDriver driver) {
		PageFactory.initElements(driver, this);}
	
	//Prepaid recharge manual amount entry
	public void toEnterMobNo(String mob) {
		mobNo.sendKeys(mob);}
	public void toEnterAmount(String amnt) {
		amount.sendKeys(amnt);}
	public void toClickOnProceedAndClosePopup() {
		rechargeButton.click();
		paymentTabClose.click();}
	//Prepaid Recharge by selecting plan
	public void prepaidRechargeByPlan() {
		mobNo.sendKeys("7767890840");
		firstplan.click();
		rechargeButton.click();
		paymentTabClose.click();}
	//Postpaid Recharge
	public void postpaidRecharge() {
		postpaidButton.click();}
	public void postpaidData() {
		mobNo.sendKeys("7767890840");
		amount.sendKeys("50");
		proceesToPay.click();
		paymentTabClose.click();}
	public String getTextOfButton() {
		String text=rechargeButton.getText();
		return text;}

}
