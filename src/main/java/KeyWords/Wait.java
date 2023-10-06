package KeyWords;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import dev.failsafe.internal.util.Durations;

public class Wait extends BrowserUtil {
	
	public static void ImplicitlyWait(int MilliSeconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(MilliSeconds));
	}
	public static void ExplicitlyWait(By element) {
		
		FluentWait wait=new FluentWait(driver);
		wait.withTimeout(Duration.ofMillis(300));
		wait.pollingEvery(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void ThreadSleep(int MilliSeconds) throws InterruptedException {
		Thread.sleep(MilliSeconds);
	}	
}