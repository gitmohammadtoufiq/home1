package Homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Popups {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		
		//authenticate popup
		//driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");//admin:admin basically skips the pop ups and authenticate the popup
		
		
		//permission popup and how to disable this popup
		driver.get("https://www.redbus.in/");
	}

}
