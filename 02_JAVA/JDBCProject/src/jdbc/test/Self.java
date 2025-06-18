package jdbc.test;

import java.sql.Date;
import java.util.Objects;

public class Self {
	private int tno;
	private String tname;
	private Date tDate;
	
	public Self() {
		super();
	}

	public Self(int tno, String tname, Date tDate) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.tDate = tDate;
	}

	public int getTno() {
		return tno;
	}

	public void setTno(int tno) {
		this.tno = tno;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Date gettDate() {
		return tDate;
	}

	public void settDate(Date tDate) {
		this.tDate = tDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tno);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Self) {
			Self s = (Self)obj;
			return s.getTno() == this.tno;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Self [tno=" + tno + ", tname=" + tname + ", tDate=" + tDate + "]";
	}
	
	
}
