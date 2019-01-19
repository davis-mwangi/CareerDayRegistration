/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.career.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 * @param <T>
 */
@JsonIgnoreProperties(ignoreUnknown  = true)
@JsonInclude(Include.NON_NULL)
public class ErrorResponse <T>{
    private List<T> errors =  new ArrayList<>(1);
    
    public ErrorResponse(List<T> errors) {
        this.errors = errors;
    }
    
    public List<T> getErrors(){
        return errors;
    }
    
}
