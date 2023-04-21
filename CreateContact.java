package week2.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoCsr");
		driver.findElement(By.xpath("(//input[@class='inputLogin'])[2]")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[contains(@class,'Submit')]")).click();
		
		String title=driver.getTitle();
		System.out.println(title);
		
		driver.findElement(By.xpath("//a[contains(text(),'/SFA')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Create Contact')]")).click();
		
		driver.findElement(By.xpath("//input[@id='firstNameField']")).sendKeys("sanu");
		driver.findElement(By.xpath("//input[@id='lastNameField']")).sendKeys("g");
		driver.findElement(By.xpath("//input[@id='createContactForm_firstNameLocal']")).sendKeys("sanu");
		driver.findElement(By.xpath("//input[@id='createContactForm_lastNameLocal']")).sendKeys("g");
		
		driver.findElement(By.xpath("//input[contains(@name,'department')]")).sendKeys("testing");
		driver.findElement(By.xpath("//textarea[contains(@name,'description')]")).sendKeys("Iam joining Selenium course");
		driver.findElement(By.xpath("//input[@id='createContactForm_primaryEmail']")).sendKeys("sanu@gmail.com");
		
		Select option=new Select(driver.findElement(By.xpath("//select[contains(@id,'createContactForm_generalStateProvince')]")));
		option.selectByVisibleText("Indiana");
		
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.xpath("//textarea[contains(@name,'description')]")).clear();
		driver.findElement(By.xpath("//textarea[@id='updateContactForm_importantNote']")).sendKeys("Iam joining API batch");
		driver.findElement(By.xpath("//input[contains(@name,'submitButton')]")).click();
		String title1=driver.getTitle();
		System.out.println(title1);
		
		
		
		driver.close();
	}

}
