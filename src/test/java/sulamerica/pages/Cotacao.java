package sulamerica.pages;

import com.everis.Action;
import com.everis.EFA;
import com.everis.Element;
import com.everis.GlobalData;

import sulamerica.core.BasePage;
import sulamerica.utils.Utils;

/**
 * @author luviepo
 * 
 */

public class Cotacao extends sulamerica.core.BasePage {
	
		// ELEMENTOS
//Global
	public static int Anexos;
	
	// Acesso
		private Element btnSolicitacoes = new Element("xpath", "//span[contains(@id,'VerTodasSol')]");
		private Element backPeriodo = new Element("xpath", "//input[contains(@id,'InpPeriodoDe')]");
		private Element back1ano = new Element("xpath", "//div[contains(text(),'«')]");

		private Element buscaCNPJ = new Element("xpath", "//input[contains(@id,'InpBuscaGeral')]");
		private Element btnBusca = new Element("xpath", "//input[contains(@id,'BtnPesquisar')]");

		// Global
		private Element btnAvancar = new Element("xpath", "//input[contains(@id,'Avancar')]");
		private Element lblDefProduto = new Element("xpath", "//div[contains(@id,'LblDefProd')]");
		
		// Identificação da Carteira
		private Element qntVidasSaude = new Element("xpath", "//input[contains(@id,'InpQuantidadeVidasSaude')]");
		private Element qntVidasOdonto = new Element("xpath", "//input[contains(@id,'InpQuantidadeVidasOdonto')]");
		private Element btnEmpregaticio = new Element("xpath", "//input[contains(@id,'TipoEmpregaticio')]");
		private Element btnEntidadeClasse = new Element("xpath", "//input[contains(@id,'TipoAssociativo')]");
		private Element slcEntidadeClasse = new Element("xpath", "//select[contains(@id,'CmbEntidadeClasses')]");

		// Identificação do Produto
		private Element tipoContSaude = new Element("xpath",
				"//input[@value='" + GlobalData.getData("vTipoContratacaoSaude") + "'][contains(@id,'TpContrSaude')]");
		private Element tipoContOdonto = new Element("xpath",
				"//input[@value='" + GlobalData.getData("vTipoContratacaoOdonto") + "'][contains(@id,'TpContrOdonto')]");

		private Element btnPlusOdonto = new Element("xpath","(//input[@value='" + GlobalData.getData("vPlusProdutoOdonto") + "'])[1]");

		// Seleção do produtos
		private Element slcProduto557 = new Element("xpath", "//input[@value='8'][contains(@id,'ProdCobSaude')]");
		private Element slcProduto553 = new Element("xpath", "//input[@value='9'][contains(@id,'ProdCobSaude')]");
		private Element slcProduto506 = new Element("xpath", "//input[@value='22'][contains(@id,'ProdCobSaude')]");
		private Element slcProduto515 = new Element("xpath", "//input[@value='23'][contains(@id,'ProdCobSaude')]");
		private Element slcProduto545 = new Element("xpath", "//input[@value='18'][contains(@id,'ProdCobSaude')]");
		private Element slcProduto546 = new Element("xpath", "//input[@value='19'][contains(@id,'ProdCobSaude')]");
		private Element slcProduto582 = new Element("xpath", "//input[@value='24'][contains(@id,'ProdCobSaude')]");
		private Element slcProduto567 = new Element("xpath", "//input[@value='11'][contains(@id,'ProdCobSaude')]");
		private Element slcProduto563 = new Element("xpath", "//input[@value='12'][contains(@id,'ProdCobSaude')]");

		// Dados do Cliente
		private Element cmpCNPJ = new Element("xpath", "(//input[contains(@id,'InpCNPJ')])[1]");
		// Congenere
		private Element cmpCongenereSaude = new Element("xpath", "//input[contains(@id,'InputCongSaude')]");
		private Element cmpCongenereOdonto = new Element("xpath", "//input[contains(@id,'InputCongOdonto')]");

		// Distribuição de Vidas
		private Element btnGerarPreco = new Element("xpath", "//span[contains(text(),'GERAR PREÇO')]");
		private Element btnGerarPrecoOdt = new Element("xpath", "//input[@value='GERAR PREÇO']");
		private Element btnAddPlano = new Element("xpath", "//a[contains(@id,'LnkAddPlano')]");
		private Element vidasFaltantesSaude = new Element("xpath", "//span[contains (@id,'ExpVidasFalt')]");
		private Element vidasFaltantesOdonto = new Element("xpath", "//span[contains (@id,'ExpQtdVidaFalt')]");

		// Distribução de Vidas Odonto
		private Element cmpOdontoMais = new Element("xpath", "(//input[contains(@id,'InpVidas')])[1]");
		private Element cmpOdontoDoc = new Element("xpath", "(//input[contains(@id,'InpVidas')])[2]");
		private Element cmpOdontoPrestige = new Element("xpath", "(//input[contains(@id,'InpVidas')])[3]");
		private Element btnAvancar3 = new Element("xpath", "//input[@value='AVANÇAR']");

		private Element lblCotacao = new Element("xpath", "(//div[contains(@id,'CntDadosCotacao')])[1]");

		private Element btnDeletarCotacao = new Element("xpath", "(//a[contains(@id,'LnkDeletarSolicitacao')])[1]");
		private Element clicktoRefresh = new Element("xpath", "//div[contains(@id,'CtnMain')]");
		private Element lblPreco = new Element("xpath", "//label[contains(@id,'VlrPremioTotal')]");

		private Element AvancarDisabled = new Element("xpath", "//input[@disabled='disabled'][contains(@id,'BtnAvancar')]");

		private Element clickCongenereSaude = new Element("xpath", "(//html/body/ul//a)[1]");
		private Element clickCongenereOdonto = new Element("xpath", "(//html/body/ul//a)[2]");

		private Element btnSemCopart = new Element("xpath", "(//div[contains(@id,'CntListCopartSaude')])[1]/input");
		private Element btnComCopart = new Element("xpath", "(//div[contains(@id,'CntListCopartSaude')])[2]/input");

		private Element cmpVigencia = new Element("xpath", "//input[contains(@id,'InpDtVig')]");

		private Element btnTarifas = new Element("xpath", "//input[contains(@id,'RdbBuscaTarifa')]");
		private Element buscaTarifas = new Element("xpath", "//input[contains(@id,'InpBuscaTarifa')]");

		private Element AdicionarTarifas = new Element("xpath", "//input[contains(@id,'BtnAdicionarBusca')]");

		private Element btnAnexaArquivos = new Element("xpath", "(//span[contains(@id,'AnexarArquivos')])[1]");

		//TODO
		private Element inputAnexaArquivos = new Element("xpath","(//div[contains(@id,'wtCntUploadBackground')]/input)[1]");

		private Element potencialSaude = new Element("xpath", "//input[contains(@id,'PotencialSaude')]");
		private Element potencialOdonto = new Element("xpath", "//input[contains(@id,'PotencialOdonto')]");

		private Element documentoCarregado = new Element("xpath", "//div[contains(@id,'CntListfile')]");

		// Carregamento Comercial.
		private Element cmbCorretagemS = new Element("xpath", "//select[contains(@id,'CmbCorretagemS')]");
		private Element cmbAgenciamentoS = new Element("xpath", "//select[contains(@id,'CmbAgenciamentoS')]");
		private Element cmbCorretagemO = new Element("xpath", "//select[contains(@id,'CmbCorretagemO')]");
		private Element cmbAgenciamentoO = new Element("xpath", "//select[contains(@id,'CmbAgenciamentoO')]");

		private Element campoTextoObs = new Element("xpath", "//textarea[contains(@id,'InpObservacao')]");

		private Element cmpCNPJcoligadas = new Element("xpath", "//input[contains(@id,'InpCNPJCol')]");
		private Element btnIncluir = new Element("xpath", "//input[@value='Incluir']");
		private Element cmpAfastados = new Element("xpath", "//input[contains(@id,'InpQtdAfastados')]");
		private Element cmpCID = new Element("xpath", "//input[contains(@id,'InputCID')]");
		private Element btnIncluirCID = new Element("xpath", "//input[contains(@id,'BtnIncluir')]");

		private Element cmpNomeCID = new Element("xpath", "//input[contains(@id,'InputName')]");
		private Element cmpDataCID = new Element("xpath", "//input[contains(@id,'InputData')]");
		private Element btnDistribuiManual = new Element("xpath", "//input[contains(@id,'BtnAvancarTelaDistVidas')]");
		private Element lblSucesso = new Element("xpath", "//label[contains(@id,'DscDistSaudeSucesso')]");
		private Element btnValidar = new Element("xpath", "//input[@value='Validar']");

		private Element btnConfirmaCID = new Element("xpath", "(//li/a[@id='os-internal-ui-active-menuitem'])[1]");
		private Element btnVidasOdonto = new Element("xpath", "//input[contains(@id,'VidasTotalOdonto')]");

		// TELA PRINCIPAL
		private Element btnNovaCotacao = new Element("xpath", "//div[contains(@id,'ButtonNewPrice')]");
		private Element btnAvancarEnviar = new Element("xpath","//input[contains(@id,'BtnAvancarEnviar')]");
		private Element btnTodasTarifas = new Element("xpath","//label[contains(@id,'AdicionarTodasTarifas')]");
		private Element slcStatus = new Element ("xpath","(//select)[2]");
		private Element cmpBuscaGeral = new Element ("xpath","//input[contains(@id,'InpBuscaGeral')]");
		private Element cmpTipoEmpresa = new Element ("xpath","//select[contains(@id,'CmbTipEmp')]");
		private Element plusSaude = new Element ("xpath","//input[contains(@id,'SaudeSim')]");
		
