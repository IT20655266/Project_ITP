package model;

public class Supplier {

	String name,address,phone,create,update;
	int id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone() {
		return phone;
	}
	public String getCreate() {
		return create;
	}
	public String getUpdate() {
		return update;
	}
	public int getId() {
		return id;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setCreate(String create) {
		this.create = create;
	}
	public void setUpdate(String update) {
		this.update = update;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
