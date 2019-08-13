package sulamerica.utils;

import static com.everis.GlobalData.getData;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import com.everis.Action;
//import com.everis.Data;
import com.everis.EFA;
import com.everis.Element;
import com.everis.ExecutionInfo;
import com.everis.GlobalData;
//import com.everis.Utils;
import com.everis.data.DataExcel;

import sulamerica.core.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author kappa
 *
 */
public class Utils extends sulamerica.core.BasePage {
	// public static Data mv_database = new Data();
	private static Date mv_sceneTime;
	/* VARIÁVEIS PARA RESUMO DE EXECUÇÃO */
	public static int contadorCases = 0;
	public static int contadorPassed = 0;
	public static int contadorFailed = 0;
	public static int contadorErroSalvarManifest = 0;
	public static int contadorErroSLA = 0;
	public static int contadorErroFila = 0;
	public static int contadorErroStatus = 0;
	public static int contadorErroMarco = 0;
	public static int contadorErroScript = 0;
	public static int contadorErroNaoMapeado = 0;
	public static String nomeExecucao = "";

	/**
	 * Procura um objeto dentro dos frames do sistema
	 * 
	 * @param type
	 * @param locator
	 * @param timeOut
	 * @throws Exception
	 */
	public static void changeFrameByObject(String type, String locator, int timeOut) throws Exception {
		Element temp = new Element(type, locator);
		changeFrameByObject(temp, timeOut);
	}

	/**
	 * Procura um objeto dentro dos frames do sistema
	 * 
	 * @param objeto
	 * @param timeOut - Tempo esperado antes de iniciar a busca
	 * @throws Exception
	 */
	public static void changeFrameByObject(Element objeto, int timeOut) throws Exception {
		boolean retorno = false;
		timeOut = timeOut * 1000;
		int relogio = 0;

		while (!(Boolean) EFA.executeAction(Action.IsElementPresent, objeto)) {
			int i = 0;
			while (true) {
				try {
					EFA.cv_driver.switchTo().frame(i);
					if ((Boolean) EFA.executeAction(Action.IsElementPresent, objeto)) {
						EFA.executeAction(Action.JSExecuteScript, objeto, "arguments[0].scrollIntoView(true);");
						retorno = true;
						break;
					} else {
						EFA.cv_driver.switchTo().parentFrame();
					}
				} catch (Exception e) {
					retorno = false;
					break;
				}
				i++;
			}

			if (retorno) {
				return;
			} else {
				Thread.sleep(500);
				relogio = relogio + 500;
				if (relogio > timeOut)
					return;
			}
		}
	}

	/**
	 * Define como frame da execução o frame pai do que está ativo no momento
	 */
	public static void changeToParentFrame() {
		EFA.cv_driver.switchTo().parentFrame();
	}

	/**
	 * Troca a janela da execução
	 */
	public static void changeWindow() {
		String janelaFinal = "";
		Set<String> janelas = EFA.cv_driver.getWindowHandles();
		for (String janela : janelas) {
			janelaFinal = janela;
		}
		EFA.cv_driver.switchTo().window(janelaFinal);
	}

	/**
	 * Finaliza somente a aba atual
	 */
	public static void closeCurrentTab() {
		String originalHandle = EFA.cv_driver.getWindowHandle();
		String nextHandle = "";

		// Do something to open new tabs
		for (String handle : EFA.cv_driver.getWindowHandles()) {
			if (!handle.equals(originalHandle)) {
				nextHandle = handle;
			}
		}
		if (EFA.cv_driver.getWindowHandles().size() > 1) {
			EFA.cv_driver.switchTo().window(originalHandle);
			EFA.cv_driver.close();
			EFA.cv_driver.switchTo().window(nextHandle);
		}
	}

