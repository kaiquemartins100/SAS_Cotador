package com.everis.webautomation;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
//import java.util.Hashtable;
import java.util.List;
//import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;

import com.everis.Action;
import com.everis.EFA;
import com.everis.ExecutionInfo;
import com.everis.Manager;
import com.everis.Utils;
import com.everis.data.DataLoad;

//import web.CoreWeb;

public class ExecutionWrapper {

	// private static CoreWeb web;

	@Rule
	public TestName currentTest = new TestName();

	/**
	 * Load data from input file or data base
	 * 
	 * @return List with data
	 * @throws Exception
	 */
	public static List<Object> loadData() throws Exception {
		// Capture test name and test suite
		String[] fullClassName = new Throwable().getStackTrace()[1].getClassName().toString().split("\\W");
		ExecutionInfo.setTestSuite(fullClassName[fullClassName.length - 2]);
		ExecutionInfo.setTestName(fullClassName[fullClassName.length - 1]);
		ExecutionInfo.setExecutionTimestamp(new SimpleDateFormat("yyyyMMdd-HHmmss-SSS").format(new Date()));
		// Load data used on script
		return Arrays.asList(new DataLoad().load());
	}

	/**
	 * Setup log file
	 * 
	 * @throws Exception
	 */
	@Before
	public void beforeRunTest() throws Exception {
	}

	/**
	 * Initialize the framework
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void beforeExecution() throws Exception {

		// >> SERVER EXAMPLE
		// web = new CoreWeb();
		// web.start();
		// Start driver
		Manager.loadDriver();
	}

	/**
	 * Scenario - Postcondition for the test
	 * 
	 * @throws Exception
	 */
	@After
	public void afterRunTest() throws Exception {

		EFA.executeAction(Action.ClearSession, null);
		EFA.finishExecution();
		// Generate report file
		// Report.genereateReport();
		// Report.genereateReport();
	}

	/**
	 * Execution - Postcondition for the execution
	 * 
	 * @throws Exception
	 */
	@AfterClass
	public static void afterExecution() throws Exception {
		// Start driver
		// Testlink.TestStatus = Status.FAILED;
		// Testlink.publish();
		Manager.finishDriver();
		// >> SERVER EXAMPLE
		// web.stop();
		// Generate report
		// EFA.genereteReport();
		// EFA.genereteReport();
	}
	
	
	public void ms_updateCaseStatus(boolean status) {

        String old_name;
        File oldfile;
        String new_name;
        File newfile;

        if (status) {
               //com.everis.Utils util = new com.everis.Utils();
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
