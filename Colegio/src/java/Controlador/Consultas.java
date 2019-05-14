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
import java.sql.SQLException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agonzalez
 */
public class Consultas extends Conexion {

    public boolean autentication(String USUARIO, String CONTRASEÑA) {
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String consulta = "Select * from LOGIN where USUARIO = ? and PASSWORD = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, USUARIO);
            pst.setString(2, CONTRASEÑA);
            rs = pst.executeQuery();
            if (rs.absolute(1)) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error" + e);
        } finally {
            try {
                if (getConexion() != null) {
                    getConexion().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error" + e);
            }
        }
        return false;
    }

    public boolean registrar(int cod_rol, int cod_login, String usuario, String password) {
        PreparedStatement pst = null;
        try {
            String consulta = "INSERT INTO login (COD_ROL, COD_LOGIN, USUARIO, PASSWORD) VALUES(?,?,?,?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, cod_rol);
            pst.setInt(2, cod_login);
            pst.setString(3, usuario);
            pst.setString(4, password);
            if (pst.executeUpdate() == 1) {
                return true;
            }
        } catch (Exception ex) {

        } finally {
            try {
                if (getConexion() != null) {
                    getConexion().close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                System.err.println("Error" + e);

            }

        }

        return false;
    }

    public boolean regis_estudiante(int cod_estudiante, int cod_rol, String nombre, String apellido, int telefono1, int telefono2, String sexo, String direccion, String cui, String fecha_nacimiento, int cod_grado, int cod_encargado) {
        PreparedStatement pst = null;
        try {
            String consulta = "INSERT INTO estudiante (COD_ESTUDIANTE, COD_ROL, NOMBRE, APELLIDO, TELEFONO_1, TELEFONO_2, SEXO, DIRECCION, CUI, FECHA_NACIMIENTO, COD_GRADO, COD_ENCARGADO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
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
            pst.setInt(12, cod_encargado);
            if (pst.executeUpdate() == 1) {
                return true;
            }
        } catch (Exception ex) {

        } finally {
            try {
                if (getConexion() != null) {
                    getConexion().close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                System.err.println("Error" + e);

            }

        }

        return false;
    }

    public boolean regis_encargado(int cod_encargado, int cod_rol, String nombre, String apellido, int telefono1, int telefono2, String correo, String parentesco, String direccion, String dpi) {
        PreparedStatement pst = null;
        try {
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
            if (pst.executeUpdate() == 1) {
                return true;
            }
        } catch (Exception ex) {

        } finally {
            try {
                if (getConexion() != null) {
                    getConexion().close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                System.err.println("Error" + e);

            }

        }

        return false;
    }

    public boolean regis_catedratico(int cod_catedratico, int cod_rol, String nombre, String apellido, int telefono1, int telefono2, String correo, String direccion, String dpi, String sexo, String fecha, String titulo) {
        PreparedStatement pst = null;
        try {
            String consulta = "INSERT INTO catedratico (COD_CATEDRATICO, COD_ROL, NOMBRE, APELLIDO, TELEFONO_1, TELEFONO_2, CORREO, DIRECCION, DPI, SEXO, FECHA_NACIMIENTO, TITULO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, cod_catedratico);
            pst.setInt(2, cod_rol);
            pst.setString(3, nombre);
            pst.setString(4, apellido);
            pst.setInt(5, telefono1);
            pst.setInt(6, telefono2);
            pst.setString(7, correo);
            pst.setString(8, direccion);
            pst.setString(9, dpi);
            pst.setString(10, sexo);
            pst.setString(11, fecha);
            pst.setString(12, titulo);
            if (pst.executeUpdate() == 1) {
                return true;
            }
        } catch (Exception ex) {

        } finally {
            try {
                if (getConexion() != null) {
                    getConexion().close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                System.err.println("Error" + e);

            }

        }

        return false;
    }

    public String generar_password() {
        String contraseña = UUID.randomUUID().toString().toUpperCase().substring(0, 8);
        return contraseña;
    }

    public int login() {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            int cont = 1;
            String consulta = "Select * from LOGIN";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                cont++;
            }
            return cont;
        } catch (Exception e) {
        }
        return 0;

    }
    
    public int estudiante() {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            int cont = 1;
            String consulta = "Select * from estudiante";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                cont++;
            }
            return cont;
        } catch (Exception e) {
        }
        return 0;

    }
    
    public int encargado() {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            int cont = 1;
            String consulta = "Select * from encargado";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                cont++;
            }
            return cont;
        } catch (Exception e) {
        }
        return 0;

    }
    
    public int catedratico() {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            int cont = 1;
            String consulta = "Select * from catedratico";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                cont++;
            }
            return cont;
        } catch (Exception e) {
        }
        return 0;

    }
    
    public ResultSet nombre_encargado() {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "Select * from encargado";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
            
            return rs;
        } catch (Exception e) {
        }
        return null;
        
    }

    
//    public static void main(String[] args){
//        Consultas co = new Consultas();
//        System.out.println(co.regis_estudiante(1, 3, "ANZONY RAFAEL", "GONZALEZ RIOS", 56695380, 30226300, "MASCULINO", "2da. calle B", "2985611460101", "08/04/2019", 4));        
//    }
    public static void main(String[] args) {
        Consultas co = new Consultas();
        try {
            ResultSet rst = co.nombre_encargado();
            while (rst.next()) {
                String nombre_encargado = rst.getString(3) + " " + rst.getString(4);
                System.out.println(nombre_encargado);
                break;
            }
        } catch (SQLException ex) {
            
        }
    }

}
