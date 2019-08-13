package sulamerica.cotador;

import static com.everis.GlobalData.load;
import static com.everis.GlobalData.getData;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.everis.Action;
import com.everis.EFA;
import com.everis.ExecutionInfo;
import com.everis.GlobalData;
import com.everis.data.DataDictionary;
import com.everis.webautomation.ExecutionWrapper;

import sulamerica.pages.Acesso;
import sulamerica.pages.Cotacao;
import sulamerica.pages.Validacao;
import sulamerica.utils.*;

/**
 * @author lpouso
 *
 */

@RunWith(Parameterized.class)
public class Adesao extends ExecutionWrapper {

	private String retorno = "";

	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	ChromeOptions options = new ChromeOptions();

	// Pages used on current script
	private Acesso acesso;
	private Cotacao cotacao;

	public Adesao(String executionName, DataDictionary data) {
		ExecutionInfo.setExecutionName(executionName);
		ExecutionInfo.setTestPlanName("XXXXXX");
		load(data); // Fill Global Dictionary
	}

	@Parameters(name = "{0}")
	public static List<Object> loadTestData() throws Exception {
		return loadData(); // Call data loader for all interactions
	}

	@Before
	public void beforeTest() throws Exception {
		Utils.dataExcelBackup();
		acesso = new Acesso();
		cotacao = new Cotacao();
		
		EFA.capabilities.setCapability("platformVersion", "8");
		EFA.loadExecutionInfo();
		
	}

	@Test
	public void script() throws Throwable {
		try {
			String output;
			acesso.navigate();

			switch (getData("vTipoUsuario")) {
			case "Vendedor":
				acesso.loginVend();
				acesso.selectCorretor();
				break;

			case "Corretor":
				acesso.loginFake();
				acesso.selectVendaApoio();
				break;

			case "Internos":
				acesso.loginCentrify();
				acesso.loginInt();
				break;
			}
			cotacao.novaCotacao();
			cotacao.identfCarteira();
			cotacao.avancar();
			cotacao.defProduto();
			cotacao.avancar();
			cotacao.dadosCliente();
			Thread.sleep(3100);
			cotacao.avancar();
//			cotacao.infoEmpresa();
			Thread.sleep(3100);
			EFA.executeAction(Action.WaitForPageToLoad, 5);
			cotacao.avancar();
			cotacao.contratacao();
			cotacao.avancar();
			
			if (!(boolean)GlobalData.getData("vVidasSaude").equals("")){
			cotacao.tarifaSaudeAdesao();
			cotacao.avancar();
			}
			
			// o sistema usa as mesmas tarifas de saúde para odonto, já foi solicitado a unificação das páginas.
			if (!(boolean)GlobalData.getData("vVidasOdonto").equals(""))	{
			cotacao.avancar();
			}
			
			cotacao.docEmpresa();
			cotacao.avancar();
			cotacao.carrComercial();
			cotacao.avancar();
			cotacao.obs();
			cotacao.avancar();
			output = Validacao.validarAnexos();
			if (!output.trim().equals("")){
				retorno = output;
				return;
				}
					
			if (GlobalData.getData("vFluxo").equals("Validar dados da Confirmação")){
				output = Validacao.validaConfDados();
				retorno = output;
				return;
				}
			
			cotacao.avancar();
			
			if (GlobalData.getData("vFluxo").equals("Validar Cotação")){
				output = Validacao.finalCotacao();
				retorno = output;
				return;
			}
				
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			retorno = EFA.stackTrace = sw.toString();
		} 
		finally {
			EFA.evidenceEnabled = true;
			if (!EFA.cv_onError.equals(""))
				EFA.cf_getTestEvidenceWithStep("Error", 1);
			ms_updateCaseStatus(retorno.equalsIgnoreCase(GlobalData.getData("Expected Result")));
			ExecutionInfo.setResult(retorno);
		}
	}
}
