/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboratorio6.Models;

/**
 *
 * @author SEG11
 */
public class User {
    private String username ;
    private String password ;
    private String nombre;

    public User() {
        this.username = "vale.mdlr";
        this.password = "pass123";       
    }
 
    public String getUsername() {
        return this.username;
    }
    public String getPassword(){
        return password;
    }
    public String getNombre(){
        return nombre = "Valeria";
    }
    
}
