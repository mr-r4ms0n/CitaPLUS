/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosBD;

import RSMaterialComponent.RSComboBox;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import metodosAux.MetodosAux;
import metodosAux.RSObjectArray;
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

    /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*METODOS PARA PACIENTES-*-*-*-*-*-*-*-*--*-*-*-*-*-*-*-*-*-*/
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
                    ret = new Object[6];
                    ret[0] = true;
                    byte[] imagen1 = null;
                    Blob i1 = resultado.getBlob("foto");
                    imagen1 = i1.getBytes(1, (int) i1.length());
                    ret[1] = resultado.getString("usuario");
                    ret[2] = resultado.getString("nombre") + " " + resultado.getString("apellidoPaterno") + " " + resultado.getString("apellidoMaterno");
                    ret[3] = imagen1;
                    ret[4] = resultado.getInt("estatus");
                    ret[5] = resultado.getInt("id");
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
     * Método que verifica que el campo que digite el usuario en alguna caja de
     * texto no exista en la base de datos, esto porque hay campos que son
     * unicos y no se deben repetir
     *
     * @param campo valor que el usuario esta digitando
     * @param tipoC tipo de campo unico nombre = 1, telefono = 2, correo = 3
     * @param tabla tabla donde se desea buscar
     * @return
     */
    public static boolean existeCampoRepet(String campo, String tipoC, String tabla)
    {
        try
        {
            dbCon = ConectaBD.ConectaBD();
            sentencia = dbCon.prepareStatement("SELECT * FROM " + tabla + " WHERE " + tipoC + " = ?");
            sentencia.setString(1, campo);
            resultado = sentencia.executeQuery();
            if (resultado.next())
            {
                return true;
            }
        } catch (SQLException e)
        {
            System.err.println("Error al verificar si exsite duplicidad de campos: " + e);
        }
        return false;
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

    /**
     * Método para actualizar el estatus de un cliente
     *
     * @param id
     * @param estatus
     * @return
     */
    public static boolean actualizarEstatusPaciente(int id, int estatus)
    {
        try
        {
            dbCon = ConectaBD.ConectaBD();

            sentencia = dbCon.prepareStatement("UPDATE pacientes SET estatus = ? WHERE id = ?");
            sentencia.setInt(1, estatus);
            sentencia.setInt(2, id);
            int rs = sentencia.executeUpdate();
            if (rs > 0)
            {
                return true;
            }
            dbCon.close();

        } catch (SQLException e)
        {
            System.err.println("Error al actualizar el status del paciente de tipo sql: " + e);
        }
        return false;
    }

    public static boolean actualizarPaciente(int id, Object[] datos)
    {
        try
        {
            if (datos[0] instanceof String)
            {
                String rutaImagen = datos[0].toString();
                System.out.println(rutaImagen);
                //La transformamos a fichero
                File fPerf = new File(rutaImagen);
                //La transformamos a fichero de enteada (binario)
                FileInputStream fIPerf = new FileInputStream(fPerf);
                //Reasignamos la foto codificada al arreglo y hacemos la insercion a la BD
                datos[0] = fIPerf;
            } else
            {
                InputStream myInputStream = new ByteArrayInputStream((byte[]) datos[0]);
                datos[0] = myInputStream;
            }
            dbCon = ConectaBD.ConectaBD();
            sentencia = dbCon.prepareStatement("UPDATE pacientes SET foto =?,nombre=?,apellidoPaterno=?,apellidoMaterno=?,sexo=?,telefono=?,correo=? WHERE id = ?");
            sentencia.setBinaryStream(1, (InputStream) datos[0]);
            sentencia.setString(2, datos[1].toString());
            sentencia.setString(3, datos[2].toString());
            sentencia.setString(4, datos[3].toString());
            sentencia.setString(5, datos[4].toString());
            sentencia.setString(6, datos[5].toString());
            sentencia.setString(7, datos[6].toString());
            sentencia.setInt(8, id);
            int rs = sentencia.executeUpdate();

            if (rs > 0)
            {
                return true;
            }

            dbCon.close();
        } catch (FileNotFoundException | SQLException e)
        {
            System.err.println("Error al actualizar o al cargar la imagen del paciente de tipo sql: " + e);
        }
        return false;
    }

    /**
     * Método que te muestra los datos para rellenar algun combo solicitado
     *
     * @param combo componente a rellenar
     * @param tipo tipo de combo que se desea rellenar
     */
    public static void mostrarDatosCombo(RSComboBox combo, String tipo)
    {
        //Consulta SQL
        try
        {
            //Conectar BD
            dbCon = ConectaBD.ConectaBD();
            sentencia = dbCon.prepareStatement("SELECT * FROM " + tipo + " WHERE estatus = ?");
            sentencia.setInt(1, 1);
            //Preparando consulta
            //compilando
            resultado = sentencia.executeQuery();

            if (tipo.equals("pacientes") || tipo.equals("usuarios"))
            {
                while (resultado.next())
                {
                    combo.addItem(resultado.getString("nombre") + " " + resultado.getString("apellidoPaterno") + " " + resultado.getString("apellidoMaterno"));
                }
            } else
            {
                while (resultado.next())
                {
                    combo.addItem(resultado.getString("nombre"));
                }
            }

            dbCon.close();
        } catch (SQLException e)
        {
            System.out.println("Error al llenar combobox de registrar citas: " + e);
        }
    }

    /**
     * Metoco para buscar el id del paciente usando el nombre completo
     *
     * @param nombre
     * @return
     */
    public static int buscarPacienteNombre(String nombre)
    {
        try
        {
            dbCon = ConectaBD.ConectaBD();
            //Concatenamos el nombre mas apellidos para que extraiga exactamente el deseado
            sentencia = dbCon.prepareStatement("SELECT id FROM pacientes WHERE CONCAT(nombre,' ',apellidoPaterno,' ',apellidoMaterno) = ?");
            sentencia.setString(1, nombre);
            //compilando
            resultado = sentencia.executeQuery();
            if (resultado.next())
            {
                return resultado.getInt("id");
            }

        } catch (NumberFormatException | SQLException e)
        {
            System.out.println("Error en obtener el id del paciente: " + e);
        }
        return -1;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-PARTE CITAS *-*-*-*-*-*-*-*-*-*-**-*-*-**-*-*-*-*-
    /**
     * Método que obtiene unicamente los datos de una cita para su edicion
     *
     * @param citasId
     * @return
     */
    public static RSObjectArray getCitas(String citasId)
    {
        try
        {
            dbCon = ConectaBD.ConectaBD();
            sentencia = dbCon.prepareStatement("SELECT citas.id,"
                    + "CONCAT(pacientes.nombre,' ',pacientes.apellidoPaterno,' ',IF(pacientes.apellidoMaterno='No Proporcionado','',pacientes.apellidoMaterno)) AS NombreP, "
                    + "fechaCita AS fechaC, "
                    + "time_format(horaCita, \"%H:%i\") AS horaC, "
                    + "CONCAT(usuarios.nombre,' ',usuarios.apellidoPaterno,' ',IF(usuarios.apellidoMaterno='No Proporcionado','',usuarios.apellidoMaterno)) AS NombreAtiende, "
                    + "(CASE WHEN estatusCitasId = 1 THEN 'Proxima' WHEN  estatusCitasId = 2 THEN 'Atendida' WHEN  estatusCitasId = 3 THEN 'Cancelada' END) AS estatusCita, "
                    + "servicios.nombre AS servicioN, "
                    + "IFNULL(fechaEdito,'Sin Editar') AS FechaEdito, "
                    + "IFNULL(citas.fechaRegistro,'Sin Registrar') AS FechaR, "
                    + "IFNULL(citas.fechaCancelo,'Sin Cancelar') AS FechaCan, "
                    + "IFNULL(citas.fechaAtendida,'Sin Atender')AS FechaAtend, "
                    + "IFNULL(citas.descripcionCancelo,'Sin Cancelar')AS DescCancel, "
                    + "IFNULL((SELECT CONCAT(usuarios.nombre,' ',usuarios.apellidoPaterno,' ',IF(usuarios.apellidoMaterno='No Proporcionado','',usuarios.apellidoMaterno)) AS NombreCompleto FROM usuarios WHERE usuarios.id = usuarioEdito),'No Registrado') AS NombreEdito, "
                    + "IFNULL((SELECT CONCAT(usuarios.nombre,' ',usuarios.apellidoPaterno,' ',IF(usuarios.apellidoMaterno='No Proporcionado','',usuarios.apellidoMaterno)) AS NombreCompleto2 FROM usuarios WHERE usuarios.id = usuarioId),'No Registrado') AS NombreRegistro, "
                    + "IFNULL((SELECT CONCAT(usuarios.nombre,' ',usuarios.apellidoPaterno,' ',IF(usuarios.apellidoMaterno='No Proporcionado','',usuarios.apellidoMaterno)) AS NombreCompleto2 FROM usuarios WHERE usuarios.id = usuarioAtiende),'No Registrado') AS NombreAtiende "
                    + "FROM citas "
                    + "INNER JOIN pacientes ON pacientes.id = pacienteId "
                    + "INNER JOIN usuarios ON usuarios.id = usuarioId "
                    + "INNER JOIN servicios ON servicios.id = servicioId "
                    + "WHERE citas.id = ?");
            sentencia.setString(1, citasId);
            resultado = sentencia.executeQuery();
            if (resultado.next())
            {
                RSObjectArray arreglo = new RSObjectArray();
                arreglo.add("id", resultado.getInt("id"));
                arreglo.add("nombrePaciente", resultado.getString("NombreP"));
                arreglo.add("fechaCita", resultado.getDate("fechaC"));
                arreglo.add("horaCita", resultado.getString("horaC"));
                arreglo.add("nombreUsuario", resultado.getString("NombreAtiende"));
                arreglo.add("estatusCita", resultado.getString("estatusCita"));
                arreglo.add("nombreServicio", resultado.getString("servicioN"));
                arreglo.add("fechaEdito", resultado.getString("FechaEdito"));
                arreglo.add("fechaRegistro", resultado.getString("FechaR"));
                arreglo.add("fechaCancelo", resultado.getString("FechaCan"));
                arreglo.add("fechaAtendida", resultado.getString("FechaAtend"));
                arreglo.add("descripcionCancelo", resultado.getString("DescCancel"));
                arreglo.add("usuarioEdito", resultado.getString("NombreEdito"));
                arreglo.add("usuarioRegistro", resultado.getString("NombreRegistro"));
                arreglo.add("usuarioAtendio", resultado.getString("NombreAtiende"));
                return arreglo;
            }
            dbCon.close();
        } catch (SQLException e)
        {
            System.err.println("Error en obtener la cita de forma individual de tipo sql: " + e);
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
            "pacienteId", "fechaRegistro", "fechaCita", "horaCita", "usuarioId", "servicioId"
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
                //Para el caso de que se seleccione proximas, atendidas o canceladas y no se haga busqueda
                sentencia = dbCon.prepareStatement("SELECT citas.id,CONCAT(pacientes.nombre,' ',pacientes.apellidoPaterno,' ',IF(pacientes.apellidoMaterno='No Proporcionado','',pacientes.apellidoMaterno)) AS NombreP,"
                        + "fechaCita AS fechaC,"
                        + "time_format(horaCita, \"%H:%i\") AS horaC,"
                        + "CONCAT(usuarios.nombre,' ',usuarios.apellidoPaterno,' ',IF(usuarios.apellidoMaterno='No Proporcionado','',usuarios.apellidoMaterno)) AS NombreAtiende,"
                        + "(CASE WHEN  estatusCitasId = 1 THEN 'Proxima' WHEN  estatusCitasId = 2 THEN 'Atendida' WHEN  estatusCitasId = 3 THEN 'Cancelada' END) AS estatusCita,"
                        + "servicios.nombre AS servicioN "
                        + "FROM citas "
                        + "INNER JOIN pacientes ON pacientes.id = pacienteId "
                        + "INNER JOIN usuarios ON usuarios.id = usuarioId "
                        + "INNER JOIN servicios ON servicios.id = servicioId "
                        + "WHERE estatusCitasId = ?");
                sentencia.setInt(1, tab);
            } else
            {
                String auxfiltro = "%" + filtro + "%";
                //Fase de pruebas
                if (filtro != null && (tab == 1 || tab == 2 || tab == 3))
                {
                    //Para el caso de que se seleccione activos o inactivos y se haga una busqueda
                    sentencia = dbCon.prepareStatement("SELECT citas.id,CONCAT(pacientes.nombre,' ',pacientes.apellidoPaterno,' ',IF(pacientes.apellidoMaterno='No Proporcionado','',pacientes.apellidoMaterno)) AS NombreP,"
                            + "fechaCita AS fechaC,"
                            + "time_format(horaCita, \"%H:%i\") AS horaC,"
                            + "CONCAT(usuarios.nombre,' ',usuarios.apellidoPaterno,' ',IF(usuarios.apellidoMaterno='No Proporcionado','',usuarios.apellidoMaterno)) AS NombreAtiende,"
                            + "(CASE WHEN  estatusCitasId = 1 THEN 'Proxima' WHEN  estatusCitasId = 2 THEN 'Atendida' WHEN  estatusCitasId = 3 THEN 'Cancelada' END) AS estatusCita,"
                            + "servicios.nombre AS servicioN "
                            + "FROM citas "
                            + "INNER JOIN pacientes ON pacientes.nombre LIKE ? AND pacientes.id = pacienteId "
                            + "INNER JOIN usuarios ON usuarios.id = usuarioId "
                            + "INNER JOIN servicios ON servicios.id = servicioId "
                            + "WHERE estatusCitasId = ?");
                    sentencia.setString(1, auxfiltro);
                    sentencia.setInt(2, tab);
                } else
                {
                    //Para el caso de que se entre en la pestaña de todos pero se haga una busqueda
                    if (tab == 0 && filtro != null)
                    {
                        System.out.println("ENTROOO");
                        sentencia = dbCon.prepareStatement("SELECT citas.id,CONCAT(pacientes.nombre,' ',pacientes.apellidoPaterno,' ',IF(pacientes.apellidoMaterno='No Proporcionado','',pacientes.apellidoMaterno)) AS NombreP,"
                                + "fechaCita AS fechaC,"
                                + "time_format(horaCita, \"%H:%i\") AS horaC,"
                                + "CONCAT(usuarios.nombre,' ',usuarios.apellidoPaterno,' ',IF(usuarios.apellidoMaterno='No Proporcionado','',usuarios.apellidoMaterno)) AS NombreAtiende,"
                                + "(CASE WHEN  estatusCitasId = 1 THEN 'Proxima' WHEN  estatusCitasId = 2 THEN 'Atendida' WHEN  estatusCitasId = 3 THEN 'Cancelada' END) AS estatusCita,"
                                + "servicios.nombre AS servicioN "
                                + "FROM citas "
                                + "INNER JOIN pacientes ON pacientes.nombre LIKE ? AND pacientes.id = pacienteId "
                                + "INNER JOIN usuarios ON usuarios.id = usuarioId "
                                + "INNER JOIN servicios ON servicios.id = servicioId ");
                        sentencia.setString(1, auxfiltro);
                    } else
                    {
                        //Para el caso de que se entre en la pestaña de todos y no se consulten busquedas
                        sentencia = dbCon.prepareStatement("SELECT citas.id,CONCAT(pacientes.nombre,' ',pacientes.apellidoPaterno,' ',IF(pacientes.apellidoMaterno='No Proporcionado','',pacientes.apellidoMaterno)) AS NombreP,"
                                + "fechaCita AS fechaC,"
                                + "time_format(horaCita, \"%H:%i\") AS horaC,"
                                + "CONCAT(usuarios.nombre,' ',usuarios.apellidoPaterno,' ',IF(usuarios.apellidoMaterno='No Proporcionado','',usuarios.apellidoMaterno)) AS NombreAtiende,"
                                + "(CASE WHEN  estatusCitasId = 1 THEN 'Proxima' WHEN  estatusCitasId = 2 THEN 'Atendida' WHEN  estatusCitasId = 3 THEN 'Cancelada' END) AS estatusCita,"
                                + "servicios.nombre AS servicioN "
                                + "FROM citas "
                                + "INNER JOIN pacientes ON pacientes.id = pacienteId "
                                + "INNER JOIN usuarios ON usuarios.id = usuarioId "
                                + "INNER JOIN servicios ON servicios.id = servicioId ");
                    }
                }
            }
            resultado = sentencia.executeQuery();
            if (checkResultSet(resultado))
            {
                return resultado;
            } else
            {

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
                System.out.println("Error al cerrar la conexion en el metodo de contar citas" + ex);
            }
        }
        return total;
    }

    public static boolean actualizarCita(Object[] datos, int id)
    {
        try
        {
            dbCon = ConectaBD.ConectaBD();
            sentencia = dbCon.prepareStatement("UPDATE citas SET pacienteId =?,fechaCita=?,horaCita=?,usuarioId=?,servicioId=?,usuarioEdito=?,fechaEdito=? WHERE id = ?");
            sentencia.setInt(1, (int) datos[0]);
            sentencia.setString(2, datos[1].toString());
            sentencia.setTime(3, (Time) datos[2]);
            sentencia.setInt(4, (int) datos[3]);
            sentencia.setInt(5, (int) datos[4]);
            sentencia.setInt(6, (int) datos[5]);
            sentencia.setString(7, datos[6].toString());
            sentencia.setInt(8, id);
            int rs = sentencia.executeUpdate();

            if (rs > 0)
            {
                return true;
            }

            dbCon.close();
        } catch (SQLException e)
        {
            System.err.println("Error al actualizar citas de tipo sql: " + e);
        }
        return false;
    }

    /**
     * Método para establecer el estatus de una cita como atendida o cancelada
     * @param arr
     * @return 
     */
    public static boolean actualizarEstatusCita(Object arr[])
    {
        try
        {
            dbCon = ConectaBD.ConectaBD();
            switch ((int) arr[0])
            {
                //Parte para establecer el estado de atendida a una cita.
                case 2:
                    sentencia = dbCon.prepareStatement("UPDATE citas SET estatusCitasId = ?,usuarioAtiende = ?,fechaAtendida = ? WHERE id = ?");
                    sentencia.setInt(1, (int) arr[0]);
                    sentencia.setInt(2, (int) arr[1]);
                    sentencia.setString(3, arr[2].toString());
                    sentencia.setInt(4, (int) arr[3]);
                    break;
                //Parte para establecer el estado de cancelada a una cita.
                case 3:
                    sentencia = dbCon.prepareStatement("UPDATE citas SET estatusCitasId = ?,descripcionCancelo = ?,fechaCancelo=? WHERE id = ?");
                    sentencia.setInt(1, (int) arr[0]);
                    sentencia.setString(2, arr[1].toString());
                    sentencia.setString(3, arr[2].toString());
                    sentencia.setInt(4, (int) arr[3]);
                    break;
            }

            int rs = sentencia.executeUpdate();
            if (rs > 0)
            {
                return true;
            }
            dbCon.close();

        } catch (SQLException e)
        {
            System.err.println("Error al actualizar el status del usuario de tipo sql: " + e);
        }
        return false;
    }

    //*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-PARTE USUARIOS *-*-*-*-*-*-*-*-*-*-**-*-*-**-*-*-*-*-
    public static ResultSet rsListarUsuarios(int tab, String filtro)
    {
        try
        {
            dbCon = ConectaBD.ConectaBD();
            if (tab != 0 && filtro.equals(""))
            {
                //Para el caso de que se seleccione activos o inactivos y no se haga busqueda
                sentencia = dbCon.prepareStatement("SELECT *,IF(estatus=1,'Activo','Inactivo') AS estatusUsr FROM usuarios WHERE estatus = ?");
                sentencia.setInt(1, tab);
            } else
            {
                String auxFiltro = filtro + "%";
                if (filtro != null && (tab == 1 || tab == 2))
                {
                    //Para el caso de que se seleccione activos o inactivos y se haga una busqueda
                    sentencia = dbCon.prepareStatement("SELECT *,IF(estatus=1,'Activo','Inactivo') AS estatusUsr FROM usuarios WHERE estatus = ? AND (nombre LIKE ? OR apellidoPaterno LIKE ? OR usuario LIKE ?)");
                    sentencia.setInt(1, tab);
                    sentencia.setString(2, (auxFiltro + "%"));
                    sentencia.setString(3, (auxFiltro + "%"));
                    sentencia.setString(4, (auxFiltro + "%"));
                } else
                {
                    //Para el caso de que se entre en la pestaña de todos pero se haga una busqueda
                    if (tab == 0 && filtro != null)
                    {
                        sentencia = dbCon.prepareStatement("SELECT *,IF(estatus=1,'Activo','Inactivo') AS estatusUsr FROM usuarios WHERE nombre LIKE ? OR apellidoPaterno LIKE ? OR usuario LIKE ?");
                        sentencia.setString(1, (auxFiltro + "%"));
                        sentencia.setString(2, (auxFiltro + "%"));
                        sentencia.setString(3, (auxFiltro + "%"));
                    } else
                    {
                        //Para el caso de que se entre en la pestaña de todos y no se consulten busquedas
                        sentencia = dbCon.prepareStatement("SELECT *,IF(estatus=1,'Activo','Inactivo') AS estatusUsr FROM usuarios");
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
            System.out.println("Error en obtener el ResultSet de Usuarios: " + e);
        }
        return null;
    }

    public static int contarUsuarios(int tab)
    {
        int total = -1;
        try
        {
            dbCon = ConectaBD.ConectaBD();
            //Si se selecciona alguna tab (Activos o Inactivos)
            if (tab != 0)
            {
                sentencia = dbCon.prepareStatement("SELECT COUNT(*)AS total FROM usuarios WHERE estatus = ?");
                sentencia.setInt(1, tab);
            } else
            {
                //Si se entra dentro de consulta general es decir sin tab seleccionada
                sentencia = dbCon.prepareStatement("SELECT COUNT(*)AS total FROM usuarios");
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
            System.err.println("Error al contar Usuarios: " + e);
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

    public static boolean actualizarEstatusUsuario(int id, int estatus)
    {
        try
        {
            dbCon = ConectaBD.ConectaBD();

            sentencia = dbCon.prepareStatement("UPDATE usuarios SET estatus = ? WHERE id = ?");
            sentencia.setInt(1, estatus);
            sentencia.setInt(2, id);
            int rs = sentencia.executeUpdate();
            if (rs > 0)
            {
                return true;
            }
            dbCon.close();

        } catch (SQLException e)
        {
            System.err.println("Error al actualizar el status del usuario de tipo sql: " + e);
        }
        return false;
    }

    public static boolean actualizarUsuario(int id, Object[] datos)
    {
        try
        {
            if (datos[6] instanceof String)
            {
                String rutaImagen = datos[6].toString();
                System.out.println(rutaImagen);
                //La transformamos a fichero
                File fPerf = new File(rutaImagen);
                //La transformamos a fichero de enteada (binario)
                FileInputStream fIPerf = new FileInputStream(fPerf);
                //Reasignamos la foto codificada al arreglo y hacemos la insercion a la BD
                datos[6] = fIPerf;
            } else
            {

                InputStream myInputStream = new ByteArrayInputStream((byte[]) datos[6]);
                datos[6] = myInputStream;

            }
            dbCon = ConectaBD.ConectaBD();
            sentencia = dbCon.prepareStatement("UPDATE usuarios SET usuario = ?, nombre =?, apellidoPaterno=?,apellidoMaterno=?,contraseña=?,sexo=?,foto=? WHERE id = ?");
            sentencia.setString(1, datos[0].toString());
            sentencia.setString(2, datos[1].toString());
            sentencia.setString(3, datos[2].toString());
            sentencia.setString(4, datos[3].toString());
            sentencia.setString(5, datos[4].toString());
            sentencia.setString(6, datos[5].toString());
            sentencia.setBinaryStream(7, (InputStream) datos[6]);
            sentencia.setInt(8, id);
            int rs = sentencia.executeUpdate();

            if (rs > 0)
            {
                return true;
            }

            dbCon.close();
        } catch (FileNotFoundException | SQLException e)
        {
            System.err.println("Error al actualizar o al cargar la imagen del usuario de tipo sql: " + e);
        }
        return false;
    }

    public static boolean insertarUsuario(Object[] datos)
    {
        String columnas[] =
        {
            "usuario", "nombre", "apellidoPaterno", "apellidoMaterno", "contraseña", "sexo", "foto"
        };
        try
        {
            //Vemos que la ruta de la imagen este correcta
            String rutaImagen = (String) datos[6];
            System.out.println(rutaImagen);
            //La transformamos a fichero
            File fPerf = new File(rutaImagen);
            //La transformamos a fichero de enteada (binario)
            FileInputStream fIPerf = new FileInputStream(fPerf);
            //Reasignamos la foto codificada al arreglo y hacemos la insercion a la BD
            datos[6] = fIPerf;
            dbCon = ConectaBD.ConectaBD();

            sentencia = MetodosAux.SQLInserta("usuarios", columnas, datos, dbCon, sentencia);

            int r = sentencia.executeUpdate();

            if (r > 0)
            {
                return true;
            }
        } catch (SQLException e)
        {
            System.out.println("Error al insertar usuario: " + e.toString());
        } catch (FileNotFoundException ex)
        {
            System.out.println("Error al obtener la imagen : " + ex.toString());
        }
        return false;
    }

    public static RSObjectArray getUsuario(String usuarioId)
    {
        try
        {
            dbCon = ConectaBD.ConectaBD();
            sentencia = dbCon.prepareStatement("SELECT * FROM usuarios WHERE id = ?");
            sentencia.setString(1, usuarioId);
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
                    arreglo.add("usuario", resultado.getString("usuario"));
                    arreglo.add("nombre", resultado.getString("nombre"));
                    arreglo.add("apellidoPaterno", resultado.getString("apellidoPaterno"));
                    arreglo.add("apellidoMaterno", resultado.getString("apellidoMaterno"));
                    arreglo.add("contraseña", Encoder.deencode(resultado.getString("contraseña")));
                    int estado = resultado.getInt("estatus");
                    String estadoCad = (estado == 1) ? "Activo" : "Inactivo"; //Para que entiendas por si lees el codigo xd, si el estado es 1 entonces estadocad sera activo, sino sera inactivo.
                    arreglo.add("estatus", estadoCad);
                    arreglo.add("sexo", resultado.getString("sexo"));
                    arreglo.add("foto", imagen1);
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
     * Metoco para buscar el id del paciente usando el nombre completo
     *
     * @param nombre
     * @return
     */
    public static int buscarUsuarioNombre(String nombre)
    {
        try
        {
            dbCon = ConectaBD.ConectaBD();
            //Concatenamos el nombre mas apellidos para que extraiga exactamente el deseado
            sentencia = dbCon.prepareStatement("SELECT id FROM usuarios WHERE CONCAT(nombre,' ',apellidoPaterno,' ',apellidoMaterno) = ?");
            sentencia.setString(1, nombre);
            //compilando
            resultado = sentencia.executeQuery();
            if (resultado.next())
            {
                return resultado.getInt("id");
            }

        } catch (NumberFormatException | SQLException e)
        {
            System.out.println("Error en obtener el id del usuario: " + e);
        }
        return -1;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-Parte de servicios*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-//
    public static ResultSet rsListarServicios(int tab, String filtro)
    {
        try
        {
            dbCon = ConectaBD.ConectaBD();
            if (tab != 0 && filtro.equals(""))
            {
                //Para el caso de que se seleccione activos o inactivos y no se haga busqueda
                sentencia = dbCon.prepareStatement("SELECT servicios.id,servicios.nombre,servicios.descripcion, IF(servicios.estatus=1,'Activo','Inactivo') AS estatusSer, "
                        + "CONCAT(usuarios.nombre,' ',usuarios.apellidoPaterno,' ',usuarios.apellidoMaterno) AS nombreU,servicios.fechaRegistro "
                        + "FROM servicios INNER JOIN usuarios ON usuarios.id = servicios.usuarioRegistro AND servicios.estatus = ?");
                sentencia.setInt(1, tab);
            } else
            {
                String auxFiltro = filtro + "%";
                if (filtro != null && (tab == 1 || tab == 2))
                {
                    //Para el caso de que se seleccione activos o inactivos y se haga una busqueda
                    sentencia = dbCon.prepareStatement("SELECT servicios.id,servicios.nombre,servicios.descripcion, IF(servicios.estatus=1,'Activo','Inactivo') AS estatusSer, "
                            + "CONCAT(usuarios.nombre,' ',usuarios.apellidoPaterno,' ',usuarios.apellidoMaterno) AS nombreU,servicios.fechaRegistro "
                            + "FROM servicios INNER JOIN usuarios ON usuarios.id = servicios.usuarioRegistro AND servicios.estatus = ? AND (servicios.nombre LIKE ? OR servicios.descripcion LIKE ?)");
                    sentencia.setInt(1, tab);
                    sentencia.setString(2, (auxFiltro + "%"));
                    sentencia.setString(3, (auxFiltro + "%"));
                } else
                {
                    //Para el caso de que se entre en la pestaña de todos pero se haga una busqueda
                    if (tab == 0 && filtro != null)
                    {
                        sentencia = dbCon.prepareStatement("SELECT servicios.id,servicios.nombre,servicios.descripcion, IF(servicios.estatus=1,'Activo','Inactivo') AS estatusSer, "
                                + "CONCAT(usuarios.nombre,' ',usuarios.apellidoPaterno,' ',usuarios.apellidoMaterno) AS nombreU,servicios.fechaRegistro "
                                + "FROM servicios INNER JOIN usuarios ON usuarios.id = servicios.usuarioRegistro AND (servicios.nombre LIKE ? OR servicios.descripcion LIKE ?)");
                        sentencia.setString(1, (auxFiltro + "%"));
                        sentencia.setString(2, (auxFiltro + "%"));
                    } else
                    {
                        //Para el caso de que se entre en la pestaña de todos y no se consulten busquedas
                        sentencia = dbCon.prepareStatement("SELECT servicios.id,servicios.nombre,servicios.descripcion, IF(servicios.estatus=1,'Activo','Inactivo') AS estatusSer, "
                                + "CONCAT(usuarios.nombre,' ',usuarios.apellidoPaterno,' ',usuarios.apellidoMaterno) AS nombreU,servicios.fechaRegistro "
                                + "FROM servicios INNER JOIN usuarios ON usuarios.id = servicios.usuarioRegistro");
                    }

                }

            }
            resultado = sentencia.executeQuery();
            if (checkResultSet(resultado))
            {
                //resultado.next();
                //System.out.println(resultado.getString("id") + resultado.getString("nombre") + resultado.getString("descripcion")+resultado.getString("estatusSer")+resultado.getString("nombreU")+ resultado.getString("fechaRegistro"));
                return resultado;
            }
            dbCon.close();
        } catch (SQLException e)
        {
            System.out.println("Error en obtener el ResultSet de Servicios: " + e);
        }
        return null;
    }

    public static int contarServicios(int tab)
    {
        int total = -1;
        try
        {
            dbCon = ConectaBD.ConectaBD();
            //Si se selecciona alguna tab (Activos o Inactivos)
            if (tab != 0)
            {
                sentencia = dbCon.prepareStatement("SELECT COUNT(*)AS total FROM servicios WHERE estatus = ?");
                sentencia.setInt(1, tab);
            } else
            {
                //Si se entra dentro de consulta general es decir sin tab seleccionada
                sentencia = dbCon.prepareStatement("SELECT COUNT(*)AS total FROM servicios");
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
            System.err.println("Error al contar Servicios: " + e);
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

    public static boolean actualizarEstatusServicio(int id, int estatus)
    {
        try
        {
            dbCon = ConectaBD.ConectaBD();

            sentencia = dbCon.prepareStatement("UPDATE servicios SET estatus = ? WHERE id = ?");
            sentencia.setInt(1, estatus);
            sentencia.setInt(2, id);
            int rs = sentencia.executeUpdate();
            if (rs > 0)
            {
                return true;
            }
            dbCon.close();

        } catch (SQLException e)
        {
            System.err.println("Error al actualizar el status del servicio de tipo sql: " + e);
        }
        return false;
    }

    public static boolean actualizarServicio(int id, Object[] datos)
    {
        try
        {
            dbCon = ConectaBD.ConectaBD();
            sentencia = dbCon.prepareStatement("UPDATE servicios SET nombre = ?, descripcion = ?, usuarioRegistro = ?, fechaRegistro = ? WHERE id = ?");
            sentencia.setString(1, datos[0].toString());
            sentencia.setString(2, datos[1].toString());
            sentencia.setInt(3, (int) datos[2]);
            sentencia.setString(4, datos[3].toString());
            sentencia.setInt(5, id);
            int rs = sentencia.executeUpdate();

            if (rs > 0)
            {
                return true;
            }

            dbCon.close();
        } catch (SQLException e)
        {
            System.err.println("Error al actualizar o al cargar la imagen del usuario de tipo sql: " + e);
        }
        return false;
    }

    public static boolean insertarServicio(Object[] datos)
    {
        String columnas[] =
        {
            "nombre", "descripcion", "usuarioRegistro", "fechaRegistro"
        };
        try
        {
            dbCon = ConectaBD.ConectaBD();

            sentencia = MetodosAux.SQLInserta("servicios", columnas, datos, dbCon, sentencia);

            int r = sentencia.executeUpdate();

            if (r > 0)
            {
                return true;
            }
        } catch (SQLException e)
        {
            System.out.println("Error al insertar servicio: " + e.toString());
        }
        return false;
    }

    public static RSObjectArray getServicio(String servicioId)
    {
        try
        {
            dbCon = ConectaBD.ConectaBD();
            sentencia = dbCon.prepareStatement("SELECT CONCAT(usuarios.nombre,' ',usuarios.apellidoPaterno,' ',usuarios.apellidoMaterno) AS nombreUsr, servicios.* "
                    + "FROM servicios INNER JOIN usuarios ON usuarios.id = servicios.usuarioRegistro AND servicios.id = ?");

            sentencia.setString(1, servicioId);
            resultado = sentencia.executeQuery();
            if (resultado.next())
            {
                RSObjectArray arreglo = new RSObjectArray();
                arreglo.add("nombreUsr", resultado.getString("nombreUsr"));
                arreglo.add("id", resultado.getInt("id"));
                arreglo.add("nombreServ", resultado.getString("nombre"));
                arreglo.add("descripcion", resultado.getString("descripcion"));
                int estado = resultado.getInt("estatus");
                String estadoCad = (estado == 1) ? "Activo" : "Inactivo";
                arreglo.add("estatus", estadoCad);
                arreglo.add("FechaReg", resultado.getString("fechaRegistro"));
                return arreglo;
            }
            dbCon.close();
        } catch (SQLException e)
        {
            System.err.println("Error en obtener servicio de tipo sql: " + e);
        }

        return null;
    }

    /**
     * Metoco para buscar el id del paciente usando el nombre completo
     *
     * @param nombre
     * @return
     */
    public static int buscarServicioNombre(String nombre)
    {
        try
        {
            dbCon = ConectaBD.ConectaBD();
            //Concatenamos el nombre mas apellidos para que extraiga exactamente el deseado
            sentencia = dbCon.prepareStatement("SELECT id FROM servicios WHERE nombre = ?");
            sentencia.setString(1, nombre);
            //compilando
            resultado = sentencia.executeQuery();
            if (resultado.next())
            {
                return resultado.getInt("id");
            }

        } catch (NumberFormatException | SQLException e)
        {
            System.out.println("Error en obtener el id del servicio: " + e);
        }
        return -1;
    }

}
