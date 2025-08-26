package model;

public class RodVO {

	private int rodid;
	private String name;
	private int price;

	public RodVO(int rodId, String name, int price) {
		super();
		this.rodid = rodId;
		this.name = name;
		this.price = price;
	}

	public RodVO() {

	}

	public int getRodid() {
		return rodid;
	}

	public void setRodid(int rodId) {
		this.rodid = rodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
