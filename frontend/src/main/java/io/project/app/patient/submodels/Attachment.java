package io.project.app.patient.submodels;

import java.io.Serializable;

/**
 *
 * @author lilith
 */
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
    
    
    private String url;
    
    private String size;
    
    private String title;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
    
}
