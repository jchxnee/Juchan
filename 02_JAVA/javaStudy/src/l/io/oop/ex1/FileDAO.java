package l.io.oop.ex1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDAO {
	public boolean checkName(String file) {		
		File f1 = new File(file);
		return f1.exists();
	}
	
	public void fileSave(String file, String s) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(s);
			bw.flush();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	public StringBuilder fileOpen(String file) {
		StringBuilder res = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))){
		String str = null;
		while((str = br.readLine()) != null) {
			res.append(str);
		 }
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return res;
	}
	
	public void fileEdit(String file, String s) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
			bw.write(s);
			bw.flush();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
	}
}
