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
     * Método que nos permite evaluar si un ResultSet es nulo o no sin recorrer
     * el RsultSet evitando perder registros de una consulta
     *
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
                } else
                {
                    ret[0] = false;
                }
            }
            dbCon.close();
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
            dbCon.close();
        } catch (SQLException e)
        {
            System.err.println("Error em obtener pacientes de sql: " + e);
        }

        return null;
    }

    /**
     * Método que lista la tabla de pacientes tomando como parametro el tipo de
     * tab que se seleccione
     *
     * @param tab 1 = Activos | 2 = Inactivos | 0 = Todos los pacientes
     * @return resultset con los pacientes hechos
     */
    public static ResultSet rsListarPacientes(int tab, String filtro)
    {
        try
        {
            dbCon = ConectaBD.ConectaBD();
            if (tab != 0 && filtro.equals(""))
            {
                //Para el caso de que se seleccione activos o inactivos y no se haga busqueda
                sentencia = dbCon.prepareStatement("SELECT *,IF(estatus=1,'Activo','Inactivo') AS estatusPac FROM pacientes WHERE estatus = ?");
                sentencia.setInt(1, tab);
            } else
            {
                String auxFiltro = filtro + "%";
                if (filtro != null && (tab == 1 || tab == 2))
                {
                    //Para el caso de que se seleccione activos o inactivos y se haga una busqueda
                    sentencia = dbCon.prepareStatement("SELECT *,IF(estatus=1,'Activo','Inactivo') AS estatusPac FROM pacientes WHERE estatus = ? AND (nombre LIKE ? OR apellidoPaterno LIKE ?)");
                    sentencia.setInt(1, tab);
                    sentencia.setString(2, auxFiltro);
                    sentencia.setString(3, auxFiltro);
                } else
                {
                    //Para el caso de que se entre en la pestaña de todos pero se haga una busqueda
                    if (tab == 0 && filtro != null)
                    {
                        sentencia = dbCon.prepareStatement("SELECT *,IF(estatus=1,'Activo','Inactivo') AS estatusPac FROM pacientes WHERE nombre LIKE ? OR apellidoPaterno LIKE ?");
                        sentencia.setString(1, auxFiltro);
                        sentencia.setString(2, auxFiltro);
                    } else
                    {
                        //Para el caso de que se entre en la pestaña de todos y no se consulten busquedas
                        sentencia = dbCon.prepareStatement("SELECT *,IF(estatus=1,'Activo','Inactivo') AS estatusPac FROM pacientes");
                    }

                }

            }

            resultado = sentencia.executeQuery();
            if (checkResultSet(resultado))
            {
                return resultado;
            }
            dbCon.close();
        } catch (SQLException e)
        {
            System.out.println("Error en obtener el ResultSet de Pacientes: " + e);
        }
        return null;
    }

    /**
     * Método que regresa la cantidad de pacientes y es auxiliar de la funcion
     * de los labels encargados de mostrar la cantidad de pacientes.
     *
     * @param tab el tipo de filtro del paciente 1 = Activos | 2 = Inactivos | 3
     * = Todos los pacientes
     * @return cantidad de pacientes seleccionados
     */
    public static int contarPacientes(int tab)
    {
        int total = -1;
        try
        {
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
            dbCon.close();
        } catch (SQLException e)
        {
            System.err.println("Error al contar Pacientes: " + e);
        } finally
        {
            try
            {
                dbCon.close();
            } catch (SQLException ex)
            {
                Logger.getLogger(MetodosBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return total;
    }

    public static boolean insertarPaciente(Object[] datos)
    {
        String columnas[] =
        {
            "nombre", "apellidoPaterno", "apellidoMaterno", "sexo", "telefono", "correo"
        };
        try
        {
            dbCon = ConectaBD.ConectaBD();
            sentencia = MetodosAux.generaSQLInsercion("pacientes", columnas, datos, dbCon, sentencia);

            int r = sentencia.executeUpdate();

            if (r > 0)
            {
                return true;
            }
        } catch (SQLException e)
        {
            System.out.println("Error al insertar paciente: " + e.toString());
        }
        return false;
    }

}
