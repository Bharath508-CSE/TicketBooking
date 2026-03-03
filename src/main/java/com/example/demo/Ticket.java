package com.example.demo;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pnr;

    private String fromStation;
    private String toStation;
    private String date;
    private String cls;
    private String passengerName;
    private int age;
    private String gender;
    private String mobile;
    private String email;
	public Ticket(Long id, String pnr, String fromStation, String toStation, String date, String cls,
			String passengerName, int age, String gender, String mobile, String email) {
		super();
		this.id = id;
		this.pnr = pnr;
		this.fromStation = fromStation;
		this.toStation = toStation;
		this.date = date;
		this.cls = cls;
		this.passengerName = passengerName;
		this.age = age;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
	}
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@PrePersist
	public void generatePnr() {
	    this.pnr = UUID.randomUUID()
	            .toString()
	            .substring(0, 8)
	            .toUpperCase();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public String getFromStation() {
		return fromStation;
	}
	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}
	public String getToStation() {
		return toStation;
	}
	public void setToStation(String toStation) {
		this.toStation = toStation;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

    // getters + setters
	
    
}
