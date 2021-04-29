package week2.Day2.Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver ();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Email")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("Raj@yahoo.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String text = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]/div/a ")).getText();
		System.out.println("Name of the User "+text);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.findElement(By.xpath("(//table/tbody/tr/td[3]/div/a)[1]")).click();
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
     try {
  			Thread.sleep(2000);
  		} catch (InterruptedException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
    
     String text2 =driver.getTitle();
    
     
     if(text2.equals("Duplicate Lead | opentaps CRM")) {
    	 
    	 System.out.println("Title matchs as "+ text2);
     }
     else {
    	 System.out.println("title doesnot match");
     }
		
     driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     String text3 = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
   
     if (text.equals(text3)) {
    	 
    	  System.out.println("Duplicate Lead name captured "+ text3);
     }
     else {
    	 System.out.println("duplicated lead name is not same as captured name");
     }
     
     driver.close();
	}

}
