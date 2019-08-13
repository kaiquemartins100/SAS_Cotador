package sulamerica.comands;

import com.everis.Action;
import com.everis.EFA;
import com.everis.Element;

public class Hover {

	public Hover xpath(Element locator) throws Exception {

		EFA.evidenceEnabled = true;
		EFA.executeAction(Action.Hover, locator);
		EFA.evidenceEnabled = false;

		return this;
	}

}
