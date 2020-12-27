package br.com.bean;

import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean(name = "downloadBean")
@SessionScoped
public class DownloadBasicoBean {

	private StreamedContent file;

	public StreamedContent getFile() {
		return file;
	}

	public DownloadBasicoBean() throws FileNotFoundException {
		InputStream stream = this.getClass().getResourceAsStream("testeDownloadExcel.xlsx");
		file = new DefaultStreamedContent(stream, "application/xls", "testeDownloadExcel.xls");
	}

}