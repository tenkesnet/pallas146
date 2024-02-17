package org.pallas.alaprest.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AutoCsopDTO {
    public Integer id;
    public String csoportNev;
    public int kmDij;
    public int napiDij;
}
