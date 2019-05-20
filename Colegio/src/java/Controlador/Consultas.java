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

    public boolean registrar(int cod_rol, String usuario, String password) {
        PreparedStatement pst = null;
        try {
            String consulta = "INSERT INTO login (COD_ROL, USUARIO, PASSWORD) VALUES(?,?,?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, cod_rol);
            pst.setString(2, usuario);
            pst.setString(3, password);
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

    public boolean regis_estudiante(int cod_rol, String nombre, String apellido, int telefono1, int telefono2, String sexo, String direccion, String cui, String fecha_nacimiento, int cod_grado, int cod_encargado, String correo) {
        PreparedStatement pst = null;
        try {
            String consulta = "INSERT INTO estudiante (COD_ROL, NOMBRE, APELLIDO, TELEFONO_1, TELEFONO_2, SEXO, DIRECCION, CUI, FECHA_NACIMIENTO, COD_GRADO, COD_ENCARGADO, CORREO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, cod_rol);
            pst.setString(2, nombre);
            pst.setString(3, apellido);
            pst.setInt(4, telefono1);
            pst.setInt(5, telefono2);
            pst.setString(6, sexo);
            pst.setString(7, direccion);
            pst.setString(8, cui);
            pst.setString(9, fecha_nacimiento);
            pst.setInt(10, cod_grado);
            pst.setInt(11, cod_encargado);
            pst.setString(12, correo);
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

    public boolean regis_encargado(int cod_rol, String nombre, String apellido, int telefono1, int telefono2, String correo, String parentesco, String direccion, String dpi) {
        PreparedStatement pst = null;
        try {
            String consulta = "INSERT INTO encargado (COD_ROL, NOMBRE, APELLIDO, TELEFONO_1, TELEFONO_2, CORREO, PARENTESCO, DIRECCION, DPI) VALUES(?,?,?,?,?,?,?,?,?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, cod_rol);
            pst.setString(2, nombre);
            pst.setString(3, apellido);
            pst.setInt(4, telefono1);
            pst.setInt(5, telefono2);
            pst.setString(6, correo);
            pst.setString(7, parentesco);
            pst.setString(8, direccion);
            pst.setString(9, dpi);
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

    public boolean regis_catedratico(int cod_rol, String nombre, String apellido, int telefono1, int telefono2, String correo, String direccion, String dpi, String sexo, String fecha, String titulo) {
        PreparedStatement pst = null;
        try {
            String consulta = "INSERT INTO catedratico (COD_ROL, NOMBRE, APELLIDO, TELEFONO_1, TELEFONO_2, CORREO, DIRECCION, DPI, SEXO, FECHA_NACIMIENTO, TITULO) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, cod_rol);
            pst.setString(2, nombre);
            pst.setString(3, apellido);
            pst.setInt(4, telefono1);
            pst.setInt(5, telefono2);
            pst.setString(6, correo);
            pst.setString(7, direccion);
            pst.setString(8, dpi);
            pst.setString(9, sexo);
            pst.setString(10, fecha);
            pst.setString(11, titulo);
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

    public boolean regis_asignacion(int cod_grado, int cod_curso, int cod_seccion, int cod_catedratico, int cod_estudiante, String horario, int zona, int parcial_1, int parcial_2, int examen_final, String estado) {
        PreparedStatement pst = null;
        try {
            String consulta = "INSERT INTO asignacion (COD_GRADO, COD_CURSO, COD_SECCION, COD_CATEDRATICO, COD_ESTUDIANTE, HORARIO, ZONA, PARCIAL_1, PARCIAL_2, EXAMEN_FINAL, ESTADO) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, cod_grado);
            pst.setInt(2, cod_curso);
            pst.setInt(3, cod_seccion);
            pst.setInt(4, cod_catedratico);
            pst.setInt(5, cod_estudiante);
            pst.setString(6, horario);
            pst.setInt(7, zona);
            pst.setInt(8, parcial_1);
            pst.setInt(9, parcial_2);
            pst.setInt(10, examen_final);
            pst.setString(11, estado);

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

    public boolean regis_actividad(int cod_asignacion, int cod_grado, int cod_curso, int cod_seccion, int cod_catedratico, String titulo, String descripcion, int nota, String fecha) {
        PreparedStatement pst = null;
        try {
            String consulta = "INSERT INTO actividad (COD_ASIGNACION, COD_GRADO, COD_CURSO, COD_SECCION, COD_CATEDRATICO, TITULO, DESCRIPCION, NOTA, FECHA_ENTREGA) VALUES(?,?,?,?,?,?,?,?,?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, cod_asignacion);
            pst.setInt(2, cod_grado);
            pst.setInt(3, cod_curso);
            pst.setInt(4, cod_seccion);
            pst.setInt(5, cod_catedratico);
            pst.setString(6, titulo);
            pst.setString(7, descripcion);
            pst.setInt(8, nota);
            pst.setString(9, fecha);

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

    public boolean regis_entrega_actividad(int cod_actividad, int cod_asignacion, int cod_grado, int cod_curso, int cod_seccion, int cod_catedratico, int cod_estudiante, String descripcion, int nota, String fecha) {
        PreparedStatement pst = null;
        try {
            String consulta = "INSERT INTO entrega_actividad (COD_ACTIVIDAD, COD_ASIGNACION, COD_GRADO, COD_CURSO, COD_SECCION, COD_CATEDRATICO, COD_ESTUDIANTE, DESCRIPCION, NOTA, ESTADO) VALUES(?,?,?,?,?,?,?,?,?,?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, cod_actividad);
            pst.setInt(2, cod_asignacion);
            pst.setInt(3, cod_grado);
            pst.setInt(4, cod_curso);
            pst.setInt(5, cod_seccion);
            pst.setInt(6, cod_catedratico);
            pst.setInt(7, cod_estudiante);
            pst.setString(8, descripcion);
            pst.setInt(9, nota);
            pst.setString(10, fecha);

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

    
    public ResultSet cod_usuario_login_catedratico(String usuario) {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "Select COD_CATEDRATICO from catedratico WHERE CORREO = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, usuario);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
        }
        return null;

    }

    public ResultSet cod_usuario_login_encargado(String usuario) {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "Select COD_ENCARGADO from encargado WHERE CORREO = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, usuario);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
        }
        return null;

    }

    public ResultSet cod_usuario_login_estudiante(String usuario) {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "Select COD_ESTUDIANTE from estudiante WHERE CORREO = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, usuario);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
        }
        return null;

    }

    public ResultSet entrega_actividiad_cod_actividad(int cod_grado, int cod_curso, int cod_seccion, int cod_catedratico, int cod_estudiante) {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "Select COD_ACTIVIDAD from entrega_actividad WHERE COD_GRADO = ? AND COD_CURSO = ? AND COD_SECCION = ? AND COD_CATEDRATICO = ? AND COD_ESTUDIANTE = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, cod_grado);
            pst.setInt(2, cod_curso);
            pst.setInt(3, cod_seccion);
            pst.setInt(4, cod_catedratico);
            pst.setInt(5, cod_estudiante);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
        }
        return null;

    }

    public ResultSet actividiad_cod_asignacion(int cod_grado, int cod_curso, int cod_seccion, int cod_catedratico) {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "Select COD_ASIGNACION from asignacion WHERE COD_GRADO = ? AND COD_CURSO = ? AND COD_SECCION = ? AND COD_CATEDRATICO = ? AND COD_ESTUDIANTE = 0";
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
            String consulta = "select a.COD_ESTUDIANTE, b.DESCRIPCION, concat(a.NOMBRE, ' ', a.APELLIDO), a.TELEFONO_1, a.DIRECCION, a.CUI, a.CORREO  FROM estudiante a INNER JOIN rol b ON (b.COD_ROL = a.COD_ROL) WHERE 1";
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

    public ResultSet cod_actividad_entrega(int cod_grado, int cod_curso, int cod_seccion, int cod_catedratico, String titulo) {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "select a.COD_ACTIVIDAD FROM actividad a  WHERE COD_GRADO = ? AND COD_CURSO = ? AND COD_SECCION = ? AND COD_CATEDRATICO =? AND TITULO = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, cod_grado);
            pst.setInt(2, cod_curso);
            pst.setInt(3, cod_seccion);
            pst.setInt(4, cod_catedratico);
            pst.setString(5, titulo);
            rs = pst.executeQuery();

            return rs;
        } catch (Exception e) {
        }
        return null;

    }

    public ResultSet cod_estudiante (String nombre, String apellido, String correo) {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "select COD_ESTUDIANTE FROM estudiante WHERE NOMBRE = ? AND APELLIDO =? AND CORREO =?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, nombre);
            pst.setString(2, apellido);
            pst.setString(3, correo);
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
            String consulta = "select b.DESCRIPCION, d.DESCRIPCION, c.DESCRIPCION, a.HORARIO, b.COD_GRADO, d.COD_CURSO, c.COD_SECCION FROM asignacion a INNER JOIN grado b ON a.COD_GRADO = b.COD_GRADO INNER JOIN seccion c ON (a.COD_GRADO = c.COD_GRADO) AND (a.COD_SECCION = c.COD_SECCION) INNER JOIN curso d ON (a.COD_GRADO = d.COD_GRADO) AND (a.COD_CURSO = d.COD_CURSO) WHERE a.COD_CATEDRATICO = ? AND a.COD_ESTUDIANTE = 0";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, cod_catedratico);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
        }
        return null;

    }

    public ResultSet nombre_asignacion_estudiante(int cod_estudiante) {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "select b.DESCRIPCION, d.DESCRIPCION, c.DESCRIPCION, concat(e.NOMBRE,' ', e.APELLIDO), a.HORARIO, b.COD_GRADO, d.COD_CURSO, c.COD_SECCION, e.COD_CATEDRATICO FROM asignacion a INNER JOIN grado b ON a.COD_GRADO = b.COD_GRADO INNER JOIN seccion c ON (a.COD_GRADO = c.COD_GRADO) AND (a.COD_SECCION = c.COD_SECCION) INNER JOIN curso d ON (a.COD_GRADO = d.COD_GRADO) AND (a.COD_CURSO = d.COD_CURSO) INNER JOIN catedratico e ON (a.COD_CATEDRATICO = e.COD_CATEDRATICO) WHERE a.COD_ESTUDIANTE = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, cod_estudiante);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
        }
        return null;

    }

    public ResultSet nombre_encargado_estudiante(int cod_encargado) {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "select concat(a.NOMBRE,' ', a.APELLIDO), d.DESCRIPCION, e.DESCRIPCION, a.COD_ESTUDIANTE FROM estudiante a INNER JOIN encargado b ON a.COD_ENCARGADO = b.COD_ENCARGADO INNER JOIN asignacion c ON a.COD_ESTUDIANTE = c.COD_ESTUDIANTE INNER JOIN grado d ON c.COD_GRADO = d.COD_GRADO INNER JOIN seccion e ON c.COD_SECCION = e.COD_SECCION   WHERE a.COD_ENCARGADO = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, cod_encargado);
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

    public ResultSet nombre_list_asignacion_estudiante(int cod_grado, int cod_curso, int cod_seccion, int cod_catedratico, int cod_estudiante) {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "select b.DESCRIPCION, a.ZONA, a.PARCIAL_1, a.PARCIAL_2, a.EXAMEN_FINAL from asignacion a INNER JOIN curso b ON a.COD_CURSO = b.COD_CURSO WHERE a.COD_GRADO = ? AND a.COD_CURSO = ? AND a.COD_SECCION = ? AND a.COD_CATEDRATICO = ? AND a.COD_ESTUDIANTE = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, cod_grado);
            pst.setInt(2, cod_curso);
            pst.setInt(3, cod_seccion);
            pst.setInt(4, cod_catedratico);
            pst.setInt(5, cod_estudiante);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
        }
        return null;

    }

    public ResultSet nombre_catedratico_asignacion(int cod_grado, int cod_curso, int cod_seccion) {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "select COD_CATEDRATICO from asignacion WHERE COD_GRADO = ? AND COD_CURSO = ? AND COD_SECCION = ? AND COD_ESTUDIANTE = 0";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, cod_grado);
            pst.setInt(2, cod_curso);
            pst.setInt(3, cod_seccion);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
        }
        return null;

    }

    public ResultSet nombre_estudiante_asignacion(int cod_grado, int cod_curso, int cod_seccion, int cod_catedratico) {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "select COD_ESTUDIANTE from asignacion WHERE COD_GRADO = ? AND COD_CURSO = ? AND COD_SECCION = ? AND COD_CATEDRATICO = ? AND COD_ESTUDIANTE > 0";
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

    public ResultSet nombre_entrega_actividad(int cod_actividad, int cod_grado, int cod_curso, int cod_seccion, int cod_catedratico, int cod_estudiante) {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            String consulta = "select b.TITULO, b.DESCRIPCION, a.NOTA, b.NOTA, b.FECHA_ENTREGA, a.ESTADO from entrega_actividad a INNER JOIN actividad b ON a.COD_ACTIVIDAD = b.COD_ACTIVIDAD AND a.COD_GRADO = b.COD_GRADO AND a.COD_CURSO = b.COD_CURSO AND a.COD_SECCION = b.COD_SECCION AND a.COD_CATEDRATICO = b.COD_CATEDRATICO WHERE a.COD_ACTIVIDAD = ? AND a.COD_GRADO = ? AND a.COD_CURSO = ? AND a.COD_SECCION = ? AND a.COD_CATEDRATICO = ? AND a.COD_ESTUDIANTE = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, cod_actividad);
            pst.setInt(2, cod_grado);
            pst.setInt(3, cod_curso);
            pst.setInt(4, cod_seccion);
            pst.setInt(5, cod_catedratico);
            pst.setInt(6, cod_estudiante);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
        }
        return null;

    }

//   public static void main(String[] args){
//        Consultas co = new Consultas();
//        System.out.println(co.regis_asignacion(1, 1, 2, 4, 0, "15:30", 0, 0, 0, 0, "asignado"));
//      }
//    public static void main(String[] args) {
//        Consultas co = new Consultas();
//        try {
//            ResultSet rst = co.nombre_encargado_estudiante(2);
//            String nombre = null;
//            String grado = null;
//            String seccion = null;
//            String cod_estudiante = null;
//            String nombre2 = null;
//            String grado2 = null;
//            String seccion2 = null;
//            String cod_estudiante2 = null;
//            while (rst.next()) {
//                nombre = rst.getString(1);
//                grado = rst.getString(2);
//                seccion = rst.getString(3);
//                cod_estudiante = rst.getString(4);
//                if ((rst.getString(1).equals(nombre2)) && (rst.getString(2).equals(grado2)) && (rst.getString(3).equals(seccion2)) && (rst.getString(4).equals(cod_estudiante2))) {
//
//                    nombre2 = nombre;
//                    grado2 = grado;
//                    seccion2 = seccion;
//                    cod_estudiante2 = cod_estudiante;
//
//                } else {
//                    String nombre_encargado = rst.getString(1) + " " + rst.getString(2) + " " + rst.getString(3) + " " + rst.getString(4);
//                    System.out.println(nombre_encargado);
//
//                    nombre2 = nombre;
//                    grado2 = grado;
//                    seccion2 = seccion;
//                    cod_estudiante2 = cod_estudiante;
//                }
//            }
//        } catch (SQLException ex) {
//
//        }
//    }
    public static void main(String[] args) {
        Consultas co = new Consultas();
        try {
            ResultSet rst = co.nombre_catedratico_asignacion(1, 5, 1);
            while (rst.next()) {
                String nombre_encargado = rst.getString(1);
                    System.out.println(nombre_encargado);
            }
        }catch (SQLException ex) {
            
        }
    }
}
