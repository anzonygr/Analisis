/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author agonzalez
 */
public class Modificar extends Conexion{
    
    public boolean formulario_atendido(int cod_coordinacion){
        PreparedStatement pst = null;
        try{
            String modificar2 = "UPDATE solicitud_vehiculo SET FINALIZADO = \"si\" WHERE COD_SOLICITUD_VEHICULO =?";
            pst = getConexion().prepareStatement(modificar2);
            pst.setInt(1, cod_coordinacion);
            if(pst.executeUpdate() == 1){
                return  true;
            }
        } catch(Exception ex){
            System.err.println("Error" + ex);
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
    
    public static void main(String[] args){
        Modificar co = new Modificar();
        System.out.println(co.formulario_atendido(1));
        
    }
}
