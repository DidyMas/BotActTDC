package com.QaTestBots;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class InactTDC {

	private WebDriver driver;

	@Before
	public void setUp() {
		String TDC = "4268070348677636";
		String QAportal = "https://appstestbc.com:8180/apps/#!/act_cta_tarjeta";
		System.setProperty("webdriver.chrome.driver", "src/test/resources/ChormeDriver/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("w3c", true);

		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.get(QAportal);
		try {
			Thread.sleep(1000);
			// Block of code to try
			driver.findElement(By.id("tarjeta_plastico_tdc")).click();
			WebElement Cpcelular = driver.findElement(By.id("num_plastico_tarjeta"));
			Cpcelular.clear();
			Cpcelular.sendKeys(TDC);
			WebElement Enviar = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[16]/div/div[2]/button"));
			Enviar.click();
			Thread.sleep(1000);
			Select TDCSel = new Select(driver.findElement(By.id("nuevo_estatus_plastico")));
			TDCSel.selectByValue("robada");
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[16]/div/div[3]/div[2]/button")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("tarjeta")).click();
			WebElement CT = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[14]/div[1]/input"));
			CT.clear();
			CT.sendKeys(TDC);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[14]/div[3]/button")).click();
			Thread.sleep(1000);
			Select TDCNSta = new Select(driver.findElement(By.id("nuevo_estatus_tarjeta")));
			TDCNSta.selectByValue("3");
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[14]/div[4]/div[2]/button")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[5]/input")).click();
			WebElement TDCin = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[16]/div/input"));
			TDCin.clear();
			TDCin.sendKeys(TDC);
			Thread.sleep(2000);
			WebElement EnviarTDC = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[16]/div/div[2]/button"));
			EnviarTDC.click();
			Thread.sleep(3000);
			
			Select TDCSeli = new Select(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[16]/div/div[5]/div[1]/select")));
			TDCSeli.selectByValue("inactiva");
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[16]/div/div[5]/div[2]/button")).click();
			Thread.sleep(3000);

		} catch (Exception e) {
			// Block of code to handle errors
			System.out.println("El error es:" + e.getMessage());
			driver.quit();

		}
		driver.quit();
	}

	@Test

	@After
	public void tearDown() {
		driver.quit();

	}
}