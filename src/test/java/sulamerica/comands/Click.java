package sulamerica.comands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.everis.Action;
import com.everis.EFA;
import com.everis.Element;

import sulamerica.core.BasePage;


/**
 * Realiza ação de click
 * 
 * @param locator
 *            Elemento que será clicado
 * @return
 * @throws Exception
 */
public class Click extends sulamerica.core.BasePage {

	
	public Click xpath(Element locator) throws Exception {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator.getValue())));
		EFA.executeAction(Action.Click, locator);

		return this;
	}

	/**
	 * Realiza ação de click
	 * 
	 * @param locator
	 *            Elemento que será clicado
	 * @return
	 */
	public Click xpathMove(Element locator) {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator.getValue())));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator.getValue() + "[@disabled]")));
		new Actions(EFA.cv_driver).moveToElement(EFA.cv_driver.findElement(By.xpath(locator.getValue()))).click()
				.perform();
		EFA.cs_getTestEvidence("Click", 1);
		return this;
	}

	/**
	 * Realiza ação de click
	 * 
	 * @param locator
	 *            Elemento que será clicado
	 * @return
	 * @throws InterruptedException
	 */
	public Click xpathMove(Element locator, int time) throws InterruptedException {
		for (int i = 0; i <= time; i++) {
			Thread.sleep(1000);
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator.getValue())));
		new Actions(EFA.cv_driver).moveToElement(EFA.cv_driver.findElement(By.xpath(locator.getValue()))).click()
				.perform();
		EFA.cs_getTestEvidence("Click", 1);
		return this;
	}

	/**
	 * Realiza ação de click
	 * 
	 * @param locator
	 *            Elemento que será clicado
	 * @return
	 * @throws Exception
	 */
	public Click xpath(Element locator, String Value) throws Exception {
		if (!Value.isEmpty()) {

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator.getValue())));

			EFA.executeAction(Action.Click, locator);
		}
		return this;
	}

	/**
	 * Aguarda tempo determinado e Realiza ação de click
	 * 
	 * @param locator
	 *            Elemento que será clicado
	 * @param time
	 *            Tempo que será esperado antes de clicar em segundos
	 * @return
	 */
	public Click xpath(Element locator, int time) {
		try {
			for (int i = 0; i <= time; i++) {
				Thread.sleep(1000);
			}
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator.getValue())));
			EFA.executeAction(Action.Click, locator);
		} catch (Exception e) {
		}
		return this;
	}

	/**
	 * Realiza click com javaScript
	 * 
	 * @param locator
	 *            Elemento que será clicado
	 * @return
	 */
	public Click jsXpath(Element locator) {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator.getValue())));
		WebElement element = EFA.cv_driver.findElement(By.xpath(locator.getValue()));
		js.executeScript("arguments[0].click();", element);
		EFA.cs_getTestEvidence("Click", 1);
		return this;
	}

	/**
	 * Aguarda tempo determinado e Realiza click com javaScript
	 * 
	 * @param locator
	 *            Elemento que será clicado
	 * @param time
	 *            Tempo que será esperado antes de clicar em segundos
	 * @return
	 */
	public Click jsXpath(Element locator, int time) {
		try {
			for (int i = 0; i <= time; i++) {
				Thread.sleep(1000);
			}
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator.getValue())));
			WebElement element = EFA.cv_driver.findElement(By.xpath(locator.getValue()));
			js.executeScript("arguments[0].click();", element);
			EFA.cs_getTestEvidence("Click", 1);
		} catch (Exception e) {
		}
		return this;
	}

}
