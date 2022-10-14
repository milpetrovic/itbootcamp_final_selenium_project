package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage {
	
	private WebDriver driver;
	private WebDriverWait wait;

	
	public CitiesPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getNewItemButton() {
		return driver.findElement(By.className("btnNewItem"));
	}
	
	public WebElement getSearchInput() {
		return driver.findElement(By.id("search"));
	}
	
	public void waitForCreateOrEditDialogToBeVisible() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.className("dlgNewEditItem")));      
    }
	
	public WebElement getNewItemInput() {
		return driver.findElement(By.id("name"));
	}
	
	public WebElement getEditItemInput() {
		return driver.findElement(By.xpath("//input[@id = 'name']"));
	}
	
	
	public void waitForDeleteDialogToBeVisible() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'v-dialog')]//div[text() = 'Warning']")));  
	}
	
	public WebElement getSaveButton() {
		return driver.findElement(By.className("btnSave"));      
    }
	
	public WebElement getDeleteButton() {
		return driver.findElement(By.xpath("//*[text() = ' Delete ']"));      
    }
	
	public void waitForNumberOfRaws(int rawNumber) {
		wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody/tr"), rawNumber));     
    }
	
	public WebElement waitCellFromTheTable(int rawNumber, int columnNumber) {
		return driver.findElement(By
				.xpath("//tbody/tr[" + rawNumber + "]/td[" + columnNumber + "]")); 
    }
	
	public WebElement waitEditButton(int rawNumber) {
		return driver.findElement(By
				.xpath("//tbody/tr[" + rawNumber + "]//button[@id = 'edit']")); 
    }
	
	public WebElement waitDeleteButton(int rawNumber) {
		return driver.findElement(By
				.xpath("//tbody/tr[" + rawNumber + "]//div/button[2]"));  
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
	
	
	
	
	
	

	

}
