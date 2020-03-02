/*
 * 
 * BODY FORMAT FOR RESPONSE FOR TOKEN
 * 
 * 
 * */
package com.temporary.configurationWithH2;

import java.io.Serializable;

public class JwtTokenResponse implements Serializable {

  private static final long serialVersionUID = 8317676219297719109L;

  private final String token;

    public JwtTokenResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}