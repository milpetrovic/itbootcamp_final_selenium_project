package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SignupTests extends BasicTest {
	
	SoftAssert softAssert = new SoftAssert();
	
	@Test(priority = 10)
	public void visitsTheSignupPage() {
		navPage.getSignUpButton().click();
		String currentUrl = driver.getCurrentUrl();
		softAssert.assertEquals(currentUrl, "https://vue-demo.daniel-avellaneda.com/signup");	
	}
	
	@Test(priority = 20)
	public void checksInputTypes() {
		navPage.getSignUpButton().click();
		WebElement email = signUpPage.getEmailInput();
		softAssert.assertEquals(email.getAttribute("type"), "email");
		WebElement password = signUpPage.getPasswordInput();
		softAssert.assertEquals(password.getAttribute("type"), "password");
		WebElement confirmPassword = signUpPage.getConfirmPasswordInput();
		softAssert.assertEquals(password.getAttribute("type"), "password");
		softAssert.assertAll();
	}
	
	@Test(priority = 30)
	public void  displaysErrorsWhenAlreadyExist() {
		navPage.getSignUpButton().click();
		String currentUrl = driver.getCurrentUrl();
		softAssert.assertEquals(currentUrl, "https://vue-demo.daniel-avellaneda.com/signup");
        signUpPage.getNameInput().sendKeys("Another User");
        signUpPage.getEmailInput().sendKeys ("admin@admin.com");
        signUpPage.getPasswordInput().sendKeys("12345");
        signUpPage.getConfirmPasswordInput().sendKeys("12345");
        signUpPage.getSignMeUpButton().click();
        messagePopUpPage.waitForPopUpToBeVisible();
        WebElement errorMessage = messagePopUpPage.getPopUpErrorMessage();
		softAssert.assertEquals(errorMessage.getText(), "E-mail already exists");
		String currentUrl1 = driver.getCurrentUrl();
		softAssert.assertEquals(currentUrl1, "https://vue-demo.daniel-avellaneda.com/signup");
	}
	
	@Test(priority = 40)
	public void signup() {
		navPage.getSignUpButton().click();
		signUpPage.getNameInput().sendKeys( "Ime i prezime polaznika");
	    signUpPage.getEmailInput().sendKeys ("ime.prezime@itbootcamp.rs");
	    signUpPage.getPasswordInput().sendKeys("12345");
	    signUpPage.getConfirmPasswordInput().sendKeys("12345");
	    signUpPage.getSignMeUpButton().click();
	    String currentUrl = driver.getCurrentUrl();
		softAssert.assertEquals(currentUrl, "https://vue-demo.daniel-avellaneda.com/home");
		messagePopUpPage.getCloseButtonFromVerifyAccountPopUp().click();
		navPage.getLogoutButton().click();
	}
	
	
	
	
	

}
