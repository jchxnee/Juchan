package o.collection.generics.practice;

public class Nut extends Farm{
	private String name;

	public Nut() {
		super();
	}
	
	
	public Nut(String kind, String name) {
		super(kind);
		this.name = name;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "견과 : " + name;
	}
	
	public int hashCode() {
		return 0;
	}
	
	public boolean equals() {
		return true;
	}
}
