package j.interface1.oop.ex1;

public abstract class SmartPhone implements CellPhone , TouchDisplay{
	private String maker;
	private String maker() {
		return null;
	}
	
	public void SmartPhone() {
		
	}
	
	public abstract String printInformation();
	
	
	public void setMaker(String maker) {
	   this.maker = maker;
	}
	
	public String getMaker() {
		return maker;
	}
}
