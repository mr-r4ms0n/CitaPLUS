/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosAux;

import RSMaterialComponent.RSTableMetroCustom;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            }else
            {
                JOptionPane.showMessageDialog(null, "No hay datos en la tabla requerida");
            }

        } catch (SQLException e)
        {
            System.out.println("Error al listar tabla: " + e);
        }

    }
}
