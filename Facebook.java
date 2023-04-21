package week2.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Facebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://en-gb.facebook.com/");
		
		String text=driver.getTitle();
		System.out.println(text);
		
		driver.findElement(By.xpath("//a[contains(text(),'Create new')]")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Sanu");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("g");
		driver.findElement(By.xpath("//input[contains(@name,'reg_email__')]")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[contains(@name,'reg_passwd__')]")).sendKeys("Sandy@2021");
		
		Select options=new Select(driver.findElement(By.xpath("//select[@id='day']")));
		options.selectByIndex(20);
		
		Select options1=new Select(driver.findElement(By.xpath("//select[@name='birthday_month']")));
		options1.selectByValue("6");
		
		Select options2=new Select(driver.findElement(By.xpath("//select[@name='birthday_year']")));
		options2.selectByVisibleText("1995");
		
		driver.findElement(By.xpath("//input[contains(@name,'sex')]")).click();
		
		driver.close();
		
		
	}

}
