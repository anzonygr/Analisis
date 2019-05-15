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

    public boolean regis_asignacion(int cod_asignacion, int cod_grado, int cod_curso, int cod_seccion, int cod_catedratico, int cod_estudiante, String horario, int zona, int parcial_1, int parcial_2, int examen_final, String estado) {
        PreparedStatement pst = null;
        try {
            String consulta = "INSERT INTO asignacion (COD_ASIGNACION, COD_GRADO, COD_CURSO, COD_SECCION, COD_CATEDRATICO, COD_ESTUDIANTE, HORARIO, ZONA, PARCIAL_1, PARCIAL_2, EXAMEN_FINAL, ESTADO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, cod_asignacion);
            pst.setInt(2, cod_grado);
            pst.setInt(3, cod_curso);
            pst.setInt(4, cod_seccion);
            pst.setInt(5, cod_catedratico);
            pst.setInt(6, cod_estudiante);
            pst.setString(7, horario);
            pst.setInt(8, zona);
            pst.setInt(9, parcial_1);
            pst.setInt(10, parcial_2);
            pst.setInt(11, examen_final);
            pst.setString(12, estado);

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

    public int asignacion() {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            int cont = 1;
            String consulta = "Select * from asignacion";
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

    public ResultSet nombre_estudiante() {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "Select * from estudiante";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();

            return rs;
        } catch (Exception e) {
        }
        return null;

    }

    public ResultSet nombre_catedratico() {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "Select * from catedratico";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();

            return rs;
        } catch (Exception e) {
        }
        return null;

    }

    public ResultSet nombre_rol() {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "Select * from rol";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();

            return rs;
        } catch (Exception e) {
        }
        return null;

    }

    public ResultSet nombre_grado() {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "Select * from grado";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();

            return rs;
        } catch (Exception e) {
        }
        return null;

    }

    public ResultSet nombre_seccion() {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "Select * from seccion";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();

            return rs;
        } catch (Exception e) {
        }
        return null;

    }

    public ResultSet nombre_encargado_completo() {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "select a.COD_ENCARGADO, b.DESCRIPCION, concat(a.NOMBRE, ' ', a.APELLIDO), a.TELEFONO_1, a.DIRECCION, a.DPI, a.Correo FROM encargado a INNER JOIN rol b ON (b.COD_ROL = a.COD_ROL) WHERE 1";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();

            return rs;
        } catch (Exception e) {
        }
        return null;

    }

    public ResultSet nombre_estudiante_completo() {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "select a.COD_ESTUDIANTE, b.DESCRIPCION, concat(a.NOMBRE, ' ', a.APELLIDO), a.TELEFONO_1, a.DIRECCION, a.CUI  FROM estudiante a INNER JOIN rol b ON (b.COD_ROL = a.COD_ROL) WHERE 1";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();

            return rs;
        } catch (Exception e) {
        }
        return null;

    }

    public ResultSet nombre_catedratico_completo() {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "select a.COD_CATEDRATICO, b.DESCRIPCION, concat(a.NOMBRE, ' ', a.APELLIDO), a.TELEFONO_1, a.DIRECCION, a.DPI, a.CORREO, a.TITULO FROM catedratico a INNER JOIN rol b ON (b.COD_ROL = a.COD_ROL) WHERE 1";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();

            return rs;
        } catch (Exception e) {
        }
        return null;

    }

    public ResultSet nombre_grado_seccion() {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "select a.COD_SECCION, a.DESCRIPCION, b.DESCRIPCION FROM seccion a INNER JOIN grado b ON (b.COD_GRADO = a.COD_GRADO) WHERE 1";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();

            return rs;
        } catch (Exception e) {
        }
        return null;

    }

    public ResultSet cod_grado_seccion(int cod_seccion) {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "select a.COD_GRADO, a.COD_SECCION FROM seccion a  WHERE COD_SECCION = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, cod_seccion);
            rs = pst.executeQuery();

            return rs;
        } catch (Exception e) {
        }
        return null;

    }
    
    public ResultSet nombre_grado_curso(int cod_grado) {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "select a.COD_CURSO, a.DESCRIPCION FROM curso a  WHERE COD_GRADO = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, cod_grado);
            rs = pst.executeQuery();

            return rs;
        } catch (Exception e) {
        }
        return null;

    }
    
    public ResultSet nombre_grado_curso_seccion() {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "select b.DESCRIPCION, a.DESCRIPCION, c.DESCRIPCION, b.COD_GRADO, a.COD_CURSO, c.COD_SECCION FROM curso a INNER JOIN grado b ON a.COD_GRADO = b.COD_GRADO INNER JOIN seccion c ON a.COD_GRADO = c.COD_GRADO WHERE 1";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
        }
        return null;

    }
    
    public ResultSet nombre_asignacion(int cod_catedratico) {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "select b.DESCRIPCION, d.DESCRIPCION, c.DESCRIPCION, a.HORARIO, b.COD_GRADO, d.COD_CURSO, c.COD_SECCION FROM asignacion a INNER JOIN grado b ON a.COD_GRADO = b.COD_GRADO INNER JOIN seccion c ON (a.COD_GRADO = c.COD_GRADO) AND (a.COD_SECCION = c.COD_SECCION) INNER JOIN curso d ON (a.COD_GRADO = d.COD_GRADO) AND (a.COD_CURSO = d.COD_CURSO) WHERE a.COD_CATEDRATICO = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, cod_catedratico);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
        }
        return null;

    }
    
    public ResultSet nombre_list_asignacion(int cod_grado, int cod_curso, int cod_seccion, int cod_catedratico) {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "select b.NOMBRE, b.APELLIDO, b.TELEFONO_1, c.CORREO, a.ZONA, a.PARCIAL_1, a.PARCIAL_2, a.EXAMEN_FINAL from asignacion a INNER JOIN estudiante b ON a.COD_ESTUDIANTE = b.COD_ESTUDIANTE INNER JOIN encargado c ON b.COD_ENCARGADO = c.COD_ENCARGADO WHERE a.COD_GRADO = ? AND a.COD_CURSO = ? AND a.COD_SECCION = ? AND a.COD_CATEDRATICO = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, cod_grado);
            pst.setInt(2, cod_curso);
            pst.setInt(3, cod_seccion);
            pst.setInt(4, cod_catedratico);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
        }
        return null;

    }
//    public static void main(String[] args){
//        Consultas co = new Consultas();
//        System.out.println(co.regis_asignacion(4, 4, 1, 2, 1, 15, "12:30", 0, 0, 0, 0, "asignado"));        
//    }
    public static void main(String[] args) {
       Consultas co = new Consultas();
       try {
           ResultSet rst = co.nombre_grado_curso(4);
          while (rst.next()) {
               String nombre_encargado = rst.getString(1) + " " + rst.getString(2);
              System.out.println(nombre_encargado);
      }
        } catch (SQLException ex) {

        }
   }

}
