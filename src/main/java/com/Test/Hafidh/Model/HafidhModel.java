package com.Test.Hafidh.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="log_hafidh")
public class HafidhModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRequestBooking;
	
	@Column(name = "id_platform")
	private long id_platform;
	
	@Column(name = "nama_platform")
	private String nama_platform;
	
	@Column(name = "doc_type")
	private String doc_type;
	
	@Column(name = "term_of_payment")
	private String term_of_payment;
	
	
	
	
	public HafidhModel() {
		super();
	}
	public HafidhModel(long id_platform, String nama_platform, String doc_type, String term_of_payment) {
		super();
		this.id_platform = id_platform;
		this.nama_platform = nama_platform;
		this.doc_type = doc_type;
		this.term_of_payment = term_of_payment;
	}
	public long getIdRequestBooking() {
		return idRequestBooking;
	}
	public void setIdRequestBooking(long idRequestBooking) {
		this.idRequestBooking = idRequestBooking;
	}
	public long getId_platform() {
		return id_platform;
	}
	public void setId_platform(long id_platform) {
		this.id_platform = id_platform;
	}
	public String getNama_platform() {
		return nama_platform;
	}
	public void setNama_platform(String nama_platform) {
		this.nama_platform = nama_platform;
	}
	public String getDoc_type() {
		return doc_type;
	}
	public void setDoc_type(String doc_type) {
		this.doc_type = doc_type;
	}
	public String getTerm_of_payment() {
		return term_of_payment;
	}
	public void setTerm_of_payment(String term_of_payment) {
		this.term_of_payment = term_of_payment;
	}
	
	
	

}
