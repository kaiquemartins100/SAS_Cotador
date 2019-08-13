package sulamerica.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

public class EvidenceUtil {
	
	public static void create(String proj, String scenario, String testCase) {
		
		// output folder
		File output  = new File("output");
		File[] files = Arrays.stream(output.listFiles()).filter(f -> f.isDirectory()).toArray(File[]::new);
		
		Arrays.sort(files, (f1, f2) -> new Long(f2.lastModified()).compareTo(f1.lastModified()));
		
		String testCaseFolderPath = files[0] + File.separator + proj + File.separator + scenario + File.separator + testCase;
		
		// evidence's folder
		File testCaseFolder = new File(testCaseFolderPath);
		
		output = new File(testCaseFolder.getAbsolutePath() + File.separator + "evidence");
		files  = output.listFiles();
		
		Arrays.sort(files, (f1, f2) -> new Long(f1.lastModified()).compareTo(f2.lastModified()));
		
		// create doc
		
		XWPFDocument document = null;
		FileOutputStream fos  = null;
		
		try {
			
			document = new XWPFDocument(OPCPackage.open(new File("src/test/resources/template_evidencia.docx").getCanonicalPath()));
			XWPFParagraph paragraph = document.createParagraph();
			
			XWPFRun run = paragraph.createRun();
			run.setFontFamily("Calibri");
			run.setFontSize(11);
			run.setBold(true);
			run.setText("Caso de Teste: ");
			
			run = paragraph.createRun();
			run.setFontFamily("Calibri");
			run.setFontSize(11);
			run.setBold(false);
			run.setText(testCase);

			XWPFParagraph paragraph1 = document.createParagraph();

			paragraph1.setSpacingAfterLines(1);
			
			InputStream pic = null;
			XWPFParagraph paragraphOne = document.createParagraph();
			XWPFRun paragraphOneRunOne = paragraphOne.createRun();
			paragraphOneRunOne.addBreak();
			
			XWPFParagraph paragraphFive = null;
			XWPFRun paragraphFiveRunOne = null;
			
			for (File file : files) {
				pic = new FileInputStream(file);

				paragraphFive = document.createParagraph();
				paragraphFive.setAlignment(ParagraphAlignment.CENTER);
				
				paragraphFiveRunOne = paragraphFive.createRun();
				paragraphFiveRunOne.addPicture(pic, XWPFDocument.PICTURE_TYPE_PNG, file.toString(), Units.toEMU(500), Units.toEMU(230));
			}
			
			fos = new FileOutputStream(testCaseFolder + File.separator + testCase + ".docx");

			XWPFParagraph paragraph11 = document.createParagraph();
			XWPFRun run11 = paragraph11.createRun();

			//-----------------------Inicio configuração de Rodapé-----------------------------

			//=-=-=-=-=-=-=-=-=-=-=-=- Criando Rodapé=-=-=-=-=-=-=-
			CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
			XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(document, sectPr);
			XWPFFooter footer = headerFooterPolicy.createFooter(XWPFHeaderFooterPolicy.DEFAULT);
			paragraph11 = footer.getParagraphArray(0);

			//=-=-=-=-=-=-=-=-=-= Criando Tabela no rodapé=-=-=-=-=-=-=-=-=-=-=
			paragraph11 = footer.createParagraph();

			XmlCursor cursor = paragraph11.getCTP().newCursor();
			XWPFTable table = footer.insertNewTbl(cursor);

			XWPFTableRow row = table.createRow();
			int twipsPerInch = 1440;
			table.getCTTbl().addNewTblGrid().addNewGridCol().setW(BigInteger.valueOf(6 * twipsPerInch));

			//=-=-=-=-=-=-=-=-=-=-=-Inserindo autor da execução no Rodapé=-=-=-=-=-=-=-=-=-=-=-=
			XWPFTableCell cell = row.createCell();
			CTTblWidth tblWidth = cell.getCTTc().addNewTcPr().addNewTcW();
			tblWidth.setW(BigInteger.valueOf(8 * twipsPerInch));
			tblWidth.setType(STTblWidth.DXA);
			paragraph11 = cell.getParagraphs().get(0);
			
			run11 = paragraph11.createRun();
			run11.setFontFamily("Calibri");
			run11.setFontSize(11);
			run11.setText("Teste executado de forma automatizada em "+ new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
			
		} catch (InvalidFormatException e) {
			e.printStackTrace();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				document.write(fos);
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}
}
