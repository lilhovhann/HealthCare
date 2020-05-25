package io.project.app.beans.auth;

import io.project.app.api.requests.FileRequest;
import io.project.app.usercontext.SessionController;
import io.project.app.unicorn.PatientClient;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import lombok.Data;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

@Named
@ViewScoped
@Data
public class FileUploadBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private static final Logger LOG = Logger.getLogger(FileUploadBean.class);
    
    @Inject
    private PatientClient patientClient;
    
    @Inject
    private SessionController sessionController;
    private Part uploadedFile = null;
    
    private FacesContext context = null;
    private ExternalContext externalContext = null;
    private FileRequest fileDTO;
    
    public FileUploadBean() {
        this.sessionController = null;
        
    }
    
    @PostConstruct
    public void init() {
        context = FacesContext.getCurrentInstance();
        externalContext = context.getExternalContext();
        fileDTO = new FileRequest();
        
    }
    
    public String doAction() throws IOException {
        if (uploadedFile != null) {
            
            long size = uploadedFile.getSize();
            
            String content = uploadedFile.getContentType();
            
            InputStream stream = uploadedFile.getInputStream();
            
            byte[] contentBytes = new byte[(int) size];
            stream.read(contentBytes);
            String base64String = Base64.encodeBase64String(contentBytes);
            fileDTO.setFileContent(base64String);
            fileDTO.setFileName(uploadedFile.getSubmittedFileName());
            fileDTO.setFileSize(size);
            fileDTO.setUserId(sessionController.getAccount().getId());//logged user id, patient is not logged
            //logged always account model, event it can be patient!!!
            
            fileDTO.setContentType(uploadedFile.getContentType());
            //System.out.println("ICO " + uploadedFile.getContentType());

            if (!content.equalsIgnoreCase("image/jpeg") && !content.equalsIgnoreCase("image/pjpeg")
                    && !content.equalsIgnoreCase("image/jpg") && !content.equalsIgnoreCase("image/gif")
                    && !content.equalsIgnoreCase("image/x-png") && !content.equalsIgnoreCase("image/png")
                    && !content.equalsIgnoreCase("image/x-icon")) {
                try {
                    
                    return null;
                } catch (Exception e) {
                }
            }
            String saveFile = patientClient.saveFile(fileDTO);
            if(saveFile != null){
                LOG.info("Received file id from backend");
                sessionController.setUserAvatarId(saveFile);
            }
            
        }
        return null;
        
    }
    
    public void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    private void facesError(String message) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }
    
    public Part getUploadedFile() {
        return uploadedFile;
    }
    
    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
    
}
