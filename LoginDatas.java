package Login;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.WebSettingsDocument;

import Pom.JsDriver;
import Pom.WaitUtility;

public class LoginDatas {
	public static WebElement email(WebDriver driver) {
		return WaitUtility.click(driver, By.id("email"), 20);
	}

	public static WebElement password(WebDriver driver) {
		return WaitUtility.click(driver, By.id("password"), 20);
	}

	public static WebElement subbtn(WebDriver driver) {
		return WaitUtility.click(driver, By.id("loginBtn"), 20);
	}

	public static WebElement errorMessage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement errmsg = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast toast-error']")));
		return errmsg;
	}

	public static WebElement dashboard(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement errmsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dashboard")));
		errmsg.click(); // WebElement
		// head=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dash-userTitle")));
		return errmsg;
	}

	public static WebElement welcome(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement head = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dash-userTitle")));
		return head;
	}

	public static void leads(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement lead = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Leads")));
		lead.click();
		Thread.sleep(10000);
//		WebDriverWait leadHead = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement head = leadHead.until(ExpectedConditions.visibilityOfElementLocated(By.id("filterBtn")));
//		if (head.isDisplayed()) {}
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement leadbtn = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("addleadBtn")));
		Thread.sleep(8000);
		leadbtn.click();
		Thread.sleep(8000);
//		String url = "https://app.leadcircle.ai/lead/add-lead?form_id=fa680979-f883-49af-b5d5-298c40b77358";
//		WebDriverWait waitLead = new WebDriverWait(driver, Duration.ofSeconds(30));
//		WebElement bc = waitLead.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section")));
//		if (bc == null || !bc.isDisplayed()) {
//		((JavascriptExecutor) driver).executeScript("window.open()");
//		ArrayList<String> newtab = new ArrayList<>(driver.getWindowHandles());
//		driver.switchTo().window(newtab.get(1));
//		String url1 = "https://app.leadcircle.ai/lead/add-lead?form_id=fa680979-f883-49af-b5d5-298c40b77358";
//		driver.get(url1);

//		if (bc.isDisplayed()) {
//			System.out.println("it is in add lead page");
//		} else {
//			System.out.println("you are in wrong page");
//		}

	}

	public static void leadPage(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement lead = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Leads")));
		lead.click();
		Thread.sleep(10000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement leadbtn = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("addleadBtn")));
		Thread.sleep(8000);
		leadbtn.click();
		Thread.sleep(8000);

	}

	public static void zippyLeads(WebDriver driver) {
		WebElement shadowHost = driver.findElement(By.id("leadForm"));

		// Use JavaScript to access the shadow DOM elements directly
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement businessNameInput = (WebElement) js.executeScript(
				"return arguments[0].shadowRoot.querySelector('div.relative > input[placeholder=\" Business Name\"]');",
				shadowHost);

		businessNameInput.click();
		businessNameInput.sendKeys("Test Business");

		WebElement firstNameInput = (WebElement) js.executeScript(
				"return arguments[0].shadowRoot.querySelector('div.relative > input[placeholder=\"First Name\"]');",
				shadowHost);

		firstNameInput.click();
		firstNameInput.sendKeys("John");

		WebElement lastNameInput = (WebElement) js.executeScript(
				"return arguments[0].shadowRoot.querySelector('div.relative > input[placeholder=\"Last Name\"]');",
				shadowHost);
		lastNameInput.click();
		lastNameInput.sendKeys("Doe");

		WebElement phoneNum = (WebElement) js.executeScript(
				"return arguments[0].shadowRoot.querySelector('div.relative > input[placeholder=\"Phone Number\"]');",
				shadowHost);
		phoneNum.click();
		phoneNum.sendKeys("1234567890");

		WebElement emailInput = (WebElement) js.executeScript(
				"return arguments[0].shadowRoot.querySelector('div.relative > input[placeholder=\"Email\"]');",
				shadowHost);

		emailInput.click();
		emailInput.sendKeys("john@example.com");

//		WebElement desCription = (WebElement) js.executeScript(
//				"return arguments[0].shadowRoot.querySelector('div.relative > input[placeholder=\"Description\"]');",
//				shadowHost);
//
//		desCription.click();
//		desCription.sendKeys("Embrace challenges, learn from failures, and grow stronger every day");

//		WebElement submitButton = (WebElement) js
//				.executeScript("return arguments[0].shadowRoot.querySelector('.next.action-button');", shadowHost);
//		submitButton.click();
		// Use JavaScript to get the shadow root

	}

	public static void submitButtonLead(WebDriver driver) {
		jsExcutor(driver);
		WebElement shadowHostParent = driver.findElement(By.id("leadForm"));

		// Use JavaScript to access the shadow DOM and locate the Submit button
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement submitButton = (WebElement) js.executeScript(
				"return arguments[0].shadowRoot.querySelector('.next.action-button');", shadowHostParent);

		// Scroll to the submit button and click it using JavaScript
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", submitButton);
		js.executeScript("arguments[0].click();", submitButton);
		System.out.println("submit button is clicked and the lead added");
//		WebElement shadowHost = driver.findElement(By.cssSelector("#leadForm"));
//
//		// Use JavaScript to get the shadow root and locate the submit button
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		WebElement submitButton = (WebElement) js.executeScript(
//		    "return arguments[0].shadowRoot.querySelector('button[type=\"submit\"]');", shadowHost
//		);
//
//		// Scroll to the submit button
//		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", submitButton);
//
//		// Click the submit button
//		submitButton.click();
	}

	public static WebElement clickOnClient(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement client = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Clients")));
		client.click();
		return client;
	}

	public static WebElement clientForm(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement clkbtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='adduserbtn']")));
		clkbtn.click();
		return clkbtn;

	}

	public static WebElement addClientForm(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement formvisible = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-body']")));
		return formvisible;
	}

	public static WebElement datasOfClient(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement bname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("business_name")));
		bname.click();
		;
		return bname;
	}

	public static void jsExcutor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	}

	public static WebElement countryName(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement country = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("select2-country-container")));
		country.click();
		List<WebElement> element = driver.findElements(By.xpath("//ul[@id='select2-country-results']//li"));
		for (WebElement webElement : element) {
			String text = webElement.getText().trim().toLowerCase();
			String originalValue = "United States".trim().toLowerCase();
			if (text.equals(originalValue)) {
				webElement.click();
				break;
			}

		}
		return country;
	}

	public static WebElement phoneField(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement phoneNum = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone_number")));
		phoneNum.click();
		return phoneNum;
	}

	public static WebElement websiteField(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement web = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("website")));
		web.click();
		return web;
	}

	public static WebElement subbutton(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement subbutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='stepperbtn']")));
		subbutton.click();
		return subbutton;
	}

	public static WebElement viewPage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement clientViewPage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-body p-4']")));
		return clientViewPage;
	}

