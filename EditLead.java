package week2.Day2.Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver ();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Abi");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table/tbody/tr/td/div/a")).click();
		String text = driver.getTitle();
		
		if (text.equals("View Lead | opentaps CRM")) {
			
			System.out.println("title matches "+text);
		}
		else {
			System.out.println("title doesn't match");
		}
		String text2 = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println(text2);
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("capegemini");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		String text3 =driver.findElement(By.id("viewLead_companyName_sp")).getText();
		
		if (text2.equals(text3)) {
			System.out.println("No changes are updated ");
		}
		else {
			System.out.println("Company name change is updated");
		}
	}

}
