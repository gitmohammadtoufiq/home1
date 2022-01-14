package Homework;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakingScreenshots {
	
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/mohammadtoufiq/eclipse-workspace/Homework1/chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.delta.com/");
		driver.manage().window().maximize();
		
		//showing the date format
//		Date current=new Date();
//		System.out.println(current);
//		String screenshotname=current.toString().replace("", "-").replace(":", "-");
//		System.out.println(screenshotname);
		
		//taking the screenshot of full page
//		TakesScreenshot ts=(TakesScreenshot) driver;
//		File source=ts.getScreenshotAs(OutputType.FILE);
//		File target=new File(".//screenshots/page.png");
//		FileUtils.copyFile(source, target);
		
		
		//taking the screenshot of portion of a page
//		WebElement section=driver.findElement(By.xpath("//span[@class='card-title brand-head-home']"));		
//		File source2=section.getScreenshotAs(OutputType.FILE);
//		File target2=new File(".//screenshots/portion.png");
//		FileUtils.copyFile(source2, target2);
		
		//taking the screenshot of particular logo or an element
		WebElement ele=driver.findElement(By.xpath("//img[@class='siteLogo']"));
		File source3=ele.getScreenshotAs(OutputType.FILE);
		File target3=new File(".//screenshots/element.png");
		FileUtils.copyFile(source3, target3);
		
		

}
}
