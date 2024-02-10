package org.retail.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "beszallitoId")
@Table(name = "beszallito")
public class Beszallito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer beszallitoId;

    @Column(nullable = false)
    public String beszallitoNev;

    @Column(nullable = false)
    public String termek;

    @Column(nullable = false)
    public Integer koltseg;

    @Column(nullable = false)
    public String cim;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "kozpont_id")
    @JsonBackReference
    public Kozpont kozpont;


}
