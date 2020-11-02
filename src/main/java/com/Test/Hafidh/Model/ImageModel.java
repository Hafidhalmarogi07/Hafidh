package com.Test.Hafidh.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="images_hafidh")
public class ImageModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idrequestbooking;
	
	@Column(name = "description")
	private String description;

	public long getIdrequestbooking() {
		return idrequestbooking;
	}

	public void setIdrequestbooking(long idrequestbooking) {
		this.idrequestbooking = idrequestbooking;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ImageModel(String description) {
		super();
		this.description = description;
	}

	public ImageModel() {
		super();
	}
	
	

}
