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
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kevin
 */
public class MetodosAux
{

    public static Color bg_primary = new Color(1, 56, 228);
    public static Color bg_success = new Color(40, 167, 69);
    public static Color bg_danger = new Color(220, 53, 69);
    public static Color bg_warning = new Color(255, 136, 0);
    public static Color bg_info = new Color(51, 181, 229);
    public static Color bg_white = new Color(255, 255, 255);

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

    public static String validarFormu(RSTextFieldOne field, JLabel error, String tipo)
    {
        String resultado = "error";
        switch (tipo)
        {
            case "requerid":
                if (field.getText().equals(""))
                {
                    error.setText("Este campo es requerido");
                    error.setForeground(MetodosAux.bg_danger);
                } else
                {
                    error.setForeground(MetodosAux.bg_white);
                    resultado = "success";
                }
                break;
        }
        return resultado;
    }
    
        public static String validarBox(RSComboBox field, JLabel error, String tipo)
    {
        String resultado = "error";
        switch (tipo)
        {
            case "requerid":
                if (field.getSelectedIndex() == 0)
                {
                    error.setText("Este campo es requerido");
                    error.setForeground(MetodosAux.bg_danger);
                } else
                {
                    error.setForeground(MetodosAux.bg_white);
                    resultado = "success";
                }
                break;
        }
        return resultado;
    }
}
