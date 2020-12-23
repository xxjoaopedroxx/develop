package br.com.controller;

import java.io.IOException;
import java.util.List;

import br.com.entidades.LinhasExcel;

public class WriteExcelController {
	public static void main(String[] args) throws IOException {
		LinhasExcel excel = new LinhasExcel();

		List<LinhasExcel> linhas = excel.getLinhasExcels();
		String path = "src/main/java/arquivos/testeEscritaExcel.xlsx";

		excel.writeExcel(linhas, path);
		
	}
}
