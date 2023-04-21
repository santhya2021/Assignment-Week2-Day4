package week2.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

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
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("7760513299");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		WebElement leadId=driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		String Id=driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).getText();
		System.out.println(Id);
		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(Id);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		
		String text=driver.findElement(By.xpath("//div[contains(text(),'No records to display')]")).getText();
		if(text.contains("No records"))
		{
			System.out.println("This "+text+" message confirms the successful deletion");
		}
		
		driver.close();
	}

}
