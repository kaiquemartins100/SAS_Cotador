package sulamerica.comands;

import com.everis.Action;
import com.everis.EFA;
import com.everis.Element;

/**
 * Apaga valores do campo indicado pelo xpath
 * 
 * @author nconceic
 *
 */
public class Clear {
	/**
	 * 
	 * Apaga valores do campo indicado pelo xpath
	 * 
	 * @param locator
	 * @return
	 * @throws Exception
	 */
	public Clear xpath(Element locator) throws Exception {
		EFA.executeAction(Action.Clear, locator);
		return this;
	}

	public Clear xpath(Element locator, String value) throws Exception {

		if (!value.isEmpty())
			EFA.executeAction(Action.Clear, locator);

		return this;
	}

	public Clear xpath(Element locator, String value, int time) {
		try {
			if (!value.isEmpty()) {
				for (int i = 0; i <= time; i++) {
					Thread.sleep(1000);
				}
				EFA.executeAction(Action.Clear, locator);
			}
		} catch (Exception e) {
		}

		return this;
	}

}
