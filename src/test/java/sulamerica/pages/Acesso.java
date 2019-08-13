package sulamerica.pages;

import static com.everis.EFA.cv_driver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.everis.Action;
import com.everis.EFA;
import com.everis.Element;
import com.everis.GlobalData;

import sulamerica.core.BasePage;

/**
 * @author lpouso
 * 
 */

public class Acesso extends sulamerica.core.BasePage {

	// CorretorFake
	private Element selectEVFake = new Element("xpath", "//input[contains(@id,'InpEV')]");
	private Element btnOKEV = new Element("xpath", "//input[contains(@id,'BtnOk')]");

	// Corretor
	private Element selectEA = new Element("xpath", "//select[contains(@id,'CmbEAxEV')]");
	private Element selectAA = new Element("xpath", "//select[contains(@id,'CmbAAxEAxEV')]");
	private Element btnEntrarC = new Element("xpath", "//input[contains(@id,'BtnEntrar')]");
	private Element selectEV = new Element("xpath", "//select[contains(@id,'CmbEVProd')]");

	// Vendedor
	private Element campoCPF = new Element("xpath", "//input[contains(@id,'InpCodCPFVendedor')]");
	private Element campoEmail = new Element("xpath", "//input[contains(@id,'InpEmlVendedor')]");
	private Element campoSenha = new Element("xpath", "//input[contains(@id,'InpPassword')]");
	private Element btnEntrarV = new Element("xpath", "//input[contains(@id,'BtnLogin')]");
	private Element CorretorVendedor = new Element("xpath", "//select[contains(@id,'CmbSelEV')]");
	private Element btnOKCorretorVendedor = new Element("xpath", "//input[contains(@id,'BtnCotador')]");

	// Internos
	// Centrify
	private Element nomeUsuario = new Element("xpath", "//div[@id='usernameForm']//input");
	private Element btnProximoU = new Element("xpath", "//div[@id='usernameForm']//button");
	private Element senhaUsuario = new Element("xpath", "//div[@id='passwordForm']/div[3]//input");
	private Element btnProximoS = new Element("xpath", "//div[@id='passwordForm']/div[4]/button");
	// CotadorInt
	private Element codEstruturaAP = new Element("xpath", "//input[contains(@id,'InpNumEA')]");
	private Element menuClicktoRefresh = new Element("xpath", "//label[contains(@id,'LblNumEA')]");
	private Element selectCorretor = new Element("xpath", "//select[contains(@id,'CmbNumEV')]");
	private Element selectApoio = new Element("xpath", "//select[contains(@id,'CmbNumAA')]");
	private Element btnOKCI = new Element("xpath", "//input[contains(@id,'BtnEntrar')]");

	// Senha Vendedor
	private Element btnEsqueci = new Element("xpath", "//label[contains(@id,'EsqueciSenha')]");
	private Element cmpCpfEsqueci = new Element("xpath", "//input[contains(@id,'InpCodCPFVendedor2')]");
	private Element cmpEmailEsqueci = new Element("xpath", "//input[contains(@id,'InpEmlVendedor2')]");
	private Element btnEnviarEsqueci = new Element("xpath", "//input[contains(@id,'BtnEnviar')]");

	protected WebDriverWait wait = new WebDriverWait(cv_driver, 15);

	public void navigate() throws Exception {
		EFA.evidenceEnabled = false;
		Element btnContinuar = new Element("xpath", "//id[@id='invalidcert_continue']");
		EFA.executeAction(Action.Navigate, GlobalData.getData("vURL"));
		Thread.sleep(2000);
		if ((boolean) EFA.executeAction(Action.IsElementPresent,
				new Element("linkText", "Continuar neste site (não recomendado)."))) {
			EFA.cv_driver.findElement(By.linkText("Continuar neste site (não recomendado).")).click();
		} else if ((boolean) EFA.executeAction(Action.IsElementPresent,
				new Element("linkText", "Continue to this website (not recommended)."))) {
			EFA.cv_driver.findElement(By.linkText("Continue to this website (not recommended).")).click();
		}
		if ((boolean) EFA.executeAction(Action.IsElementPresent, btnContinuar))
			EFA.executeAction(Action.Click, btnContinuar);
		
		//EFA.cv_driver.manage().window().setSize(arg0);
	}

	public void loginFake() throws Exception {
		if (!EFA.cv_onError.isEmpty())
			return;
		EFA.evidenceEnabled = false;
		EFA.executeAction(Action.WaitForElementPresent, selectEVFake, 10);
		EFA.executeAction(Action.Click, selectEVFake);
		EFA.executeAction(Action.SendKeys, selectEVFake, GlobalData.getData("vEVFAKE"));
		EFA.evidenceEnabled = true;
		EFA.executeAction(Action.Hover, btnOKEV);
		EFA.evidenceEnabled = false;
		EFA.executeAction(Action.Click, btnOKEV);
	}

	public void selectVendaApoio() throws Exception {
		if (!EFA.cv_onError.isEmpty())
			return;
		EFA.evidenceEnabled = false;
		EFA.executeAction(Action.WaitForPageToLoad, 2);
//		if ((boolean) EFA.executeAction(Action.IsElementPresent, selectEV)) {
			select.xpath(selectEV, GlobalData.getData("vEV"));
			Thread.sleep(1000);
//		}
		select.xpath(selectEA, GlobalData.getData("vEA"));
		Thread.sleep(1000);
		EFA.executeAction(Action.WaitForElementPresent, selectAA, 2);
		select.xpath(selectAA, GlobalData.getData("vAA"));
		EFA.evidenceEnabled = true;
		EFA.executeAction(Action.Click, btnEntrarC);
	}

