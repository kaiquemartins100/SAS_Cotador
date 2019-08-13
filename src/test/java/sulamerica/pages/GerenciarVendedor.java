package sulamerica.pages;

import com.everis.Action;
import com.everis.EFA;
import com.everis.Element;
import com.everis.GlobalData;

import sulamerica.utils.GeraCPF;
import sulamerica.utils.Utils;

/**
 * @author lpouso
 * 
 * 
 *
 */

public class GerenciarVendedor {
	
	
	
	//ELEMENTOS
	
	//Menu
	private Element cadastroVend = new Element ("xpath","//input[contains(@id,'BtnCadVnd')]");
	private Element gerenciarVend = new Element ("xpath","//div[contains(@id,'GerVendedores')]");
		
	//Gerenciar Vendedor
	private Element cmpBuscaVend = new Element ("xpath","//input[contains(@id,'InpBusca')]");
	private Element btnBuscaVend = new Element ("xpath","//a[contains(@id,'LnkBuscar')]");
	private Element btnEditarVend = new Element ("id","VanillaTheme_wtLayVndGer:wtMainContent:wtTblVendedorCorretor:0:WebPatterns_wtCtrlEditar:block:wtButton");
	private Element btnVinculoVend = new Element ("xpath","(//a[contains(@id,'LnkVincVend')])[1]");
	private Element btnDadosVend = new Element ("xpath","(//a[contains(@id,'LnkDadosVend')])[1]");
	
			//Vinculo Vendedor
	private Element slcEAVend = new Element ("id","RichWidgets_wtLayVndEditVinc:wtMainContent:wtCmbEA");
	private Element slcAAVend = new Element ("id","RichWidgets_wtLayVndEditVinc:wtMainContent:wtCmbAA");
	private Element btnSalvarVinculo = new Element ("id","RichWidgets_wtLayVndEditVinc:wtMainContent:wtBtnOK");
	
			//Dados Vendedor
	private Element cmpCPFVend = new Element ("id","RichWidgets_wtLayPopVndEditDados:wtMainContent:ValidationTools_wt14:wtInputToValidate:wtInpNumCPFVend");
	private Element cmpEmailVend = new Element ("id","RichWidgets_wtLayPopVndEditDados:wtMainContent:wtInpEmlVend");
	private Element cmpCelVend = new Element ("id","RichWidgets_wtLayPopVndEditDados:wtMainContent:wtInpTelCelVend");
	private Element btnSalvarDados = new Element ("id","RichWidgets_wtLayPopVndEditDados:wtMainContent:wtBtnOK");
	
		//Cadastrar Vendedor
	private Element tituloCadastro = new Element ("id","VanillaTheme_wtLayVndCad:block:wtTitle");
	private Element cmpCPFCadastro = new Element ("id","VanillaTheme_wtLayVndCad:wtMainContent:ValidationTools_wtWbbNumCPFVend:wtInputToValidate:wtInpNumCPFVend");
	private Element cmpNomeCadastro = new Element ("id","VanillaTheme_wtLayVndCad:wtMainContent:wtInpNomVend");
	private Element cmpEmailCadastro= new Element ("id","VanillaTheme_wtLayVndCad:wtMainContent:wtInpEmlVend");
	private Element cmpCelularCadastro = new Element ("id","VanillaTheme_wtLayVndCad:wtMainContent:wtInpTelCelVend");
	private Element slcEACadastro = new Element ("id","VanillaTheme_wtLayVndCad:wtMainContent:wtCmbNumEA");
	private Element slcAACadastro = new Element ("id","VanillaTheme_wtLayVndCad:wtMainContent:wtCmbNumAA");
	private Element btnOKCadastro = new Element ("id","VanillaTheme_wtLayVndCad:wtMainContent:wtBtnOK");

	private Element menuLateral = new Element ("xpath","(//a[contains(@id,'MenuLateral')])[1]");
	
	
	//START
	
