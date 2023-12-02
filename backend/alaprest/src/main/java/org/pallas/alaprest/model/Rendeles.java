//package org.pallas.alapozo.model;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "RENDELES")
//public class Rendeles {
//	
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//    public int rendelesId;
//	
//	@Column(length = 5, nullable = false)
//	public int rendelesSzam;
//
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "rendeles")
//	@JoinColumn(name = "UGYFELEK_id")
//	private List<Ugyfelek> ugyfelek = new ArrayList<>();
////	@OneToMany
////    @JoinColumn(name = "UGYFELEK_id")
////    public Ugyfelek ugyfelek;
//	
//
//	public Date rendelesDatum;
//	
//	@Column(length = 12, nullable = false)
//	public String rendeloSzemely;
//
//	public Date kolcsonKezdete;
//	
//	public int napok;
//
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "rendeles")
//	@JoinColumn(name = "AUTOK_id")
//	private List<Autok> autok = new ArrayList<>();
////	@OneToMany
////    @JoinColumn(name = "AUTOK_id")
////    public Autok autok;
//	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "rendeles")
//	@JoinColumn(name = "TIPUS_id")
//	private List<Tipus> tipus = new ArrayList<>();
////	@OneToMany
////    @JoinColumn(name = "TIPUS_id")
////    public Tipus tipus;
//
//	public int kmKezdet;
//
//	public int kmVeg;
//
//	public int kolcsonDij;
//
//	@Column(length = 12, nullable = false)
//	public int fizetes;
//
//}
