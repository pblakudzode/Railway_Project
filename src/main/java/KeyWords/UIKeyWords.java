package KeyWords;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.asn1.cmc.GetCert;
import org.bouncycastle.asn1.smime.SMIMEEncryptionKeyPreferenceAttribute;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class UIKeyWords extends BrowserUtil {
	
	public static void ClickMe(By element) {
		driver.findElement(element).click();
	}
	public static void SendKeys(By element, String Text) {
		driver.findElement(element).sendKeys(Text);
	}
	public static void Text(By element) {
		driver.findElement(element).getText();
	}
	public static void Title() {
		String Title=driver.getCurrentUrl();
		System.out.println(Title);
	}
	public static void clear(By element) {
		driver.findElement(element).clear();
	}
	public static void AshottakeScreenshots(String testCaseName) throws IOException {
		
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("DDmmYYHHmmss");
		LocalDateTime now=LocalDateTime.now();
		String date=dtf.format(now);
		String baseDir=System.getProperty("user.dir");
		
		AShot ashot=new AShot();
		ashot.shootingStrategy(ShootingStrategies.viewportPasting(2000));
		Screenshot srcshot=ashot.takeScreenshot(driver);
		BufferedImage img=srcshot.getImage();
		ImageIO.write(img, "png",new File(baseDir+"\\Screenshots\\"+testCaseName+"___"+".png"));
	}
	public static void SeleniumtakeScreenshots(String testCaseName) throws IOException, InterruptedException {			
		
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("DDMMYYhhmmss");
		LocalDateTime now=LocalDateTime.now();
		String date=dtf.format(now);
		File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String baseDir=System.getenv("user.dir");
		FileUtils.copyFile(screenshotFile, new File(baseDir+"\\Screenshots\\"+testCaseName+"_"+date+"__"+".png"));	
		Thread.sleep(2000);
	}
	public static void asserEqual(String EnterAcualTitle) {
		String Title=driver.getTitle();
		System.out.println(Title);
		assertEquals(EnterAcualTitle, Title);
	}
	public static void PageDown(int NumberOfDown) throws AWTException, InterruptedException {
		Robot robo=new Robot();
		for(int i=0;i<=NumberOfDown;i++) {
			Thread.sleep(200);
		robo.keyPress(KeyEvent.VK_DOWN);
		robo.keyRelease(KeyEvent.VK_DOWN);
	}
	}
	public static void ParentWindHandle() {
		
		Set<String>allhandle=driver.getWindowHandles();
		
		Iterator<String>iterator=allhandle.iterator();
		String Parenthandle=iterator.next();
		String ChildHandle=iterator.next();		
		driver.switchTo().window(Parenthandle);
	}
	public static void ChildWindHandle() {
		
		Set<String>allhandle=driver.getWindowHandles();
		
		Iterator<String>iterator=allhandle.iterator();
		String Parenthandle=iterator.next();
		String ChildHandle=iterator.next();		
		driver.switchTo().window(ChildHandle);
	}
}