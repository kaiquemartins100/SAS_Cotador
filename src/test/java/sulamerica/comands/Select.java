package sulamerica.comands;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.everis.EFA;
import com.everis.Element;

public class Select extends sulamerica.core.BasePage {

	/**
	 * Realiza ação de Selecionar um texto por sua visibilidade
	 * 
	 * @param locator
	 *            Elemento que será Selecionado
	 * @param value
	 *            Texto que será selecionado
	 * @return
	 * @throws Exception
	 */
	public Select xpath(Element locator, String value) throws Exception {

		if (!value.isEmpty()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator.getValue())));

			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator.getValue() + "[@readonly]")));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator.getValue() + "[@disabled]")));

			new org.openqa.selenium.support.ui.Select(EFA.cv_driver.findElement(By.xpath(locator.getValue())))
					.selectByVisibleText(value);
			EFA.cs_getTestEvidence("Select", 1);
		}
		return this;
	}

	/**
	 * Realiza ação de Selecionar um texto por sua visibilidade
	 * 
	 * @param locator
	 *            Elemento que será Selecionado
	 * @param value
	 *            Texto que será selecionado
	 * @return
	 * @throws Exception
	 */
	public Select xpathIndex(Element locator, int value) throws Exception {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator.getValue())));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator.getValue() + "[@readonly]")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator.getValue() + "[@disabled]")));

		new org.openqa.selenium.support.ui.Select(EFA.cv_driver.findElement(By.xpath(locator.getValue())))
				.selectByIndex(value);
		EFA.cs_getTestEvidence("Select", 1);
		return this;
	}

	/**
	 * 
	 * Aguarda um tempo determinado e Realiza ação de Selecionar um texto por sua
	 * visibilidade
	 *
	 * @param locator
	 *            Elemento que será Selecionado
	 * @param value
	 *            Texto que será selecionado
	 * @param time
	 *            Tempo que será esperado em segundos antes de selecionar
	 * @return
	 * @throws Exception
	 */
	public Select xpath(Element locator, String value, int time) throws Exception {
		try {
			for (int i = 0; i <= time; i++) {
				Thread.sleep(1000);
			}
			if (!value.isEmpty()) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator.getValue())));

				wait.until(
						ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator.getValue() + "[@readonly]")));
				wait.until(
						ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator.getValue() + "[@disabled]")));

				new org.openqa.selenium.support.ui.Select(EFA.cv_driver.findElement(By.xpath(locator.getValue())))
						.selectByVisibleText(value);
				EFA.cs_getTestEvidence("Select", 1);
			}
		} catch (Exception e) {
		}
		return this;
	}

}
