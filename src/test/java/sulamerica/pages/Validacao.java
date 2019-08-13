package sulamerica.pages;

import java.util.Calendar;
import com.everis.Action;
import com.everis.EFA;
import com.everis.Element;
import com.everis.GlobalData;

import sulamerica.utils.Utils;

public class Validacao {

	// ELEMENTOS
	private static Element btnOKdesabilitado = new Element("xpath", "//input[@disabled='disabled']");
	private static Element menuLateral = new Element("xpath","(//a[contains(@id,'MenuLateral')])[1]");
	private static Element msgRestricao = new Element("xpath", "//span[contains(text(),'Acesso não autorizado')]");
	private static Element tabelaInfos = new Element("xpath","//div[contains(@id,'wtInfo')]");
	private static Element EVAAdesabilitado = new Element("xpath", "//select[@disabled='disabled']");
	private static Element CorretorVendedor = new Element("xpath","//select[contains(@id,'CmbSelEV')]");

	// gerenciar vendedor
	private static Element msgSucesso = new Element("xpath", "//span[contains(text(),'sucesso!')]");
	private static Element nomeRetornoPesquisa = new Element("xpath","//span[contains(@id,'ExpNomVend')]");
	private static Element msgNovaSenha = new Element("xpath","//span[contains(text(),'Uma nova senha foi enviada para o seu e-mail.')]");

	// mensagens de erro.
	private static Element msgCampoObrigatorio = new Element("xpath", "//span[contains(text(),'Campo obrigatório')]");
	private static Element msgCampoInvalido = new Element("xpath", "//span[contains(text(),'CPF Inválido')]");
	private static Element msgEmailInvalido = new Element("xpath", "//span[contains(text(),'Esperado um e-mail')]");
	private static Element msgCPFduplicado = new Element("xpath","//span[contains(text(),'Já existe um Vendedor cadastrado')]");

	// mensagens de saudação.
	private static Element bomdia = new Element("xpath", "//span[contains(text(),'dia')]");
	private static Element boatarde = new Element("xpath", "//span[contains(text(),'tarde')]");
	private static Element boanoite = new Element("xpath", "//span[contains(text(),'noite')]");

	// Cotação
			//Confirmação de Dados / Validação
	private static Element menuConfirmaDados = new Element("xpath","//div[contains(@id,'CtnConfDados')]");
	private static Element resCNPJ = new Element("xpath","//span[contains(@id,'OutCnpjCei')]");
	private static Element resVidaSaude = new Element("xpath","//span[contains(@id,'OutQtdVidaSaude')]");
	private static Element resVidaOdonto = new Element("xpath","//span[contains(@id,'OutQtdVidaOdonto')]");
	private static Element resTipoVinculo = new Element("xpath","//span[contains(@id,'OutTipVinculo')]");
	private static Element linkVerMais = new Element("xpath","//span[contains(@id,'LinkVerMais')]");
	private static Element sucessoCotacao = new Element("xpath","//img[contains(@src, 'finished')]");
	private static Element nrPrtcSaude = new Element("xpath","//div[contains(@id,'CtnProtocoloSaude')]");
	private static Element nrPrtcOdonto = new Element("xpath","//div[contains(@id,'CtnProtocoloOdonto')]");
	private static Element resEV = new Element("xpath","//span[contains(@id,'OutNumEv')]");
	private static Element resEA = new Element("xpath","//span[contains(@id,'OutNumEA')]");
	private static Element resAA = new Element("xpath","//span[contains(@id,'OutNumAA')]");
	private static Element resAnexo= new Element("xpath","(//span[contains(@id,'OutNomArqAnexo')])[1]");
	
	

	// START

	public static String validaLogin() throws Exception {
		EFA.evidenceEnabled = false;
		if (!EFA.cv_onError.equals(""))
			return "";
		if (!(boolean) EFA.executeAction(Action.IsElementPresent, menuLateral, 2)) {
			return "Login não realizado";
		} else {
			EFA.evidenceEnabled = true;
			EFA.executeAction(Action.Hover, menuLateral);
			return "Login realizado com sucesso";
		}	
	}

