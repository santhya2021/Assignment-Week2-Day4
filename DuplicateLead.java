package week2.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {

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
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		String name = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).click();
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		String title1=driver.getTitle();
		System.out.println(title1);
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		String text = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		if(name.equals(text))
		{
			System.out.println("Matched");
		}
		else
		{
			System.out.println("Not Matched");
			
		}
		driver.close();
	}

}
