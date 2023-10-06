package POM;

import org.openqa.selenium.By;

import KeyWords.BrowserUtil;
import KeyWords.UIKeyWords;
import KeyWords.Wait;
import Util.PropUtil;

public class POM_1 extends BrowserUtil {
	PropUtil pro = new PropUtil();

	public void ClickOnFromTab() {
		Wait.ExplicitlyWait(By.xpath(pro.getObjectFromRepo("FROM")));
		UIKeyWords.ClickMe(By.xpath(pro.getObjectFromRepo("FROM")));
	}

	public void clear() {
		Wait.ExplicitlyWait(By.xpath(pro.getObjectFromRepo("FROM")));
		UIKeyWords.clear(By.xpath(pro.getObjectFromRepo("FROM")));
	}

	public void SelectDelhiAzadpur() {
		Wait.ExplicitlyWait(By.xpath(pro.getObjectFromRepo("DelhiAzadpur")));
		UIKeyWords.ClickMe(By.xpath(pro.getObjectFromRepo("DelhiAzadpur")));
	}
}
