package o.collection.generics.practice;

import java.util.ArrayList;
import java.util.HashMap;

public class FarmController {
	private HashMap<Farm,Integer> hMap = new HashMap<>();
	private ArrayList<Farm> list = new ArrayList<>();
	
	public boolean addNewKind(Farm f, int amount) {
		if(hMap.containsKey(f)) {
			return false;
		} else {
			hMap.put(f, amount);
			return true;
		}	
	}
	
	public boolean removeKind(Farm f) {	
		if(hMap.containsKey(f)) {
			hMap.remove(f);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean changeAmount(Farm f, int amount) {
		if(hMap.containsKey(f)) {
			hMap.put(f, amount);
			return true;
		} else {
			return false;
		}
	}
	
	public HashMap<Farm , Integer> printFarm() {
		return hMap;
	}
	
	public boolean buyFarm(Farm f) {
		if(hMap.containsKey(f) && hMap.get(f) >= 0 && hMap.get(f) != null) {
			list.add(f);
			int count = hMap.get(f);
			hMap.put(f, count-1);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean removeFarm(Farm f) {
		return true;
	}
	
	public ArrayList<Farm> printBuyFarm() {
		return list;
	}
	


}