	public static String validaObgEV() throws Exception {
		EFA.evidenceEnabled = false;
		if (!EFA.cv_onError.equals(""))
			return "";
		Thread.sleep(3000);
		if (!(boolean) EFA.executeAction(Action.IsElementPresent, btnOKdesabilitado, 4)) {
			return "o botão 'ok' desabilitado não existe";
		} else {
			EFA.evidenceEnabled = true;
			EFA.executeAction(Action.Hover, btnOKdesabilitado);
			return "Campos EV e EA obrigatórios";
		}
	}

	public static String validaSaudacao() throws Exception {
		EFA.evidenceEnabled = false;
		if (!EFA.cv_onError.equals(""))
			return "";
		Thread.sleep(700);

		if (!(boolean) EFA.executeAction(Action.IsElementPresent, menuLateral, 4)) {
			return "Menu com saudação não apresentado";
		} else {
			EFA.evidenceEnabled = true;
			EFA.executeAction(Action.Hover, menuLateral);
			return "Saudação apresentada no menu";
		}
	}

	public static String validaSaudacaoHorario() throws Exception {
		EFA.evidenceEnabled = false;
		if (!EFA.cv_onError.equals(""))
			return "";
		Thread.sleep(700);
		Calendar data = Calendar.getInstance();
		int hora = data.get(Calendar.HOUR_OF_DAY);

		if (hora >= 00 & hora < 12) {
			if ((boolean) EFA.executeAction(Action.IsElementPresent, bomdia))
				return "mensagem apresentada corretamente";
		}

		if (hora >= 12 && hora <= 18) {
			if ((boolean) EFA.executeAction(Action.IsElementPresent, boatarde))
				return "mensagem apresentada corretamente";
		}

		if (hora >= 19 && hora <= 23) {
			if ((boolean) EFA.executeAction(Action.IsElementPresent, boanoite))
				return "mensagem apresentada corretamente";
		}
		return "mensagem não apresentada";
	}

	public static String validaRestricao() throws Exception {
		EFA.evidenceEnabled = false;
		if (!EFA.cv_onError.equals(""))
			return "";
		Thread.sleep(700);
		if (!(boolean) EFA.executeAction(Action.IsElementPresent, msgRestricao, 4)) {
			return "a mensagem impeditiva não foi apresentada";
		} else {
			EFA.evidenceEnabled = true;
			EFA.executeAction(Action.Hover, msgRestricao);
			return "Acesso não permitido";
		}
	}

	public static String validaInfos() throws Exception {
		EFA.evidenceEnabled = false;
		if (!EFA.cv_onError.equals(""))
			return "";
		Thread.sleep(700);
		EFA.executeAction(Action.WaitForElementPresent, menuLateral, 4);
		EFA.executeAction(Action.Click, menuLateral);
		EFA.executeAction(Action.WaitForElementPresent, linkVerMais, 4);
		EFA.executeAction(Action.Click, linkVerMais);
		EFA.executeAction(Action.WaitForElementPresent, tabelaInfos);

		if (!(boolean) EFA.executeAction(Action.IsElementPresent, tabelaInfos, 4)) {
			return "Menu com informações não apresentado";
		} else {
			EFA.evidenceEnabled = true;
			Thread.sleep(1000);
			EFA.executeAction(Action.Hover, tabelaInfos);
			return "informações apresentadas";
		}
	}

	public static String ValidaOrdemEAEV() throws Exception {
		EFA.evidenceEnabled = false;
		if (!EFA.cv_onError.equals(""))
			return "";
		Thread.sleep(2000);
		if (!(boolean) EFA.executeAction(Action.IsElementPresent, EVAAdesabilitado, 4)) {
			return "Elemento não apresentado na tela";
		} else {
			EFA.evidenceEnabled = true;
			Thread.sleep(1000);
			EFA.executeAction(Action.Hover, EVAAdesabilitado);
			return "necessário preenchimento de EA antes de EV";
		}
	}

	public static String validaComboEV() throws Exception {
		EFA.evidenceEnabled = false;
		if (!EFA.cv_onError.equals(""))
			return "";
		Thread.sleep(500);
		if (!(boolean) EFA.executeAction(Action.IsElementPresent, CorretorVendedor, 4)) {
			return "Elemento não apresentado na tela";
		} else {
			EFA.evidenceEnabled = true;
			Thread.sleep(1000);
			EFA.executeAction(Action.Hover, CorretorVendedor);
			return "Campo de seleção de EV apresentado";
		}
	}