//	public static void retriveTheDatas(WebDriver driver) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		WebElement rows = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-sm-12']")));
//		System.out.println("the row text" + rows.getText());
//		List<WebElement> rowDatas = rows.findElements(By.xpath("//div[@class='col-sm-12']//table//tbody//tr"));
//
//		System.out.println("Number of rows " + rowDatas.size());
//		for (WebElement element : rowDatas) {
//			List<WebElement> colmn = element.findElements(By.tagName("td"));
//			for (WebElement celldata : colmn) {
//				System.out.println(celldata.getText());
//			}
//		}
//
//	}

	public static void userNav(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Users")));
		user.click();

	}

	public static void addUserBtn(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement addbtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='adduserbtn']")));
		addbtn.click();

	}

	public static void jsExcutors(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}

	public static void detailsOfUser(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement fname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name")));
		fname.click();
		fname.sendKeys("hari");
		WebElement lname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last_name")));
		lname.click();
		lname.sendKeys("sai");

	}

	public static void mailAndPhone(WebDriver driver) {
		jsExcutors(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		email.click();
		Random ran = new Random();
		int num = ran.nextInt(1000);
		email.sendKeys("hari" + num + "@yopmail.com");
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement phno = waits
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='user_phone_number']")));
		phno.click();
		phno.sendKeys("1" + num + "121-2121");
		WebDriverWait zip = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement zipcode = zip
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='zipcode']")));
		zipcode.click();
		zipcode.sendKeys("12345");
		WebDriverWait waitstate = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement btn = waitstate.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_user")));
		btn.click();

	}

//	public static void countryField(WebDriver driver) {
//		WebDriverWait waitCon = new WebDriverWait(driver, Duration.ofSeconds(20));
//		WebElement country = waitCon
//				.until(ExpectedConditions.visibilityOfElementLocated(By.id("select2-user_country-container")));
//		country.click();	
//		List<WebElement> element = driver.findElements(By.xpath("//ul[@id='select2-user_country-results']//li"));
//		for (WebElement webElement : element) {
//			String text = webElement.getText().trim().toLowerCase();
//			String originalValue = "United States".trim().toLowerCase();
//			if (text.equals(originalValue)) {
//				webElement.click();
//				break;
//			}
//		}
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//		WebElement state = wait.until(
//				ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='select2-user_state-results']")));
//		state.click();
//		List<WebElement> statelist = driver.findElements(By.xpath("//ul[@id='select2-user_state-results']//li"));
//		for (WebElement statelists : statelist) {
//			String text = statelists.getText().trim().toLowerCase();
//			String originalState = "California".trim().toLowerCase();
//			if (text.equals(originalState)) {
//				statelists.click();
//				break;
//			}
//			
//		}

	// }
}
