/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.career.models;

import java.util.Date;

/**
 *
 * @author david
 */
public interface ModifiableEntity {
    public Date getModified();
    public void setModified(Date modified);
    
}