		// START
	public void novaCotacao() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		Thread.sleep(900);
		EFA.executeAction(Action.WaitForElementPresent, btnNovaCotacao,2);
		EFA.executeAction(Action.Click, btnNovaCotacao );
	}

	public void identfCarteira() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		
		EFA.executeAction(Action.Click, qntVidasSaude);
		sendKeys.xpath(qntVidasSaude, GlobalData.getData("vVidasSaude"));
		click.xpath(qntVidasSaude);
		Thread.sleep(500);

		EFA.executeAction(Action.Click, qntVidasOdonto);
		sendKeys.xpath(qntVidasOdonto, GlobalData.getData("vVidasOdonto"));
		Thread.sleep(500);


		if (!(boolean) GlobalData.getData("vTipoVinculo").equals("Empregatício")) {
			EFA.executeAction(Action.WaitForElementPresent, btnEntidadeClasse, 5);
			EFA.executeAction(Action.Click, btnEntidadeClasse);
			EFA.executeAction(Action.SelectByVisibleText, slcEntidadeClasse, GlobalData.getData("vEntidadeClasse"));
		} else{
			Thread.sleep(500);
			EFA.executeAction(Action.Click, btnEmpregaticio);
			}
		
		if ((boolean) GlobalData.getData("vCarteira").equals("ASO")){
			Element btnModalPag = new Element("xpath","//input[@value='"+GlobalData.getData("vModalPagamento")+"']");
			EFA.executeAction(Action.WaitForElementPresent, btnModalPag, 2);
			EFA.evidenceEnabled=true;
			EFA.executeAction(Action.Click, btnModalPag);
		}	
	}

	public void avancar() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		Thread.sleep(2000);
		EFA.executeAction(Action.WaitForElementPresent, btnAvancar, 5);
		EFA.executeAction(Action.JSExecuteScript, btnAvancar, "window.scrollBy(0,-400)");
		EFA.evidenceEnabled = true;
		EFA.executeAction(Action.Click, btnAvancar);
	}

	public void defProduto() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		Thread.sleep(1000);
		EFA.executeAction(Action.WaitForElementPresent, lblDefProduto, 5);

		if (!(GlobalData.getData("vVidasSaude").equals(""))) {
			click.xpathMove(tipoContSaude);
			Thread.sleep(1000);
			if ((boolean)EFA.executeAction(Action.IsElementPresent, plusSaude, 5)){
				Element btnplusSaude = new Element ("xpath","//input[contains(@id,'Saude"+GlobalData.getData("vPlusSaude")+"')]");
				EFA.executeAction(Action.Click, btnplusSaude);
			}
		}
		
		Thread.sleep(1000);

		if (!(GlobalData.getData("vVidasOdonto").equals(""))) {
			click.xpathMove(tipoContOdonto);
			
			if (GlobalData.getData("vCarteira").equals("Empresarial"))// || GlobalData.getData("vCarteira").equals("ASO"))
				if(GlobalData.getData("vVidasSaude").equals("")){
					btnPlusOdonto = new Element("xpath", "(//input[@value='N'])[1]");
					click.xpathMove(btnPlusOdonto);
				}
				else
					if((boolean)EFA.executeAction(Action.IsElementPresent, btnPlusOdonto))// && !GlobalData.getData("vVidasSaude").equals(""))
							{
					btnPlusOdonto = new Element("xpath", "(//input[@value='"+GlobalData.getData("vPlusProdutoOdonto")+"'])[1]");
					click.xpathMove(btnPlusOdonto);
				}
			}
		Thread.sleep(500);
		
		if (!(GlobalData.getData("vVidasSaude").equals(""))) {	
			// PME
			if (GlobalData.getData("vProdutoSaude").equals("557"))
				EFA.executeAction(Action.Click, slcProduto557);
			
			if (GlobalData.getData("vProdutoSaude").equals("553"))
				EFA.executeAction(Action.Click, slcProduto553);
			
			//PME Mais
			if (GlobalData.getData("vProdutoSaude").equals("567"))
				EFA.executeAction(Action.Click, slcProduto567);
			
			if (GlobalData.getData("vProdutoSaude").equals("563"))
				EFA.executeAction(Action.Click, slcProduto563);
			
			// ADESAO
			if (GlobalData.getData("vProdutoSaude").equals("506"))
				EFA.executeAction(Action.Click, slcProduto506);
			
			if (GlobalData.getData("vProdutoSaude").equals("515"))
				EFA.executeAction(Action.Click, slcProduto515);
			
			// EMPRESARIAL
			if (GlobalData.getData("vProdutoSaude").equals("545"))
				EFA.executeAction(Action.Click, slcProduto545);
			if (GlobalData.getData("vProdutoSaude").equals("546"))
				EFA.executeAction(Action.Click, slcProduto546);
			
			//ASO
			if (GlobalData.getData("vProdutoSaude").equals("582"))
				EFA.executeAction(Action.Click, slcProduto582);
		}
		Element abrangencia = new Element ("xpath","//input[contains(@id,'AbrangenciaSaude')][@value='N']");
		if ((boolean) EFA.executeAction(Action.IsElementPresent, abrangencia,2)){
			Thread.sleep(500);
			EFA.executeAction(Action.Click, abrangencia);
		}
	}

	public void dadosCliente() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		EFA.executeAction(Action.WaitForElementPresent, cmpCNPJ, 5);
		Thread.sleep(2500);
		
		 sendKeys.xpath(cmpCNPJ, GlobalData.getData("vCNPJ"));
		 
		if ((boolean) GlobalData.getData("vCarteira").equals("PME")){
			Thread.sleep(500);
			EFA.executeAction(Action.SelectByVisibleText, cmpTipoEmpresa , GlobalData.getData("vTipoEmpresa"));
		}
		
		if (!(boolean) GlobalData.getData("vEmpresasColigadas").equals("")) {
			String[] qtdEmpresas = GlobalData.getData("vEmpresasColigadas").split(";");
			for (int i = 0; i < qtdEmpresas.length; i++) {
				EFA.executeAction(Action.Click, cmpCNPJcoligadas);
				Thread.sleep(1200);
				EFA.executeAction(Action.SendKeys, cmpCNPJcoligadas, qtdEmpresas[i]);
				Thread.sleep(1200);
				EFA.executeAction(Action.Click, btnIncluir);
			}
		}
	}

	public void infoEmpresa() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		Thread.sleep(1000);
		Element btnRazaoSocial= new Element("xpath","//label[contains(@id,'blRazaoSocial')]");
		EFA.waitForElement(btnRazaoSocial, 15);
		EFA.executeAction(Action.WaitForPageToLoad, 2);
	}

	public void congeneres() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		Thread.sleep(1000);
		if ((boolean) GlobalData.getData("vVidasSaude").equals("")) {
			EFA.executeAction(Action.Click, cmpCongenereOdonto);
			
			 sendKeys.xpath(cmpCongenereOdonto, GlobalData.getData("vCongenereOdonto"));
			 
			EFA.executeAction(Action.WaitForElementPresent, clickCongenereSaude);
			EFA.executeAction(Action.Click, clickCongenereSaude);
		}

		else {

			if (!(boolean) GlobalData.getData("vProdutoSaude").equals("")) {
				EFA.executeAction(Action.Click, cmpCongenereSaude);
				
				 sendKeys.xpath(cmpCongenereSaude, GlobalData.getData("vCongenereSaude"));
				 
				EFA.executeAction(Action.WaitForElementPresent, clickCongenereSaude, 2);
				EFA.executeAction(Action.Click, clickCongenereSaude);
			}

			if (!(boolean) GlobalData.getData("vProdutoOdonto").equals("")) {
				EFA.executeAction(Action.Click, cmpCongenereOdonto);
				 sendKeys.xpath(cmpCongenereOdonto, GlobalData.getData("vCongenereOdonto"));
				EFA.executeAction(Action.WaitForElementPresent, clickCongenereOdonto, 2);
				EFA.executeAction(Action.Click, clickCongenereOdonto);
			}

			EFA.evidenceEnabled = true;
			EFA.executeAction(Action.Hover, cmpCongenereSaude);
		}
	}

	public void distVidasSaude() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		Thread.sleep(1000);
		String[] tipoPlano = GlobalData.getData("vPlanoVidas").split(";");
	
		String[] vidas0a18 = GlobalData.getData("vIdade0a18").split(";");
		String[] vidas19a23 = GlobalData.getData("vIdade19a23").split(";");
		String[] vidas24a28 = GlobalData.getData("vIdade24a28").split(";");
		String[] vidas29a33 = GlobalData.getData("vIdade29a33").split(";");
		String[] vidas34a38 = GlobalData.getData("vIdade34a38").split(";");
		String[] vidas39a43 = GlobalData.getData("vIdade39a43").split(";");
		String[] vidas44a48 = GlobalData.getData("vIdade44a48").split(";");
		String[] vidas49a53 = GlobalData.getData("vIdade49a53").split(";");
		String[] vidas54a58 = GlobalData.getData("vIdade54a58").split(";");
		
		String[] Inativos0a18 = GlobalData.getData("vInativos0a18").split(";");
		String[] Inativos19a23 = GlobalData.getData("vInativos19a23").split(";");
		String[] Inativos24a28 = GlobalData.getData("vInativos24a28").split(";");
		String[] Inativos29a33 = GlobalData.getData("vInativos29a33").split(";");
		String[] Inativos34a38 = GlobalData.getData("vInativos34a38").split(";");
		String[] Inativos39a43 = GlobalData.getData("vInativos39a43").split(";");
		String[] Inativos44a48 = GlobalData.getData("vInativos44a48").split(";");
		String[] Inativos49a53 = GlobalData.getData("vInativos49a53").split(";");
		String[] Inativos54a58 = GlobalData.getData("vInativos54a58").split(";");
		
		String[] Agregados0a18 = GlobalData.getData("vAgregados0a18").split(";");
		String[] Agregados19a23 = GlobalData.getData("vAgregados19a23").split(";");
		String[] Agregados24a28 = GlobalData.getData("vAgregados24a28").split(";");
		String[] Agregados29a33 = GlobalData.getData("vAgregados29a33").split(";");
		String[] Agregados34a38 = GlobalData.getData("vAgregados34a38").split(";");
		String[] Agregados39a43 = GlobalData.getData("vAgregados39a43").split(";");
		String[] Agregados44a48 = GlobalData.getData("vAgregados44a48").split(";");
		String[] Agregados49a53 = GlobalData.getData("vAgregados49a53").split(";");
		String[] Agregados54a58 = GlobalData.getData("vAgregados54a58").split(";");

		EFA.executeAction(Action.WaitForElementPresent, vidasFaltantesSaude, 5);

		for (int i = 0; i < tipoPlano.length; i++) {
			i += 1;
			Element slcPlano = new Element("xpath", "(//select[contains(@id,'CmbPlano')])[" + i + "]");
			if (tipoPlano.length > 1) {
				click.xpath(btnAddPlano, 1);
				}
			i -= 1;
			select.xpath(slcPlano, tipoPlano[i]);
		}

		for (int i = 0; i < tipoPlano.length; i++) {
	Element Idade0a18 = new Element("xpath","(//span[contains(text(),'0 - 18')]/../../..//input)[1]");
	Element Idade19a23 = new Element("xpath","(//span[contains(text(),'19 - 23')]/../../..//input)[1]");
	Element Idade24a28 = new Element("xpath","(//span[contains(text(),'24 - 28')]/../../..//input)[1]");
	Element Idade29a33 = new Element("xpath","(//span[contains(text(),'29 - 33')]/../../..//input)[1]");
	Element Idade34a38 = new Element("xpath","(//span[contains(text(),'34 - 38')]/../../..//input)[1]");
	Element Idade39a43 = new Element("xpath","(//span[contains(text(),'39 - 43')]/../../..//input)[1]");
	Element Idade44a48 = new Element("xpath","(//span[contains(text(),'44 - 48')]/../../..//input)[1]");
	Element Idade49a53 = new Element("xpath","(//span[contains(text(),'49 - 53')]/../../..//input)[1]");
	Element Idade54a58 = new Element("xpath","(//span[contains(text(),'54 - 58')]/../../..//input)[1]");
	
	Element eInativos0a18 = new Element("xpath","(//span[contains(text(),'0 - 18')]/../../..//input)[2]");
	Element eInativos19a23 = new Element("xpath","(//span[contains(text(),'19 - 23')]/../../..//input)[2]");
	Element eInativos24a28 = new Element("xpath","(//span[contains(text(),'24 - 28')]/../../..//input)[2]");
	Element eInativos29a33 = new Element("xpath","(//span[contains(text(),'29 - 33')]/../../..//input)[2]");
	Element eInativos34a38 = new Element("xpath","(//span[contains(text(),'34 - 38')]/../../..//input)[2]");
	Element eInativos39a43 = new Element("xpath","(//span[contains(text(),'39 - 43')]/../../..//input)[2]");
	Element eInativos44a48 = new Element("xpath","(//span[contains(text(),'44 - 48')]/../../..//input)[2]");
	Element eInativos49a53 = new Element("xpath","(//span[contains(text(),'49 - 53')]/../../..//input)[2]");
	Element eInativos54a58 = new Element("xpath","(//span[contains(text(),'54 - 58')]/../../..//input)[2]");
	
	Element Agregs0a18 = new Element("xpath","(//span[contains(text(),'0 - 18')]/../../..//input)[3]");
	Element Agregs19a23 = new Element("xpath","(//span[contains(text(),'19 - 23')]/../../..//input)[3]");
	Element Agregs24a28 = new Element("xpath","(//span[contains(text(),'24 - 28')]/../../..//input)[3]");
	Element Agregs29a33 = new Element("xpath","(//span[contains(text(),'29 - 33')]/../../..//input)[3]");
	Element Agregs34a38 = new Element("xpath","(//span[contains(text(),'34 - 38')]/../../..//input)[3]");
	Element Agregs39a43 = new Element("xpath","(//span[contains(text(),'39 - 43')]/../../..//input)[3]");
	Element Agregs44a48 = new Element("xpath","(//span[contains(text(),'44 - 48')]/../../..//input)[3]");
	Element Agregs49a53 = new Element("xpath","(//span[contains(text(),'49 - 53')]/../../..//input)[3]");
	Element Agregs54a58 = new Element("xpath","(//span[contains(text(),'54 - 58')]/../../..//input)[3]");
	
			Thread.sleep(900);
			// ATIVOS
			//TODO
			EFA.executeAction(Action.Click, Idade0a18);
			
			if (i < vidas0a18[i].length())
			sendKeys.xpath(Idade0a18, vidas0a18[i]);
			
			if (i < vidas19a23[i].length())
			sendKeys.xpath(Idade19a23, vidas19a23[i]);
			
			if (i < vidas24a28[i].length())
			sendKeys.xpath(Idade24a28, vidas24a28[i]);
			
			if (i < vidas29a33[i].length())
			sendKeys.xpath(Idade29a33, vidas29a33[i]);
			
			if (i < vidas34a38[i].length())
			sendKeys.xpath(Idade34a38, vidas34a38[i]);
			
			if (i < vidas39a43[i].length())
			sendKeys.xpath(Idade39a43, vidas39a43[i]);
			
			if (i < vidas44a48[i].length())
			 sendKeys.xpath(Idade44a48, vidas44a48[i]);
			
			if (i < vidas49a53[i].length())
			 sendKeys.xpath(Idade49a53, vidas49a53[i]);
			
			if (i < vidas54a58[i].length())
			 sendKeys.xpath(Idade54a58, vidas54a58[i]);
			 
			// INATIVOS
			
			if (i < Inativos0a18[i].length())
				 sendKeys.xpath(eInativos0a18, Inativos0a18[i]);
				
			if (i < Inativos19a23[i].length())
				 sendKeys.xpath(eInativos19a23, Inativos19a23[i]);
			
			if (i < Inativos24a28[i].length())
				 sendKeys.xpath(eInativos24a28, Inativos24a28[i]);

			if (i < Inativos29a33[i].length())
				 sendKeys.xpath(eInativos29a33, Inativos29a33[i]);
				
			if (i < Inativos34a38[i].length())
				 sendKeys.xpath(eInativos34a38, Inativos34a38[i]);
				
			if (i < Inativos39a43[i].length())
				 sendKeys.xpath(eInativos39a43, Inativos39a43[i]);
				
			if (i < Inativos44a48[i].length())
				 sendKeys.xpath(eInativos44a48, Inativos44a48[i]);
				
			if (i < Inativos49a53[i].length())
				 sendKeys.xpath(eInativos49a53, Inativos49a53[i]);
				
			if (i < Inativos54a58[i].length())
				 sendKeys.xpath(eInativos54a58, Inativos54a58[i]);
				 
				// AGREGADOS

			if (i < Agregados0a18[i].length())
				 sendKeys.xpath(Agregs0a18, Agregados0a18[i]);
					
			if (i < Agregados19a23[i].length())
				 sendKeys.xpath(Agregs19a23, Agregados19a23[i]);
					
			if (i < Agregados24a28[i].length())
				 sendKeys.xpath(Agregs24a28, Agregados24a28[i]);

			if (i < Agregados29a33[i].length())
				 sendKeys.xpath(Agregs29a33, Agregados29a33[i]);
					
			if (i < Agregados34a38[i].length())
				 sendKeys.xpath(Agregs34a38, Agregados34a38[i]);
					
			if (i < Agregados39a43[i].length())
				 sendKeys.xpath(Agregs39a43, Agregados39a43[i]);
					
			if (i < Agregados44a48[i].length())
				 sendKeys.xpath(Agregs44a48, Agregados44a48[i]);
					
			if (i < Agregados49a53[i].length())
				 sendKeys.xpath(Agregs49a53, Agregados49a53[i]);
					
			if (i < Agregados54a58[i].length())
				 sendKeys.xpath(Agregs54a58, Agregados54a58[i]);
		}

		Thread.sleep(1000);
		
		EFA.evidenceEnabled = true;
		EFA.executeAction(Action.Click, btnValidar);
		Thread.sleep(500);
	}

		// APENAS PME
	public void distVidasOdonto() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		Thread.sleep(1000);
		EFA.executeAction(Action.WaitForElementPresent, vidasFaltantesOdonto, 5);

		if (!(GlobalData.getData("vOdontoMais").equals(""))) {
			 sendKeys.xpath(cmpOdontoMais, GlobalData.getData("vOdontoMais"));
		}

		if (!(GlobalData.getData("vOdontoDoc").equals(""))) {
			 sendKeys.xpath(cmpOdontoDoc, GlobalData.getData("vOdontoDoc"));
		}

		if (!(GlobalData.getData("vOdontoPrestige").equals(""))) {
			 sendKeys.xpath(cmpOdontoPrestige, GlobalData.getData("vOdontoPrestige"));
		}
		Thread.sleep(1000);
	}

	public void avancar3() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		Thread.sleep(1000);
		EFA.executeAction(Action.WaitForElementPresent, btnAvancar3, 5);
		EFA.evidenceEnabled = true;
		EFA.executeAction(Action.Click, btnAvancar3);
	}

	public void contratacao() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		
		// Coparticipação - o sistema trás os campos selecionados.
		if (!(boolean) GlobalData.getData("vProdutoSaude").equals("506")) {
			if ((boolean) GlobalData.getData("vCopart").equals("COM")) {
				
				EFA.executeAction(Action.Click, btnSemCopart);
			}
			if ((boolean) GlobalData.getData("vCopart").equals("SEM")) {
				
				EFA.executeAction(Action.Click, btnComCopart);
			}
		}
		// Vigencia
		EFA.executeAction(Action.WaitForElementPresent, cmpVigencia, 5);
		EFA.executeAction(Action.Click, cmpVigencia);
		
		 sendKeys.xpath(cmpVigencia, GlobalData.getData("vVigencia"));
		
		EFA.evidenceEnabled = true;
		EFA.executeAction(Action.Hover, btnAvancar);
		Thread.sleep(1500);
	}

	public void tarifaSaudeAdesao() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		String[] tipoTarifa = GlobalData.getData("vTarifas").split(";");
		
		EFA.executeAction(Action.Click, btnTarifas);

		for (int i = 0; i < tipoTarifa.length; i++) {
			
			click.xpath(buscaTarifas, 1);
			sendKeys.xpath(buscaTarifas, tipoTarifa[i]);

			i += 1;
			Element selectTarifas = new Element("xpath", "(//html/body/ul//a)[" + i + "]");

			click.xpath(selectTarifas);

			i -= 1;

			click.xpath(AdicionarTarifas, 1);
		}
	}

	public void docEmpresa() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		String[] tipoDocumento = GlobalData.getData("vTipoDocumento").split(";");

		for (int i = 0; i < tipoDocumento.length; i++) {
			Element btnDocumento = new Element("xpath", "//input[contains(@id,'" + tipoDocumento[i] + "')]");
			EFA.executeAction(Action.Click, btnDocumento);
			Thread.sleep(1000);
		}

		Utils.uploadFile(inputAnexaArquivos, GlobalData.getData("vDocumentoAnexo"));
		Anexos++;

		EFA.executeAction(Action.WaitForElementPresent, documentoCarregado, 5);

		// Potencial de vidas.
		if(!GlobalData.getData("vVidasSaude").equals("")){
			
			EFA.executeAction(Action.Click, potencialSaude);
			 sendKeys.xpath(potencialSaude, GlobalData.getData("vVidasSaude"));
			 
		}
	Thread.sleep(1000);
		if(!GlobalData.getData("vVidasOdonto").equals("")){
			
			EFA.executeAction(Action.Click, potencialOdonto);
			 sendKeys.xpath(potencialOdonto, GlobalData.getData("vVidasOdonto"));
			 
		}
		Element btnApoliceEx = new Element("xpath","//input[contains(@id,'"+GlobalData.getData("vApoliceEx")+"')]");
		EFA.evidenceEnabled = true;
		EFA.executeAction(Action.Click, btnApoliceEx);
	}

	public void carrComercial() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		EFA.executeAction(Action.WaitForPageToLoad, 3);
		EFA.waitForPageToLoad(3);
		if(!(boolean)GlobalData.getData("vVidasSaude").equals("")){
			EFA.executeAction(Action.WaitForElementPresent, cmbCorretagemS);
			EFA.executeAction(Action.SelectByVisibleText, cmbCorretagemS, GlobalData.getData("vCorretagemS"));
			Thread.sleep(500);
			EFA.executeAction(Action.SelectByVisibleText, cmbAgenciamentoS, GlobalData.getData("vAgenciamentoS"));
		}
		
		Thread.sleep(500);
		
		if(!(boolean)GlobalData.getData("vVidasOdonto").equals("")){
		EFA.executeAction(Action.SelectByVisibleText, cmbCorretagemO, GlobalData.getData("vCorretagemO"));
		Thread.sleep(500);
		EFA.evidenceEnabled = true;
		EFA.executeAction(Action.SelectByVisibleText, cmbAgenciamentoO, GlobalData.getData("vAgenciamentoO"));
		}
	}

	public void obs() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;

		if (!(boolean) GlobalData.getData("vAnexoAdicional").equals("nao")) {
			Utils.uploadFile(inputAnexaArquivos, GlobalData.getData("vDocumentoAdicional"));
			Anexos++;
		}
		
		EFA.executeAction(Action.WaitForElementPresent, campoTextoObs);
		EFA.executeAction(Action.Click, campoTextoObs);
		EFA.evidenceEnabled = true;
		 sendKeys.xpath(campoTextoObs, "Testando AUTO");
	}

	public void crt1Empresarial() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		EFA.executeAction(Action.WaitForPageToLoad, 2);
		
		// VIGENCIA & CONGENERE
		Element VigenciaSaude =new Element("xpath","(//input[@value='" + GlobalData.getData("vVigenciaSaude") + "'])[1]");
		Element VigenciaOdonto =new Element("xpath","(//input[@value='" + GlobalData.getData("vVigenciaOdonto") + "'])[2]");

		if (!(boolean) GlobalData.getData("vVidasSaude").equals("")){
			EFA.executeAction(Action.WaitForElementPresent, VigenciaSaude,2);
			EFA.executeAction(Action.Click, VigenciaSaude);
		}
		
		if (!(boolean) GlobalData.getData("vVidasOdonto").equals("")){
			if((boolean) GlobalData.getData("vVidasSaude").equals("")){
				VigenciaOdonto = new Element("xpath","(//input[@value='" + GlobalData.getData("vVigenciaOdonto") + "'])[1]");
				EFA.executeAction(Action.WaitForElementPresent, VigenciaOdonto,2);
				EFA.executeAction(Action.Click, VigenciaOdonto);
			}
			else
				EFA.executeAction(Action.WaitForElementPresent, VigenciaOdonto,2);
				EFA.executeAction(Action.Click, VigenciaOdonto);
		}

		if (!(boolean) GlobalData.getData("vVidasSaude").equals("")){
			String[] tipoCongenereSaude = GlobalData.getData("vCongenereSaude").split(";");
			for (int i = 0; i < tipoCongenereSaude.length; i++) {
				
				Thread.sleep(1000);
				EFA.executeAction(Action.Click, cmpCongenereSaude);
				
				 sendKeys.xpath(cmpCongenereSaude, tipoCongenereSaude[i]);
				Thread.sleep(1000);
				
				Element btnConSaude = new Element("xpath","//strong[contains(text(),'"+tipoCongenereSaude[i]+"')]");
				EFA.executeAction(Action.Click, btnConSaude);
			}
		}
		
		if (!(boolean) GlobalData.getData("vVidasOdonto").equals("")){
			String[] tipoCongenereOdonto = GlobalData.getData("vCongenereOdonto").split(";");
			for (int i = 0; i < tipoCongenereOdonto.length; i++) {
				
				Thread.sleep(1000);
				
				//TODO não está sendo apresentado o btnConOdonto
				
//				Element btnConOdonto;
//				if(GlobalData.getData("vCongenereOdonto").equals(GlobalData.getData("vCongenereSaude")))
//					btnConOdonto = new Element("xpath","(//strong[contains(text(),'"+tipoCongenereOdonto[i]+"')])[2]");
//				else
//					btnConOdonto = new Element("xpath", "(//strong[contains(text(),'"+tipoCongenereOdonto[i]+"')])[1]");
				
				//EFA.executeAction(Action.Click, cmpCongenereOdonto);
				 sendKeys.xpath(cmpCongenereOdonto, tipoCongenereOdonto[i],1);
				Thread.sleep(1500);
				//EFA.executeAction(Action.Click, btnConOdonto);
			}
		}
		
		// AFASTADOS
			
		if (!(boolean) GlobalData.getData("vAfastados").equals("")) {
			Thread.sleep(1800);
			 sendKeys.xpath(cmpAfastados, GlobalData.getData("vQtdAfastados"));
			 Thread.sleep(1800);
				
			if ((boolean)GlobalData.getData("vAfastados").equals("Manual")){
			EFA.executeAction(Action.WaitForElementPresent, cmpCID);
			EFA.executeAction(Action.Click, cmpCID);
			 sendKeys.xpath(cmpCID, GlobalData.getData("vCID"));
			EFA.executeAction(Action.Click, btnConfirmaCID );
			EFA.executeAction(Action.Click, cmpNomeCID);
			 sendKeys.xpath(cmpNomeCID, GlobalData.getData("vNomeCID"));
			EFA.executeAction(Action.Click, cmpDataCID);
			 sendKeys.xpath(cmpDataCID, GlobalData.getData("vDataCID"));
			EFA.executeAction(Action.Click, btnIncluirCID);
				}
				
				else{
				Element btnPlanilhaAfastados = new Element("xpath","//input[contains(@id,'btnViaUpload')]");
					Thread.sleep(1200);
					EFA.executeAction(Action.Click, btnPlanilhaAfastados);
					Thread.sleep(1200);
					Utils.uploadFile(inputAnexaArquivos, GlobalData.getData("vPlanilhaAfastados"));
					Anexos++;
					}
				}
		Thread.sleep(700);
		
			// PRESTADORES DE SERVIÇO
