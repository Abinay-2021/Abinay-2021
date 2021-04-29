package week2.Day2.Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver ();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Phone")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
		driver.findElement(By.linkText("Find Leads")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//String text = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]/div/a")).getText();
		driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]/div/a")).click();
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String text2 = text.replaceAll("[A-Za-z ()]","");
		System.out.println(text2);
		driver.findElement(By.linkText("Delete")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Find Leads")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(text2,Keys.TAB);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String recordResult= driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
	if (recordResult.equalsIgnoreCase("No records to display")) {
		
		System.out.println("Records deleted successfully");
	}
	else {
		System.out.println("Records are not deleted");
	}
	}

}
