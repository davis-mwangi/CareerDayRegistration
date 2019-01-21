/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.career.payload;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author david
 */
public class LoginRequest {
    
    @NotBlank
    private String password;
    
    @NotBlank
    private String usernameOrEmail;

    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }
     
    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

        
    
}
