package h.inherit2;

public class Product {
	private String brand;
	private String pCode;
	private String pName;
	private int price;
	
	public Product() {
		System.out.println("Product()");
	}
	
	
	
	public Product(String brand, String pCode, String pName, int price) {
		super();
		this.brand = brand;
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
	}



	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getpCode() {
		return pCode;
	}


	public void setpCode(String pCode) {
		this.pCode = pCode;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String information() {
		return "브랜드 : " + brand + " 제품번호 : " + pCode + "제품명 : " + pName +
				"가격 : " + price + "원";
	}
}
