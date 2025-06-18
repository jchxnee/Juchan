package z.practice.object;

public class Movie_Run {

	public static void main(String[] args) {
		Movie m1 = new Movie("기생충","25/01/06","23:15","3관",47,18000);
		Movie m2 = new Movie("트와일라잇","25/01/01","17:50","1관",31,18000);
		Movie m3 = new Movie("어벤져스","25/01/05","15:10","Dorby Atmos관",73,28000);
		Movie m4 = new Movie("청설","25/01/03","11:40","7관",15,18000);
		
		
		m1.Minfo();
		m2.Minfo();
		m3.Minfo();
		m4.Minfo();
		
	}

}
