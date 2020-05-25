package io.project.app.patientcare.services;

import io.project.app.models.FileModel;
import io.project.app.api.requests.FileRequest;
import io.project.app.patientcare.repositories.FileModelRepository;
import java.io.IOException;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lilith
 */
@Service
@Component
@Slf4j
public class FileService {

   @Autowired
   private FileModelRepository fileModelRepository;
   
   @Autowired
   private FileStorageService fileStorageService;
   
   public FileRequest findUserFileId(String userId){
       FileRequest fileDTO = new FileRequest();
       
       Optional<FileModel> userFile = fileModelRepository.findByUserId(userId);
       
       if(userFile.isPresent()){
           log.info("findUSerFile file name is "+userFile.get().getFileName());
           fileDTO.setFileName(userFile.get().getFileName());
           fileDTO.setId(userFile.get().getId());
           
       }
       return fileDTO;
       
   }
   
   public FileRequest findFile(String id) throws IOException{
       log.info("Start find file");
       FileRequest fileDTO = new FileRequest();
       Optional<FileModel> userFile = fileModelRepository.findById(id);
       if(userFile.isPresent()){
           byte [] savedFile = fileStorageService.readFile(userFile.get().getFilePath());
           String base64String = Base64.encodeBase64String(savedFile);
           fileDTO.setFileContent(base64String);
           
           log.info("file name is "+userFile.get().getFileName());
           fileDTO.setFileName(userFile.get().getFileName());
       }
       
       return fileDTO;
   }
   
   public void deleteById(String id) {
        log.info("find patient with id and delete");
        fileModelRepository.deleteById(id);
    }
   
   public Optional<FileModel> findByUserId(String id){
        return fileModelRepository.findByUserId(id);
   }
   
  
   
    @Transactional(transactionManager = "transactionManager", readOnly = false)
    public Optional<FileModel> saveFileMetadata(
            FileModel fileModel
    ) {
        log.info("FileModel save");

        FileModel savedFileModel = fileModelRepository.save(fileModel);
        if (Optional.ofNullable(savedFileModel.getId()).isPresent()) {
            log.info("Saved FileModel!");
            return Optional.ofNullable(savedFileModel);
        }
        log.info("Could not save FileModel");
        return Optional.empty();
    }
}
