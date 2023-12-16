package com.pvxdv.taskmanagementsystem.exception;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AccessErrorException extends  Exception{
    public AccessErrorException(String message) {
        super(message);
    }
}
