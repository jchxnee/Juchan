package o.collection.list.practice;

public class Music {
	private String title;
	private String singer;
	
	public Music() {
		super();
	}

	public Music(String title, String singer) {
		super();
		this.title = title;
		this.singer = singer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	@Override
	public String toString() {
		return singer + " - " + title;
	}
	
	public int hashCode() {
		return 0;
	}
	
	//클래스에서 equals를 오버라이딩하지 않으면 기본Object의 equals를 따른다(참조비교)
	//실제 해당클래스의 객체비교시 기준을 가지고 오버라이딩해줘야 컬렉션과 같은 곳에서 
	//적절하게 사용된다. Object에서는 주소값 비교, 여기서는 가수명과 곡명을 같이 비교하여 값 반환
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Music) {
			Music m = (Music)obj;
			if(m.getTitle().equals(this.title) && m.getSinger().equals(this.singer)) {
				return true;
			}
		}
		return false;
	}
	
	public int compareTo(Object o) {
		return 0;
	}
}
