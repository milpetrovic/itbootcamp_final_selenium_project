package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTests extends BasicTest{
	
	
		
	@Test(priority = 10)
	public void visitsTheLoginPage() {
		SoftAssert softAssert = new SoftAssert();
		navPage.getLanguageButton().click();
		navPage.getEnglishLanguageButton().click();
		navPage.getLoginButton().click();
		String currentUrl = driver.getCurrentUrl();
		softAssert.assertEquals(currentUrl, "https://vue-demo.daniel-avellaneda.com/login");
		softAssert.assertAll();
		
	}
	
	@Test(priority = 20)
	public void checksInputTypes () {
		SoftAssert softAssert = new SoftAssert();
		navPage.getLoginButton().click();
		WebElement email = loginPage.getEmailInput();
		softAssert.assertEquals(email.getAttribute("type"), "email");
		WebElement password = loginPage.getPasswordInput();
		softAssert.assertEquals(password.getAttribute("type"), "password");
		softAssert.assertAll();
		
	}
	
	@Test(priority = 30)
	public void  displaysErrorsWhenUserDoesNotExist() {
		SoftAssert softAssert = new SoftAssert();
		navPage.getLoginButton().click();;
		loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
		loginPage.getPasswordInput().sendKeys("password123");
		loginPage.getLoginButton().click();
		messagePopUpPage.waitForPopUpToBeVisible();
		WebElement errorMessage = messagePopUpPage.getPopUpErrorMessage();
		softAssert.assertEquals(errorMessage.getText(), "User does not exists");
		String currentUrl = driver.getCurrentUrl();
		softAssert.assertEquals(currentUrl, "https://vue-demo.daniel-avellaneda.com/login");
		softAssert.assertAll();
		
	}
	
	@Test(priority = 40)
	public void  displaysErrorsWhenPasswordIsWrong() {
		SoftAssert softAssert = new SoftAssert();
		navPage.getLoginButton().click();;
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("password123");
		loginPage.getLoginButton().click();
		messagePopUpPage.waitForPopUpToBeVisible();
		WebElement wrongPassword = messagePopUpPage.getPopUpErrorMessage();
		softAssert.assertEquals(wrongPassword.getText(), "Wrong password");
		String currentUrl = driver.getCurrentUrl();
		softAssert.assertEquals(currentUrl, "https://vue-demo.daniel-avellaneda.com/login");
		softAssert.assertAll();
	}
	
	
	@Test(priority = 50)
	public void  login() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginButton().click();
		Thread.sleep(1000);
		String currentUrl = driver.getCurrentUrl();
		softAssert.assertEquals(currentUrl, "https://vue-demo.daniel-avellaneda.com/home");
		softAssert.assertAll();
	}
	
	@Test(priority = 60)
	public void logout() {
		SoftAssert softAssert = new SoftAssert();
		WebElement logoutButton = navPage.getLogoutButton();
		softAssert.assertTrue(logoutButton.isDisplayed());
		logoutButton.click();
		softAssert.assertAll();
	}
	

}
