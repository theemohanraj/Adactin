import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumMethods {

	public static void main(String[] args) throws Throwable {

		System.setProperty("webdriver.chrome.driver", "D:\\Eclipse Backup_0512\\Eclipse\\Adactin\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://adactinhotelapp.com/index.php");
		driver.manage().window().maximize();

		String currentUrl = driver.getCurrentUrl();
		System.out.println("Cureent Url: " + currentUrl);

		String title = driver.getTitle();
		System.out.println("Title: " + title);

		/*
		 * String pageSource = driver.getPageSource(); System.out.println(pageSource);
		 */

		// SendKeys

		WebElement user = driver.findElement(By.id("username"));
		user.sendKeys("SeMohanraj");

		WebElement pass = driver.findElement(By.name("password"));
		pass.sendKeys("one1two2");

		// GetAttribute

		String attribute = user.getAttribute("id");
		System.out.println("User Attribute name: " + attribute);

		String attribute2 = pass.getAttribute("password");
		System.out.println("Pass Attribute Value: " + attribute2);

		// GetText

		WebElement para = driver.findElement(By.xpath(
				"//li[contains(text(),'Thus, functional test cases and automation scripts will fail on this build. ' )]"));
		String l1 = para.getText();
		System.out.println("para: " + l1);

		WebElement LogIn = driver.findElement(By.id("login"));
		LogIn.click();

		// SelectClass

		WebElement loc = driver.findElement(By.name("location"));
		Select s = new Select(loc);
		s.selectByIndex(1);
		List<WebElement> options = s.getOptions();
		for (WebElement webElement : options) {
			
		}
		System.out.println(options);

		WebElement hotels = driver.findElement(By.id("hotels"));
		Select s1 = new Select(hotels);
		s1.selectByValue("Hotel Creek");
		WebElement fso = s1.getFirstSelectedOption();
		System.out.println(fso);

		WebElement room_type = driver.findElement(By.id("room_type"));
		Select s2 = new Select(room_type);
		s2.selectByVisibleText("Super Deluxe");

		WebElement room_nos = driver.findElement(By.id("room_nos"));
		Select s3 = new Select(room_nos);
		s3.selectByValue("1");

		WebElement check_In = driver.findElement(By.id("datepick_in"));
		//check_In.clear();
		
		  Robot r = new Robot(); 
		  check_In.click();
		  r.keyPress(KeyEvent.VK_CONTROL);
		  r.keyPress(KeyEvent.VK_A); r.keyRelease(KeyEvent.VK_CONTROL);
		  r.keyRelease(KeyEvent.VK_A); r.keyPress(KeyEvent.VK_DELETE);
		  r.keyRelease(KeyEvent.VK_DELETE);
		
		
		check_In.sendKeys("05/12/2020");

		WebElement check_out = driver.findElement(By.id("datepick_out"));
		check_out.clear();

		/*
		 * Robot r = new Robot(); r.keyPress(KeyEvent.VK_CONTROL);
		 * r.keyPress(KeyEvent.VK_A); r.keyRelease(KeyEvent.VK_CONTROL);
		 * r.keyRelease(KeyEvent.VK_A); r.keyPress(KeyEvent.VK_DELETE);
		 * r.keyRelease(KeyEvent.VK_DELETE);
		 */
		
		check_out.sendKeys("08/12/2020");

		WebElement adult_room = driver.findElement(By.id("adult_room"));
		Select s4 = new Select(adult_room);
		s4.selectByIndex(2);

		WebElement child_room = driver.findElement(By.id("child_room"));
		Select s5 = new Select(child_room);
		s5.selectByIndex(1);

		WebElement search = driver.findElement(By.id("Submit"));
		search.click();

		WebElement radiobutton = driver.findElement(By.id("radiobutton_0"));
		radiobutton.click();

		WebElement cont = driver.findElement(By.id("continue"));
		cont.click();

		WebElement first_name = driver.findElement(By.id("first_name"));
		first_name.sendKeys("Mohanraj");

		WebElement last_name = driver.findElement(By.id("last_name"));
		Thread.sleep(2000);
		last_name.sendKeys("Selvadurai");

		WebElement address = driver.findElement(By.id("address"));
		address.sendKeys("1/29, Gangai Amman Kovil Street, Ramapuram");

		WebElement ccNum = driver.findElement(By.id("cc_num"));
		ccNum.sendKeys("1234567890987654");

		WebElement cc_type = driver.findElement(By.id("cc_type"));
		Select s6 = new Select(cc_type);
		s6.selectByVisibleText("Master Card");

		WebElement cc_exp_month = driver.findElement(By.id("cc_exp_month"));
		Select s7 = new Select(cc_exp_month);
		s7.selectByIndex(5);

		WebElement cc_exp_year = driver.findElement(By.id("cc_exp_year"));
		Select s8 = new Select(cc_exp_year);
		s8.selectByIndex(5);

		WebElement cvv = driver.findElement(By.id("cc_cvv"));
		cvv.sendKeys("250");

		// Screenshot
		TakesScreenshot tk = (TakesScreenshot) driver;
		File ss = tk.getScreenshotAs(OutputType.FILE);
		File img = new File("D:\\Java_Files\\Eclipse\\Adactin\\Screenshot\\sn.png");
		FileUtils.copyFile(ss, img);

		WebElement book = driver.findElement(By.id("book_now"));
		book.click();

		
		WebElement itinerary = driver.findElement(By.name("my_itinerary"));
		itinerary.click();
		 
		  WebElement logout = driver.findElement(By.name("logout")); logout.click();

	}

}
