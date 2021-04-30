/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosAux;

import RSMaterialComponent.RSComboBox;
import RSMaterialComponent.RSTableMetroCustom;
import RSMaterialComponent.RSTextFieldOne;
import formularios_Registros.FormPacientes;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kevin
 */
public class MetodosAux
{

    /**
     * Método generico que enlista cualquier tabla
     *
     * @param rs ResultSet con los datos extraidos de la consulta previa a la
     * base de datos
     * @param tabla Modelo de la tabla que se rellenara con los datos
     * @param columnas Columnas de la tabla en la base de datos
     */
    public static void listarTablas(ResultSet rs, RSTableMetroCustom tabla, String columnas[])
    {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        //Limpiamos la tabla para evitar cualquier error
        while (modelo.getRowCount() > 0)
        {
            modelo.removeRow(0);
        }

        try
        {
            if (rs != null)
            {
                Object datos[] = new Object[columnas.length];
                while (rs.next())
                {
                    for (int i = 0; i < columnas.length; i++)
                    {
                        //Cuando en el llenado se encuentra con la columna de los botones la deja vacia
                        if (columnas[i].equals("accion"))
                        {
                            datos[i] = "";
                        } else
                        {
                            //Si no es la columna de los botones entonces llenamos la columna con la informacion que se encuentre
                            datos[i] = rs.getObject(columnas[i]);
                        }

                    }
                    modelo.addRow(datos);
                }
            } else
            {
                JOptionPane.showMessageDialog(null, "No hay datos en la tabla requerida");
            }

        } catch (SQLException e)
        {
            System.out.println("Error al listar tabla: " + e);
        }
    }

    /**
     * Método general que inserta datos en cualquier tabla
     *
     * @param tabla nombre de la tabla donde se hara el INSERT
     * @param columnas columnas de la tabla (Nombres en la base de datos)
     * @param datos datos que se insertatan (Valores)
     * @param dbC conexion instanciada previamente
     * @param sentencia PreparedStatement al que se le asignara el Query final
     * @return PreparedStatement listo para insertarse
     */
    public static PreparedStatement SQLInserta(String tabla, String columnas[], Object datos[], Connection dbC, PreparedStatement sentencia)
    {
        String sql = "INSERT INTO " + tabla + " (";
        //Primero armamos la parte de los atributos a insertar
        for (int i = 0; i < columnas.length; i++)
        {
            //Para la posicion ultima a insertar
            if (i == (columnas.length - 1))
            {
                sql += columnas[i];
            } else
            {
                sql += columnas[i] + ", ";
            }
        }
        // INSERT INTO "INSERT INTO person (name, email) values (?, ?)"

        //Despues se arma la insercion de los VALUES junto al anti sql injection
        sql += ") VALUES (";

        for (int i = 0; i < datos.length; i++)
        {
            if (i == (datos.length - 1))
            {
                sql += "?";
            } else
            {
                sql += "?, ";
            }
        }

        sql += ") ";

        try
        {
            sentencia = dbC.prepareStatement(sql);
            for (int i = 0; i < datos.length; i++)
            {
                if (datos[i] instanceof String)
                {
                    sentencia.setString((i + 1), (String) datos[i]);
                }
                if (datos[i] instanceof Integer)
                {
                    sentencia.setInt((i + 1), (int) datos[i]);
                }
                if (datos[i] instanceof FileInputStream)
                {
                    sentencia.setBinaryStream((i + 1), (InputStream) datos[i]);
                }
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(MetodosAux.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sentencia;
    }

    /**
     * Método encargado de obtener la fecha y hota actual
     *
     * @return fecha formateada
     */
    public static String getFecha()
    {
        DateTimeFormatter dff = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        return dff.format(now);
    }

    /**
     * Método encargado de validar que un TextField no este vacio
     *
     * @param field TextField a validar
     * @param error Label donde se mostrara el error si esta vacio
     * @param tipo Parametro para identificar si es requerido o no
     * @return true si no esta vacio | false si esta vacio
     */
    public static boolean validarFormu(RSTextFieldOne field, JLabel error, String tipo)
    {
        boolean resultado = false;
        switch (tipo)
        {
            case "required":
                if (field.getText().trim().isEmpty())
                {
                    error.setText("Este campo es requerido");
                    error.setForeground(SysConfigs.bg_danger);
                } else
                {
                    error.setForeground(SysConfigs.bg_white);
                    resultado = true;
                }
                break;
        }
        return resultado;
    }

    /**
     * Método usado para validar que el index de un combobox sea distinto de
     * default o 0
     *
     * @param field combobox a evaluar
     * @param error label donde se mostrara el error en dado caso de existir
     * @param tipo tipo de validacion que se requiere
     * @return
     */
    public static boolean validarBox(RSComboBox field, JLabel error, String tipo)
    {
        boolean resultado = false;
        switch (tipo)
        {
            case "required":
                if (field.getSelectedIndex() == 0)
                {
                    error.setText("Este campo es requerido");
                    error.setForeground(SysConfigs.bg_danger);
                } else
                {
                    error.setForeground(SysConfigs.bg_white);
                    resultado = true;
                }
                break;
        }
        return resultado;
    }

    public static String getFoto(JDialog jd)
    {
        //Esta parte es para que nuestro jfilechooser se vea como una ventana de windows
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(FormPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(FormPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(FormPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(FormPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG", "jpg", "png");
        fc.setFileFilter(filtro);
        int res = fc.showOpenDialog(jd);
        if (res == JFileChooser.APPROVE_OPTION)
        {
            String ruta = fc.getSelectedFile().getPath();

            return ruta;
        }
        return null;
    }

    public static void copiarImagen(String origen, String destino)
    {
        Path orig = Paths.get(origen);
        Path desti = Paths.get(destino);

        CopyOption[] opciones =
        {
            StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES
        };

        try
        {
            Files.copy(orig, desti, opciones);
        } catch (IOException e)
        {
            System.err.println("Error al copiar la imagen: " + e);
        }

    }
}