//		EFA.executeAction(Action.Click, cmpPrestadores);
//		
//		 sendKeys.xpath(cmpPrestadores, GlobalData.getData("vPrestadores"));
		 
		Thread.sleep(700);
		// RFQ, RFI, RFP
		Element RFQIP = new Element("xpath", "//div/input[@value='" + GlobalData.getData("vRFQIP") + "']");
		
		EFA.executeAction(Action.Click, RFQIP);
	}

	public void crt2Empresarial() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		EFA.executeAction(Action.WaitForPageToLoad, 2);
		Element btnCopartSaude =new Element("xpath","(//span[contains(text(),'"+ GlobalData.getData("vCopartSaude") +"')]//../input[contains(@id,'Saude')])");
		Element btnCopartOdonto =new Element("xpath","(//span[contains(text(),'"+ GlobalData.getData("vCopartOdonto") +"')]//../input[contains(@id,'Odonto')])");
		Element btnReembolsoSaude =new Element("xpath","(//input[@value='"+ GlobalData.getData("vReembolsoSaude") +"'])[1]");
		Element btnReembolsoOdonto =new Element("xpath","(//input[@value='"+ GlobalData.getData("vReembolsoOdonto") +"'])[2]");
		Element PersonalSaude =new Element ("xpath","//textarea[contains(@id,'CoPartPersSaude')]");
		Element PersonalOdonto =new Element ("xpath","//textarea[contains(@id,'CoPartPersOdonto')]");
		Element ReembolsoSaude =new Element ("xpath","//textarea[contains(@id,'ReembolsoSaude')]");
		Element ReembolsoOdonto =new Element ("xpath","//textarea[contains(@id,'ReembolsoOdonto')]");		
		
		if (!((GlobalData.getData("vTipoFluxo").equals("Duplicar")) || (GlobalData.getData("vTipoFluxo").equals("Retomar")))){
			
			if (!(boolean) GlobalData.getData("vVidasSaude").equals("")){
			Thread.sleep(800);
			EFA.executeAction(Action.JSExecuteScript, btnCopartSaude, "arguments[0].click();");
			//EFA.executeAction(Action.Click, btnCopartSaude);
			
			if ((boolean)GlobalData.getData("vCopartSaude").equals("Personalizada")){
				Thread.sleep(500);
				sendKeys.xpath(PersonalSaude, "Testando AUTO.");
				}
			}

		if (!(boolean) GlobalData.getData("vVidasOdonto").equals("")){
			Thread.sleep(800);
			EFA.executeAction(Action.JSExecuteScript, btnCopartOdonto, "arguments[0].click();");
			//EFA.executeAction(Action.Click, btnCopartOdonto);
			
 			if ((boolean)GlobalData.getData("vCopartOdonto").equals("Personalizada")){
				Thread.sleep(500);
				sendKeys.xpath(PersonalOdonto, "Testando AUTO.");
				}
			}
		}
		
		if (!(boolean) GlobalData.getData("vVidasSaude").equals("")){
			Thread.sleep(800);
			EFA.executeAction(Action.JSExecuteScript, btnReembolsoSaude, "arguments[0].click();");
			if ((boolean)GlobalData.getData("vReembolsoSaude").equals("S")){
				Thread.sleep(800);
				 sendKeys.xpath(ReembolsoSaude, "Testando AUTO.");
			}
		}		
						
		if (!(boolean) GlobalData.getData("vVidasOdonto").equals("")){
			if(GlobalData.getData("vVidasSaude").equals("")){
				 btnReembolsoOdonto =new Element("xpath","(//input[@value='"+ GlobalData.getData("vReembolsoOdonto") +"'])[1]");
				 EFA.executeAction(Action.JSExecuteScript, btnReembolsoOdonto, "arguments[0].click();");
			}
			else
				Thread.sleep(800);
			EFA.executeAction(Action.JSExecuteScript, btnReembolsoOdonto, "arguments[0].click();");
				if ((boolean)GlobalData.getData("vReembolsoOdonto").equals("S")){
					Thread.sleep(800);
				 sendKeys.xpath(ReembolsoOdonto, "Testando AUTO.");
				}
			}
		}
	
	public void metodoDistrib() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
			
			EFA.evidenceEnabled = false;
			EFA.executeAction(Action.WaitForPageToLoad, 2);
			
			if (GlobalData.getData("vTipoDistribuicao").equals("Planilha")) {
				Utils.uploadFile(inputAnexaArquivos, GlobalData.getData("vPlanilhaAfastados"));
				Anexos++;
				EFA.executeAction(Action.WaitForElementPresent, lblSucesso, 15);
				
				EFA.executeAction(Action.Click, btnAvancar);
		} else {
			EFA.executeAction(Action.Click, btnDistribuiManual);
		}
	}

	public void distribuicao() throws Exception {
		Element btnFecharDist = new Element("xpath", "//a[text()='FECHAR']");
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
			if ((boolean)GlobalData.getData("vTipoDistribuicao").equals("Manual")){
				EFA.executeAction(Action.WaitForPageToLoad, 2);
				String[] tipoTarifa = GlobalData.getData("vTarifas").split(";");
		
		//Masculino
		String[] vidas0a18M = GlobalData.getData("vIdade0a18M").split(";");
		String[] vidas19a23M = GlobalData.getData("vIdade19a23M").split(";");
		String[] vidas24a28M = GlobalData.getData("vIdade24a28M").split(";");
		String[] vidas29a33M = GlobalData.getData("vIdade29a33M").split(";");
		String[] vidas34a38M = GlobalData.getData("vIdade34a38M").split(";");
		String[] vidas39a43M = GlobalData.getData("vIdade39a43M").split(";");
		String[] vidas44a48M = GlobalData.getData("vIdade44a48M").split(";");
		String[] vidas49a53M = GlobalData.getData("vIdade49a53M").split(";");
		String[] vidas54a58M = GlobalData.getData("vIdade54a58M").split(";");
		String[] inativos0a18M = GlobalData.getData("vInativos0a18M").split(";");
		String[] inativos19a23M = GlobalData.getData("vInativos19a23M").split(";");
		String[] inativos24a28M = GlobalData.getData("vInativos24a28M").split(";");
		String[] inativos29a33M = GlobalData.getData("vInativos29a33M").split(";");
		String[] inativos34a38M = GlobalData.getData("vInativos34a38M").split(";");
		String[] inativos39a43M = GlobalData.getData("vInativos39a43M").split(";");
		String[] inativos44a48M = GlobalData.getData("vInativos44a48M").split(";");
		String[] inativos49a53M = GlobalData.getData("vInativos49a53M").split(";");
		String[] inativos54a58M = GlobalData.getData("vInativos54a58M").split(";");
		String[] agregados0a18M = GlobalData.getData("vAgregados0a18M").split(";");
		String[] agregados19a23M = GlobalData.getData("vAgregados19a23M").split(";");
		String[] agregados24a28M = GlobalData.getData("vAgregados24a28M").split(";");
		String[] agregados29a33M = GlobalData.getData("vAgregados29a33M").split(";");
		String[] agregados34a38M = GlobalData.getData("vAgregados34a38M").split(";");
		String[] agregados39a43M = GlobalData.getData("vAgregados39a43M").split(";");
		String[] agregados44a48M = GlobalData.getData("vAgregados44a48M").split(";");
		String[] agregados49a53M = GlobalData.getData("vAgregados49a53M").split(";");
		String[] agregados54a58M = GlobalData.getData("vAgregados54a58M").split(";");
		
		//Feminino
		String[] vidas0a18F = GlobalData.getData("vIdade0a18F").split(";");
		String[] vidas19a23F = GlobalData.getData("vIdade19a23F").split(";");
		String[] vidas24a28F = GlobalData.getData("vIdade24a28F").split(";");
		String[] vidas29a33F = GlobalData.getData("vIdade29a33F").split(";");
		String[] vidas34a38F = GlobalData.getData("vIdade34a38F").split(";");
		String[] vidas39a43F = GlobalData.getData("vIdade39a43F").split(";");
		String[] vidas44a48F = GlobalData.getData("vIdade44a48F").split(";");
		String[] vidas49a53F = GlobalData.getData("vIdade49a53F").split(";");
		String[] vidas54a58F = GlobalData.getData("vIdade54a58F").split(";");
		String[] inativos0a18F = GlobalData.getData("vInativos0a18F").split(";");
		String[] inativos19a23F = GlobalData.getData("vInativos19a23F").split(";");
		String[] inativos24a28F = GlobalData.getData("vInativos24a28F").split(";");
		String[] inativos29a33F = GlobalData.getData("vInativos29a33F").split(";");
		String[] inativos34a38F = GlobalData.getData("vInativos34a38F").split(";");
		String[] inativos39a43F = GlobalData.getData("vInativos39a43F").split(";");
		String[] inativos44a48F = GlobalData.getData("vInativos44a48F").split(";");
		String[] inativos49a53F = GlobalData.getData("vInativos49a53F").split(";");
		String[] inativos54a58F = GlobalData.getData("vInativos54a58F").split(";");
		String[] agregados0a18F = GlobalData.getData("vAgregados0a18F").split(";");
		String[] agregados19a23F = GlobalData.getData("vAgregados19a23F").split(";");
		String[] agregados24a28F = GlobalData.getData("vAgregados24a28F").split(";");
		String[] agregados29a33F = GlobalData.getData("vAgregados29a33F").split(";");
		String[] agregados34a38F = GlobalData.getData("vAgregados34a38F").split(";");
		String[] agregados39a43F = GlobalData.getData("vAgregados39a43F").split(";");
		String[] agregados44a48F = GlobalData.getData("vAgregados44a48F").split(";");
		String[] agregados49a53F = GlobalData.getData("vAgregados49a53F").split(";");
		String[] agregados54a58F = GlobalData.getData("vAgregados54a58F").split(";");

		EFA.executeAction(Action.WaitForElementPresent, vidasFaltantesSaude, 5);
		click.xpath(btnTarifas);

		if (!(boolean)GlobalData.getData("vTodasTarifas").equals("Sim")){
			for (int i = 0; i < tipoTarifa.length; i++) {
				Thread.sleep(800);
				EFA.executeAction(Action.Click, buscaTarifas);
				sendKeys.xpath(buscaTarifas, tipoTarifa[i]);
				i += 1;
				Element selectTarifas = new Element("xpath", "(//html/body/ul//a)[" + i + "]");
				Thread.sleep(1100);
				click.xpath(selectTarifas);
				i -= 1;
				Thread.sleep(2000);
				EFA.executeAction(Action.WaitForElementPresent, AdicionarTarifas, 1);
				click.xpath(AdicionarTarifas);
				Thread.sleep(1500);
				}
		}else{
			EFA.waitForElement(btnTodasTarifas, 2);
			EFA.executeAction(Action.Click, btnTodasTarifas);
			}

		for (int i = 0; i < tipoTarifa.length; i++) {
			// Vidas ativas Masculinox
			Element Idade0a18M = new Element("xpath", "(//span[text()='0-18']/../../..//input)[1]");
			Element Idade19a23M = new Element("xpath","(//span[text()='19-23']/../../..//input)[1]");
			Element Idade24a28M = new Element("xpath","(//span[text()='24-28']/../../..//input)[1]");
			Element Idade29a33M = new Element("xpath","(//span[text()='29-33']/../../..//input)[1]");
			Element Idade34a38M = new Element("xpath","(//span[text()='34-38']/../../..//input)[1]");
			Element Idade39a43M = new Element("xpath","(//span[text()='39-43']/../../..//input)[1]");
			Element Idade44a48M = new Element("xpath","(//span[text()='44-48']/../../..//input)[1]");
			Element Idade49a53M = new Element("xpath","(//span[text()='49-53']/../../..//input)[1]");
			Element Idade54a58M = new Element("xpath","(//span[text()='54-58']/../../..//input)[1]");
			// Vidas inativas Masculino
			Element Inativos0a18M = new Element("xpath","(//span[text()='0-18']/../../..//input)[3]");
			Element Inativos19a23M = new Element("xpath","(//span[text()='19-23']/../../..//input)[3]");
			Element Inativos24a28M = new Element("xpath","(//span[text()='24-28']/../../..//input)[3]");
			Element Inativos29a33M = new Element("xpath","(//span[text()='29-33']/../../..//input)[3]");
			Element Inativos34a38M = new Element("xpath","(//span[text()='34-38']/../../..//input)[3]");
			Element Inativos39a43M = new Element("xpath","(//span[text()='39-43']/../../..//input)[3]");
			Element Inativos44a48M = new Element("xpath","(//span[text()='44-48']/../../..//input)[3]");
			Element Inativos49a53M = new Element("xpath","(//span[text()='49-53']/../../..//input)[3]");
			Element Inativos54a58M = new Element("xpath","(//span[text()='54-58']/../../..//input)[3]");
			// Vidas agregados Masculino
			Element Agregados0a18M = new Element("xpath","(//span[text()='0-18']/../../..//input)[5]");
			Element Agregados19a23M = new Element("xpath","(//span[text()='19-23']/../../..//input)[5]");
			Element Agregados24a28M = new Element("xpath","(//span[text()='24-28']/../../..//input)[5]");
			Element Agregados29a33M = new Element("xpath","(//span[text()='29-33']/../../..//input)[5]");
			Element Agregados34a38M = new Element("xpath","(//span[text()='34-38']/../../..//input)[5]");
			Element Agregados39a43M = new Element("xpath","(//span[text()='39-43']/../../..//input)[5]");
			Element Agregados44a48M = new Element("xpath","(//span[text()='44-48']/../../..//input)[5]");
			Element Agregados49a53M = new Element("xpath","(//span[text()='49-53']/../../..//input)[5]");
			Element Agregados54a58M = new Element("xpath","(//span[text()='54-58']/../../..//input)[5]");

			// Vidas ativas Feminino
			Element Idade0a18F = new Element("xpath","(//span[text()='0-18']/../../..//input)[2]");
			Element Idade19a23F = new Element("xpath","(//span[text()='19-23']/../../..//input)[2]");
			Element Idade24a28F = new Element("xpath","(//span[text()='24-28']/../../..//input)[2]");
			Element Idade29a33F = new Element("xpath","(//span[text()='29-33']/../../..//input)[2]");
			Element Idade34a38F = new Element("xpath","(//span[text()='34-38']/../../..//input)[2]");
			Element Idade39a43F = new Element("xpath","(//span[text()='39-43']/../../..//input)[2]");
			Element Idade44a48F = new Element("xpath","(//span[text()='44-48']/../../..//input)[2]");
			Element Idade49a53F = new Element("xpath","(//span[text()='49-53']/../../..//input)[2]");
			Element Idade54a58F = new Element("xpath","(//span[text()='54-58']/../../..//input)[2]");
			// Vidas inativas Feminino
			Element Inativos0a18F = new Element("xpath","(//span[text()='0-18']/../../..//input)[4]");
			Element Inativos19a23F = new Element("xpath","(//span[text()='19-23']/../../..//input)[4]");
			Element Inativos24a28F = new Element("xpath","(//span[text()='24-28']/../../..//input)[4]");
			Element Inativos29a33F = new Element("xpath","(//span[text()='29-33']/../../..//input)[4]");
			Element Inativos34a38F = new Element("xpath","(//span[text()='34-38']/../../..//input)[4]");
			Element Inativos39a43F = new Element("xpath","(//span[text()='39-43']/../../..//input)[4]");
			Element Inativos44a48F = new Element("xpath","(//span[text()='44-48']/../../..//input)[4]");
			Element Inativos49a53F = new Element("xpath","(//span[text()='49-53']/../../..//input)[4]");
			Element Inativos54a58F = new Element("xpath","(//span[text()='54-58']/../../..//input)[4]");
			// Vidas agregados Feminino
			Element Agregados0a18F = new Element("xpath","(//span[text()='0-18']/../../..//input)[6]");
			Element Agregados19a23F = new Element("xpath","(//span[text()='19-23']/../../..//input)[6]");
			Element Agregados24a28F = new Element("xpath","(//span[text()='24-28']/../../..//input)[6]");
			Element Agregados29a33F = new Element("xpath","(//span[text()='29-33']/../../..//input)[6]");
			Element Agregados34a38F = new Element("xpath","(//span[text()='34-38']/../../..//input)[6]");
			Element Agregados39a43F = new Element("xpath","(//span[text()='39-43']/../../..//input)[6]");
			Element Agregados44a48F = new Element("xpath","(//span[text()='44-48']/../../..//input)[6]");
			Element Agregados49a53F = new Element("xpath","(//span[text()='49-53']/../../..//input)[6]");
			Element Agregados54a58F = new Element("xpath","(//span[text()='54-58']/../../..//input)[6]");
			
			// Distribuição
			Thread.sleep(1500);
			i +=1;
			Element CardCotacao = new Element("xpath", "(//div[contains(@id,'CntDadosRegiao')])[" + i + "]");
			EFA.executeAction(Action.Click, CardCotacao);
			i -=1;
			
			EFA.executeAction(Action.WaitForElementPresent, Idade0a18M, 3);
			
			//DISTRIBUIÇÃO  MASCULINO
			Thread.sleep(500);
			Utils.changeFrameByObject(Idade0a18M, 2);
			EFA.executeAction(Action.Click, Idade0a18M);
				if (i < vidas0a18M.length)
				 sendKeys.xpath(Idade0a18M, vidas0a18M[i]);
				if (i < vidas19a23M.length)
				 sendKeys.xpath(Idade19a23M, vidas19a23M[i]);
				if (i < vidas24a28M.length)
				 sendKeys.xpath(Idade24a28M, vidas24a28M[i]);
				if (i < vidas29a33M.length)
				 sendKeys.xpath(Idade29a33M, vidas29a33M[i]);
				if (i < vidas34a38M.length)
				 sendKeys.xpath(Idade34a38M, vidas34a38M[i]);
				if (i < vidas39a43M.length)
				 sendKeys.xpath(Idade39a43M, vidas39a43M[i]);
				if (i < vidas44a48M.length)
				 sendKeys.xpath(Idade44a48M, vidas44a48M[i]);
				if (i < vidas49a53M.length)
				 sendKeys.xpath(Idade49a53M, vidas49a53M[i]);
				if (i < vidas54a58M.length)
				 sendKeys.xpath(Idade54a58M, vidas54a58M[i]);
				
				//DISTRIBUIÇÃO FEMININO
//				EFA.executeAction(Action.JSExecuteScript, btnAvancar, "window.scrollBy(0,-400)");				
				EFA.executeAction(Action.Click, Idade0a18F);
				if (i < vidas0a18F.length)
				 sendKeys.xpath(Idade0a18F, vidas0a18F[i]);
				if (i < vidas19a23F.length)
				 sendKeys.xpath(Idade19a23F, vidas19a23F[i]);
				if (i < vidas24a28F.length)
				 sendKeys.xpath(Idade24a28F, vidas24a28F[i]);
				if (i < vidas29a33F.length)
				 sendKeys.xpath(Idade29a33F, vidas29a33F[i]);
				if (i < vidas34a38F.length)
				 sendKeys.xpath(Idade34a38F, vidas34a38F[i]);
				if (i < vidas39a43F.length)
				 sendKeys.xpath(Idade39a43F, vidas39a43F[i]);
				if (i < vidas44a48F.length)
				 sendKeys.xpath(Idade44a48F, vidas44a48F[i]);
				if (i < vidas49a53F.length)
				 sendKeys.xpath(Idade49a53F, vidas49a53F[i]);
				if (i < vidas54a58F.length)
				 sendKeys.xpath(Idade54a58F, vidas54a58F[i]);
				
				//DISTRIBUIÇÃO INATIVOS MASCULINO
//				EFA.executeAction(Action.JSExecuteScript, btnAvancar, "window.scrollBy(0,-400)");	
				EFA.executeAction(Action.Click, Inativos0a18M);
				if (i < inativos0a18M.length)
					 sendKeys.xpath(Inativos0a18M, inativos0a18M[i]);
				if (i < inativos19a23M.length)
					 sendKeys.xpath(Inativos19a23M, inativos19a23M[i]);
				if (i < inativos24a28M.length)
					 sendKeys.xpath(Inativos24a28M, inativos24a28M[i]);
				if (i < inativos29a33M.length)
					 sendKeys.xpath(Inativos29a33M, inativos29a33M[i]);
				if (i < inativos34a38M.length)
					 sendKeys.xpath(Inativos34a38M, inativos34a38M[i]);
				if (i < inativos39a43M.length)
					 sendKeys.xpath(Inativos39a43M, inativos39a43M[i]);
				if (i < inativos44a48M.length)
					 sendKeys.xpath(Inativos44a48M, inativos44a48M[i]);
				if (i < inativos49a53M.length)
					 sendKeys.xpath(Inativos49a53M, inativos49a53M[i]);
				if (i < inativos54a58M.length)
					 sendKeys.xpath(Inativos54a58M, inativos54a58M[i]);
				
				
				//DISTRIBUIÇÃO INATIVOS FEMININO
//				EFA.executeAction(Action.JSExecuteScript, btnAvancar, "window.scrollBy(0,-400)");	
				EFA.executeAction(Action.Click, Inativos0a18F);
				if (i < inativos0a18F.length)
					 sendKeys.xpath(Inativos0a18F, inativos0a18F[i]);
				if (i < inativos19a23F.length)
					 sendKeys.xpath(Inativos19a23F, inativos19a23F[i]);
				if (i < inativos24a28F.length)
					 sendKeys.xpath(Inativos24a28F, inativos24a28F[i]);
				if (i < inativos29a33F.length)
					 sendKeys.xpath(Inativos29a33F, inativos29a33F[i]);
				if (i < inativos34a38F.length)
					 sendKeys.xpath(Inativos34a38F, inativos34a38F[i]);
				if (i < inativos39a43F.length)
					 sendKeys.xpath(Inativos39a43F, inativos39a43F[i]);
				if (i < inativos44a48F.length)
					 sendKeys.xpath(Inativos44a48F, inativos44a48F[i]);
				if (i < inativos49a53F.length)
					 sendKeys.xpath(Inativos49a53F, inativos49a53F[i]);
				if (i < inativos54a58F.length)
					 sendKeys.xpath(Inativos54a58F, inativos54a58F[i]);
			
				//DISTRIBUIÇÃO AGREGADOS MASCULINO
//				EFA.executeAction(Action.JSExecuteScript, btnAvancar, "window.scrollBy(0,-400)");	
				EFA.executeAction(Action.Click, Agregados0a18M);
				if (i < agregados0a18M.length)
					 sendKeys.xpath(Agregados0a18M, agregados0a18M[i]);
				if (i < agregados19a23M.length)
					 sendKeys.xpath(Agregados19a23M, agregados19a23M[i]);
				if (i < agregados24a28M.length)
					 sendKeys.xpath(Agregados24a28M, agregados24a28M[i]);
				if (i < agregados29a33M.length)
					 sendKeys.xpath(Agregados29a33M, agregados29a33M[i]);
				if (i < agregados34a38M.length)
					 sendKeys.xpath(Agregados34a38M, agregados34a38M[i]);
				if (i < agregados39a43M.length)
					 sendKeys.xpath(Agregados39a43M, agregados39a43M[i]);
				if (i < agregados44a48M.length)
					 sendKeys.xpath(Agregados44a48M, agregados44a48M[i]);
				if (i < agregados49a53M.length)
					 sendKeys.xpath(Agregados49a53M, agregados49a53M[i]);
				if (i < agregados54a58M.length)
					 sendKeys.xpath(Agregados54a58M, agregados54a58M[i]);
				
				//DISTRIBUIÇÃO AGREGADOS FEMININO
//				EFA.executeAction(Action.JSExecuteScript, btnAvancar, "window.scrollBy(0,-400)");	
				EFA.executeAction(Action.Click, Agregados0a18F);
				if (i < agregados0a18F.length)
					 sendKeys.xpath(Agregados0a18F, agregados0a18F[i]);
				if (i < agregados19a23F.length)
					 sendKeys.xpath(Agregados19a23F, agregados19a23F[i]);
				if (i < agregados24a28F.length)
					 sendKeys.xpath(Agregados24a28F, agregados24a28F[i]);
				if (i < agregados29a33F.length)
					 sendKeys.xpath(Agregados29a33F, agregados29a33F[i]);
				if (i < agregados34a38F.length)
					 sendKeys.xpath(Agregados34a38F, agregados34a38F[i]);
				if (i < agregados39a43F.length)
					 sendKeys.xpath(Agregados39a43F, agregados39a43F[i]);
				if (i < agregados44a48F.length)
					 sendKeys.xpath(Agregados44a48F, agregados44a48F[i]);
				if (i < agregados49a53F.length)
					 sendKeys.xpath(Agregados49a53F, agregados49a53F[i]);
				if (i < agregados54a58F.length)
					 sendKeys.xpath(Agregados54a58F, agregados54a58F[i]);
				
				Thread.sleep(1200);
				EFA.executeAction(Action.JSExecuteScript, btnFecharDist, "arguments[0].click();");
							
				Utils.changeToParentFrame();
				}
			}
		}
	

	public void ditribuicaoOdonto() throws Exception {
		Element btnBuscaPorTarifa = new Element("xpath", "//label[contains(text(), 'por tarifa')]/..//input");
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		EFA.executeAction(Action.WaitForPageToLoad, 3);
		
		if ((boolean)GlobalData.getData("vVidasSaude").equals("")){
			String[] tipoTarifa = GlobalData.getData("vTarifas").split(";");
			EFA.executeAction(Action.Click, btnBuscaPorTarifa);
			EFA.executeAction(Action.WaitForElementPresent, buscaTarifas, 2);
			
			for (int i = 0; i < tipoTarifa.length; i++) {
				EFA.executeAction(Action.Click, buscaTarifas);
				 sendKeys.xpath(buscaTarifas, tipoTarifa[i]);
				i += 1;
				Thread.sleep(1000);
				Element selectTarifas = new Element("xpath", "(//html/body/ul//a)[" + i + "]");
				EFA.executeAction(Action.Click, selectTarifas);
				i -= 1;
				Thread.sleep(1000);
				EFA.executeAction(Action.WaitForElementPresent, AdicionarTarifas, 1);
				EFA.executeAction(Action.Click, AdicionarTarifas);
			}
			}
			EFA.executeAction(Action.Click, btnVidasOdonto);
			 sendKeys.xpath(btnVidasOdonto, GlobalData.getData("vVidasOdonto"));
			EFA.evidenceEnabled =true;
			EFA.executeAction(Action.Click, btnValidar);
		}
		

	public void checklist() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		EFA.executeAction(Action.WaitForPageToLoad, 3);
		
		String[] slcDetentorS = GlobalData.getData("vDetentor").split(";");
		String[] cmpDetentorS = GlobalData.getData("vDetentorConta").split(";");
		
		for (int i = 1; i <= slcDetentorS.length; i++) {
			
			//XPATH EM COMUM
			Element slcDetentor = new Element("xpath","(//span[contains(text(),'Corretor é detentor da conta?')]/..//input[@value='"+slcDetentorS[i-1]+"'])["+i+"]");
			Element cmpDetentor = new Element("xpath","(//span[contains(text(),'informe o nome do detentor da conta')]/..//textarea)["+i+"]");
			
			EFA.executeAction(Action.WaitForElementPresent, slcDetentor, 2);
			//click.xpath(slcDetentor);
			EFA.executeAction(Action.JSExecuteScript, slcDetentor, "arguments[0].click();");
			Thread.sleep(700);
			if ((boolean) slcDetentorS.equals("N")){
			 click.xpath(cmpDetentor);
			 sendKeys.xpath(cmpDetentor, cmpDetentorS[i-1]);}
			
			Thread.sleep(700);
			
			if(GlobalData.getData("vAnexarDocumento").equals("Sim")){
				EFA.executeAction(Action.WaitForElementPresent, btnAnexaArquivos);
				Utils.uploadFile(inputAnexaArquivos, GlobalData.getData("vDocumentoAnexo"));
				EFA.executeAction(Action.WaitForElementPresent, documentoCarregado, 5);
				Anexos++;
			}
		}
	}	
		

	public void limparDados() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		EFA.executeAction(Action.WaitForPageToLoad, 2);
		EFA.executeAction(Action.WaitForElementPresent, btnSolicitacoes, 5);
		EFA.executeAction(Action.Click, btnSolicitacoes);
		EFA.executeAction(Action.Hover, backPeriodo);
		EFA.executeAction(Action.Click, backPeriodo);
		Thread.sleep(2000);
		EFA.executeAction(Action.Click, back1ano);
		EFA.executeAction(Action.Click, buscaCNPJ);
		Thread.sleep(2000);
		 sendKeys.xpath(buscaCNPJ, GlobalData.getData("vCNPJ"));
		EFA.executeAction(Action.Click, btnBusca);
		EFA.evidenceEnabled = true;
		EFA.executeAction(Action.WaitForPageToLoad, 2);
		Thread.sleep(5000);

		while ((boolean) EFA.executeAction(Action.IsElementPresent, lblCotacao)) {
			if ((boolean) EFA.executeAction(Action.IsElementPresent, btnDeletarCotacao, 2)) {
				EFA.executeAction(Action.JSExecuteScript, btnDeletarCotacao, "arguments[0].click();");
				Thread.sleep(3000);
				EFA.executeAction(Action.AlertConfirmationMessage, true);
			} else
				break;
		}
	}

	public void crtContrat() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		EFA.executeAction(Action.WaitForPageToLoad, 2);
		Thread.sleep(2000);
		Element btnChekup =new Element ("xpath","//span[text()='"+GlobalData.getData("vChekup")+"']/../input");
		Element btnRemissao =new Element ("xpath","//input[@value='"+GlobalData.getData("vRemissao")+"']");
		
		if ((boolean) EFA.executeAction(Action.IsElementPresent, btnChekup, 3)){
			EFA.executeAction(Action.Click, btnChekup);
			EFA.executeAction(Action.Click, btnRemissao);
			
			if ((boolean) GlobalData.getData("vCarteira").equals("ASO")){
				Element btnAssistViagem= new Element("xpath","//div[contains(@id,'CtnAssViag')]//span[text()='"+GlobalData.getData("vAssistViagem")+"']/../input");
				EFA.executeAction(Action.WaitForElementPresent, btnAssistViagem);
				EFA.evidenceEnabled=true;
				EFA.executeAction(Action.Click, btnAssistViagem);
			}
		}
		else
			return;
	}

	public void avancarEnviar() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		Thread.sleep(1500);
		EFA.executeAction(Action.WaitForElementPresent, btnAvancarEnviar , 5);
		EFA.executeAction(Action.JSExecuteScript, btnAvancarEnviar, "window.scrollBy(0,-400)");
		EFA.evidenceEnabled = true;
		EFA.executeAction(Action.Click, btnAvancarEnviar);
		}

	public void duplimar() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return;
		EFA.evidenceEnabled = false;
		EFA.executeAction(Action.WaitForPageToLoad, 2);
		EFA.executeAction(Action.WaitForElementPresent, btnSolicitacoes, 5);
		EFA.executeAction(Action.Click, btnSolicitacoes);
		EFA.executeAction(Action.WaitForPageToLoad, 2);
		EFA.executeAction(Action.Hover, backPeriodo);
		EFA.executeAction(Action.Click, backPeriodo);
		Thread.sleep(2000);
		EFA.executeAction(Action.Click, back1ano);
		select.xpath(slcStatus , GlobalData.getData("vStatusPesquisa"));
		//PESQUISAR UMA COTAÇÃO A SER DUPLICADA OU RETOMADA
		EFA.executeAction(Action.Click, cmpBuscaGeral);
		sendKeys.xpath(cmpBuscaGeral, GlobalData.getData("vProtocoloAnterior"));

		EFA.executeAction(Action.Click, btnBusca);
		
			if((boolean)GlobalData.getData("vTipoFluxo").equals("Retomar")){
				Element Retomar = new Element("xpath","(//input[contains(@id,'BtnRetomarCotacao')])[1]");
				Thread.sleep(1100);
				EFA.executeAction(Action.Click, Retomar);
				
				}else{
					Element duplicar = new Element("xpath","(//a[contains(@id,'nkPopUpDuplicar')])[1]");
					Element confirmarDuplicar = new Element("xpath","//input[contains(@id,'BtnSim')]");
					EFA.executeAction(Action.Click, duplicar);
					Thread.sleep(1100);
					Utils.changeFrameByObject(confirmarDuplicar, 2);
					EFA.executeAction(Action.Click, confirmarDuplicar);
					Utils.changeToParentFrame();
					Thread.sleep(2000);
		}	
	}

	public void distVidasSaudePME() throws Exception {
		if (!EFA.cv_onError.isEmpty())
			return;
		EFA.evidenceEnabled = false;
		String[] tipoPlano = GlobalData.getData("vPlanoVidas").split(";");
		String[] vidas0a18 = GlobalData.getData("vIdade0a18").split(";");
		String[] vidas19a23 = GlobalData.getData("vIdade19a23").split(";");
		String[] vidas24a28 = GlobalData.getData("vIdade24a28").split(";");
		String[] vidas29a33 = GlobalData.getData("vIdade29a33").split(";");
		String[] vidas34a38 = GlobalData.getData("vIdade34a38").split(";");
		String[] vidas39a43 = GlobalData.getData("vIdade39a43").split(";");
		String[] vidas44a48 = GlobalData.getData("vIdade44a48").split(";");
		String[] vidas49a53 = GlobalData.getData("vIdade49a53").split(";");
		String[] vidas54a58 = GlobalData.getData("vIdade54a58").split(";");

		EFA.executeAction(Action.WaitForElementPresent, vidasFaltantesSaude, 5);

		for (int i = 0; i < tipoPlano.length; i++) {
			i += 1;
			Element slcPlano = new Element("xpath", "(//select[contains(@id,'CmbPlano')])[" + i + "]");
			
			if (tipoPlano.length > 1) {
			click.xpath(btnAddPlano, 1);
			}
			i -= 1;
			select.xpath(slcPlano, tipoPlano[i]);
		}

		for (int i = 0; i < tipoPlano.length; i++) {
			Element Idade0a18 = new Element("xpath",
					"(//span[contains(text(),'0 - 18')]/../../..//input)[" + (i + 1) + "]");
			Element Idade19a23 = new Element("xpath",
					"(//span[contains(text(),'19 - 23')]/../../..//input)[" + (i + 1) + "]");
			Element Idade24a28 = new Element("xpath",
					"(//span[contains(text(),'24 - 28')]/../../..//input)[" + (i + 1) + "]");
			Element Idade29a33 = new Element("xpath",
					"(//span[contains(text(),'29 - 33')]/../../..//input)[" + (i + 1) + "]");
			Element Idade34a38 = new Element("xpath",
					"(//span[contains(text(),'34 - 38')]/../../..//input)[" + (i + 1) + "]");
			Element Idade39a43 = new Element("xpath",
					"(//span[contains(text(),'39 - 43')]/../../..//input)[" + (i + 1) + "]");
			Element Idade44a48 = new Element("xpath",
					"(//span[contains(text(),'44 - 48')]/../../..//input)[" + (i + 1) + "]");
			Element Idade49a53 = new Element("xpath",
					"(//span[contains(text(),'49 - 53')]/../../..//input)[" + (i + 1) + "]");
			Element Idade54a58 = new Element("xpath",
					"(//span[contains(text(),'54 - 58')]/../../..//input)[" + (i + 1) + "]");

			click.xpathMove(Idade0a18, 1);
			sendKeys.xpath(Idade0a18, vidas0a18[i]);
			

			click.xpathMove(Idade19a23);
			sendKeys.xpath(Idade19a23, vidas19a23[i]);
			

			click.xpathMove(Idade24a28);
			sendKeys.xpath(Idade24a28, vidas24a28[i]);
			
			
			click.xpathMove(Idade29a33);
			sendKeys.xpath(Idade29a33, vidas29a33[i]);
			

			click.xpathMove(Idade34a38);
			sendKeys.xpath(Idade34a38, vidas34a38[i]);
			

			click.xpathMove(Idade39a43);
			sendKeys.xpath(Idade39a43, vidas39a43[i]);
			

			click.xpathMove(Idade44a48);
			sendKeys.xpath(Idade44a48, vidas44a48[i]);
			

			click.xpathMove(Idade49a53);
			sendKeys.xpath(Idade49a53, vidas49a53[i]);
			

			click.xpathMove(Idade54a58);
			sendKeys.xpath(Idade54a58, vidas54a58[i]);
			
		}

		click.xpath(btnValidar);
		Thread.sleep(1000);
		click.xpath(btnGerarPreco, 1);

		EFA.executeAction(Action.WaitForElementPresent, lblPreco, 3);

		if ((boolean) EFA.executeAction(Action.IsElementPresent, AvancarDisabled))
			click.xpath(btnGerarPreco, 1);
		
	}

	public void copartMais() throws Exception {
		if (!EFA.cv_onError.isEmpty())
			return;
		EFA.evidenceEnabled = false;
		
		Element btnCopartSaude =new Element("xpath","(//span[contains(text(),'"+ GlobalData.getData("vCopartSaude") +"')]//../input[contains(@id,'Saude')])");
		Element PersonalSaude =new Element ("xpath","//textarea[contains(@id,'CoPartPersSaude')]");		
		
		if (!(boolean) GlobalData.getData("vVidasSaude").equals("")){
			Thread.sleep(800);
			EFA.executeAction(Action.JSExecuteScript, btnCopartSaude, "arguments[0].click();");
			
			if ((boolean)GlobalData.getData("vCopartSaude").equals("Personalizado")){
				Thread.sleep(500);
				 sendKeys.xpath(PersonalSaude, "Testando AUTO.");
			}
		}
	}

	public void validaDistSaude() throws Exception {
		if (!EFA.cv_onError.isEmpty())
			return;
		EFA.evidenceEnabled = false;
		Thread.sleep(1200);
		Element PrecoFinalSaude = new Element ("xpath","//span[contains(text(),'PREÇO SAUDE')]");
		if ((boolean) EFA.executeAction(Action.IsElementPresent, PrecoFinalSaude, 2)){
			Thread.sleep(1000);
		EFA.executeAction(Action.Click, btnAvancar);
		}
	}

	public void validaDistOdonto() throws Exception {
		if (!EFA.cv_onError.isEmpty())
			return;
		EFA.evidenceEnabled = false;
		Thread.sleep(1200);
		Element PrecoFinalOdonto = new Element ("xpath","//span[contains(text(),'PREÇO ODONTO')]");
		if ((boolean) EFA.executeAction(Action.IsElementPresent, PrecoFinalOdonto, 2)){
		EFA.executeAction(Action.Click, btnAvancar);
		}
	}

	public void remissao() throws Exception {
		if (!EFA.cv_onError.isEmpty())
			return;
		EFA.evidenceEnabled = false;
		Element labelRemissao = new Element("xpath","//label[contains(text(),'Remissão')]");
		Element btnRemissao = new Element("xpath","//input[contains(@value,'"+GlobalData.getData("vRemissao")+"')]");
		EFA.executeAction(Action.WaitForElementPresent, labelRemissao,2);
		click.xpath(btnRemissao);
		
		EFA.executeAction(Action.Click, btnAvancar);
	}

	public void cartaNomeacao() throws Exception {
		if (!EFA.cv_onError.isEmpty())
			return;
		EFA.evidenceEnabled = false;
		Element labelNomeacao = new Element("xpath","//span[contains(text(),'de nomeação')]");
		EFA.executeAction(Action.WaitForPageToLoad,3);
		if ((boolean)EFA.executeAction(Action.IsElementPresent, labelNomeacao, 5)){
			Utils.uploadFile(inputAnexaArquivos, GlobalData.getData("vCartaNomeacao"));
			Thread.sleep(3000);
			click.xpath(btnAvancar3);
		}
	}
}