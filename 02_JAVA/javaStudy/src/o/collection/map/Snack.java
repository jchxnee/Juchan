package o.collection.map;

import java.util.Objects;

public class Snack {
	private String flavor;
	private int calory;
	

	public Snack(String flavor, int calory) {
		super();
		this.flavor = flavor;
		this.calory = calory;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public int getCalory() {
		return calory;
	}

	public void setCalory(int calory) {
		this.calory = calory;
	}

	@Override
	public String toString() {
		return "Snack [flavor=" + flavor + ", calory=" + calory + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(flavor,calory);
		//return ("" + flavor , calory).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Snack) {
			Snack s = (Snack)obj;
			if(this.flavor.equals(s.getFlavor()) && this.calory==s.getCalory()) {
				return true;
			}
		}
		return false;
	}
	
	
}
