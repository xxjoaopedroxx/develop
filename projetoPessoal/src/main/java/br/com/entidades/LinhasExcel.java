package br.com.entidades;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

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
	private void writeBook(LinhasExcel conteudo, Row row) {
		Cell cell = row.createCell(1);
		cell.setCellValue(conteudo.getNomeAluno());

		cell = row.createCell(2);
		cell.setCellValue(conteudo.getIdade());

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
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet();

		int rowCount = 0;

		for (LinhasExcel linha : listaLinhas) {
			Row row = sheet.createRow(++rowCount);
			writeBook(linha, row);
		}

		try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
			workbook.write(outputStream);
		}
	}

}
