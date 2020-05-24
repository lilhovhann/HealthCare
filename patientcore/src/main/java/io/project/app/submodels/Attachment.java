/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.submodels;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.primefaces.model.file.UploadedFile;


/**
 *
 * @author lilith
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Attachment implements Serializable{
//    // from Element: extension
//  "contentType" : "<code>", // Mime type of the content, with charset etc.
//  "language" : "<code>", // Human language of the content (BCP-47)
//  "data" : "<base64Binary>", // Data inline, base64ed
//  "url" : "<url>", // Uri where the data can be found
//  "size" : "<unsignedInt>", // Number of bytes of content (if url provided)
//  "hash" : "<base64Binary>", // Hash of the data (sha-1, base64ed)
//  "title" : "<string>", // Label to display in place of the data
//  "creation" : "<dateTime>" // Date attachment was first created
    
    private UploadedFile file;
    
//        private String url;
//        
//        private String size;
//        
//        private String title;

   
    
    
    
}
