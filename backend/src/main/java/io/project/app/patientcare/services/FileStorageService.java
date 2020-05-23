package io.project.app.patientcare.services;

import java.io.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author lilith
 */
@Service
@Component
@Slf4j

public class FileStorageService {

    @Value("${fileStoragePath}")
    private String basepath;

    public String storeFile(String title, byte[] content, String userId) throws IOException  {

        log.info("storing file");

        String folder = title.substring(0, 2);
        String absPath = basepath + folder;

        String filePath = absPath + "/" + title;

        File file = new File(absPath);
        if (!file.exists()) {
            file.mkdirs();
        }

        file.createNewFile();

        try (FileOutputStream out = new FileOutputStream(file)) {
            out.write(content);
        } 
        
        return filePath ;
    }


    public boolean removeFile(String filepath) {
        log.info("removing file");

        File file = new File(filepath);
        if (file.exists()) {
            boolean delete = file.delete();
            if (delete) {
                log.info("document deleted");
                return true;
            }
        }
        return false;

    }
    
    public byte[] readFile(String filepath) throws IOException{

        byte [] content = null;
        String abspath = basepath + filepath;
        File file = new File(abspath);
        

                FileInputStream in = new FileInputStream(file);
                int bytesize = in.available(); ///method returns number of remaining bytes 
//              that can be read from this input stream without blocking by the 
//              next method call for this input stream. The next method call can also be the another thread.
                content = new byte[bytesize];
                in.read(content);
           
         
        return content;
    }
}





