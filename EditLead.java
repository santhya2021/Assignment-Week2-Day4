package week2.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.findElement(By.xpath("(//input[@class='inputLogin'])[1]")).sendKeys("DemoCsr");
		driver.findElement(By.xpath("(//input[@class='inputLogin'])[2]")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[contains(@class,'Submit')]")).click();
		
		String title=driver.getTitle();
		System.out.println(title);
		
		
		driver.findElement(By.xpath("//a[contains(text(),'/SFA')]")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("sunita");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		String title1=driver.getTitle();
		if(title1.contains("View Lead"))
		{
			System.out.println("Title Verified");
		}
		else
		{
			System.out.println("Title Not Verified");
		}
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys("Infosys");
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		String text = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		System.out.println(text);
		if(text.contains("Infosys"))
		{
			System.out.println("Value Updated");
		}
		else
		{
			System.out.println("Value Not Updated");
		}
		driver.close();
	}

}