	public void acessoCadastro() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		EFA.executeAction(Action.WaitForElementPresent, menuLateral , 5);
		EFA.executeAction(Action.Click,menuLateral);
		EFA.executeAction(Action.WaitForElementPresent, gerenciarVend, 5);
		EFA.executeAction(Action.Click, gerenciarVend);
		EFA.executeAction(Action.WaitForElementPresent, cadastroVend, 5);
		EFA.evidenceEnabled=true;
		EFA.executeAction(Action.Click, cadastroVend);
		
	}
	
	public void acessoGerenciar() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		EFA.executeAction(Action.WaitForElementPresent, menuLateral , 5);
		EFA.executeAction(Action.Click,menuLateral);
		EFA.executeAction(Action.WaitForElementPresent, gerenciarVend, 5);
		EFA.executeAction(Action.Click, gerenciarVend);
	}
	
	public void cadastroVendedor() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		String cpf = "";
		if (GlobalData.getData("vGeraCPF").equals("SIM")){
		cpf = GeraCPF.geraCPF();
		Utils.armazenarDadosPlanilha("vCPFGerado", cpf);}
		else{
		cpf = GlobalData.getData("vCPF");}
		
		EFA.executeAction(Action.WaitForElementPresent, tituloCadastro );
		EFA.executeAction(Action.Click, cmpCPFCadastro);
		EFA.executeAction(Action.SendKeys,cmpCPFCadastro, cpf);
		Thread.sleep(1200);
		EFA.executeAction(Action.Click, cmpNomeCadastro);
		Thread.sleep(1000);
		EFA.executeAction(Action.SendKeys, cmpNomeCadastro, GlobalData.getData("vNomeVendedor"));
		EFA.executeAction(Action.Click, cmpEmailCadastro);
		EFA.executeAction(Action.SendKeys, cmpEmailCadastro, GlobalData.getData("vEmailVendedor"));
		EFA.executeAction(Action.Click, cmpCelularCadastro);
		EFA.executeAction(Action.SendKeys, cmpCelularCadastro, GlobalData.getData("vCelularVendedor"));
		EFA.executeAction(Action.SelectByVisibleText, slcEACadastro, GlobalData.getData("vEAVendedor"));
		Thread.sleep(1000);
		EFA.executeAction(Action.SelectByVisibleText, slcAACadastro, GlobalData.getData("vAAVendedor"));
	}

	public void salvarCadastro() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = true;
		EFA.executeAction(Action.Click, btnOKCadastro);	
	}

	public void pesquisarVendedor() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		EFA.executeAction(Action.WaitForElementPresent, cmpBuscaVend);
		EFA.executeAction(Action.SendKeys, cmpBuscaVend, GlobalData.getData("vBuscaVendedor"));
		Thread.sleep(1000);
		EFA.executeAction(Action.Click, btnBuscaVend);
	}

	public void acessoDadosVendedor() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		EFA.executeAction(Action.WaitForElementPresent, btnEditarVend, 4);
		Thread.sleep(500);
		EFA.executeAction(Action.Click, btnEditarVend);
		Thread.sleep(800);
		EFA.evidenceEnabled = true;
		EFA.executeAction(Action.Click, btnDadosVend);
	}

	public void acessoVinculoVendedor() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		EFA.executeAction(Action.WaitForElementPresent, btnEditarVend, 4);
		Thread.sleep(500);
		EFA.executeAction(Action.Click, btnEditarVend);
		Thread.sleep(800);
		EFA.evidenceEnabled = true;
		EFA.executeAction(Action.Click, btnVinculoVend);
		
	}

	public void editarDadosVendedor() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		EFA.executeAction(Action.SwitchToFrame, 0);
		EFA.executeAction(Action.WaitForElementPresent, cmpCPFVend, 4);
		EFA.executeAction(Action.Clear, cmpEmailVend);
		EFA.executeAction(Action.SendKeys, cmpEmailVend, GlobalData.getData("vEmailVendedor"));
		Thread.sleep(800);
		EFA.executeAction(Action.Clear, cmpCelVend);
		EFA.executeAction(Action.SendKeys, cmpCelVend, GlobalData.getData("vCelularVendedor"));
		EFA.evidenceEnabled = true;
		EFA.executeAction(Action.Click, btnSalvarDados);
	}

	public void editarVinculoVendedor() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		EFA.executeAction(Action.SwitchToFrame, 0);
		EFA.executeAction(Action.WaitForElementPresent, slcEAVend, 4);
		EFA.executeAction(Action.SelectByVisibleText, slcEAVend, GlobalData.getData("vEAVendedor"));
		Thread.sleep(800);
		EFA.executeAction(Action.SelectByVisibleText, slcAAVend, GlobalData.getData("vAAVendedor"));
		EFA.evidenceEnabled = true;
		EFA.executeAction(Action.Click, btnSalvarVinculo);
	}	
}
