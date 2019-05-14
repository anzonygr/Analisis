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
    
    public boolean autentication (String USUARIO, String CONTRASEÑA){
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            String consulta = "Select * from LOGIN where USUARIO = ? and PASSWORD = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, USUARIO);
            pst.setString(2, CONTRASEÑA);
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
    
    public boolean registrar(int cod_rol, int cod_login, String usuario, String password){
        PreparedStatement pst = null;
        try{
            String consulta = "INSERT INTO login (COD_ROL, COD_LOGIN, USUARIO, PASSWORD) VALUES(?,?,?,?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, cod_rol);
            pst.setInt(2, cod_login);
            pst.setString(3, usuario);
            pst.setString(4, password);
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
    
    public boolean regis_estudiante(int cod_estudiante, int cod_rol, String nombre, String apellido, int telefono1, int telefono2, String sexo, String direccion, String cui, String fecha_nacimiento, int cod_grado){
        PreparedStatement pst = null;
        try{
            String consulta = "INSERT INTO estudiante (COD_ESTUDIANTE, COD_ROL, NOMBRE, APELLIDO, TELEFONO_1, TELEFONO_2, SEXO, DIRECCION, CUI, FECHA_NACIMIENTO, COD_GRADO) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, cod_estudiante);
            pst.setInt(2, cod_rol);
            pst.setString(3, nombre);
            pst.setString(4, apellido);
            pst.setInt(5, telefono1);
            pst.setInt(6, telefono2);
            pst.setString(7, sexo);
            pst.setString(8, direccion);
            pst.setString(9, cui);
            pst.setString(10, fecha_nacimiento);
            pst.setInt(11, cod_grado);
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

    public boolean regis_encargado(int cod_encargado, int cod_rol, String nombre, String apellido, int telefono1, int telefono2, String correo, String parentesco, String direccion, String dpi){
        PreparedStatement pst = null;
        try{
            String consulta = "INSERT INTO encargado (COD_ENCARGADO, COD_ROL, NOMBRE, APELLIDO, TELEFONO_1, TELEFONO_2, CORREO, PARENTESCO, DIRECCION, DPI) VALUES(?,?,?,?,?,?,?,?,?,?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, cod_encargado);
            pst.setInt(2, cod_rol);
            pst.setString(3, nombre);
            pst.setString(4, apellido);
            pst.setInt(5, telefono1);
            pst.setInt(6, telefono2);
            pst.setString(7, correo);
            pst.setString(8, parentesco);
            pst.setString(9, direccion);
            pst.setString(10, dpi);
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
   
//    public static void main(String[] args){
//        Consultas co = new Consultas();
//        System.out.println(co.regis_estudiante(1, 3, "ANZONY RAFAEL", "GONZALEZ RIOS", 56695380, 30226300, "MASCULINO", "2da. calle B", "2985611460101", "08/04/2019", 4));        
//    }
    public static void main(String[] args){
        Consultas co = new Consultas();
        System.out.println(co.regis_encargado(2, 4, "nombre", "apellido", 12345678, 12345678, "correo", "parentesco", "direccion", "dpi"));        
    }
    
}