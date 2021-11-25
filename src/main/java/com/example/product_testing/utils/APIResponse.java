package com.example.product_testing.utils;

public class APIResponse {

    private boolean status;
    private String message;




//constructor

    public APIResponse(boolean status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    public  APIResponse() {
        super();
    }

//    getters and setters

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
