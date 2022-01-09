package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//handling alert with only ok option		
//		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
//		Thread.sleep(3000);
//		driver.switchTo().alert().accept();
		
		//handling alert window with ok and cancel button
//		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
//		Thread.sleep(3000);
//		driver.switchTo().alert().accept();//confirming using ok button
//		driver.switchTo().alert().dismiss();//confirming using cancel button
		
		//alert window with input box, capture text from alert
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert();
		Thread.sleep(2000);
		driver.switchTo().alert().sendKeys("how are you");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		
		
		
		}

}
