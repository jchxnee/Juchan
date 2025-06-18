package k.exception.oop.practice1;

public class CharacterController {

	   public CharacterController() {
	      super();
	   }
	   
	   public int countAlpha(String s) throws CharCheckException{
	      int count = 0;
	      
	       if (s.contains(" ")) {
	          throw new CharCheckException("체크할 문자열 안에 공백이 포함되어 있습니다.");
	          }
	       
	      for(int i=0;i<s.length();i++) {
	         char ch = s.charAt(i);
	               
	         if(ch >= 'A' && ch <= 'Z' || ch>= 'a' && ch <= 'z' ) {
	            count++;
	         }
	      }
	      return count;
	      
	   }
	   

	}
