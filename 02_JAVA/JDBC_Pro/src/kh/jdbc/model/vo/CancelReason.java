package kh.jdbc.model.vo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class CancelReason {
    private String reservationId;
    private Timestamp cancelDate;
    private String cancelReason;
    
    
    public CancelReason() {
		super();
	}

	public CancelReason(String reservationId, Timestamp cancelDate, String cancelReason) {
        this.reservationId = reservationId;
        this.cancelDate = cancelDate;
        this.cancelReason = cancelReason;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public Timestamp getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Timestamp cancelDate) {
        this.cancelDate = cancelDate;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(this.cancelDate);
        
        return "예약 ID: " + reservationId +
               ", 취소 날짜: " + formattedDate +
               ", 취소 사유: " + cancelReason;
    }
}