package kh.jdbc.project.controller;

import kh.jdbc.project.model.dao.FoodDao;
import kh.jdbc.project.model.vo.Member;

public class FoodController {
	FoodDao fd = new FoodDao();
	
	public boolean checkLogin(String id) {
		int fact = fd.searchId(id);
		if(fact == 1) {
			return true;
		}
		return false;
	}
	
	public void insertMember(String id, String pwd, String name, int age, String email,
			String phone, String address) {
		Member m = new Member(id,pwd,name,age,email,phone,address);
		
		int result = fd.insertMember(m);
		
	}
}
