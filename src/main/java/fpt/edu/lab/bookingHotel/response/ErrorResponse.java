package fpt.edu.lab.bookingHotel.response;

import java.util.Date;

public class ErrorResponse {

    String code;
    String message;
    Date timeStamp;
    String details;


    public ErrorResponse(String code, String message, Date timeStamp, String details) {
        this.code = code;
        this.message = message;
        this.timeStamp = timeStamp;
        this.details = details;
    }

    public ErrorResponse(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public ErrorResponse(Date timeStamp, String message, String details) {
        this.message = message;
        this.timeStamp = timeStamp;
        this.details = details;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
