package com.pojo;

public class Customer {
	private Integer id;
	private String gender;
	private String name;
	private String telephone;
	private String address;
	
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", gender=" + gender + ", name=" + name + ", telephone=" + telephone
				+ ", address=" + address + "]";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
