package com.api.demo.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class CustomErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;
    private int status;
    private String error;

    public void setTimestamp(LocalDateTime timestamp){
    	this.timestamp = timestamp;
    }
    public void setStatus(int status){
    	this.status = status;
    }
    public void setError(String error){
    	this.error = error;
    }

    public String getError(){
        return this.error;
    }
    public int getStatus(){
        return this.status;
    }
    public LocalDateTime getTimeStammp(){
        return this.timestamp;
    }
}