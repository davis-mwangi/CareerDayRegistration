/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.career.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author david
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AppException  extends RuntimeException{

    public AppException(String message) {
        super(message);
    }

    public AppException(String string, Throwable cause) {
        super(string, cause);
    }
    
    
    
}
