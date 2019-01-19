/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.career.exceptions;

/**
 *
 * @author david
 */
public class EntityNotFoundException  extends RuntimeException {
    private static final long serialVersionUID = 1L;
    
    public EntityNotFoundException(Class<?>entityClass, Object id) {
        super(String.format("%s was not found for parameter %s", entityClass.getSimpleName(), id));
    }
    
}
