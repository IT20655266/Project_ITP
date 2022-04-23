package model;

public class Stock {

	int id,inQty,outQty,available_stock;
	String item_name,generic_name,category,strength,manuf_name,exp_date;
	double sale_price,purch_price;
	
	public int getId() {
		return id;
	}
	public int getInQty() {
		return inQty;
	}
	public int getOutQty() {
		return outQty;
	}
	public int getAvailable_stock() {
		return available_stock;
	}
	public String getItem_name() {
		return item_name;
	}
	public String getGeneric_name() {
		return generic_name;
	}
	public String getCategory() {
		return category;
	}
	public String getStrength() {
		return strength;
	}
	public String getManuf_name() {
		return manuf_name;
	}
	public String getExp_date() {
		return exp_date;
	}
	public double getSale_price() {
		return sale_price;
	}
	public double getPurch_price() {
		return purch_price;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setInQty(int inQty) {
		this.inQty = inQty;
	}
	public void setOutQty(int outQty) {
		this.outQty = outQty;
	}
	public void setAvailable_stock(int available_stock) {
		this.available_stock = available_stock;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public void setGeneric_name(String generic_name) {
		this.generic_name = generic_name;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setStrength(String strength) {
		this.strength = strength;
	}
	public void setManuf_name(String manuf_name) {
		this.manuf_name = manuf_name;
	}
	public void setExp_date(String exp_date) {
		this.exp_date = exp_date;
	}
	public void setSale_price(double sale_price) {
		this.sale_price = sale_price;
	}
	public void setPurch_price(double purch_price) {
		this.purch_price = purch_price;
	}
	
}
