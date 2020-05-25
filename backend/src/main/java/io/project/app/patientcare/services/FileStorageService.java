package io.project.app.patientcare.services;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

    public String storeFile(
            String title,
            byte[] content,
            String userId
    ) {
        log.info("1. user id " + userId);
        String orgDir = userId.substring(0, 2) + "/" + userId.substring(3, 5);
        log.info("2. orgDir " + orgDir);
        String filePath = "";
        String absPath = basepath + orgDir;
        log.info("3. absPath " + absPath);
        String hashString = title + String.valueOf(System.currentTimeMillis());

        File file = null;

        do {
            StringBuilder sb = new StringBuilder();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                byte[] bs;
                bs = messageDigest.digest(hashString.getBytes());
                for (int i = 0; i < bs.length; i++) {
                    String hexVal = Integer.toHexString(0xFF & bs[i]);
                    if (hexVal.length() == 1) {
                        sb.append("0");
                    }
                    sb.append(hexVal);
                }
                hashString = sb.toString();
            } catch (NoSuchAlgorithmException ex) {
                log.error("Cannot fined implementation of SHA algorigm: " + ex);
                return filePath;
            }
            filePath = orgDir + "/" + hashString; //for return
            
            log.info("4.0. orgDir " + orgDir);
            log.info("4. filePath " + filePath);
          
            
            file = new File(absPath + "/" + hashString); //for save
            log.info("5. file  " + file);
            
        } while (file.exists());

        try {
            File dirs = new File(absPath);
            if (!dirs.exists()) {
                dirs.mkdirs();
            }

            file.createNewFile();

            try (FileOutputStream out = new FileOutputStream(file)) {
                out.write(content);
            }
        } catch (IOException e) {
            log.error("Cannot create file: " + absPath + ", exception: " + e);
        }
        log.info("6. return file path " + filePath);
        return filePath;
    }

    public boolean removeFile(String filepath) {
        log.info("filepath is " + filepath);
        File file = new File(basepath + filepath);
        if (file.exists()) {
            boolean delete = file.delete();
            if (delete) {
                log.info("Document deleted");
                return true;
            }
        }
        log.info("Document is not present");
        return false;
    }

    public byte[] readFile(String filepath) {
        byte[] content = null;
        if (basepath != null && filepath != null) {
            String abspath = basepath + filepath;
            log.info("File abspath is " + abspath);
            File file = new File(abspath);
            log.info("******* File: *******" + file);
            if (!file.exists()) {
                log.info("File did not exist");
                return content;
            }
            try {
                FileInputStream io = new FileInputStream(file);
                log.info("IO is " + io);
                int bytesize = io.available();//method returns number of remaining bytes 
//                that can be read from this input stream without blocking by the 
//                        next method call for this input stream. 
//                                The next method call can also be the another thread.
                
                log.info("bytesize" + bytesize);
                content = new byte[bytesize];
                //  log.info("content " + Arrays.toString(content));
                io.read(content);
            } catch (IOException e) {
                log.error("cannot read file: " + abspath + ", exception: " + e);
            }
        }
        return content;
    }
}





