package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdminCitiesTests extends BasicTest{
	
	
	
	@Test(priority = 10)
	public void visitsTheAdminCitiesPageAndListCities() {
		SoftAssert softAssert = new SoftAssert();
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginButton().click();
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		String currentUrl = driver.getCurrentUrl();
		softAssert.assertEquals(currentUrl, "https://vue-demo.daniel-avellaneda.com/admin/cities");
		softAssert.assertAll();
	}
	
	@Test(priority = 20)
	public void checksInputTypesForCreateEditNewCity () {
		SoftAssert softAssert = new SoftAssert();
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getNewItemButton().click();
		citiesPage.waitForCreateOrEditDialogToBeVisible();
		WebElement city = citiesPage.getNewItemInput(); 
		softAssert.assertEquals(city.getAttribute("type"), "text");
		softAssert.assertAll();
		
	}
	
	@Test(priority = 30)
	public void CreateNewCity() {
		SoftAssert softAssert = new SoftAssert();
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getNewItemButton().click();
		citiesPage.waitForCreateOrEditDialogToBeVisible();
		citiesPage.getNewItemInput().sendKeys("Nnis");
		citiesPage.getSaveButton().click();
		messagePopUpPage.waitForSuccessPopUp();
		WebElement successText = messagePopUpPage.getSuccessPopUpText();
		System.out.println(successText.getText());
		softAssert.assertEquals(successText.getText().toString(), "Saved successfully CLOSE");
		softAssert.assertAll();
		
	}
	
	@Test(priority = 40)
	public void EditCity() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getSearchInput().sendKeys("Nnis");
		citiesPage.waitForNumberOfRaws(1);
		citiesPage.waitEditButton(1).click();
		citiesPage.waitForCreateOrEditDialogToBeVisible();
		Thread.sleep(1000);
		citiesPage.getEditItemInput().sendKeys(Keys.CONTROL + "a");
		citiesPage.getEditItemInput().sendKeys(Keys.DELETE);
		citiesPage.getEditItemInput().sendKeys("Nnis Edited");
		citiesPage.getSaveButton().click();
		messagePopUpPage.waitForSuccessPopUp();
		WebElement successText = messagePopUpPage.getSuccessPopUpText() ;
		softAssert.assertEquals(successText.getText().toString(), "Saved successfully CLOSE");	
		softAssert.assertAll();
		
	}
	
	@Test(priority = 50)
	public void SearchCity() {
		SoftAssert softAssert = new SoftAssert();
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getSearchInput().sendKeys("Nnis Edited");
		citiesPage.waitForNumberOfRaws(1);
		citiesPage.waitCellFromTheTable(1, 2);
		WebElement nameCell = citiesPage.waitCellFromTheTable(1, 2);
		softAssert.assertEquals(nameCell.getText(), "Nnis Edited");	
		softAssert.assertAll();
	}
	
	@Test(priority = 60)
	public void DeleteCity() {
		SoftAssert softAssert = new SoftAssert();
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getSearchInput().sendKeys("Nnis Edited");
		citiesPage.waitForNumberOfRaws(1);
		citiesPage.waitCellFromTheTable(1, 2);
		WebElement nameCell = citiesPage.waitCellFromTheTable(1, 2);
		softAssert.assertEquals(nameCell.getText(), "Nnis Edited");	
		citiesPage.waitDeleteButton(1).click();
		citiesPage.waitForDeleteDialogToBeVisible();
		citiesPage.getDeleteButton().click();
		WebElement successText = messagePopUpPage.getSuccessPopUpText() ;
		softAssert.assertEquals(successText.getText(), " Deleted successfully ");
		softAssert.assertAll();
		
	}



}
