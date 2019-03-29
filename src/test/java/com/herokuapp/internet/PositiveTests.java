package com.herokuapp.internet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {

	@Test

	public void logInTest() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "F:\\Chrome driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		Thread.sleep(3000);

		String url = "http://the-internet.herokuapp.com/login";

		driver.get(url);

		System.out.println("Page is open");

		Thread.sleep(3000);

		driver.manage().window().maximize();

		Thread.sleep(3000);

		// user name

		WebElement username = driver.findElement(By.id("username"));

		username.sendKeys("tomsmith");

		// password

		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));

		password.sendKeys("SuperSecretPassword!");

		// Login button

		WebElement login = driver.findElement(By.className("radius"));

		login.click();

		// verification
		// logout button is visible

		WebElement logout = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
		Assert.assertTrue(logout.isDisplayed(), "LogIn button is not visible");

		Thread.sleep(5000);

		// verification

		// correctURL

		String ExpectedURL = "http://the-internet.herokuapp.com/secure";
		String ActualURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualURL, ExpectedURL);

		// verification
		// Success Message

		WebElement SuccessMessage = driver.findElement(By.id("flash"));
		String expectedSuccessMessage = "You logged into a secure area!";
		String actualSuccessMessage = SuccessMessage.getText();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage), "Expected message is incorrect");

		Thread.sleep(2000);
		
		// Close browser
		driver.quit();

	}

}
