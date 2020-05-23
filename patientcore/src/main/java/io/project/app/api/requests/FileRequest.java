package io.project.app.api.requests;


import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

/**
 *
 * @author lilith
 */

public class FileRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String userId;
    
    private String fileName;
    
    private String contentType;
    
    private Long fileSize;
    
    private Date uploadDate;
    
    private String fileContent;
    

}
