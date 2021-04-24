/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosAux;

import RSMaterialComponent.RSComboBox;
import RSMaterialComponent.RSTableMetroCustom;
import RSMaterialComponent.RSTextFieldOne;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kevin
 */
public class MetodosAux
{

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
                        datos[i] = rs.getObject(columnas[i]);
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

    public static PreparedStatement generaSQLInsercion(String tabla, String columnas[], Object datos[], Connection dbC, PreparedStatement sentencia)
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
                    sentencia.setString((i+1), (String) datos[i]);
                }
                if (datos[i] instanceof Integer)
                {
                    sentencia.setInt((i+1), (int) datos[i]);
                }
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(MetodosAux.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sentencia;
    }
    
    public static String getFecha()
    {
        DateTimeFormatter dff = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dff.format(now);
    }

    public static boolean validarFormu(RSTextFieldOne field, JLabel error, String tipo)
    {
        boolean resultado = false;
        switch (tipo)
        {
            case "required":
                if (field.getText().trim().isEmpty())
                {
                    error.setText("Este campo es requerido");
                    error.setForeground(ColoresSys.bg_danger);
                } else
                {
                    error.setForeground(ColoresSys.bg_white);
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
                    error.setForeground(ColoresSys.bg_danger);
                } else
                {
                    error.setForeground(ColoresSys.bg_white);
                    resultado = true;
                }
                break;
        }
        return resultado;
    }
}
