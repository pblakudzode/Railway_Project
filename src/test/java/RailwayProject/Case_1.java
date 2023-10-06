package RailwayProject;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import KeyWords.BrowserUtil;
import KeyWords.UIKeyWords;

import POM.POM_1;
import Util.Excel_Reader;
import Util.PropUtil;
import dev.failsafe.internal.util.Assert;
import KeyWords.UIKeyWords;

public class Case_1 extends BrowserUtil {
	PropUtil pro = new PropUtil();
	POM_1 cl = new POM_1();

	@Test(priority = 0)
	public void CreateTheReport() throws IOException, AWTException, InterruptedException {
		cl.ClickOnFromTab();
		cl.clear();
		UIKeyWords.SendKeys(By.xpath(pro.getObjectFromRepo("FROM")), "DEL");
		UIKeyWords.PageDown(2);
		cl.SelectDelhiAzadpur();
		WebElement element = driver.findElement(By.xpath("//input[@id='txtStationFrom']"));
		Thread.sleep(2000);
		String actual_Station = element.getAttribute("value");
		String expected_Station = Excel_Reader.readExcel().get(0);
		assertEquals(actual_Station, expected_Station);

		driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@title='Select Departure date for availability']")).click();

		String myDate = "21";
		driver.findElement(By.xpath("(//*[@id='divCalender']/center/table/tbody/tr[1]/td/table/tbody/tr/td[contains(text(),'"+ myDate + "')])[1]")).click();

		String string = driver.findElement(By.xpath("//*[@id='divCalender']/center/table/tbody/tr[1]/td/table/tbody/tr/td[contains(text(),'Oct-23')]")).getText();
		System.out.println("Text: " + string);
	}

}