	/**
	 * Simula a ação de pressionar o botão Enter do teclado através da classe Robot
	 * do Java
	 */
	public static void robotEnter() {
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

	public static void robotTAB() {
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Calcula a quantidade de dia uteis entre duas datas
	 * 
	 * @param dataInicio
	 * @param dataFim
	 * @return Inteiro com a quantidade de dias uteis
	 * @throws ParseException
	 */
	public static int nuDiasExecutadosUteis(Date dataInicio, Date dataFim, String[] feriados) throws ParseException {

		// Numero de dias que se passaram, sem contar com a data inicio e data fim
		// Observação: Contando que a data inicio e data fim sejam dias uteis

		long nuDiasExecutados = (long) (dataFim.getTime() - dataInicio.getTime()) / 86400000;
		int totalDiasExecutadosUteis = 0;
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataInicio);
		for (int i = 1; i <= nuDiasExecutados; i++) {

			// Verifica se não é dia util
			if (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				totalDiasExecutadosUteis += 1;
			}

			/* Feriado */
			for (int n = 0; n < feriados.length; n++) {
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				String StringDate = format.format(cal.getTime());

				if (StringDate.equals(feriados[n])) {
					totalDiasExecutadosUteis -= 1;
				}
			}

			// Acrescenta mais um dia na data para poder verificar se é dia util
			cal.add(Calendar.DATE, 1);

		}

		return totalDiasExecutadosUteis;
	}

	/**
	 * Completa uma string com zeros a esquerda
	 * 
	 * @param valor
	 * @param totalCaracteres - Quantidade de caracteres que a string deve conter
	 * @return Valor com zeros a esquerda
	 */
	public static String completarZeroEsquerda(String valor, int totalCaracteres) {
		for (int i = valor.length(); i < totalCaracteres; i++) {
			valor = "0" + valor;
		}

		return valor;
	}

	/**
	 * Abrir o excel para realizar manipulações de dados
	 * 
	 * @return Objeto do excel
	 */
	private static DataExcel openExcel() {
		DataExcel excel = new DataExcel(
				new File("data").getAbsoluteFile() + "/" + ExecutionInfo.getTestSuite() + ".xlsx");
		try {
			excel.open();
			excel.readSheet(ExecutionInfo.getTestName());
			return excel;
		} catch (Exception e) {
			e.printStackTrace();
			EFA.cv_onError = e.getMessage();
			return null;
		}
	}

	/**
	 * Armazenar dados na planilha de massa na linha que está sendo executada
	 * 
	 * @param campo: nome do campo na planilha de dados
	 * @param valor: valor a ser salvo na planilha de dados
	 */
	public static void armazenarDadosPlanilha(String campo, String valor) {
		DataExcel dataExcel = Utils.openExcel();
		if (!(dataExcel == null)) {
			dataExcel.writeCell(Integer.parseInt(GlobalData.getData("index")), campo, valor);
			try {
				dataExcel.save();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// dataExcel.close();
			}
		}
	}

	/**
	 * Esta função irá criar uma basta 'backup' no mesmo diretório deste projeto e
	 * fará um backup da planilha de execução a cada novo test case. Isto evita que
	 * perca a execução caso a planilha corrompa durante alguma execução
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void dataExcelBackup() throws IOException, InterruptedException {
		String excelPath = new File("data").getAbsolutePath() + "\\" + ExecutionInfo.getTestSuite() + ".xlsx";
		String dataPath = new File("data").getAbsolutePath() + "\\backup";

		new File(dataPath).mkdir();

		String[] args = { "CMD", "/C", "COPY", "/Y", excelPath, dataPath };

		Process p = Runtime.getRuntime().exec(args);

		p.waitFor();
	}

	/**
	 * Esta função será responsável por separar as evidências de um caso de teste
	 * passado
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void separaEvidencias() throws IOException, InterruptedException {

		String evidencePath = "N/A";
		// evidencePath = Utils.getOutputDirectory() + "\\";
		evidencePath = new File("output").getAbsolutePath() + "\\";
		evidencePath += ExecutionInfo.getExecutionTimestamp() + "\\";
		evidencePath += ExecutionInfo.getTestSuite() + "\\";
		evidencePath += ExecutionInfo.getTestName() + "\\";
		evidencePath += ExecutionInfo.getExecutionName();

//		System.out.println(evidencePath);
//		
//		String newEvidencePath = "N/A";
//		newEvidencePath = new File("output").getAbsolutePath();
//		newEvidencePath += "\\PASSEDS\\" + ExecutionInfo.getExecutionName();
//		
//		new File(newEvidencePath).mkdir();

//		String[] args = { "CMD", "/C", "ROBOCOPY", "/E", "\"" + evidencePath + "\"",
//				"\"" + newEvidencePath + "\"" };

//		String[] args = { "CMD", "/C", "REN", "\"" + evidencePath + "\"", "\"" + ExecutionInfo.getExecutionName() + "_PASSED" + "\"" };

		String args = "CMD /C REN " + "\"" + evidencePath + "\"" + " " + "\"" + ExecutionInfo.getExecutionName()
				+ "_PASSED" + "\"";
		// System.out.println(args);

		try {
			Process p = Runtime.getRuntime().exec(args);
			p.waitFor();
			p.destroy();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Esta função irá esperar um alerta aparecer pelo tempo que for determinado e
	 * retornará True ou False.
	 * 
	 * @throws throws Exception
	 * @return True ou False
	 */
	public static boolean waitToAlert(int time) throws Exception {

		for (int i = 0; i <= time; i++) {

			if ((Boolean) EFA.executeAction(Action.AlertIsPresent, null)) {
				return true;

			} else {
				Thread.sleep(1000);
			}
		}
		return false;
	}

	// ===================================================================================
	// +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
	// cf_getDiffTime() => calculates the Time difference ------
	// +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
	// ===================================================================================
	public static String cf_getDiffTime(Date cv_date1, Date cv_date2) {
		if (cv_date2.getTime() - cv_date1.getTime() < 0) {
			Calendar c = Calendar.getInstance();
			c.setTime(cv_date2);
			c.add(Calendar.DATE, 1);
			cv_date2 = c.getTime();
		}
		long ms = cv_date2.getTime() - cv_date1.getTime();
		long diffSeconds = ms / 1000 % 60;
		long diffMinutes = ms / (60 * 1000) % 60;
		long diffHours = ms / (60 * 60 * 1000);
		String hh = String.valueOf(diffHours);
		String mm = String.valueOf(diffMinutes);
		String ss = String.valueOf(diffSeconds);
		if (String.valueOf(diffHours).length() == 1)
			hh = "0" + hh;
		if (String.valueOf(diffMinutes).length() == 1)
			mm = "0" + mm;
		if (String.valueOf(diffSeconds).length() == 1)
			ss = "0" + ss;
		return hh + ":" + mm + ":" + ss;
	}

	/**
	 * Inicia a contagem de tempo da execução do caso de teste
	 */
	public static void mf_startSceneTimer() {
		mv_sceneTime = new Date();
		mv_sceneTime.setTime(System.currentTimeMillis());
	}

	/**
	 * Encerra a contagem de tempo da execução do caso de teste
	 * 
	 * @return: retorna o tempo decorrido da execução
	 */
	public static Date mf_endSceneTimer() {
		Date sceneTimeCurrent = new Date();
		sceneTimeCurrent.setTime(System.currentTimeMillis());
		return sceneTimeCurrent;
	}

	/**
	 * Armazena na planilha o tempo de execução do caso de teste
	 */
	public static void ms_writeTimeOutput() {
		armazenarDadosPlanilha("Execution Time", cf_getDiffTime(mv_sceneTime, mf_endSceneTimer()));
	}

	/**
	 * @Description: Get system date and time
	 */
	public static String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	/**
	 * Esta função calcula, a cada novo caso de teste executado, o resultado do
	 * teste contabilizando em variáveis para serem exibidas no relatório final
	 * 
	 * @param mensaje:           com base na mensajem de erro, é possível rastrear a
	 *                           causa da falha
	 * @param resultadoEsperado: se o resultado esperado está OK, o caso é
	 *                           contabilizado como 'Passed'
	 */
	public static void calculaResumoExecucao(String mensaje, String resultadoEsperado) {
		contadorCases += 1;

		if (mensaje.equals(resultadoEsperado)) {
			contadorPassed += 1;
			return;
		} else {
			contadorFailed += 1;
		}

		if (mensaje.contains("Erro ao salvar manifestação")) {
			contadorErroSalvarManifest += 1;
			return;
		}

		if (mensaje.contains("SLA Inválido")) {
			contadorErroSLA += 1;
			return;
		}

		if (mensaje.contains("enviado a fila incorreta")) {
			contadorErroFila += 1;
			return;
		}

		if (mensaje.contains("com status incorreto")) {
			contadorErroStatus += 1;
			return;
		}

		if (mensaje.contains("Marco")) {
			contadorErroMarco += 1;
			return;
		}

		if (mensaje.contains("ERRO SCRIPT")) {
			contadorErroScript += 1;
			return;
		}

		contadorErroNaoMapeado += 1;
	}

	/**
	 * Captura o nome da execução para extrair no relatório da função
	 * printaResumoExecucao()
	 * 
	 * @param execucao: String do 'Controle Pessoal' da planilha de execução
	 */
	public static void capturarNomeExecucao(String[] execucao) {
		nomeExecucao = execucao[0];
	}

	/**
	 * Esta função é executada no final da classe 'Starter' como sumário estatístico
	 * das falhas
	 * 
	 * @throws Exception
	 */
	public static void printaResumoExecucao() throws Exception {
		System.out.println("=================================================================");
		System.out.println("RESUMO DA EXECUÇÃO: " + nomeExecucao);
		System.out.println("=================================================================");
		System.out.println(" ");
		System.out.println("Casos executados...........................................: " + contadorCases);
		System.out.println("Casos passados.............................................: " + contadorPassed);
		System.out.println("Casos falhados.............................................: " + contadorFailed);
		System.out.println(" ");
		System.out
				.println("Casos falhados em salvar manifestação......................: " + contadorErroSalvarManifest);
		System.out.println("Casos falhados por SLA inválido............................: " + contadorErroSLA);
		System.out.println("Casos falhados por Fila / Proprietário inválido............: " + contadorErroFila);
		System.out.println("Casos falhados por Status inválido.........................: " + contadorErroStatus);
		System.out.println("Casos falhados por erro no Marco do SLA....................: " + contadorErroMarco);
		System.out.println("Casos falhados por intermitência/erro no script............: " + contadorErroScript);
		System.out.println("Casos falhados não mapeados na lista de erros..............: " + contadorErroNaoMapeado);
		System.out.println(" ");
		System.out.println("=================================================================");
		System.out.println("=============================FIM=================================");
		System.out.println("=================================================================");
	}

	/**
	 * Utilizado para sinalizar onde ocorreu um determinado erro
	 * 
	 * @param retorno String com o erro ou vazia
	 * @return Retorna a mesma String sem alteração
	 */
	public static void logError() {
		StackTraceElement[] stack = Thread.currentThread().getStackTrace();
		System.out.println("############## ERRO #####################");
		System.out.print("# ");
		System.out.println("Classe: " + stack[3].getClassName());
		System.out.print("# ");
		System.out.println("Metodo: " + stack[3].getMethodName());
		System.out.print("# ");
		System.out.println("Line: " + stack[3].getLineNumber());
		System.out.println("############## ERRO #####################");
	}

	// NEW LUCAS **********

	public static void configCalendarDate(String NameVarDate, String FormatDate) throws InterruptedException {
		if (!GlobalData.getData("" + NameVarDate + "").equals("")) {
			String replaceDate = GlobalData.getData("" + NameVarDate + "").replace("D+", "");
			int number = Integer.parseInt(replaceDate);

			DateFormat dateFormat = new SimpleDateFormat("" + FormatDate + "");
			Date date = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DAY_OF_MONTH, +number);
			date = cal.getTime();
			String dateAdapter = dateFormat.format(date);
			GlobalData.setData("" + NameVarDate + "", dateAdapter);
		}
	}

	public static void continuarSite() throws Exception {
		EFA.evidenceEnabled = false;
		if ((boolean) EFA.executeAction(Action.IsElementPresent,
				new Element("linkText", "Continuar neste site (não recomendado)."))) {
			EFA.cv_driver.findElement(By.linkText("Continuar neste site (não recomendado).")).click();
		} else if ((boolean) EFA.executeAction(Action.IsElementPresent,
				new Element("linkText", "Continue to this website (not recommended)."))) {
			EFA.cv_driver.findElement(By.linkText("Continue to this website (not recommended).")).click();
		}
	}

	public static void uploadFile(Element element, String fileName) {
		try {
			String path = (new File("uploadFiles").getAbsolutePath() + "\\" + fileName).toString();
			sendKeys.xpathNoClear(element, path);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

	public static void setClipboardData(String string) {
		// StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	public static void loader(String a) throws Exception {
		WebDriverWait espera = new WebDriverWait(EFA.cv_driver, 10);
		espera.until(ExpectedConditions.elementToBeClickable(EFA.cv_driver.findElement(By.xpath(a))));
	}
}
