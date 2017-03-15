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
public class Authentication {
    public static boolean authenticate(String username, String password) {

        User user = new User();
        if (user.getUsername().equals(username) && user.getPassword().equals(password) ){
            return true;
        } else {
            return false;
        }
    }
}
