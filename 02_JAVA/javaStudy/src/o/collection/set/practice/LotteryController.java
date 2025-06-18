package o.collection.set.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class LotteryController {
	private HashSet <Lottery> lottery = new HashSet<>();
	private HashSet <Lottery> win = new HashSet();
	
	public boolean insertObject(Lottery I) {
		return lottery.add(I);
	}
	
	public boolean deleteObject(Lottery I) {
		if(lottery.remove(I) && win!= null) {
			win.remove(I);
			return true;
		} else {
		return false;
		}
	}
	
	public HashSet  winObject() {
		if(lottery.size() < 4) {
			return null;
		}
		
		List<Lottery> list = new ArrayList<>();
		list.addAll(lottery);
		
		while(win.size() < 4) {
			int rand = (int)(Math.random() * list.size());
			win.add(list.get(rand));
		}
		return win;
	}
	
	public TreeSet sortedWinObject() {
		TreeSet sortedWinSet = new TreeSet(new SortedLottery());
		sortedWinSet.addAll(win);
		return sortedWinSet;
	}
	
	public boolean searchWinner(Lottery I) {
		return win.contains(I);
	}

}
