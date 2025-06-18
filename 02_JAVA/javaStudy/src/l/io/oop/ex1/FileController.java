package l.io.oop.ex1;

public class FileController {
	FileDAO fd = new FileDAO();
	
	public boolean checkName(String file) {
		boolean b = fd.checkName(file);
		return b;
	}
	
	public void fileSave(String file, StringBuilder sb) {
		String s = sb.toString();
		fd.fileSave(file, s);
	}
	
	public StringBuilder fileOpen(String file) {
		StringBuilder sb = fd.fileOpen(file);
		return sb;
	}
	
	public void fileEdit(String file, StringBuilder sb) {
		String s = sb.toString();
		fd.fileEdit(file, s);
	}
}
