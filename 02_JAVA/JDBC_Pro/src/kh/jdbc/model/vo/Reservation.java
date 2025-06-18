package kh.jdbc.model.vo;

import java.sql.Date;

public class Reservation {

    private String reservationId;      // 예약 ID
    private String customerName;    // 고객 이름
    private Date reservationDate;   // 예약 날짜
    private String reservationTime; // 예약 시간
    private int numOfPeople;        // 예약 인원 수
    private String contact;         // 고객 연락처
    private String specialRequests; // 특별 요청 사항

    // 기본 생성자
    public Reservation() {
    }

    // 전체 필드를 받는 생성자
    public Reservation(String reservationId, String customerName, Date reservationDate, String reservationTime,
                       int numOfPeople, String contact, String specialRequests) {
        this.reservationId = reservationId;
        this.customerName = customerName;
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
        this.numOfPeople = numOfPeople;
        this.contact = contact;
        this.specialRequests = specialRequests;
    }


    // Getter와 Setter 메서드들
    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(String reservationTime) {
        this.reservationTime = reservationTime;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public void setNumOfPeople(int numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSpecialRequests() {
        return specialRequests;
    }

    public void setSpecialRequests(String specialRequests) {
        this.specialRequests = specialRequests;
    }

    @Override
    public String toString() {
    	return String.format(
    	        "==============================\n" +
    	        "    예약 정보\n" +
    	        "==============================\n" +
    	        "예약 ID      : %s\n" +
    	        "고객 이름    : %s\n" +
    	        "예약 날짜    : %s\n" +
    	        "예약 시간    : %s\n" +
    	        "인원 수      : %d\n" +
    	        "연락처       : %s\n" +
    	        "추가 요청사항 : %s\n" +
    	        "==============================",
    	        reservationId, customerName, reservationDate, reservationTime, numOfPeople, contact, specialRequests
    	    );
}
}