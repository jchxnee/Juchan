package n.genetic;

import java.util.Arrays;

public class Box<T> {
	private T[] obArr;
	private int size;
	
	public Box() {
		super();
	}

	public Box(T[] obArr, int size) {
		super();
		this.obArr = obArr;
		this.size = size;
	}

	public T[] getObArr() {
		return obArr;
	}

	public void setObArr(T[] obArr) {
		this.obArr = obArr;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Box [obArr=" + Arrays.toString(obArr) + ", size=" + size + "]";
	}
	
	
	
}
