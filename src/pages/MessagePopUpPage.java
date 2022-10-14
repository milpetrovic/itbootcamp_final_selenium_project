package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage {
	
	private WebDriver driver;
	private WebDriverWait wait;


	public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	}


	public void waitForPopUpToBeVisible() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'error')]")));     
    }
	
	public WebElement getPopUpErrorMessage() {
		return driver.findElement(By.xpath("//div[@class = 'v-snack__content']/ul/li"));

	}
	
	public WebElement getCloseButtonFromPopUpMessage() {
		return driver.findElement(By.xpath("//button//*[text() = 'Close']"));
	}
	
	public void waitForVerifyAcountPopUp() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.className("dlgVerifyAccount")));
    }
	
	public void waitForSuccessPopUp() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.className("success")));
    }
	
	public WebElement getSuccessPopUpText() {
		return driver.findElement(By.xpath("//div[contains(@class, 'success')]/div[@role='status']"));
	}
	
	
	
	public WebElement getMessageFromVerifyAccountPopUp() {
		return driver.findElement(By.className("dlgVerifyAccount"));
	}
	
	public WebElement getCloseButtonFromVerifyAccountPopUp() {
		return driver.findElement(By.className("btnClose"));
	}
	
	
	
	
	
	
	
	
	
	

}
