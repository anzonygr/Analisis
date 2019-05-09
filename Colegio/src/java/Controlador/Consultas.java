/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.UUID;
/**
 *
 * @author agonzalez
 */
public class Consultas extends Conexion{
    
    public boolean autentication (String CONTRASEÑA){
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            String consulta = "Select * from LOGIN where CONTRASEÑA = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, CONTRASEÑA);
            rs = pst.executeQuery();
            if (rs.absolute(1)){
                return true;
            }
        }catch (Exception e){
            System.err.println("Error"+e);
        }finally{
            try{
                if(getConexion() !=null) getConexion().close();
                if(pst != null) pst.close();
                if(rs != null)rs.close();
            } catch (Exception e){
                System.err.println("Error"+e);
            }
        }
        return false;
    }
    
    public boolean registrar(int cod_login, String CONTRASEÑA, int cod_cuenta){
        PreparedStatement pst = null;
        try{
            String consulta = "INSERT INTO login (COD_LOGIN, CONTRASEÑA, COD_CUENTA) VALUES(?,?,?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, cod_login);
            pst.setString(2, CONTRASEÑA);
            pst.setInt(3, cod_cuenta);
            if(pst.executeUpdate() == 1){
                return  true;
            }
        } catch(Exception ex){
            
        }finally{
            try{
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
            }catch(Exception e){
                System.err.println("Error"+ e);
                
            } 
            
        }
        
        return false;
    }

    public String generar_password(){
        String contraseña = UUID.randomUUID().toString().toUpperCase().substring(0, 8);
        return contraseña;
    }
   
    public static void main(String[] args){
        Consultas co = new Consultas();
        System.out.println(co.autentication("123"));
        
    }
}