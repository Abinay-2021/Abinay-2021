package week2.Day2.Assignments;

import org.openqa.selenium.By;

public class PractiseXpath {

	public static void main(String[] args) {
		
		//1. Launch the URL
		
		//2. Enter the username based on its label
		driver.findElement(By.xpath("//label[@for="username"]/following-sibling::input")).sendKeys("");
		
		//3. Enter the password based on its label
		driver.findElement(By.xpath("//label[@for="password"]/following-sibling::input")).sendKeys("");
		//4. Click Login
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		//5. Click on CRMSFA link
		driver.findElement(By.xpath("//*[@id='label']/a")).click();
		//6. Click on Leads link
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		//7. Click on Merge Leads link
			driver.findElement(By.xpath("//a[text()='Merge Leads']")).click();
		//8. Click the first img icon
			driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[1]")).click();
		//9. Select the first resulting lead
			driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
		//10. Click the second img icon
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
		//11. Select the second resulting lead
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
		
		//12. Click on Merge Lead (submit) button
			driver.findElement(By.xpath("//a[text()='Merge']")).click();
		//13. Get the company name text based on its label
			driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		
	}

}
