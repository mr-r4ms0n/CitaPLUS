/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosBD;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import metodosAux.MetodosAux;
import metodosAux.RSObjectArray;

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
        Object ret[] = null;
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
                    ret = new Object[4];
                    ret[0] = true;
                    ret[1] = resultado.getString("usuario");
                    ret[2] = resultado.getString("nombre") + " " + resultado.getString("apellidoPaterno") + " " + resultado.getString("apellidoMaterno");
                    ret[3] = resultado.getString("foto");
                }
            }
            dbCon.close();
        } catch (SQLException e)
        {
            System.out.println("Error de consulta en Inicio de sesion de tipo sql" + e);
        }
        return ret;
    }

    /**
     * Método usado para obtener datos de pacientes de forma individual
     * proporcionando el primary key (id)
     *
     * @param pacienteId id del paciente en la base de datos
     * @return
     */
    public static RSObjectArray getPaciente(String pacienteId)
    {
        try
        {
            dbCon = ConectaBD.ConectaBD();
            sentencia = dbCon.prepareStatement("SELECT * FROM pacientes WHERE id = ?");
            sentencia.setString(1, pacienteId);
            resultado = sentencia.executeQuery();
            if (resultado.next())
            {
                RSObjectArray arreglo = new RSObjectArray();
                //Primero extraemos la imagen del usuario y la convertimos a imagen visible
                byte[] imagen1 = null;
                Blob i1 = resultado.getBlob("foto");
                imagen1 = i1.getBytes(1, (int) i1.length());
                if (imagen1 != null)
                {
                    arreglo.add("id", resultado.getInt("id"));
                    arreglo.add("foto", imagen1);
                    arreglo.add("nombre", resultado.getString("nombre"));
                    arreglo.add("apellidoPaterno", resultado.getString("apellidoPaterno"));
                    arreglo.add("apellidoMaterno", resultado.getString("apellidoMaterno"));
                    arreglo.add("sexo", resultado.getString("sexo"));
                    String telefonoCad = (!resultado.getString("telefono").equals("0") ? resultado.getString("telefono") : "No proporcionado");
                    arreglo.add("telefono", telefonoCad);
                    arreglo.add("correo", resultado.getString("correo"));
                    int estado = resultado.getInt("estatus");
                    String estadoCad = (estado == 1) ? "Activo" : "Inactivo"; //Para que entiendas por si lees el codigo xd, si el estado es 1 entonces estadocad sera activo, sino sera inactivo.
                    arreglo.add("estatus", estadoCad);
                    return arreglo;
                }
            }
            dbCon.close();
        } catch (SQLException e)
        {
            System.err.println("Error en obtener pacientes de tipo sql: " + e);
        }

        return null;
    }

    /**
     * Método que lista la tabla de pacientes tomando como parametro el tipo de
     * tab que se seleccione
     *
     * @param tab 1 = Activos | 2 = Inactivos | 0 = Todos los pacientes
     * @param filtro cuando se hace una busqueda filtrada este es el parametro
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
                sentencia = dbCon.prepareStatement("SELECT *,IF(estatus=1,'Activo','Inactivo') AS estatusPac, IF(telefono=0,'No proporcionado',telefono)AS telefonoP FROM pacientes WHERE estatus = ?");
                sentencia.setInt(1, tab);
            } else
            {
                String auxFiltro = filtro + "%";
                if (filtro != null && (tab == 1 || tab == 2))
                {
                    //Para el caso de que se seleccione activos o inactivos y se haga una busqueda
                    sentencia = dbCon.prepareStatement("SELECT *,IF(estatus=1,'Activo','Inactivo') AS estatusPac,IF(telefono=0,'No proporcionado',telefono) AS telefonoP FROM pacientes WHERE estatus = ? AND (nombre LIKE ? OR apellidoPaterno LIKE ?)");
                    sentencia.setInt(1, tab);
                    sentencia.setString(2, (auxFiltro + "%"));
                    sentencia.setString(3, (auxFiltro + "%"));
                } else
                {
                    //Para el caso de que se entre en la pestaña de todos pero se haga una busqueda
                    if (tab == 0 && filtro != null)
                    {
                        sentencia = dbCon.prepareStatement("SELECT *,IF(estatus=1,'Activo','Inactivo') AS estatusPac, IF(telefono=0,'No proporcionado',telefono) AS telefonoP FROM pacientes WHERE nombre LIKE ? OR apellidoPaterno LIKE ?");
                        sentencia.setString(1, (auxFiltro + "%"));
                        sentencia.setString(2, (auxFiltro + "%"));
                    } else
                    {
                        //Para el caso de que se entre en la pestaña de todos y no se consulten busquedas
                        sentencia = dbCon.prepareStatement("SELECT *,IF(estatus=1,'Activo','Inactivo') AS estatusPac, IF(telefono=0,'No proporcionado',telefono) AS telefonoP FROM pacientes");
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
            //Si se selecciona alguna tab (Activos o Inactivos)
            if (tab != 0)
            {
                sentencia = dbCon.prepareStatement("SELECT COUNT(*)AS total FROM pacientes WHERE estatus = ?");
                sentencia.setInt(1, tab);
            } else
            {
                //Si se entra dentro de consulta general es decir sin tab seleccionada
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

    /**
     * Método que realiza la insercion de unicamente pacientes dentro de la base
     * de datos
     *
     * @param datos Datos a insertar proporcionados en el siguiente orden
     * (Nombre,ApellidoPaterno,ApellidoMaterno,Sexo,Telefono,Correo)
     * @return true si la insercion se hizo correctamente
     */
    public static boolean insertarPaciente(Object[] datos)
    {
        String columnas[] =
        {
            "foto", "nombre", "apellidoPaterno", "apellidoMaterno", "sexo", "telefono", "correo"
        };
        try
        {
            //Vemos que la ruta de la imagen este correcta
            String rutaImagen = (String) datos[0];
            System.out.println(rutaImagen);
            //La transformamos a fichero
            File fPerf = new File(rutaImagen);
            //La transformamos a fichero de enteada (binario)
            FileInputStream fIPerf = new FileInputStream(fPerf);
            //Reasignamos la foto codificada al arreglo y hacemos la insercion a la BD
            datos[0] = fIPerf;
            dbCon = ConectaBD.ConectaBD();

            sentencia = MetodosAux.SQLInserta("pacientes", columnas, datos, dbCon, sentencia);

            int r = sentencia.executeUpdate();

            if (r > 0)
            {
                return true;
            }
        } catch (SQLException e)
        {
            System.out.println("Error al insertar paciente: " + e.toString());
        } catch (FileNotFoundException ex)
        {
            System.out.println("Error al obtener la imagen : " + ex.toString());
        }
        return false;
    }

    //*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-PARTE CITAS *-*-*-*-*-*-*-*-*-*-**-*-*-**-*-*-*-*-
    /**
     * Método que obtiene unicamente los datos de una cita
     *
     * @param citasId
     * @return
     */
    public static RSObjectArray getCitas(String citasId)
    {
        try
        {
            dbCon = ConectaBD.ConectaBD();
            sentencia = dbCon.prepareStatement("SELECT * FROM citas WHERE id = ?");
            sentencia.setString(1, citasId);
            resultado = sentencia.executeQuery();
            if (resultado.next())
            {
                RSObjectArray arreglo = new RSObjectArray();
                arreglo.add("id", resultado.getInt("id"));
                arreglo.add("fecha", resultado.getString("fecha"));
                arreglo.add("hora", resultado.getString("hora"));
                arreglo.add("fechaRegistro", resultado.getString("fechaRegistro"));
                arreglo.add("usuarioId", resultado.getString("usuarioId"));

                arreglo.add("fechaCancelo", resultado.getString("fechaCancelo"));
                arreglo.add("usuarioEdito", resultado.getString("usuarioEdito"));

                arreglo.add("pacienteId", resultado.getString("pacienteId"));
                arreglo.add("nombrenombrePaciente", resultado.getString("nombrenombrePaciente"));
                arreglo.add("usuarioAtiende", resultado.getString("usuarioAtiende"));
                arreglo.add("estatusCitasId", resultado.getString("estatusCitasId"));
                return arreglo;
            }
            dbCon.close();
        } catch (SQLException e)
        {
            System.err.println("Error en obtener citas de tipo sql: " + e);
        }

        return null;
    }

    public static RSObjectArray setCitas(String citasId)
    {
        try
        {
            dbCon = ConectaBD.ConectaBD();
            sentencia = dbCon.prepareStatement("SELECT * FROM citas WHERE id = ?");
            sentencia.setString(1, citasId);
            resultado = sentencia.executeQuery();
            if (resultado.next())
            {
                RSObjectArray arreglo = new RSObjectArray();
                arreglo.add("id", resultado.getInt("id"));
                arreglo.add("fecha", resultado.getString("fecha"));
                arreglo.add("hora", resultado.getString("hora"));
                arreglo.add("estatusCitasId", resultado.getString("estatusCitasId"));

                arreglo.add("pacienteId", resultado.getString("pacienteId"));
                arreglo.add("nombrenombrePaciente", resultado.getString("nombrenombrePaciente"));
                arreglo.add("usuarioAtiende", resultado.getString("usuarioAtiende"));
                return arreglo;
            }
            dbCon.close();
        } catch (SQLException e)
        {
            System.err.println("Error em obtener pacientes de sql: " + e);
        }

        return null;
    }

    /**
     * Método que inserta unicamente citas dentro de la base de datos
     *
     * @param datos arreglo con los datos de la cita
     * @return true si la inserción se realizo con exito
     */
    public static boolean insertarCita(Object[] datos)
    {
        String columnas[] =
        {
            "pacienteId", "nombrenombrePaciente", "fecha", "hora", "estatusCitasId", "usuarioId", "servicioId", "fechaRegistro"
        };
        try
        {
            dbCon = ConectaBD.ConectaBD();
            sentencia = MetodosAux.SQLInserta("citas", columnas, datos, dbCon, sentencia);

            int r = sentencia.executeUpdate();

            if (r > 0)
            {
                return true;
            }
        } catch (SQLException e)
        {
            System.out.println("Error al insertar cita: " + e.toString());
        }
        return false;
    }

    /**
     * Método que lista la tabla de citas tomando como parametro el tipo de tab
     * que se seleccione y el filtro cuando se hace alguna busqueda filtrada
     *
     * @param tab 1 = Activos | 2 = Atendidas |3 = Canceladas | 0 = Todas las
     * citas
     * @param filtro parametro que contiene el dato especifico a buscar
     * (busqueda filtrada)
     * @return resultset con los pacientes hechos
     */
    public static ResultSet rsListarCitas(int tab, String filtro)
    {
        try
        {
            dbCon = ConectaBD.ConectaBD();
            if (tab != 0 && filtro.equals(""))
            {
                //Para el caso de que se seleccione activos o inactivos y no se haga busqueda
                sentencia = dbCon.prepareStatement("SELECT *,IF(estatusid=1,'Activo','Inactivo') AS estatusPac FROM citas WHERE estatus = ?");
                sentencia.setInt(1, tab);
            } else
            {
                //Estos querys falta corregirlos ya que no jalan citas, te jalan pacientes.
                String auxFiltro = filtro + "%";
                if (filtro != null && (tab == 1 || tab == 2))
                {
                    //Para el caso de que se seleccione activos o inactivos y se haga una busqueda
                    sentencia = dbCon.prepareStatement("SELECT *,IF(estatus=1,'Activo','Inactivo') AS estatusPac FROM citas WHERE estatus = ? AND (nombre LIKE ? OR apellidoPaterno LIKE ?)");
                    sentencia.setInt(1, tab);
                    sentencia.setString(2, (auxFiltro + "%"));
                    sentencia.setString(3, (auxFiltro + "%"));
                } else
                {
                    //Para el caso de que se entre en la pestaña de todos pero se haga una busqueda
                    if (tab == 0 && filtro != null)
                    {
                        sentencia = dbCon.prepareStatement("SELECT *,IF(estatus=1,'Activo','Inactivo') AS estatusPac FROM pacientes WHERE nombre LIKE ? OR apellidoPaterno LIKE ?");
                        sentencia.setString(1, (auxFiltro + "%"));
                        sentencia.setString(2, (auxFiltro + "%"));
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
            System.out.println("Error en obtener el ResultSet de Citas: " + e);
        }
        return null;
    }

    /**
     * Método que regresa la cantidad de citas y es auxiliar de la funcion de
     * los labels encargados de mostrar la cantidad de citas.
     *
     * @param tab el tipo de filtro de la cita 1 = Proxima | 2 = Atendida | 3 =
     * Canceladas
     * @return cantidad de citas seleccionados
     */
    public static int contarCitas(int tab)
    {
        int total = -1;
        try
        {
            dbCon = ConectaBD.ConectaBD();
            //Si se selecciona alguna tab (Activos o Inactivos)
            if (tab != 0)
            {
                sentencia = dbCon.prepareStatement("SELECT COUNT(*)AS total FROM citas WHERE estatusCitasId = ?");
                sentencia.setInt(1, tab);
            } else
            {
                //Si se entra dentro de consulta general es decir sin tab seleccionada
                sentencia = dbCon.prepareStatement("SELECT COUNT(*)AS total FROM citas");
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
            System.err.println("Error al contar Citas: " + e);
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
}
