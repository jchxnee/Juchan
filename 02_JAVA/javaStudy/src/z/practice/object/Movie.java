package z.practice.object;

public class Movie {
    String mname;
    String mdate;
    String mtime;
    String mspace;
    int mseat;
    int mprice;

    public Movie() {
    }

    public Movie(String mname, String mdate, String mtime, String mspace, int mseat, int mprice) {
        super();
        this.mname = mname;
        this.mdate = mdate;
        this.mtime = mtime;
        this.mspace = mspace;
        this.mseat = mseat;
        this.mprice = mprice;
    }

    public void Minfo() {
        System.out.println("=========== 영화 정보 ===========");
        System.out.printf("영화명      : %s%n", mname);
        System.out.printf("상영날짜    : %s%n", mdate);
        System.out.printf("상영시간    : %s%n", mtime);
        System.out.printf("상영관      : %s%n", mspace);
        System.out.printf("남은 좌석 수: %d%n", mseat);
        System.out.printf("관람가격    : %d원%n", mprice);
        System.out.println("=================================");
    }
}
