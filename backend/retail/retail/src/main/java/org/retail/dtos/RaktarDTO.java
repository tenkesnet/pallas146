package org.retail.dtos;

import jakarta.persistence.Column;
import lombok.Data;
import org.retail.models.Bolt;

import java.util.List;

@Data
public class RaktarDTO {
    public int raktarId;
    public String raktarNev;
    public int dolgozokSzama;
    public String cim;
    public int kozpontId;
    public List<Bolt> boltok;
    /* A "raktar" table kilistázásakor a "bolt" table-ből még kinyeri a "bolt_nev" kategóriát.*/

}
