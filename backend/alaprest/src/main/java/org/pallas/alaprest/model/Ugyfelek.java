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
//import jakarta.persistence.Table;
//
//
//@Entity
//@Table(name = "UGYFELEK")
//public class Ugyfelek {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//    public int ugyfelekId;
//	
//	@Column(length = 3, nullable = false)
//	public int ugyfelSzam;
//
//	@Column(length = 20, nullable = false)
//	public String ugyfelNev;
//
//	@Column(length = 15, nullable = false)
//	public String cim;
//	
//	@Column(length = 10, nullable = false)
//	public String varos;
//
//	@Column(length = 10, nullable = false)
//	public String orszag;
//
//	@Column(length = 6, nullable = false)
//	public int iranyitoSzam;
//
//	@Column(length = 15, nullable = false)
//	public String megbizott;
//	
//	@Column(length = 1, nullable = false)
//	public int fizetesiMod;
//	
//	
//	@JsonIdentityReference(alwaysAsId = true)
//	@ManyToOne(fetch=FetchType.EAGER)	
//	@JoinColumn(name="RENDELES_ID",referencedColumnName="RSID")
//	private Rendeles rendeles;
//
//}
