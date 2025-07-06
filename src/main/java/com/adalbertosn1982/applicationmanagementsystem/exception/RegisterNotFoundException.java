package com.adalbertosn1982.applicationmanagementsystem.exception;

public class RegisterNotFoundException extends RuntimeException{
    public RegisterNotFoundException(String message) {
        super(message);
    }
}