//package org.pallas.alapozo.model;
//
//import com.fasterxml.jackson.annotation.JsonIdentityReference;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "TIPUSOK")
//public class Tipus {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    public int tipusokId;
//
//    @Column(length = 6, nullable = false)
//    public String  tipusNev ;
//
//    @Column(length = 6, nullable = false)
//    public String  leiras ;
//    public int SzervizKm;
//    
//    @OneToOne
//    @JoinColumn(name = "AUTO_CSOP_id")
//    public AutoCsop autoCsop;
//
//	@JsonIdentityReference(alwaysAsId = true)
//	@ManyToOne(fetch=FetchType.EAGER)	
//	@JoinColumn(name="AUTOK_ID",referencedColumnName="AKID")
//	private Autok autok;
//	
//	@JsonIdentityReference(alwaysAsId = true)
//	@ManyToOne(fetch=FetchType.EAGER)	
//	@JoinColumn(name="RENDELES_ID",referencedColumnName="RSID")
//	private Rendeles rendeles;
// 
//
//}