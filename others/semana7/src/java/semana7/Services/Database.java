/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semana7.Services;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import semana7.Models.User;
import java.io.*;
import java.util.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Valeria
 */
public class Database {
    
    
    private static String getPathDatabase() {
    return "C:\\DOO\\json-simple-1.1.1.jar";
    }
    
    private static boolean setJsonObject(String namedb, String lastnamedb, String usernamedb, String passworddb) {
     JSONObject obj = new JSONObject();

    //Solo guarda un valor
    obj.put("name", namedb);
    obj.put("lastname", lastnamedb);
    obj.put("username", usernamedb);
    obj.put("password", passworddb);

    String rutaJson = getPathDatabase(); //llamada a método anterior

    try (FileWriter file = new FileWriter(rutaJson)) {
            file.write(obj.toJSONString());

            return true;
    }
    catch(IOException ioext) {
        return false;
    }
    }
    private static JSONObject getJsonObject(){
       try {
            String rutaJson = getPathDatabase();
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(rutaJson));

            JSONObject jsonObject =  (JSONObject) obj;

            return jsonObject;
        }
        catch(IOException ioext) {
            return null;
        }
       catch (ParseException pex){
          return null; 
       }
    }
    
    public static User getUserByUsername(String username) {
    User user;

    JSONObject jsonObject = getJsonObject(); //llama a método anterior

    if(jsonObject != null) {
        String namedb = (String) jsonObject.get("name");
        String lastnamedb = (String) jsonObject.get("lastname");
        String usernamedb = (String) jsonObject.get("username");
        String passworddb = (String) jsonObject.get("password");

        //Valida si el usuario que se pide es igual al que se encuentra
        //en el archivo JSON
        if(username.equals(usernamedb)) {
            user = new User(namedb, lastnamedb, usernamedb, passworddb); //Completar con todas las propiedades del usuario
        }
        else {
            user = null;
        }

        return user;
    }
    else{
        return null;
    }
}
    public static User getUserByUsernamePassword(String username, String password){
    User user;

    JSONObject jsonObject = getJsonObject(); //Llamáda a método

    if(jsonObject != null) {
        String usernamedb = (String) jsonObject.get("username");
        String passworddb = (String) jsonObject.get("password");
        String namedb = (String) jsonObject.get("name");
        String lastnamedb = (String) jsonObject.get("lastname");  
        //Validar password y usuario
        if(username.equals(usernamedb) && password.equals(passworddb)) {
            user = new User(namedb, lastnamedb, usernamedb, passworddb); //Completar con propiedades para construir objeto
        }
        else {
            user = null;
        }

        return user;
    }
    else{
        return null;
    }
    }
    public static boolean setUser(String name, String lastname, String username, String password) {

    boolean isSetup = setJsonObject(name, lastname, username, password);

    return isSetup;
}

}
