package sulamerica.comands;

import org.openqa.selenium.By;

import com.everis.Action;
import com.everis.EFA;
import com.everis.Element;

public class SendKeys {

	public SendKeys xpath(Element locator, String values) throws Exception {

		String value;
		String tecla;

		value = values.replaceAll("[^\\p{ASCII}]", "").trim();
		tecla = values.replaceAll("[\\p{ASCII}]", "").trim();

		if (!value.isEmpty()) {
			do {

				EFA.executeAction(Action.Clear, locator);
				EFA.executeAction(Action.SendKeys, locator, value);
			} while (!EFA.cv_driver.findElement(By.xpath(locator.getValue())).getAttribute("value")
					.replaceAll("\\p{Punct}", "").equals(value.replaceAll("\\p{Punct}", "")));

			if (!tecla.isEmpty())
				EFA.executeAction(Action.SendKeys, locator, tecla);
		}
		return this;
	}

	public SendKeys xpathNoClear(Element locator, String value) throws Exception {

		if (!value.isEmpty()) {

			EFA.executeAction(Action.SendKeys, locator, value);
			EFA.cs_getTestEvidence("SendKeys", 1);
		}
		return this;
	}

	public SendKeys xpath(Element locator, String value, int time) {

		try {
			for (int i = 0; i <= time; i++) {
				Thread.sleep(1000);
			}
			if (!value.isEmpty()) {
				EFA.executeAction(Action.Clear, locator);
				EFA.executeAction(Action.SendKeys, locator, value);
				EFA.cs_getTestEvidence("SendKeys", 1);
			}

		} catch (Exception e) {
		}
		return this;
	}

}
