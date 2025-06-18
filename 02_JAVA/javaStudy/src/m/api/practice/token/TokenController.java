package m.api.practice.token;

import java.util.StringTokenizer;

public class TokenController {

	public TokenController() {
		super();
	}
	
	public String afterToken(String str) {
		StringTokenizer st = new StringTokenizer(str," ");
		String s = "";
		while(st.hasMoreElements()) {
			s += st.nextToken();
		}
		
		return s;
	}
	
	public String firstCap(String input) {
		char c  = input.charAt(0);
		String s = String.valueOf(c).toUpperCase();
		String a = s + input.substring(1,input.length());
		return a;
				
	}
	
	public int findChar(String input, char one) {
		int count = 0;
		char [] arr = input.toCharArray();
		for(int i =0; i<input.length(); i++) {
			if(arr[i] == one) {
				count ++;
			}
		}
		return count;
	}
}
