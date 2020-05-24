package io.project.app.models;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Document(collection = "filemetadata")

/**
 *
 * @author lilith
 */
public class FileModel implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Indexed
    private String userId;
    
    private String fileName;
    
    private String contentType;
    
    private Long fileSize;
    
    private String filePath;
    
    private Date uploadDate;
    

    

}
