package sulamerica.comands;

import org.openqa.selenium.By;

import com.everis.EFA;

import sulamerica.core.BasePage;

public class IsSelected extends BasePage {

	public boolean xpath(String locator) {
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		boolean enable = EFA.cv_driver.findElement(By.xpath(locator)).isSelected();
		return enable;
	}

}
