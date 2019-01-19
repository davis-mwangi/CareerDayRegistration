/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.career.models;

import java.util.UUID;

/**
 *
 * @author david
 */
public interface DatabaseEntity {
    public UUID getId();
    public void setId(UUID id);
    
}