	public static String validaCadastroVendedor() throws Exception {
		EFA.evidenceEnabled = false;
		if (!EFA.cv_onError.equals(""))
			return "";
		Thread.sleep(1100);
		EFA.executeAction(Action.WaitForElementPresent, msgSucesso, 4);
		if (!(boolean) EFA.executeAction(Action.IsElementPresent, msgSucesso, 4))
			return "Cadastro não realizado";
		else {
			EFA.evidenceEnabled = true;
			EFA.executeAction(Action.Hover, msgSucesso);
			return "Cadastro de Vendedor realizado com sucesso";
		}
	}

	public static String ErrosCadastroVendedor() throws Exception {

		if ((boolean) EFA.executeAction(Action.IsElementPresent, msgCampoObrigatorio)) {
			EFA.evidenceEnabled = true;
			EFA.executeAction(Action.Hover, msgCampoObrigatorio);
			return "Campo Obrigatório não preenchido";
		}
		if ((boolean) EFA.executeAction(Action.IsElementPresent, msgCampoInvalido)) {
			EFA.evidenceEnabled = true;
			EFA.executeAction(Action.Hover, msgCampoInvalido);
			return "Campo preenchido com dados inválidos";
		}
		if ((boolean) EFA.executeAction(Action.IsElementPresent, msgEmailInvalido)) {
			EFA.evidenceEnabled = true;
			EFA.executeAction(Action.Hover, msgEmailInvalido);
			return "Email invalido";
		}
		if ((boolean) EFA.executeAction(Action.IsElementPresent, msgCPFduplicado)) {
			EFA.evidenceEnabled = true;
			EFA.executeAction(Action.Hover, msgCPFduplicado);
			return "CPF já existe na base de vendedores";
		} else {
			return "nenhum erro apresentado na tela";
		}
	}

	public static String validaPesquisaVendedor() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return "";
		EFA.evidenceEnabled = false;
		EFA.executeAction(Action.Click, nomeRetornoPesquisa);
		Thread.sleep(1000);
		String nomePesquisado = "";
		nomePesquisado = (String) EFA.executeAction(Action.GetText, nomeRetornoPesquisa);

