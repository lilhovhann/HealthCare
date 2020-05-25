package io.project.app.patientcare.controllers;

import io.micrometer.core.annotation.Timed;
import io.project.app.api.patientcare.responses.ApiResponseMessage;
import io.project.app.models.FileModel;
import io.project.app.api.requests.FileRequest;
import io.project.app.patientcare.services.FileService;
import io.project.app.patientcare.services.FileStorageService;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lilith
 */
@RestController
@RequestMapping("/api/v2/file")
@Slf4j
public class FileController {

    @Autowired
    private FileService fileService;

    @Autowired
    private FileStorageService fileStorageService;

    @PutMapping
    @ResponseBody
    @CrossOrigin
    @Transactional
    public ResponseEntity<?> put(@RequestBody(required = true) FileRequest fileDTO) throws IOException {
        //decode file byte array
        final byte[] backToBytes = Base64.decodeBase64(fileDTO.getFileContent());

        Optional<FileModel> userPrevFile = fileService.findByUserId(fileDTO.getUserId());

        if (userPrevFile.isPresent()) {
            log.info("Deleting old file");
            fileStorageService.removeFile(userPrevFile.get().getFilePath());
            fileService.deleteById(userPrevFile.get().getId());
        }

        String filepath = fileStorageService.storeFile(fileDTO.getFileName(), backToBytes, fileDTO.getUserId());

        if (filepath != null) {
            FileModel fileModel = new FileModel();
            fileModel.setFileName(fileDTO.getFileName());
            fileModel.setFilePath(filepath);
            fileModel.setContentType(fileDTO.getContentType());
            fileModel.setFileSize(fileDTO.getFileSize());
            fileModel.setUserId(fileDTO.getUserId());
            fileModel.setUploadDate(new Date(System.currentTimeMillis()));
            log.info("File size is " + fileModel.getFileSize());
            log.info("Content type is " + fileModel.getContentType());

            Optional<FileModel> savedFileMetadata = fileService.saveFileMetadata(fileModel);

            if (savedFileMetadata.isPresent()) {
                log.info("File saved");
                
                return ResponseEntity.status(HttpStatus.OK).body(savedFileMetadata.get().getId());
            }

        }
log.error("File error");
                
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ApiResponseMessage("Could not save file"));
    }

    @GetMapping
    @ResponseBody
    @CrossOrigin
    @Timed
    public ResponseEntity<?> fetch(
            @RequestParam(name = "id", required = true) String id
    ) {

        FileRequest userFile = new FileRequest(); // avoid null pointer if file service return null
        try {
            userFile = fileService.findFile(id);
            log.info("GET file " + userFile.getFileName());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.OK).body(userFile);
    }

}
