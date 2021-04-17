/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosBD;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin
 */
public class ConectaBD
{
    static Connection con = null;
    static String usuario = "root";
    static String pass = "";

    public static Connection ConectaBD()
    {
        try
        {
            //Cargamos el driver de mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/citaplus",usuario,pass);
            //JOptionPane.showMessageDialog(null, "Conectado");
        } catch (HeadlessException | ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
        return con;
    }
    
}
