package RegistrationTestSuite;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.DriverInitialize;

import org.testng.annotations.BeforeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestSuite extends DriverInitialize {
	// private static WebDriver driver;

	DriverInitialize driver = new DriverInitialize();
	WebDriver dr = driver.getDriver("chrome");

	@BeforeTest
	public void beforeTest() {
		dr.get("http://demoqa.com/");
		dr.manage().window().maximize();

	}

	@Test
	public void verifyRegistration() {
	try{
		dr.findElement(By.id("menu-registration")).click();
		String header = dr.getTitle();
		Assert.assertEquals(header, "Registration | Demoqa");
	}
	catch (Exception e){
		e.getMessage();
		}
	}
	
	@Test
	public void verifySubMenu() {
	try{
		SoftAssert sa = new SoftAssert();
		dr.findElement(By.linkText("Menu")).click();
		String menutitle = dr.findElement(By.className("entry-title")).getText();
		Assert.assertEquals(menutitle, "Menu");
		dr.findElement(By.linkText("Menu With Sub Menu")).click();
		WebElement ele = dr.findElement(By.linkText("Home")); 
		Actions action = new Actions(dr);
		action.moveToElement(ele).build().perform();
		Boolean submenutitle = dr.findElement(By.linkText("Sub Menu Item 1")).isDisplayed();
		Assert.assertTrue(submenutitle);		
		sa.assertAll();
		
	}
	catch (Exception e){
		e.getMessage();
		}
	}
	
	@Test
	public void verifyTabs() {
	try{
		SoftAssert sa = new SoftAssert();
		dr.findElement(By.linkText("Tabs")).click();
		String menutitle = dr.findElement(By.className("entry-title")).getText();
		Assert.assertEquals(menutitle, "Tabs");
		dr.findElement(By.linkText("Tab 2")).click();
		Boolean tab2text = dr.findElement(By.id("tabs-2")).getText().contains("Morbi tincidunt");
		Assert.assertTrue(tab2text);		
		sa.assertAll();
		
	}
	catch (Exception e){
		e.getMessage();
		}
	}
	
	@Test
	public void verifyTooltip() {
	try{
		SoftAssert sa = new SoftAssert();
		dr.findElement(By.linkText("Tooltip")).click();
		WebElement tooltip = dr.findElement(By.id("age"));
		String toolTipText = tooltip.getAttribute("title");
		Assert.assertEquals(toolTipText, "We ask for your age only for statistical purposes.");
		sa.assertAll();
		
	}
	catch (Exception e){
		e.getMessage();
		}
	}
	
	@Test
	public void verifyDroppable() {
	try{
		SoftAssert sa = new SoftAssert();
		dr.findElement(By.linkText("Droppable")).click();
		WebElement element = dr.findElement(By.id("draggableview"));
		WebElement target = dr.findElement(By.name("droppableview"));
		(new Actions(dr)).dragAndDrop(element, target).perform();
		String DropMsg = target.getText();
		Assert.assertEquals(DropMsg, "Dropped!");
//		sa.assertAll();
		
	}
	catch (Exception e){
		e.getMessage();
		}
	}
	
	@Test
	public void verifyNewWindow() {
	try{
		SoftAssert sa = new SoftAssert();
		dr.findElement(By.linkText("Droppable")).click();
		WebElement element = dr.findElement(By.id("draggableview"));
		WebElement target = dr.findElement(By.name("droppableview"));
		(new Actions(dr)).dragAndDrop(element, target).perform();
		String DropMsg = target.getText();
		Assert.assertEquals(DropMsg, "Dropped!");
//		sa.assertAll();
		
	}
	catch (Exception e){
		e.getMessage();
		}
	}
	
	@AfterTest
	public void afterTest() throws Exception{
		Thread.sleep(2000);
		dr.quit();
	}

}
