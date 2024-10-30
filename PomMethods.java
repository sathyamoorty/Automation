package Login;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Login.LoginDatas;
import Pom.JsDriver;

@Listeners(Login.ExtentReport.class)
public class PomMethods {

	static WebDriver driver;

	@BeforeClass
	public static void startMethod() {
		System.setProperty("weddriver.chrome.driver",
				"C:\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://app.leadcircle.ai/login/");
		driver.manage().window().maximize();
	}

	//@AfterClass
//	public static void startMethodpostcondition() {
//		driver.manage().window().minimize();
//		driver.quit();
//	}

	// This is for invalid mail and valid password
	@Test(priority = 1)
	public void invalidEmail() {
		try {
			LoginDatas.email(driver).sendKeys("ramu@yopmail");// stephen000
			LoginDatas.password(driver).sendKeys("Password@123");
			LoginDatas.subbtn(driver).click();
			WebElement errmsg = LoginDatas.errorMessage(driver);
			if (errmsg.isDisplayed()) {
				System.out.println(errmsg.getText());
			} else {
				System.out.println("Working fine");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			driver.navigate().refresh();
		}
	}

	// This is for valid mail and invalid password
	@Test(priority = 2)
	public void invalidPassword() {
		try {
			LoginDatas.email(driver).sendKeys("zaigo@yopmail.com");// stephen000
			LoginDatas.password(driver).sendKeys("pass");
			LoginDatas.subbtn(driver).click();
			WebElement errmsg = LoginDatas.errorMessage(driver);
			if (errmsg.isDisplayed()) {
				System.out.println(errmsg.getText());
			} else {
				System.out.println("working fine");
				driver.quit();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			driver.navigate().refresh();
		}
	}

	// This is for valid mail and valid password
	@Test(priority = 3)
	public void bothValid() {
		try {
			LoginDatas.email(driver).sendKeys("stephenN@yopmail.com");// stephen000
			LoginDatas.password(driver).sendKeys("Password@123");
			LoginDatas.subbtn(driver).click();
			WebElement sucessmsg = LoginDatas.dashboard(driver);
			WebElement head = LoginDatas.welcome(driver);
			if (sucessmsg.isDisplayed() && head.isDisplayed()) {
				System.out.println(sucessmsg.getText() + ", Is the correct page");
			} else {
				System.out.println("it is in wrong page");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 4)
	public void leads() throws InterruptedException {
		LoginDatas.leads(driver);
	}

	@Test(priority = 5)
	public void leadsOfPage() throws InterruptedException {
		LoginDatas.leadPage(driver);
	}

	@Test(priority = 6)
	public void leadsDatas() {
		LoginDatas.zippyLeads(driver);
		LoginDatas.submitButtonLead(driver);
	} 

	// After login and it goes to the dashboard page and click on the client nav
	@Test(priority = 7)
	public void client() {
		try {

			LoginDatas.clickOnClient(driver);
			LoginDatas.clientForm(driver);
			WebElement formpage = LoginDatas.addClientForm(driver);
			if (formpage.isDisplayed()) {
				System.out.println("It is the correct page to test");
			} else {
				System.out.println("Something wrong in the testing");
				driver.quit();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

//
//	// In the client, click on the add client button and
//	// it gives all the datas and submit the client form.
	@Test(priority = 8)
	public void datasOfClientPage() {
		try {
			LoginDatas.jsExcutor(driver);
			Random ran = new Random();
			int num = ran.nextInt(1000);
			LoginDatas.datasOfClient(driver).sendKeys("Car ShowRoom " + num);
			LoginDatas.countryName(driver);
			LoginDatas.phoneField(driver).sendKeys("1234567890");
			LoginDatas.websiteField(driver).sendKeys("www.chatgpt.com");
			LoginDatas.subbutton(driver);
			WebElement viewclientPage = LoginDatas.viewPage(driver);
			if (viewclientPage.isDisplayed()) {
				System.out.println("client has been added");
			} else {
				System.out.println("Something went wrong");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 9)
	public void getDatas() {
		LoginDatas.jsExcutor(driver);
	}

	@Test(priority = 10)
	public void userPage() {
		LoginDatas.userNav(driver);
		LoginDatas.addUserBtn(driver);
		LoginDatas.detailsOfUser(driver);

	}

	@Test(priority = 11)
	public void datasOfUser() {
		LoginDatas.mailAndPhone(driver);
		
	}

}
////////////////////////////////
