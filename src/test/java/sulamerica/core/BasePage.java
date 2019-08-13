package sulamerica.core;

import java.io.File;

import javax.swing.text.Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.everis.EFA;
import com.everis.Utils;

import sulamerica.comands.Clear;
import sulamerica.comands.Click;
import sulamerica.comands.Hover;
import sulamerica.comands.IsSelected;
import sulamerica.comands.ScrollToElementView;
import sulamerica.comands.Select;
import sulamerica.comands.SendKeys;

public class BasePage extends Utils {
	
	private EFA efa;

	// Variaveis
	protected static final String PathSave = Utils.getOutputDirectory().replaceAll("output/", "").replace("\\", "\\\\");
	public static final String comboList = "//*[@id='os-internal-ui-active-menuitem']/ui-autocomplete-item";
	public static final String sim = "Sim";
	public static final String nao = "Não";

	// Funções
	protected static WebDriverWait wait = new WebDriverWait(EFA.cv_driver, 30);
	protected static JavascriptExecutor js = (JavascriptExecutor) EFA.cv_driver;
	protected static Click click = new Click();
	protected static SendKeys sendKeys = new SendKeys();
	protected static Clear clear = new Clear();
	protected static Select select = new Select();
	protected static IsSelected isSelect = new IsSelected();
	protected static Utilities utils = new Utilities();
	protected static ScrollToElementView scrollToElementView = new ScrollToElementView();
	protected static Hover hover = new Hover();
	
	public void ms_updateCaseStatus(boolean status) {

        String old_name;
        File oldfile;
        String new_name;
        File newfile;

        if (status) {
               com.everis.Utils util = new com.everis.Utils();
               old_name = Utils.getPathFromLastExecution();
               oldfile = new File(old_name);

               new_name = Utils.getPathFromLastExecution() + "_PASSED";

               newfile = new File(new_name);

               System.out.println("Arquivo Antigo: " + old_name);
               System.out.println("Arquivo Novo: " + newfile);
               boolean Rename = oldfile.renameTo(newfile);

               oldfile.renameTo(newfile);

               if (!Rename) {
                      System.out.println("Deu ruim!");

               } else {
                      System.out.println("Parabéns!");
               		}
             	}
			}
		}
