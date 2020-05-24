package io.project.app.submodels;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author lilith
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Period implements Serializable{
    
    private Date startDate;
    
    private Date endDate;
    
}
