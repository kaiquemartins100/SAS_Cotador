package sulamerica.comands;

import com.everis.Action;
import com.everis.EFA;
import com.everis.Element;

public final class ScrollToElementView extends sulamerica.core.BasePage {

	public ScrollToElementView xpath(Element locator) throws Exception {

		EFA.executeAction(Action.JSExecuteScript, locator, "arguments[0].scrollIntoView(true);");
		EFA.cs_getTestEvidence("ScrollToElementView", 1);
		return this;
	}

	public ScrollToElementView xpath(Element locator, int time) throws Exception {
		try {
			for (int i = 0; i <= time; i++) {
				Thread.sleep(1000);
			}
			EFA.executeAction(Action.JSExecuteScript, locator, "arguments[0].scrollIntoView(true);");
			EFA.cs_getTestEvidence("ScrollToElementView", 1);
		} catch (Exception e) {
		}

		return this;
	}

}
