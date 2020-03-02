package com.mitrais.todo.configuration;
import java.util.Collection;
 
import org.springframework.security.core.GrantedAuthority;
 
public class JwtResponse {
  private String token;
  private String username;
  private Collection<? extends GrantedAuthority> authorities;
 
  public JwtResponse(String token, String username, Collection<? extends GrantedAuthority> authorities) {
    this.token = token;
    this.username = username;
    this.authorities = authorities;
  }
 
  public String getToken() {
    return token;
  }
 
  public void setToken(String token) {
    this.token =  token;
  }
 
  public String getUsername() {
    return username;
  }
 
  public void setUsername(String username) {
    this.username = username;
  }
  
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }
}