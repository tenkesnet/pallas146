package org.pallas.alaprest.dtos;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AutoCsopRequestDTO {
    public String csoportNev;
    public int kmDij;
    public int napiDij;
}
