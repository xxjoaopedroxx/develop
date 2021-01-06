package br.com.entidades;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// comentario
public class LinhasExcel {
	private String nomeAluno;
	private int idade;
	private String curso;

	public LinhasExcel() {

	}

	public LinhasExcel(String nomeAluno, int idade, String curso) {
		super();
		this.nomeAluno = nomeAluno;
		this.idade = idade;
		this.curso = curso;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	/**
	 * 
	 * @author jpalm
	 * @return lista de linhas
	 */
	public List<LinhasExcel> getLinhasExcels() {

		LinhasExcel linha1 = new LinhasExcel("João Pedro Faria de Almeida", 20, "Sistemas de Informação");
		LinhasExcel linha2 = new LinhasExcel("Jordy Allan", 25, "Sistemas de Informação");
		LinhasExcel linha3 = new LinhasExcel("Junia Aguilar", 20, "Arquitetura e Urbanismo");
		LinhasExcel linha4 = new LinhasExcel("Lucas Magnago", 20, "Engenharia Mecânica");

		List<LinhasExcel> listaLinhas = Arrays.asList(linha1, linha2, linha3, linha4);

		return listaLinhas;
	}

	/**
	 * @author jpalm
	 * @param conteudo
	 * @param row
	 */
	private void writeBook(LinhasExcel conteudo, XSSFRow row, XSSFWorkbook wb) {
		
		XSSFCellStyle style = wb.createCellStyle();
		style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
		
		XSSFCell cell = row.createCell(1);		
		cell.setCellValue(conteudo.getNomeAluno());

		cell = row.createCell(2);
		cell.setCellValue(conteudo.getIdade());
		cell.setCellStyle(style);
		
		cell = row.createCell(3);
		cell.setCellValue(conteudo.getCurso());
		
	}

	/**
	 * @author jpalm
	 * @param listaLinhas
	 * @param excelFilePath
	 * @throws IOException
	 */
	public void writeExcel(List<LinhasExcel> listaLinhas, String excelFilePath) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet();

		int rowCount = 0;

		for (LinhasExcel linha : listaLinhas) {
			XSSFRow row = sheet.createRow(++rowCount);
			writeBook(linha, row, workbook);
		}

		try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
			workbook.write(outputStream);
		}
	}
	
	// CSV to XLS converter
//	public void writeExcelFromCSV(String csv) throws Exception {
//		LoadOptions lp = new LoadOptions(FileFormatType.CSV);
//		com.aspose.cells.Workbook wb = new com.aspose.cells.Workbook(csv, lp);
//		wb.save("C:/Users/jpalm/Desktop/exemploExcel.xlsx", SaveFormat.XLSX);
//	}

}