		if ((boolean) nomePesquisado.equals(GlobalData.getData("vBuscaVendedor"))) {
			EFA.evidenceEnabled = true;
			EFA.executeAction(Action.Hover, nomeRetornoPesquisa);
			return "Pesquisa por CPF realizada com sucesso";
		} else
			return "Pesquisa não realizada";
	}

	public static String validaDadosAtualizados() throws Exception {
		EFA.evidenceEnabled = false;
		if (!EFA.cv_onError.equals(""))
			return "";
		Thread.sleep(1100);
		EFA.executeAction(Action.WaitForElementPresent, msgSucesso, 4);
		if (!(boolean) EFA.executeAction(Action.IsElementPresent, msgSucesso, 4))
			return "Dados não foram alterados";
		else {
			EFA.evidenceEnabled = true;
			EFA.executeAction(Action.Hover, msgSucesso);
			return "Dados alterados com sucesso";
		}
	}

	public static String validaNovaSenha() throws Exception {
		EFA.evidenceEnabled = false;
		if (!EFA.cv_onError.equals(""))
			return "";
		Thread.sleep(1100);
		EFA.executeAction(Action.WaitForElementPresent, msgNovaSenha, 4);
		if (!(boolean) EFA.executeAction(Action.IsElementPresent, msgNovaSenha, 4))
			return "Senha não enviada para o Email";
		else {
			EFA.evidenceEnabled = true;
			EFA.executeAction(Action.Hover, msgNovaSenha);
			return "Senha provisória enviada para o Email cadastrado";
		}
	}

	public static String finalCotacao() throws Exception {
		EFA.evidenceEnabled = false;
		if (!EFA.cv_onError.equals(""))
			return "";
		Thread.sleep(1000);
		String prtcSaude = "";
		String prtcOdonto = "";
		
		EFA.executeAction(Action.WaitForElementPresent, sucessoCotacao, 5);
		
		if ((boolean)EFA.executeAction(Action.IsElementPresent, sucessoCotacao)){
			if(!(boolean)GlobalData.getData("vVidasSaude").equals("")){
			prtcSaude = (String) EFA.executeAction(Action.GetText, nrPrtcSaude);
			Utils.armazenarDadosPlanilha("vProtocoloSaude", prtcSaude);
			}
			
			if(!(boolean)GlobalData.getData("vVidasOdonto").equals("")){
			prtcOdonto = (String) EFA.executeAction(Action.GetText, nrPrtcOdonto);
			Utils.armazenarDadosPlanilha("vProtocoloOdonto", prtcOdonto);
			}
			
			return "Cotação realizada com sucesso";
		}
		else 
			return "Cotação não realizada";
	}
	
	
	public static String validaConfDados() throws Exception {
		if (!EFA.cv_onError.equals(""))
			return"";
		EFA.evidenceEnabled = false;
		String numeroCNPJ = (String) EFA.executeAction(Action.GetText, resCNPJ);
		numeroCNPJ = numeroCNPJ.replace(".", "");
		numeroCNPJ = numeroCNPJ.replace("-", "");
		numeroCNPJ = numeroCNPJ.replace("/", "");
		
		Thread.sleep(1000);
		EFA.executeAction(Action.WaitForElementPresent, menuConfirmaDados, 5);
		
		String tipoVinculo = (String) EFA.executeAction(Action.GetText, resTipoVinculo);
		
		String tipoEV = "000" + EFA.executeAction(Action.GetText, resEV).toString().trim();
		String tipoEA = "000" + EFA.executeAction(Action.GetText, resEA).toString().trim();
		String tipoAA = "00" + EFA.executeAction(Action.GetText, resAA).toString().trim();
		
		
		if (!(boolean)GlobalData.getData("vVidasSaude").equals(""))	{
			String numeroVidaSaude = (String) EFA.executeAction(Action.GetText, resVidaSaude);
		if (!(GlobalData.getData("vVidasSaude").equals(numeroVidaSaude)))
			return"Vidas Saúde diferente do cotado";
		}
		
		if (!(boolean)GlobalData.getData("vVidasOdonto").equals(""))	{
			String numeroVidaOdonto = (String) EFA.executeAction(Action.GetText, resVidaOdonto);
		if (!(GlobalData.getData("vVidasOdonto").equals(numeroVidaOdonto)))
			return"Vidas Odonto diferente do cotado";
		}

					// ANEXOS.
		
//		if (!(boolean)GlobalData.getData("vAnexarDocumento").equals("nao")){
//			if ((boolean)EFA.executeAction(Action.IsElementPresent, resAnexo)){
//				EFA.evidenceEnabled=true;
//				EFA.executeAction(Action.Hover, resAnexo);
//			}
//			else{
//				return "não foi possivel encontrar o anexo";
//			}	
//		}

			if (!(GlobalData.getData("vCNPJ").equals(numeroCNPJ)))
				return"CNPJ diferente do cotado";
			
			if (!(GlobalData.getData("vTipoVinculo").equals(tipoVinculo)))
				return"Tipo de Vinculo diferente do cotado";
			
			if (!(GlobalData.getData("vEV").equals(tipoEV)))
			return"EV diferente do cotado";
			
			if (!(GlobalData.getData("vEA").equals(tipoEA)))
			return"EA diferente do cotado";
			
			if (!(GlobalData.getData("vAA").equals(tipoAA)))
			return"AA diferente do cotado";
	
			
			return "Dados validados com sucesso";	
		}
	
	
	//TODO
	public static String validarAnexos() throws Exception {
		if (!EFA.cv_onError.isEmpty())
			return"";
		EFA.evidenceEnabled = false;
		
		if (GlobalData.getData("vAnexarDocumento").equals("Sim") | GlobalData.getData("vAnexoAdicional").equals("Sim")){
			int x =1;
			
			for (int i = 0; i < Cotacao.Anexos; i++) {
			Element Anexo = new Element("xpath","(//div[contains(@class,'upload-element')])['"+x+"']");
			if ((boolean) EFA.executeAction(Action.IsElementPresent, Anexo)){
			x++;
				}
			else
				return"Não achou os anexo";
			}
		}
		else
			return"";
			
			return"";	
		}
			}
