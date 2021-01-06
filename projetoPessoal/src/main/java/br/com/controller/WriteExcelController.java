package br.com.controller;

import java.util.List;

import br.com.entidades.LinhasExcel;

public class WriteExcelController {
	public static void main(String[] args) throws Exception {
		LinhasExcel excel = new LinhasExcel();

		List<LinhasExcel> linhas = excel.getLinhasExcels();
		String path = "C:/Users/jpalm/Desktop/TesteArquivoImportado.xlsx";

		excel.writeExcel(linhas, path);
		
		// salva o arquivo convertido do CSV para excel
//		excel.writeExcelFromCSV(path);
		
	}
}
