package training_MiniProject;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateECommerceWebsite {

	static WebDriver driver = driverSetup();
	static WebDriverWait wait = waitSetup();
	static Properties prop;

	public static void main(String[] args) {

		/* Locating the Sign-in -> Click On it. */
		WebElement SignIn = locateElement("className", "login");
		SignIn.click();

		/*
		 * Accepting email id from user -> Passing the accepted email address in 'Create
		 * and account' section.
		 */ 
		AutomateECommerceWebsite ac = new AutomateECommerceWebsite();
		try {
			ac.propertySetup();
		} catch (Exception e) {
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		}

		WebElement Email_address = locateElement("id", "email_create");
		Email_address.sendKeys(prop.getProperty("email"));

		WebElement Create__an_account = locateElement("cssSelector", "button[id='SubmitCreate'] span");
		// Click on sign in link.
		Create__an_account.click();

		/*
		 * Locating Placeholders and Entering Personal Information, Address and Contact
		 * info.
		 */
		// Locating and Putting values of Placeholders in "Your Personal Information".
		WebElement radioButton = locateElement("id", "id_gender1");
		radioButton.click();

		WebElement firstName = locateElement("id", "customer_firstname");
		firstName.sendKeys("Ram");

		WebElement lastName = locateElement("id", "customer_lastname");
		lastName.sendKeys("Kapoor");

		WebElement pwd = locateElement("id", "passwd");
		pwd.sendKeys("abc123");

		// Locating Dropdowns of "DOB"
		WebElement day = locateElement("id", "days");
		WebElement month = locateElement("id", "months");
		WebElement year = locateElement("id", "years");

		// Putting Values of "DOB" in Dropdowns.
		manageDropDown(day, "6");
		manageDropDown(month, "8");
		manageDropDown(year, "2000");

		// Locating and Putting values of Placeholders in "Your Address".
		WebElement fName = locateElement("id", "firstname");
		fName.sendKeys("Ram");

		WebElement lName = locateElement("id", "firstname");
		lName.sendKeys("Kapoor");

		WebElement Company = locateElement("id", "company");
		Company.sendKeys("CTS");

		WebElement address = locateElement("id", "address1");
		address.sendKeys("Mankato");

		WebElement address2 = locateElement("id", "address2");
		address2.sendKeys("Mississippi");

		WebElement city = locateElement("id", "city");
		city.sendKeys("Mankato Mississippi");

		WebElement state = locateElement("id", "id_state");
		manageDropDown(state, "2");

		WebElement zipCode = locateElement("id", "postcode");
		zipCode.sendKeys("96522");

		WebElement country = locateElement("id", "id_country");
		manageDropDown(country, "21");

		WebElement Add_Info = locateElement("id", "other");
		Add_Info.sendKeys("NA");

		WebElement hPhone = locateElement("id", "phone");
		hPhone.sendKeys("+18436060295");

		WebElement mPhone = locateElement("id", "phone_mobile");
		mPhone.sendKeys("+18436060295");

		WebElement aliasAddFut = locateElement("id", "alias");
		aliasAddFut.clear();
		aliasAddFut.sendKeys("NA");

		// Locating registration Button -> Clicking on it.
		WebElement register = locateElement("cssSelector", "button[id='submitAccount'] span");
		register.click();

		/* Validating if user is created or not -> Printing in console */
		String pageTitle = driver.getTitle();

		if (pageTitle.equalsIgnoreCase("My account - My Store")) {
			System.out.println("User created successfully");
		} else {
			System.out.println("User creation failed");
		}

		/* Moving cursor over Women's link. */
		WebElement hoverOn = locateElement("xpath", "//*[@id=\"block_top_menu\"]/ul/li[1]/a");
		scrollTo(hoverOn);
		mouseHover(hoverOn);

		/* Clicking on sub menu 'T-shirts'. */
		WebElement tshirts = locateElement("xpath", "(//a[@title='T-shirts'])[1]");
		wait.until(ExpectedConditions.elementToBeClickable(tshirts));
		tshirts.click();

		/* Mouse hover on the first product displayed. */
		WebElement mouseHoverOn = locateElement("cssSelector", "img[title='Faded Short Sleeve T-shirts']");
		scrollTo(mouseHoverOn);
		mouseHover(mouseHoverOn);

		/* Clicking On More Button. */
		WebElement more = locateElement("cssSelector", "a[title='View'] span");
		more.click();

		/* Increasing quantity to 2. */
		WebElement increase = locateElement("cssSelector",
				"a[class='btn btn-default button-plus product_quantity_up'] span");
		increase.click();

		/* Selecting size 'L' */
		WebElement size = locateElement("id", "group_1");
		manageDropDown(size, "3");

		/* Select color. */
		WebElement color = locateElement("id", "color_14");
		color.click();

		/* Clicking on 'Add to Cart' button. */
		WebElement aButton = locateElement("cssSelector", "button[name='Submit'] span");
		aButton.click();

		/* Clicking on 'Proceed to checkout' button */
		WebElement pButton = locateElement("linkText", "Proceed to checkout");
		pButton.click();

		/* Completing the buy order process till payment. */
		WebElement pButtonTwo = locateElement("cssSelector",
				"a[class='button btn btn-default standard-checkout button-medium'] span");
		pButtonTwo.click();

		WebElement pButtonThree = locateElement("cssSelector", "button[name='processAddress'] span");
		pButtonThree.click();

		WebElement terms = locateElement("id", "cgv");
		terms.click();

		WebElement pButtonFour = locateElement("cssSelector", "button[name='processCarrier'] span");
		pButtonFour.click();

		WebElement pButtonFive = locateElement("className", "bankwire");
		pButtonFive.click();

		/* Click on I Confirm button. */
		WebElement cnfrmButton = locateElement("cssSelector",
				"button[class='button btn btn-default button-medium'] span");
		cnfrmButton.click();

		/*
		 * Verifying whether displayed message contains “complete” text; if yes product
		 * ordered successfully.
		 */
		WebElement completeText = locateElement("cssSelector", "#center_column > div > p > strong");
		if (completeText.getText().contains("complete")) {
			System.out.println("Order was Successful");
		} else {
			System.out.println("Order Failed");
		}

		/* closing Driver. */
		closeDriver();

	}

	/*** Instantiating Methods ***/

	/* Method for instantiating the driver. */

	public static WebDriver driverSetup() {

		AutomateECommerceWebsite aec = new AutomateECommerceWebsite();
		try {
			aec.propertySetup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (prop.getProperty("browser").equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else if (prop.getProperty("browser").equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (prop.getProperty("browser").equalsIgnoreCase("Internet Explorer")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("Not a valid Browser,Please use a Valid Browser!");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		return driver;

	}

	/* Method to instantiate Wait. */
	public static WebDriverWait waitSetup() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait;
	}

	/* Method for handling Drop-downs. */
	public static void manageDropDown(WebElement dropdown, String valueToBeSeleceted) {
		Select select = new Select(dropdown);
		select.selectByValue(valueToBeSeleceted);
	}

	/* Method for handling mouseHover. */
	public static void mouseHover(WebElement hoverOnElement) {
		Actions action = new Actions(driver);
		action.moveToElement(hoverOnElement).build().perform();
	}

	/* Method for locating Elements. */
	public static WebElement locateElement(String locatorName, String locatorValue) {
		WebElement element = null;

		if (locatorName.equalsIgnoreCase("id"))
			element = driver.findElement(By.id(locatorValue));
		else if (locatorName.equalsIgnoreCase("className"))
			element = driver.findElement(By.className(locatorValue));
		else if (locatorName.equalsIgnoreCase("name"))
			element = driver.findElement(By.name(locatorValue));
		else if (locatorName.equalsIgnoreCase("linkText"))
			element = driver.findElement(By.linkText(locatorValue));
		else if (locatorName.equalsIgnoreCase("partialLinkText"))
			element = driver.findElement(By.partialLinkText(locatorValue));
		else if (locatorName.equalsIgnoreCase("tagName"))
			element = driver.findElement(By.tagName(locatorValue));
		else if (locatorName.equalsIgnoreCase("xpath"))
			element = driver.findElement(By.xpath(locatorValue));
		else if (locatorName.equalsIgnoreCase("cssSelector"))
			element = driver.findElement(By.cssSelector(locatorValue));
		else
			System.out.print("Enter correct locator Name");

		return element;
	}

	/* Method for setting up the properties. */
	public Properties propertySetup() throws Exception {
		String dirPath = System.getProperty("user.dir");
		String filePath = "\\src\\test\\resources\\configuration.properties";
		FileInputStream fs = new FileInputStream(dirPath + filePath);
		prop = new Properties();
		prop.load(fs);
		return prop;
	}

	/* Method for implementation of Scroll. */
	public static void scrollTo(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	/* Method to close the Driver */
	public static void closeDriver() {
		driver.quit();
	}

}
