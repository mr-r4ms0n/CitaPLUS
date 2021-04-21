/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosBD;

import RSMaterialComponent.RSTableMetroCustom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import metodosAux.MetodosAux;
import seguridad.Encoder;

/**
 *
 * @author Kevin
 */
public class MetodosBD
{

    private static Connection dbCon;
    private String sql = null;

    //Variable para usar consultas
    private static PreparedStatement sentencia;
    private static ResultSet resultado;

    /**
     * Método que nos permite evaluar si un ResultSet es nulo o no sin recorrer el RsultSet evitando perder registros de 
     * una consulta
     * @param rs ResultSet a evaluar
     * @return true = tiene datos | false = no tiene datos
     */
    public static boolean checkResultSet(ResultSet rs)
    {
        try
        {
            if (rs.isBeforeFirst())
            {
                return true;
            }

        } catch (SQLException e)
        {
            System.err.println("Error al verificar resultset: " + e);
        }
        return false;
    }

    /**
     * Metodo que retorna un arreglo de objetos con los valores que requerimos
     * para ingresar al sistema posteriormente se carga el usuario, nombre
     * completo e imagen en el menu principal si es que se encontro
     *
     * @param usr el usuario a buscar
     * @param pass la contraseña encriptada
     * @return objeto con 4 valores [0] = true o false para saber si si existe
     * el usuario y se le permite el acceso [1] = nombre de usuario de la
     * persona [2] = nombre completo de la persona [3] = foto de perfil de la
     * persona
     */
    public static Object[] ingresoSys(String usr, String pass)
    {
        Object ret[] = new Object[4];
        try
        {
            dbCon = ConectaBD.ConectaBD();
            sentencia = dbCon.prepareStatement("SELECT * FROM usuarios WHERE usuario = BINARY ? AND contraseña = BINARY ?");
            sentencia.setString(1, usr);
            sentencia.setString(2, pass);
            resultado = sentencia.executeQuery();
            if (resultado.next())
            {
                if (resultado.getString("usuario").equals(usr) && resultado.getString("contraseña").equals(pass))
                {
                    ret[0] = true;
                    ret[1] = resultado.getString("usuario");
                    ret[2] = resultado.getString("nombre") + " " + resultado.getString("apellidoPaterno") + " " + resultado.getString("apellidoMaterno");
                    ret[3] = resultado.getString("foto");
                }
            }
        } catch (SQLException e)
        {
            System.out.println("Error de consulta en Inicio de sesion " + e);
        }
        return ret;
    }

    public static String getPaciente(String pacienteId, String tab)
    {
        try
        {
            dbCon = ConectaBD.ConectaBD();
            sentencia = dbCon.prepareStatement("SELECT * FROM pacientes WHERE id = ?");
            sentencia.setString(1, pacienteId);
            resultado = sentencia.executeQuery();
            if (resultado.next())
            {
                return resultado.getString("id");
            }
        } catch (SQLException e)
        {
            System.err.println("Error em obtener pacientes de sql: " + e);
        }
        return null;
    }

    public static ResultSet rsListarPacientes(int tab)
    {
        try
        {
            dbCon = ConectaBD.ConectaBD();
            if (tab != 0)
            {
                sentencia = dbCon.prepareStatement("SELECT * FROM pacientes WHERE estatus = ?");
                sentencia.setInt(1, tab);
            } else
            {
                sentencia = dbCon.prepareStatement("SELECT * FROM pacientes");
            }

            resultado = sentencia.executeQuery();
            if (checkResultSet(resultado))
            {
                return resultado;
            }

        } catch (SQLException e)
        {
            System.out.println("Error en obtener el ResultSet de Pacientes: " + e);
        }
        return null;
    }
    
    public static int contarPacientes(int tab)
    {
        int total = -1;
        try
        {
            dbCon = ConectaBD.ConectaBD();
            dbCon = ConectaBD.ConectaBD();
            if (tab != 0)
            {
                sentencia = dbCon.prepareStatement("SELECT COUNT(*)AS total FROM pacientes WHERE estatus = ?");
                sentencia.setInt(1, tab);
            } else
            {
                sentencia = dbCon.prepareStatement("SELECT COUNT(*)AS total FROM pacientes");
            }
            resultado = sentencia.executeQuery();
            if (checkResultSet(resultado))
            {
                //Nos movemos a la primera posicion para que comenze a contar, ya que inicialmente está en 0
                resultado.next();
                total = resultado.getInt("total");
            }
        } catch (SQLException e)
        {
            System.err.println("Error al contar Pacientes: "+e);
        }
        return total;
    }

}
