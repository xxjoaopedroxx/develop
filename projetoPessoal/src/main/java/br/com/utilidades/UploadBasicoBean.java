package br.com.utilidades;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

@ManagedBean(name = "uploadBean")
public class UploadBasicoBean {
	private UploadedFile uploadedFile;

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public void upload() {
		try {
			File file = new File("C:/Users/jpalm/Desktop", uploadedFile.getFileName());

			OutputStream out = new FileOutputStream(file);
			out.write(uploadedFile.getContents());
			out.close();

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Upload completo", "O arquivo " + uploadedFile.getFileName() + " foi salvo!"));
		} catch (IOException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage()));
		}

	}

}
