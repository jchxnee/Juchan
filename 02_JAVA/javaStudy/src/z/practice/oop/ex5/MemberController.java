package z.practice.oop.ex5;

public class MemberController {
    private Member[] m =new Member[SIZE];
    public static final int SIZE = 10;

    public int existMemberNum() {
        return 0;
        
    }

    public Boolean checkId(String inputId) {
        for(Member mem : m) {
        	if(mem.getId().equals(inputId)) {      		
        		return true;
        	}
        	
        }
        return false;
    }

    public void insertMember(String id, String name, String password, String email, String gender, int age) {
    
    }

    public String searchId(String id) {
        for (Member mem : m) {
            if (mem.getId().equals(id)) {  
            	System.out.println("찾으신 회원 검색 결과입니다.");
                return mem.inform(); 
            }
        }
        
        System.out.println("검색결과가 없습니다.");
        return "검색결과가 없습니다."; 
    }

    public Member[] searchName(String name) {
    	 for (Member mem : m) {
             if (mem.getName().equals(name)) {  
             	System.out.println("찾으신 회원 검색 결과입니다.");
                 return m;
             }
         }
         
         return null;
              
    }

    public Member[] searchEmaiil(String email) {
    	for (Member mem : m) {
            if (mem.getEmail().equals(email)) {  
            	System.out.println("찾으신 회원 검색 결과입니다.");
                return m;
            }
    	}
       return null;
    }

    public Boolean updatePassword(String id, String password) {
        return true;
    }

    public Boolean updateName(String id, String name) {
        return true;
    }

    public Boolean updateEmail(String id, String email) {
        return true;
    }

    public Boolean delete(String id) {
        return true;
    }

    public void delete() {

    }

    public Member[] printAll(){
        return new Member[]{};
    }
}
