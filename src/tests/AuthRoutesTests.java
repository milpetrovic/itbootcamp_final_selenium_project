package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AuthRoutesTests extends BasicTest{
		
		SoftAssert softAssert = new SoftAssert();
	
	@Test(priority = 10)
	public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/home");
		softAssert.assertEquals(baseUrl + "/login", "https://vue-demo.daniel-avellaneda.com/login");	
		softAssert.assertAll();
	}
	
	@Test(priority = 20)
	public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/profile");
		softAssert.assertEquals(baseUrl + "/login", "https://vue-demo.daniel-avellaneda.com/login");
		softAssert.assertAll();
	}
	
	@Test(priority = 30)
	public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/admin/cities");
		softAssert.assertEquals(baseUrl + "/login", "https://vue-demo.daniel-avellaneda.com/login");
		softAssert.assertAll();
	}
	
	@Test(priority = 40)
	public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/admin/users");
		softAssert.assertEquals(baseUrl + "/login", "https://vue-demo.daniel-avellaneda.com/login");	
		softAssert.assertAll();
	}
	
	

	

}