	public void loginVend() throws Exception {
		if (!EFA.cv_onError.isEmpty())
			return;
		EFA.evidenceEnabled = false;
		EFA.executeAction(Action.WaitForElementPresent, campoCPF, 10);
		
		
		EFA.executeAction(Action.Click, campoCPF);
		EFA.executeAction(Action.Clear, campoCPF);
		EFA.executeAction(Action.SendKeys, campoCPF, GlobalData.getData("vCPF"));
		Thread.sleep(700);
		EFA.executeAction(Action.SendKeys, campoEmail, GlobalData.getData("vEmail"));
		Thread.sleep(700);
		EFA.executeAction(Action.SendKeys, campoSenha, GlobalData.getData("vSenha"));
		EFA.evidenceEnabled = true;
		EFA.executeAction(Action.Hover, btnEntrarV);
		EFA.evidenceEnabled = false;
		EFA.executeAction(Action.Click, btnEntrarV);
		Thread.sleep(800);
	}

	public void loginCentrify() throws Exception {
		if (!EFA.cv_onError.isEmpty())
			return;
		EFA.evidenceEnabled = false;
		if ((boolean) EFA.executeAction(Action.IsElementPresent, codEstruturaAP))
			return;
		EFA.executeAction(Action.WaitForElementPresent, nomeUsuario, 10);
		EFA.executeAction(Action.SendKeys, nomeUsuario, GlobalData.getData("vUsuarioCert"));
		EFA.executeAction(Action.Click, btnProximoU);
		EFA.executeAction(Action.WaitForElementPresent, senhaUsuario);
		EFA.executeAction(Action.SendKeys, senhaUsuario, GlobalData.getData("vSenhaCert"));
		EFA.evidenceEnabled = true;
		EFA.executeAction(Action.Hover, btnProximoS);
		EFA.evidenceEnabled = false;
		EFA.executeAction(Action.Click, btnProximoS);
	}

	public void loginInt() throws Exception {
		if (!EFA.cv_onError.isEmpty())
			return;
		EFA.evidenceEnabled = false;
		EFA.executeAction(Action.WaitForElementPresent, codEstruturaAP, 5);
		EFA.executeAction(Action.SendKeys, codEstruturaAP, GlobalData.getData("vCodEstruturaAP"));
		EFA.executeAction(Action.Click, menuClicktoRefresh);
		Thread.sleep(1000);
		EFA.executeAction(Action.WaitForElementPresent, selectCorretor, 5);
		EFA.executeAction(Action.SelectByVisibleText, selectCorretor, GlobalData.getData("vCorretorInt"));
		Thread.sleep(1000);
		EFA.executeAction(Action.WaitForElementPresent, selectApoio, 5);
		EFA.executeAction(Action.SelectByVisibleText, selectApoio, GlobalData.getData("vApoioInt"));
		EFA.evidenceEnabled = true;
		EFA.executeAction(Action.Hover, btnOKCI);
		EFA.evidenceEnabled = false;
		EFA.executeAction(Action.Click, btnOKCI);
	}

	public void selectCorretor() throws Exception {
		if (!EFA.cv_onError.isEmpty())
			return;
		if ((Boolean) EFA.executeAction(Action.IsElementPresent, CorretorVendedor, 5)) {
			EFA.evidenceEnabled = false;
			Thread.sleep(1000);
			EFA.executeAction(Action.WaitForElementPresent, CorretorVendedor);
			EFA.executeAction(Action.Click, CorretorVendedor);
			EFA.executeAction(Action.SelectByVisibleText, CorretorVendedor, GlobalData.getData("vCorretorVendedor"));
			Thread.sleep(500);
			EFA.evidenceEnabled = true;
			Thread.sleep(1000);
			EFA.executeAction(Action.Click, btnOKCorretorVendedor);
		}
	}

	public void OKselectCorretor() throws Exception {
		if (!EFA.cv_onError.isEmpty())
			return;
		EFA.evidenceEnabled = false;
		Thread.sleep(500);
		EFA.executeAction(Action.Click, btnOKCorretorVendedor);
	}

	public void recupSenhaVend() throws Exception {
		if (!EFA.cv_onError.isEmpty())
			return;
		EFA.evidenceEnabled = false;
		Thread.sleep(500);
		EFA.executeAction(Action.WaitForElementPresent, btnEsqueci, 4);
		EFA.executeAction(Action.Click, btnEsqueci);
		Thread.sleep(700);
		EFA.executeAction(Action.WaitForElementPresent, cmpCpfEsqueci, 4);
		EFA.executeAction(Action.Click, cmpCpfEsqueci);
		EFA.executeAction(Action.SendKeys, cmpCpfEsqueci, GlobalData.getData("vCPF"));
		Thread.sleep(900);
		EFA.executeAction(Action.SendKeys, cmpEmailEsqueci, GlobalData.getData("vEmail"));
		EFA.evidenceEnabled = true;
		EFA.executeAction(Action.Click, btnEnviarEsqueci);
		Thread.sleep(800);
	}
}
