/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author SEG11
 */
public class ComentariosDAO {
    
    private Connection conexion;
    
    private void abrirConexion() throws SQLException{
        String dbURI = "jdbc:derby://localhost:1527/Comentarios";
        String username = "fcfm";
        String password = "lsti01";
        conexion = DriverManager.getConnection(dbURI, username, password);
    }
    
    private void cerrarConexion() throws SQLException{
        conexion.close();
    }
    
    public boolean insertar(ComentariosPOJO cm){
       try{
           abrirConexion();
           String insert = "insert into COMENTARIOS values ('" + cm.getNombre()+ "','" + cm.getComentario() + "')";
           Statement stmt = conexion.createStatement();
           int filas = stmt.executeUpdate(insert);
           cerrarConexion();
           return filas >0 ;
       }catch(Exception ex){
        return false;
       }
    }
    
    public ArrayList buscar(ComentariosPOJO pojo){
        ArrayList<ComentariosPOJO> beans = new ArrayList();
        try{
            abrirConexion();
            String insert = "select * from COMENTARIOS where NOMBRE = '" + pojo.getNombre() + "' and COMENTARIO like '%" + pojo.getComentario() + "%'";            
            Statement stmt = conexion.createStatement();
            ResultSet result = stmt.executeQuery(insert);
            while(result.next()){
                String nombre = result.getString("Nombre");
                String comentario = result.getString("Comentario");
                ComentariosPOJO cmt = new ComentariosPOJO();
                cmt.setNombre(nombre);
                cmt.setComentario(comentario);
                beans.add(cmt);
            }
            cerrarConexion();
        }catch(Exception ex){
        }
        return beans;
    }
}
