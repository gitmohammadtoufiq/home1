package Homework;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/mohammadtoufiq/eclipse-workspace/Homework1/chromedriver");
		WebDriver himel = new ChromeDriver();
		
		//open google.com
		himel.get("https://www.google.com/");
		himel.manage().window().maximize();	
		
			
		
		//search amex in the search box
		himel.findElement(By.name("q")).sendKeys("amex");
		
		//look at all the suggestions
		List<WebElement> list = himel.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='pcTkSc']"));
		
		Thread.sleep(2000);
		
		//select AmEx from the suggestions 
		for (int i = 0; i < list.size(); i++) {
			String listItem = list.get(i).getText();
			if (listItem.contains("AmEx")) {
				list.get(i).click();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		//select the first link from the page
	    himel.findElement(By.xpath("//a[@href='https://www.americanexpress.com/']/h3[text()='American Express Credit Cards, Rewards & Banking']")).click();
	    
	    Thread.sleep(1000);
	    
	    //get  the title of the current page
	    System.out.println("Title of the home page is:"+himel.getTitle()); 
	    
	    //get url of the current page
		System.out.println("Url of the home page is:"+himel.getCurrentUrl());//this is the url of current page.com
		
		himel.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//find all the links
		List<WebElement> links=himel.findElements(By.tagName("a"));
		
		System.out.println("Total links are "+links.size());
		
		for(int i=0;i<links.size();i++)
		{
			
			WebElement ele= links.get(i);
			
			String url=ele.getAttribute("href");
			
			verifyLinkActive(url);
			himel.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
		}
		
	}
	
	
	public static void verifyLinkActive(String linkUrl)
	{
        try 
        {
           URL url = new URL(linkUrl);
           
           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
           
           httpURLConnect.setConnectTimeout(3000);
           
           httpURLConnect.connect();
           
           if(httpURLConnect.getResponseCode()==200)
           {
               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
               
            }
          if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
           {
               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
            }
        } catch (Exception e) {
           
        }
    } 
	
	
	 

}
		
		
		
//		List<WebElement>link_names=himel.findElements(By.tagName("a"));
//		int link_count=link_names.size();
//		System.out.println("Total number of links are: "+link_count);
		
		
		//printing out all the links name
//		for(int i=0; i<link_count; i++) {
//			WebElement storage= link_names.get(i);
//			String names=storage.getText(); 
//			System.out.println("The urls are: "+names);
//		}
		
		
		
		
	
