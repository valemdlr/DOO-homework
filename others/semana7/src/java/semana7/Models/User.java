/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semana7.Models;

/**
 *
 * @author Valeria
 */
public class User {
    private String name;
    private String lastname;
    private String username;
    private String password;
    
    public User(String name, String lastname, String username, String password){
       this.name = name;
       this.lastname = lastname;
       this.username = username;
       this.password = password;
    }
    public User(){
       this.username = username;
       this.password = password; 
    }

    
    public String getName(){
        return name;
    }
    public String getLastname(){
        return lastname;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
